package com.turkcell.gelecegiyazanlar.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.splunk.mint.Mint;
import com.turkcell.gelecegiyazanlar.R;
import com.turkcell.gelecegiyazanlar.adapterlisteners.ListViewAdapterYorum;
import com.turkcell.gelecegiyazanlar.configurations.AppController;
import com.turkcell.gelecegiyazanlar.configurations.GYConfiguration;
import com.turkcell.gelecegiyazanlar.models.Yorum;
import com.turkcell.gelecegiyazanlar.utilities.TarihCevir;
import com.turkcell.gelecegiyazanlar.utilities.YuklenmeEkran;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class YorumActivity extends ActionBarActivity {


    final List<Yorum> yorumlar = new ArrayList<Yorum>();
    String url;

    String Nodeid;
    JsonArrayRequest request;
    String icon;
    TextView yorumyok;

    ListView listemiz;

    YuklenmeEkran ekran;
    TarihCevir tarihCevir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yorum);
        Mint.initAndStartSession(YorumActivity.this, GYConfiguration.SPLUNK_ID);
        url = GYConfiguration.getDomain() + "yorumlar/retrieve?nodeID=";

        ekran = new YuklenmeEkran(this);
        tarihCevir = new TarihCevir();

        listemiz = (ListView) findViewById(R.id.liste);

        yorumyok = (TextView) findViewById(R.id.yorumyok);

        Bundle bundle = getIntent().getExtras();
        Nodeid = bundle.getString(Yorum.YORUM_ID);

        Goruntule(Nodeid);


    }


    public void Goruntule(String nodeid) {

        ekran.surecBasla();
        request = new JsonArrayRequest(Request.Method.GET, url + nodeid, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                ekran.surecDurdur();
                try {


                    if (response.length() == 0) {
                        yorumyok.setVisibility(View.VISIBLE);

                    } else {
                        for (int i = 0; i < response.length(); i++) {
                            String isimsoyisim = response.getJSONObject(i).getString("adSoyad");
                            String yorum = response.getJSONObject(i).getString("content");
                            icon = response.getJSONObject(i).getString("authorAvatarUrl");
                            String tarihVeri = response.getJSONObject(i).getString("date");
                            String authorID = response.getJSONObject(i).getString("authorID");

                            Log.d("TAG:", icon);


                            //add to
                            yorumlar.add(new Yorum(isimsoyisim, yorum, icon, tarihCevir.Cevir(tarihVeri), authorID));

                        }


                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                ListViewAdapterYorum adaptorumuz = new ListViewAdapterYorum(YorumActivity.this, yorumlar);
                listemiz.setAdapter(adaptorumuz);

            }


        },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("hata", "hata");
                    }
                });


        AppController.getInstance().addToRequestQueue(request);
    }


}
