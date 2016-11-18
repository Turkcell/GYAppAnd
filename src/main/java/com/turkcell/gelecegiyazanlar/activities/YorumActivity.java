package com.turkcell.gelecegiyazanlar.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
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
import com.turkcell.gelecegiyazanlar.databinding.ActivityYorumBinding;
import com.turkcell.gelecegiyazanlar.models.Yorum;
import com.turkcell.gelecegiyazanlar.utilities.TarihCevir;
import com.turkcell.gelecegiyazanlar.utilities.YuklenmeEkran;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class YorumActivity extends AppCompatActivity {

    private ActivityYorumBinding activityYorumBinding;

    final List<Yorum> yorumList = new ArrayList<Yorum>();
    private String urlString;

    private String nodeIDString;
    private JsonArrayRequest jsonArrayRequest;
    private String iconString;

    private YuklenmeEkran yuklenmeEkran;
    private TarihCevir tarihCevir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityYorumBinding = DataBindingUtil.setContentView(this,R.layout.activity_yorum);


        Mint.initAndStartSession(YorumActivity.this, GYConfiguration.SPLUNK_ID);
        urlString = GYConfiguration.getDomain() + "yorumlar/retrieve?nodeID=";

        yuklenmeEkran = new YuklenmeEkran(this);
        tarihCevir = new TarihCevir();

        Bundle bundle = getIntent().getExtras();
        nodeIDString = bundle.getString(Yorum.YORUM_ID);

        Goruntule(nodeIDString);


    }


    public void Goruntule(String nodeid) {

        yuklenmeEkran.surecBasla();
        jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, urlString + nodeid, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                yuklenmeEkran.surecDurdur();
                try {


                    if (response.length() == 0) {
                        activityYorumBinding.textViewYorumyok.setVisibility(View.VISIBLE);

                    } else {
                        for (int i = 0; i < response.length(); i++) {
                            String isimsoyisim = response.getJSONObject(i).getString("adSoyad");
                            String yorum = response.getJSONObject(i).getString("content");
                            iconString = response.getJSONObject(i).getString("authorAvatarUrl");
                            String tarihVeri = response.getJSONObject(i).getString("date");
                            String authorID = response.getJSONObject(i).getString("authorID");

                            //add to
                            yorumList.add(new Yorum(isimsoyisim, yorum, iconString, tarihCevir.Cevir(tarihVeri), authorID));

                        }


                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                ListViewAdapterYorum listViewAdapterYorum = new ListViewAdapterYorum(YorumActivity.this, yorumList);
                activityYorumBinding.listViewListe.setAdapter(listViewAdapterYorum);

            }


        },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("hata", "hata");
                    }
                });


        AppController.getInstance().addToRequestQueue(jsonArrayRequest);
    }


}
