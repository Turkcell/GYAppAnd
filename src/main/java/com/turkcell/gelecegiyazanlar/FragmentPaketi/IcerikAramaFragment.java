package com.turkcell.gelecegiyazanlar.FragmentPaketi;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.turkcell.gelecegiyazanlar.Activity.AramaActivity;
import com.turkcell.gelecegiyazanlar.AdapterListener.IcerikAramaAdapter;
import com.turkcell.gelecegiyazanlar.Configuration.AppController;
import com.turkcell.gelecegiyazanlar.Model.Icerik;
import com.turkcell.gelecegiyazanlar.Model.Kisi;
import com.turkcell.gelecegiyazanlar.Configuration.GYConfiguration;
import com.turkcell.gelecegiyazanlar.R;
import com.turkcell.gelecegiyazanlar.Utility.YuklenmeEkran;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 30.9.2015.
 */
public class IcerikAramaFragment extends Fragment implements View.OnClickListener,AramaActivity.IArama {

    //List<Kisi> icerikList = new ArrayList<Kisi>();
    List<Icerik> icerikList = new ArrayList<Icerik>();
    EditText search;

    ImageView btnAra;
    ListView listView;
    TextView tvSonuc;

    Kisi tempKisi;
    //Volley deðiþkenleri
    JsonArrayRequest jsonArrayRequest;
    JsonObjectRequest jsonObjectRequest;
    RequestQueue requestQueue;
    ImageRequest imageRequest;
    String url;
    int sayfaNumarasi=1;

    YuklenmeEkran ekran ;

    Toolbar toolbar;

    public static IcerikAramaFragment newInstance() {
        return new IcerikAramaFragment();
    }

    public IcerikAramaFragment() {

        Log.d("arama:","Icerik");
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        toolbar=(Toolbar)getActivity().findViewById(R.id.tool_bar_ara);
        View rootView= inflater.inflate(R.layout.fragment_arama, container, false);

        url = GYConfiguration.getDomain()+"contentsearch/retrieve?";

        search=(EditText)toolbar.findViewById(R.id.etSearch);

        listView = (ListView) rootView.findViewById(R.id.lvliste);
        tvSonuc = (TextView) rootView.findViewById(R.id.tvSonuc);
        btnAra = (ImageView) toolbar.findViewById(R.id.btnAra);

        ekran=new YuklenmeEkran(getActivity());


//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                if (icerikList.get(position) != null) {
//                    Kisi kisi = new Kisi();
//                    kisi.setKullaniciAdi(icerikList.get(position).getKullaniciID());
//                    Intent i=new Intent(getActivity(), ProfilActivity.class);
//                    i.putExtra("id",kisi.getKullaniciAdi());
//                    startActivity(i);
//                }
//            }
//        });


        return rootView;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAra:
                String URL = (url +"keyword="+search.getText()+"&page="+sayfaNumarasi+"&nodeType=article").trim();
                URL = URL.replace(" ", "%20");
                Listele(URL);
                break;

        }

    }

    public void Listele(String url) {
        ekran.surecBasla();
        Log.d("icerikUrl:",url);

        jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                ekran.surecDurdur();

                icerikList.clear();


                for (int i = 0; i < response.length(); i++) {

                    final Icerik tempIcerik = new Icerik();
                    try {
                        tempIcerik.setNodeID(response.getJSONObject(i).getString("nodeID"));
                        tempIcerik.setTitle(response.getJSONObject(i).getString("title"));
                        tempIcerik.setDate(response.getJSONObject(i).getString("date"));
                        tempIcerik.setNodetype(response.getJSONObject(i).getString("nodetype"));
                        tempIcerik.setExcerpt(response.getJSONObject(i).getString("excerpt"));
                        Log.d("TAG", "onResponse: " + tempIcerik.getNodeID());

                        icerikList.add(tempIcerik);


                    } catch (JSONException e) {
                        e.printStackTrace();
                        Log.d("TAG", e.toString());
                    }

                }

                IcerikAramaAdapter adapter = new IcerikAramaAdapter(getActivity(), icerikList);
                listView.setAdapter(adapter);
                adapter.notifyDataSetChanged();


                Log.d("parse islemi bitti:", "girildi");
                if (icerikList.isEmpty())
                    tvSonuc.setVisibility(View.VISIBLE);
                else tvSonuc.setVisibility(View.GONE);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        AppController.getInstance().addToRequestQueue(jsonArrayRequest);

        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(search.getWindowToken(), 0);


    }


    @Override
    public void onPageActivated() {
        btnAra.setOnClickListener(this);
    }

    }

