package com.turkcell.gelecegiyazanlar.fragment;

import android.animation.Animator;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.LinearLayout;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonArrayRequest;
import com.turkcell.gelecegiyazanlar.R;
import com.turkcell.gelecegiyazanlar.adapterlistener.RecyclerAdapterEtkinlik;
import com.turkcell.gelecegiyazanlar.configuration.AppController;
import com.turkcell.gelecegiyazanlar.configuration.GYConfiguration;
import com.turkcell.gelecegiyazanlar.model.Etkinlik;
import com.turkcell.gelecegiyazanlar.utility.TarihCevir;
import com.turkcell.gelecegiyazanlar.utility.YuklenmeEkran;

import org.json.JSONArray;
import org.json.JSONException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EtkinlikFragment extends android.support.v4.app.Fragment {


    Toolbar toolbar;


    JsonArrayRequest request;
    ImageRequest imageRequest;
    Bitmap bitmap;
    String url;
    String Nodeid;
    String image;
    List<Etkinlik> itemList = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerAdapterEtkinlik recyclerAdapterEtkinlik;
    String formattedDate;
    //int current_page=0;
    YuklenmeEkran yukleme;
    TarihCevir tarihCevir;
    CollapsingToolbarLayout collapsingToolbarLayout;
    LinearLayout layout;
    LayoutInflater layoutInflater;
    private LinearLayoutManager layoutManager;
    private int index = 0;
    private int maksSize;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        final View rootView = inflater.inflate(R.layout.fragment_etkinlik, container, false);


        toolbar = (Toolbar) getActivity().findViewById(R.id.tool_bar);


        yukleme = new YuklenmeEkran(getActivity());
        tarihCevir = new TarihCevir();

        layout = (LinearLayout) rootView.findViewById(R.id.layout_ust);
        layoutManager = new LinearLayoutManager(getActivity());

        url = GYConfiguration.getDomain() + "etkinlik/retrieve?nitems=10&index=";
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        SimpleDateFormat currentDate = new SimpleDateFormat("dd/MM/yyyy");
        Date todayDate = new Date();
        formattedDate = currentDate.format(todayDate);

        Log.d("time_current:", formattedDate);


        Listele(0);


        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                /**
                 * Sürüklenme bittiðinde
                 */
                if (!recyclerView.canScrollVertically(1)) {
                    index++;
                    dahaFazla(index);

                    /**
                     * Aþaðý Sürüklendiðinde
                     */
                } else if (dy > 0) {
                    layout.animate()
                            .translationY(-layout.getBottom() - toolbar.getBottom())
                            .setInterpolator(new AccelerateInterpolator(2))
                            .setListener(new Animator.AnimatorListener() {
                                @Override
                                public void onAnimationStart(Animator animation) {

                                }

                                @Override
                                public void onAnimationEnd(Animator animation) {
                                    layout.setVisibility(View.GONE);
                                }

                                @Override
                                public void onAnimationCancel(Animator animation) {

                                }

                                @Override
                                public void onAnimationRepeat(Animator animation) {

                                }
                            })
                            .start();


                }
            }
        });


        return rootView;
    }

    /**
     * Etkinlikleri Listele
     *
     * @param x
     */
    public void Listele(int x) {


        if (GYConfiguration.checkInternetConnectionShowDialog(getActivity())) {
            yukleme.surecBasla();
        }

        request = new JsonArrayRequest(Request.Method.GET, url + (1 + x), null, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                yukleme.surecDurdur();


                for (int i = 0; i < response.length(); i++) {

                    try {
                        String title = response.getJSONObject(i).getString("title");
                        String startDate = response.getJSONObject(i).getString("startDate");
                        String endDate = response.getJSONObject(i).getString("endDate");
                        String thumbnail = response.getJSONObject(i).getString("thumbnail");
                        String nodeID = response.getJSONObject(i).getString("nodeID");

                        String gercekBaslamaTarih = tarihCevir.Cevir(startDate);
                        String gercekBitisTarih = tarihCevir.Cevir(endDate);


                        String kalanGun = Long.toString(Math.abs(farkAl(formattedDate, gercekBaslamaTarih)));

                        if (farkAl(formattedDate, gercekBaslamaTarih) <= 0) {
                            itemList.add(i + maksSize, new Etkinlik(nodeID, title, gercekBaslamaTarih, gercekBitisTarih, thumbnail, kalanGun));
                        } else {
                            itemList.add(i + maksSize, new Etkinlik(nodeID, title, gercekBaslamaTarih, gercekBitisTarih, thumbnail, "-"));
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                maksSize = itemList.size();
                recyclerAdapterEtkinlik =
                        new RecyclerAdapterEtkinlik(itemList, getActivity());

                recyclerView.setAdapter(recyclerAdapterEtkinlik);

            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        AppController.getInstance().addToRequestQueue(request);

    }

    /**
     * Etkinlikleri daha fazla yükle
     *
     * @param x
     */
    public void dahaFazla(int x) {


        yukleme.surecBasla();

        request = new JsonArrayRequest(Request.Method.GET, url + (1 + x), null, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                yukleme.surecDurdur();

                for (int i = 0; i < response.length(); i++) {
                    try {
                        String title = response.getJSONObject(i).getString("title");
                        String startDate = response.getJSONObject(i).getString("startDate");
                        String endDate = response.getJSONObject(i).getString("endDate");
                        String thumbnail = response.getJSONObject(i).getString("thumbnail");
                        String nodeID = response.getJSONObject(i).getString("nodeID");

                        String gercekBaslamaTarih = tarihCevir.Cevir(startDate);
                        String gercekBitisTarih = tarihCevir.Cevir(endDate);

                        String kalanGun = Long.toString(Math.abs(farkAl(formattedDate, gercekBaslamaTarih)));
                        if (farkAl(formattedDate, gercekBaslamaTarih) <= 0) {
                            itemList.add(i + maksSize, new Etkinlik(nodeID, title, gercekBaslamaTarih, gercekBitisTarih, thumbnail, kalanGun));
                        } else {
                            itemList.add(i + maksSize, new Etkinlik(nodeID, title, gercekBaslamaTarih, gercekBitisTarih, thumbnail, "-"));
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }

                maksSize = maksSize + 10;
                recyclerAdapterEtkinlik.notifyDataSetChanged();

            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        AppController.getInstance().addToRequestQueue(request);

    }

    public long farkAl(String d1, String d2) throws ParseException {
        Date date1;
        Date date2;

        SimpleDateFormat dates = new SimpleDateFormat("dd/MM/yyyy");


        date1 = dates.parse(d1);
        date2 = dates.parse(d2);


        long difference = date1.getTime() - date2.getTime();
        long differenceDates = difference / (24 * 60 * 60 * 1000);


        //String dayDifference = Long.toString(differenceDates);

        return differenceDates;
    }


}

