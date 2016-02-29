package com.turkcell.gelecegiyazanlar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
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
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonArrayRequest;
import com.splunk.mint.Mint;
import com.turkcell.gelecegiyazanlar.R;
import com.turkcell.gelecegiyazanlar.configurations.AppController;
import com.turkcell.gelecegiyazanlar.configurations.GYConfiguration;
import com.turkcell.gelecegiyazanlar.utilities.YuklenmeEkran;

import org.json.JSONArray;
import org.json.JSONException;

public class EtkinlikIcerikActivity extends ActionBarActivity {

    String url;

    ImageRequest imageRequest;
    //JsonObjectRequest jsonObjectRequest;
    JsonArrayRequest stringRequest;
    String txtBaslik = "";
    TextView title, yorum;
    String id;

    YuklenmeEkran ekran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etkinlik_icerik);

        Mint.initAndStartSession(EtkinlikIcerikActivity.this, GYConfiguration.SPLUNK_ID);

        ekran = new YuklenmeEkran(EtkinlikIcerikActivity.this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbaretkinlik);
        title = (TextView) toolbar.findViewById(R.id.txtBaslik);
        yorum = (TextView) toolbar.findViewById(R.id.txtYorum);


        url = GYConfiguration.getDomain() + "etkinlik_content/retrieve?nodeID=";

        Bundle extras = getIntent().getExtras();
        id = extras.getString("etkinlikID");

        yorum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(EtkinlikIcerikActivity.this, YorumActivity.class);
                i.putExtra("yorumID", id);
                startActivity(i);
            }
        });

        Log.d("tag", url + id);

        if (GYConfiguration.checkInternetConnectionShowDialog(EtkinlikIcerikActivity.this)) {
            ekran.surecBasla();
        }

        stringRequest = new JsonArrayRequest(Request.Method.GET, url + id, null, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                Log.d("json:", response.toString());
                WebView webView = (WebView) findViewById(R.id.etkinlikDetay);
                webView.getSettings().setJavaScriptEnabled(true);
                try {


                    webView.setWebViewClient(new WebViewClient() {

                        @Override
                        public void onPageFinished(WebView view, String url) {
                            super.onPageFinished(view, url);
                            //Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                            ekran.surecDurdur();
                        }

                        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                            Toast.makeText(getApplicationContext(), R.string.hata_olustu_mesaji, Toast.LENGTH_SHORT).show();
                            ekran.surecDurdur();
                        }
                    });


                    txtBaslik = response.getJSONObject(0).getString("title");
                    title.setText(txtBaslik);
                    //Etkinlik baþlýðý bitiþ

                    webView.getSettings().setBuiltInZoomControls(true); //zoom yapýlmasýna izin verir
                    webView.getSettings().setSupportZoom(true);
                    webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
                    webView.getSettings().setAllowFileAccess(true);
                    webView.getSettings().setDomStorageEnabled(true);
                    webView.getSettings().setJavaScriptEnabled(true);
                    webView.getSettings().setUseWideViewPort(true);
                    webView.getSettings().setLoadWithOverviewMode(true);
                    webView.getSettings().setDefaultFontSize(40);


                    //Etkinlik içerik baþlangýç

                    webView.loadData(response.getJSONObject(0).getString("content")
                            , "text/html; charset=utf-8", null);
                    //Etkinlik içerik bitiþ


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

        AppController.getInstance().addToRequestQueue(stringRequest);

    }


}
