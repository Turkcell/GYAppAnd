package com.turkcell.gelecegiyazanlar.fragments;

import android.animation.Animator;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import com.android.volley.toolbox.JsonArrayRequest;
import com.turkcell.gelecegiyazanlar.R;
import com.turkcell.gelecegiyazanlar.adapterlisteners.RecyclerAdapterEtkinlik;
import com.turkcell.gelecegiyazanlar.configurations.AppController;
import com.turkcell.gelecegiyazanlar.configurations.GYConfiguration;
import com.turkcell.gelecegiyazanlar.databinding.FragmentEtkinlikBinding;
import com.turkcell.gelecegiyazanlar.models.Etkinlik;
import com.turkcell.gelecegiyazanlar.utilities.TarihCevir;
import com.turkcell.gelecegiyazanlar.utilities.YuklenmeEkran;

import org.json.JSONArray;
import org.json.JSONException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EtkinlikFragment extends Fragment {

    private FragmentEtkinlikBinding fragmentEtkinlikBinding;

    private JsonArrayRequest jsonArrayRequest;
    private String urlString;
    private List<Etkinlik> etkinlikArrayList = new ArrayList<>();
    private RecyclerAdapterEtkinlik recyclerAdapterEtkinlik;
    private String formattedDateString;
    private YuklenmeEkran yuklemeEkran;
    private TarihCevir tarihCevir;
    private LinearLayoutManager layoutManager;
    private int indexAnInt = 0;
    private int maksSizeAnInt;
    private Toolbar toolbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        fragmentEtkinlikBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_etkinlik, container, false);

        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbarMainActivity);

        View rootView = fragmentEtkinlikBinding.getRoot();

        yuklemeEkran = new YuklenmeEkran(getActivity());
        tarihCevir = new TarihCevir();

        layoutManager = new LinearLayoutManager(getActivity());

        urlString = GYConfiguration.getDomain() + "etkinlik/retrieve?nitems=10&index=";
        fragmentEtkinlikBinding.recyclerViewEtkinlikFragment.setHasFixedSize(true);
        fragmentEtkinlikBinding.recyclerViewEtkinlikFragment.setLayoutManager(layoutManager);

        SimpleDateFormat currentDate = new SimpleDateFormat("dd/MM/yyyy");
        Date todayDate = new Date();
        formattedDateString = currentDate.format(todayDate);

        Listele(0);

        fragmentEtkinlikBinding.recyclerViewEtkinlikFragment.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                /**
                 * Sürüklenme bittiðinde
                 */
                if (!recyclerView.canScrollVertically(1)) {
                    indexAnInt++;
                    dahaFazla(indexAnInt);

                    /**
                     * Aþaðý Sürüklendiðinde
                     */
                } else if (dy > 0) {
                    fragmentEtkinlikBinding.linearLayoutUstEkranEtkinlikFragment.animate()
                            .translationY(-fragmentEtkinlikBinding.linearLayoutUstEkranEtkinlikFragment.getBottom() - toolbar.getBottom())
                            .setInterpolator(new AccelerateInterpolator(2))
                            .setListener(new Animator.AnimatorListener() {
                                @Override
                                public void onAnimationStart(Animator animation) {

                                }

                                @Override
                                public void onAnimationEnd(Animator animation) {
                                    fragmentEtkinlikBinding.linearLayoutUstEkranEtkinlikFragment.setVisibility(View.GONE);
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
            yuklemeEkran.surecBasla();
        }

        jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, urlString + x, null, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                yuklemeEkran.surecDurdur();


                for (int i = 0; i < response.length(); i++) {

                    try {
                        String title = response.getJSONObject(i).getString("title");
                        String startDate = response.getJSONObject(i).getString("startDate");
                        String endDate = response.getJSONObject(i).getString("endDate");
                        String thumbnail = response.getJSONObject(i).getString("thumbnail");
                        String nodeID = response.getJSONObject(i).getString("nodeID");

                        String gercekBaslamaTarih = tarihCevir.Cevir(startDate);
                        String gercekBitisTarih = tarihCevir.Cevir(endDate);


                        String kalanGun = Long.toString(Math.abs(farkAl(formattedDateString, gercekBaslamaTarih)));

                        if (farkAl(formattedDateString, gercekBaslamaTarih) <= 0) {
                            etkinlikArrayList.add(i + maksSizeAnInt, new Etkinlik(nodeID, title, gercekBaslamaTarih, gercekBitisTarih, thumbnail, kalanGun));
                        } else {
                            etkinlikArrayList.add(i + maksSizeAnInt, new Etkinlik(nodeID, title, gercekBaslamaTarih, gercekBitisTarih, thumbnail, "-"));
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                maksSizeAnInt = etkinlikArrayList.size();
                recyclerAdapterEtkinlik =
                        new RecyclerAdapterEtkinlik(etkinlikArrayList, getActivity());

                fragmentEtkinlikBinding.recyclerViewEtkinlikFragment.setAdapter(recyclerAdapterEtkinlik);

            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        AppController.getInstance().addToRequestQueue(jsonArrayRequest);

    }

    /**
     * Etkinlikleri daha fazla yükle
     *
     * @param x
     */
    public void dahaFazla(int x) {


        yuklemeEkran.surecBasla();

        jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, urlString + x, null, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                yuklemeEkran.surecDurdur();

                for (int i = 0; i < response.length(); i++) {
                    try {
                        String title = response.getJSONObject(i).getString("title");
                        String startDate = response.getJSONObject(i).getString("startDate");
                        String endDate = response.getJSONObject(i).getString("endDate");
                        String thumbnail = response.getJSONObject(i).getString("thumbnail");
                        String nodeID = response.getJSONObject(i).getString("nodeID");

                        String gercekBaslamaTarih = tarihCevir.Cevir(startDate);
                        String gercekBitisTarih = tarihCevir.Cevir(endDate);

                        String kalanGun = Long.toString(Math.abs(farkAl(formattedDateString, gercekBaslamaTarih)));
                        if (farkAl(formattedDateString, gercekBaslamaTarih) <= 0) {
                            etkinlikArrayList.add(i + maksSizeAnInt, new Etkinlik(nodeID, title, gercekBaslamaTarih, gercekBitisTarih, thumbnail, kalanGun));
                        } else {
                            etkinlikArrayList.add(i + maksSizeAnInt, new Etkinlik(nodeID, title, gercekBaslamaTarih, gercekBitisTarih, thumbnail, "-"));
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }

                maksSizeAnInt = maksSizeAnInt + 10;
                recyclerAdapterEtkinlik.notifyDataSetChanged();

            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        AppController.getInstance().addToRequestQueue(jsonArrayRequest);

    }

    public long farkAl(String d1, String d2) throws ParseException {
        Date date1;
        Date date2;

        SimpleDateFormat dates = new SimpleDateFormat("dd/MM/yyyy");

        date1 = dates.parse(d1);
        date2 = dates.parse(d2);

        long difference = date1.getTime() - date2.getTime();
        long differenceDates = difference / (24 * 60 * 60 * 1000);

        return differenceDates;
    }


}

