package com.turkcell.gelecegiyazanlar.fragments;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.turkcell.gelecegiyazanlar.R;
import com.turkcell.gelecegiyazanlar.activities.AramaActivity;
import com.turkcell.gelecegiyazanlar.activities.ProfilActivity;
import com.turkcell.gelecegiyazanlar.adapterlisteners.KullaniciAramaAdapter;
import com.turkcell.gelecegiyazanlar.configurations.AppController;
import com.turkcell.gelecegiyazanlar.configurations.GYConfiguration;
import com.turkcell.gelecegiyazanlar.databinding.FragmentAramaBinding;
import com.turkcell.gelecegiyazanlar.models.Kisi;
import com.turkcell.gelecegiyazanlar.utilities.YuklenmeEkran;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;


public class AramaFragment extends Fragment implements View.OnClickListener, AramaActivity.IArama {

    private FragmentAramaBinding fragmentAramaBinding;

    private EditText searchEditText;
    private ImageView searchImageView;
    private JsonArrayRequest jsonArrayRequest;
    private String urlAramaKullaniciString;
    private List<Kisi> kisiArrayList = new ArrayList<Kisi>();
    private YuklenmeEkran yuklenmeEkran;

    public AramaFragment() {
    }

    public static AramaFragment newInstance() {
        return new AramaFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbarAramaActivity);
        searchEditText = (EditText) toolbar.findViewById(R.id.editTextSearchAramabar);
        searchImageView = (ImageView) toolbar.findViewById(R.id.imageViewSearchBtnAramabar);

        fragmentAramaBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_arama, container, false);
        View rootView = fragmentAramaBinding.getRoot();

        urlAramaKullaniciString = GYConfiguration.getDomain() + "usersearch/retrieve?keyword=";

        yuklenmeEkran = new YuklenmeEkran(getActivity());


        fragmentAramaBinding.listViewlisteAramaFragment.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (kisiArrayList.get(position) != null) {
                    Kisi kisi = new Kisi();
                    kisi.setKullaniciAdi(kisiArrayList.get(position).getKullaniciID());
                    Intent i = new Intent(getActivity(), ProfilActivity.class);
                    i.putExtra(Kisi.PROFIL_ID, kisi.getKullaniciAdi());
                    startActivity(i);
                }
            }
        });

        searchEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    performSearch();
                    return true;
                }
                return false;
            }
        });


        return rootView;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageViewSearchBtnAramabar:
                performSearch();
                break;
        }
    }

    private void performSearch() {
        String link = (urlAramaKullaniciString + searchEditText.getText()).trim();
        link = link.replace(" ", "%20");
        kisiArrayList.clear();
        Listele(link);
    }

    public void Listele(String url) {

        yuklenmeEkran.surecBasla();


        jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                yuklenmeEkran.surecDurdur();

                for (int i = 0; i < response.length(); i++) {

                    final Kisi tempKisi = new Kisi();
                    try {
                        if (response.getJSONObject(i).getString("adSoyad") != "null") {
                            tempKisi.setAdSoyad(response.getJSONObject(i).getString("adSoyad"));
                            tempKisi.setKullaniciAdi(response.getJSONObject(i).getString("kullaniciAdi"));
                            tempKisi.setKullaniciID(response.getJSONObject(i).getString("kullaniciID"));
                            tempKisi.setKullaniciAvatarUrl(response.getJSONObject(i).getString("kullaniciAvatarUrl"));
                            Log.d("TAG", "onResponse: " + tempKisi.getKullaniciAvatarUrl());

                            kisiArrayList.add(tempKisi);


                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Log.d("TAG", e.toString());
                    }

                }

                KullaniciAramaAdapter adapter = new KullaniciAramaAdapter(getActivity(), kisiArrayList);
                fragmentAramaBinding.listViewlisteAramaFragment.setAdapter(adapter);
                adapter.notifyDataSetChanged();

                if (kisiArrayList.isEmpty())
                    fragmentAramaBinding.textViewSonucAramaFragment.setVisibility(View.VISIBLE);
                else fragmentAramaBinding.textViewSonucAramaFragment.setVisibility(View.GONE);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        AppController.getInstance().addToRequestQueue(jsonArrayRequest);

        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(searchEditText.getWindowToken(), 0);


    }


    @Override
    public void onPageActivated() {
        searchImageView.setOnClickListener(this);
    }
}



