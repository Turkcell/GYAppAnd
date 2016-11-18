package com.turkcell.gelecegiyazanlar.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.splunk.mint.Mint;
import com.turkcell.gelecegiyazanlar.R;
import com.turkcell.gelecegiyazanlar.configurations.AppController;
import com.turkcell.gelecegiyazanlar.configurations.GYConfiguration;
import com.turkcell.gelecegiyazanlar.databinding.ActivityEtkinlikIcerikBinding;
import com.turkcell.gelecegiyazanlar.models.Etkinlik;
import com.turkcell.gelecegiyazanlar.models.Yorum;
import com.turkcell.gelecegiyazanlar.utilities.YuklenmeEkran;

import org.json.JSONArray;
import org.json.JSONException;

public class EtkinlikIcerikActivity extends AppCompatActivity {

    private ActivityEtkinlikIcerikBinding activityEtkinlikIcerikBinding;

    private String urlString;
    private JsonArrayRequest jsonArrayRequest;
    private String baslikString = "";
    private String idString;

    private YuklenmeEkran yuklenmeEkran;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityEtkinlikIcerikBinding = DataBindingUtil.setContentView(this,R.layout.activity_etkinlik_icerik);

        Mint.initAndStartSession(EtkinlikIcerikActivity.this, GYConfiguration.SPLUNK_ID);

        yuklenmeEkran = new YuklenmeEkran(EtkinlikIcerikActivity.this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbaretkinlik);

        urlString = GYConfiguration.getDomain() + "etkinlik_content/retrieve?nodeID=";

        Bundle extras = getIntent().getExtras();
        idString = extras.getString(Etkinlik.ETKINLIK_ID);

        activityEtkinlikIcerikBinding.textViewYorum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(EtkinlikIcerikActivity.this, YorumActivity.class);
                i.putExtra(Yorum.YORUM_ID, idString);
                startActivity(i);
            }
        });


        if (GYConfiguration.checkInternetConnectionShowDialog(EtkinlikIcerikActivity.this)) {
            yuklenmeEkran.surecBasla();
        }

        jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, urlString + idString, null, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {

                activityEtkinlikIcerikBinding.webViewEtkinlikDetay.getSettings().setJavaScriptEnabled(true);

                try {
                    activityEtkinlikIcerikBinding.webViewEtkinlikDetay.setWebViewClient(new WebViewClient() {

                        @Override
                        public void onPageFinished(WebView view, String url) {
                            super.onPageFinished(view, url);
                            yuklenmeEkran.surecDurdur();
                        }

                        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                            Toast.makeText(getApplicationContext(), R.string.hata_olustu_mesaji, Toast.LENGTH_SHORT).show();
                            yuklenmeEkran.surecDurdur();
                        }
                    });


                    baslikString = response.getJSONObject(0).getString("title");
                    activityEtkinlikIcerikBinding.textViewBaslik.setText(baslikString);
                    //Etkinlik ba�l��� biti�

                    activityEtkinlikIcerikBinding.webViewEtkinlikDetay.getSettings().setBuiltInZoomControls(true); //zoom yap�lmas�na izin verir
                    activityEtkinlikIcerikBinding.webViewEtkinlikDetay.getSettings().setSupportZoom(true);
                    activityEtkinlikIcerikBinding.webViewEtkinlikDetay.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
                    activityEtkinlikIcerikBinding.webViewEtkinlikDetay.getSettings().setAllowFileAccess(true);
                    activityEtkinlikIcerikBinding.webViewEtkinlikDetay.getSettings().setDomStorageEnabled(true);
                    activityEtkinlikIcerikBinding.webViewEtkinlikDetay.getSettings().setJavaScriptEnabled(true);
                    activityEtkinlikIcerikBinding.webViewEtkinlikDetay.getSettings().setUseWideViewPort(true);
                    activityEtkinlikIcerikBinding.webViewEtkinlikDetay.getSettings().setLoadWithOverviewMode(true);
                    activityEtkinlikIcerikBinding.webViewEtkinlikDetay.getSettings().setDefaultFontSize(40);

                    //Etkinlik i�erik ba�lang��

                    activityEtkinlikIcerikBinding.webViewEtkinlikDetay.loadData(response.getJSONObject(0).getString("content")
                            , "text/html; charset=utf-8", null);
                    //Etkinlik i�erik biti�


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("hata:", "hata:");
                    }
                });

        AppController.getInstance().addToRequestQueue(jsonArrayRequest);

    }


}
