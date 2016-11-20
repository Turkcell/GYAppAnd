package com.turkcell.gelecegiyazanlar.fragments;

import android.content.Context;
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.turkcell.gelecegiyazanlar.R;
import com.turkcell.gelecegiyazanlar.activities.AramaActivity;
import com.turkcell.gelecegiyazanlar.adapterlisteners.IcerikAramaAdapter;
import com.turkcell.gelecegiyazanlar.configurations.AppController;
import com.turkcell.gelecegiyazanlar.configurations.GYConfiguration;
import com.turkcell.gelecegiyazanlar.models.Icerik;
import com.turkcell.gelecegiyazanlar.utilities.YuklenmeEkran;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 30.9.2015.
 */
public class IcerikAramaFragment extends Fragment implements View.OnClickListener,AramaActivity.IArama {

    private List<Icerik> icerikArrayList = new ArrayList<Icerik>();
    private EditText searchEditText;
    private ImageView searchImageView;
    private ListView listView;
    private TextView sonucTextView;
    private JsonArrayRequest jsonArrayRequest;
    private String urlString;
    private int sayfaNumarasiAnInt = 1;
    private YuklenmeEkran yuklenmeEkran ;
    private Toolbar toolbar;

    public IcerikAramaFragment() {
    }

    public static IcerikAramaFragment newInstance() {
        return new IcerikAramaFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        toolbar=(Toolbar)getActivity().findViewById(R.id.tool_bar_ara);
        View rootView= inflater.inflate(R.layout.fragment_arama, container, false);

        urlString = GYConfiguration.getDomain()+"contentsearch/retrieve?";

        searchEditText=(EditText)toolbar.findViewById(R.id.editTextSearch);
        searchImageView = (ImageView) toolbar.findViewById(R.id.imageViewSearchBtn);

        yuklenmeEkran = new YuklenmeEkran(getActivity());


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
        switch (v.getId()){
            case R.id.imageViewSearchBtn:
                performSearch();
                break;

        }

    }
    private void performSearch() {
        String URL = (urlString +"keyword="+searchEditText.getText()+"&page="+sayfaNumarasiAnInt+"&nodeType=article").trim();
        URL = URL.replace(" ", "%20");
        Listele(URL);
    }

    public void Listele(String url) {

        yuklenmeEkran.surecBasla();

        jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                yuklenmeEkran.surecDurdur();

                icerikArrayList.clear();


                for (int i = 0; i < response.length(); i++) {

                    final Icerik tempIcerik = new Icerik();
                    try {
                        tempIcerik.setNodeID(response.getJSONObject(i).getString("nodeID"));
                        tempIcerik.setTitle(response.getJSONObject(i).getString("title"));
                        tempIcerik.setDate(response.getJSONObject(i).getString("date"));
                        tempIcerik.setNodetype(response.getJSONObject(i).getString("nodetype"));
                        tempIcerik.setExcerpt(response.getJSONObject(i).getString("excerpt"));
                        Log.d("TAG", "onResponse: " + tempIcerik.getNodeID());

                        icerikArrayList.add(tempIcerik);


                    } catch (JSONException e) {
                        e.printStackTrace();
                        Log.d("TAG", e.toString());
                    }

                }

                IcerikAramaAdapter adapter = new IcerikAramaAdapter(getActivity(), icerikArrayList);
                listView.setAdapter(adapter);
                adapter.notifyDataSetChanged();


                if (icerikArrayList.isEmpty())
                    sonucTextView.setVisibility(View.VISIBLE);
                else sonucTextView.setVisibility(View.GONE);

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

