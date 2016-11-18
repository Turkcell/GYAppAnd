package com.turkcell.gelecegiyazanlar.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonArrayRequest;
import com.splunk.mint.Mint;
import com.turkcell.curio.CurioClient;
import com.turkcell.gelecegiyazanlar.R;
import com.turkcell.gelecegiyazanlar.configurations.AppController;
import com.turkcell.gelecegiyazanlar.configurations.GYConfiguration;
import com.turkcell.gelecegiyazanlar.databinding.ActivityEgitimIcerikBinding;
import com.turkcell.gelecegiyazanlar.models.Egitim;
import com.turkcell.gelecegiyazanlar.models.Kisi;

import org.json.JSONArray;
import org.json.JSONException;


public class EgitimIcerikActivity extends AppCompatActivity {

    private ActivityEgitimIcerikBinding activityEgitimIcerikBinding;

    final Egitim egitim = new Egitim();

    private String icerikYaziString = "";
    private String yazarYaziString;
    private String resimUrlString;
    private String titleString;
    private String dugumIDString;
    private String dugumBaslikString;
    private String authorIDString;

    private Toolbar toolbar;

    private long timeALong;

    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityEgitimIcerikBinding = DataBindingUtil.setContentView(this,R.layout.activity_egitim_icerik);

        Mint.initAndStartSession(EgitimIcerikActivity.this, GYConfiguration.SPLUNK_ID);

        activityEgitimIcerikBinding.webViewWebIcerik.getSettings().setJavaScriptEnabled(true);
        activityEgitimIcerikBinding.webViewWebIcerik.getSettings().setUseWideViewPort(true);
        activityEgitimIcerikBinding.webViewWebIcerik.getSettings().setSupportZoom(true);
        activityEgitimIcerikBinding.webViewWebIcerik.getSettings().setDisplayZoomControls(true);
        activityEgitimIcerikBinding.webViewWebIcerik.getSettings().setBuiltInZoomControls(true);
        activityEgitimIcerikBinding.webViewWebIcerik.getSettings().setDefaultFontSize(40);

        activityEgitimIcerikBinding.webViewWebIcerik.getSettings().setLoadWithOverviewMode(true);
        activityEgitimIcerikBinding.textViewYazarIsim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(EgitimIcerikActivity.this, ProfilActivity.class);
                i.putExtra(Kisi.PROFIL_ID, authorIDString);
                startActivity(i);
            }
        });


        toolbar = (Toolbar) findViewById(R.id.tool_bar2);
        setSupportActionBar(toolbar);
        Bundle extras = getIntent().getExtras();
        dugumIDString = extras.getString(Egitim.NODE_ID_EGITIM);
        dugumBaslikString = extras.getString(Egitim.NODE_TITLE);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationIcon(ResourcesCompat.getDrawable(getResources(), R.drawable.backarrow, null));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        if (GYConfiguration.checkInternetConnectionShowDialog(EgitimIcerikActivity.this)) {
            getEgitimIcerik(dugumIDString);
        }

    }



    public void getEgitimIcerik(final String dugumID) {


        pDialog = new ProgressDialog(this);
        pDialog.setMessage(getString(R.string.yukleniyor));
        pDialog.show();

        JsonArrayRequest movieReq = new JsonArrayRequest(GYConfiguration.getDomain() + "book_content/retrieve?nodeID=" + dugumID,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        hidePDialog();

                        try {
                            JSONArray icerikDizi = response.getJSONObject(0).getJSONArray("content");
                            yazarYaziString = response.getJSONObject(0).getString("adSoyad");
                            titleString = response.getJSONObject(0).getString("title");
                            resimUrlString = response.getJSONObject(0).getString("authorAvatarUrl");
                            authorIDString = response.getJSONObject(0).getString("authorID");

                            for (int i = 0; i < icerikDizi.length(); i++) {
                                icerikYaziString += icerikDizi.getString(i);
                            }
                            egitim.setIcerik(icerikYaziString);
                            egitim.setYazar(yazarYaziString);
                            toolbar.setTitle(titleString);

                            if (yazarYaziString != null || icerikYaziString != null) {
                                ResimGetir();
                                activityEgitimIcerikBinding.textViewYazarIsim.setText(egitim.getYazar());
                                activityEgitimIcerikBinding.webViewWebIcerik.loadDataWithBaseURL("", egitim.getIcerik(), "text/html", "UTF-8", "");
                            }
                            CurioClient.getInstance(getApplicationContext()).sendEvent("Egitim Ýçerik>" + dugumBaslikString, titleString);
                            timeALong = System.currentTimeMillis();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("Error", "Error: " + error.getMessage());
                hidePDialog();

            }
        });

        AppController.getInstance().addToRequestQueue(movieReq);


    }

    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }

    public void ResimGetir() {
        ImageRequest image = new ImageRequest(resimUrlString, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                activityEgitimIcerikBinding.circleImageViewProfileImage.setImageBitmap(response);
            }
        }, 0, 0, null, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        AppController.getInstance().addToRequestQueue(image);
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onStop() {
        super.onStop();
        CurioClient.getInstance(getApplicationContext()).endEvent("Egitim Ýçerik>" + dugumBaslikString, titleString, System.currentTimeMillis() - timeALong);

    }
}
