package com.turkcell.gelecegiyazanlar.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
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
import com.turkcell.gelecegiyazanlar.databinding.ActivityBlogIcerikAcitivityBinding;
import com.turkcell.gelecegiyazanlar.models.Blog;
import com.turkcell.gelecegiyazanlar.models.Kisi;
import com.turkcell.gelecegiyazanlar.models.Yorum;
import com.turkcell.gelecegiyazanlar.utilities.YuklenmeEkran;

import org.json.JSONArray;
import org.json.JSONException;

public class BlogIcerikAcitivity extends AppCompatActivity {

    private ActivityBlogIcerikAcitivityBinding activityBlogIcerikAcitivityBinding;

    private String urlString;
    private ImageRequest imageRequest;
    private JsonArrayRequest jsonArrayRequest;
    private String baslikString = "";
    private YuklenmeEkran yuklenmeEkran;
    private String nodeIDString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityBlogIcerikAcitivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_blog_icerik_acitivity);

        Mint.initAndStartSession(BlogIcerikAcitivity.this, GYConfiguration.SPLUNK_ID);

        urlString = GYConfiguration.getDomain() + "article_content/retrieve?nodeID=";
        yuklenmeEkran = new YuklenmeEkran(BlogIcerikAcitivity.this);

        Bundle exras = getIntent().getExtras();
        nodeIDString = exras.getString(Blog.BLOG_ID);


        activityBlogIcerikAcitivityBinding.textViewYorumBlogIcerikActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BlogIcerikAcitivity.this, YorumActivity.class);
                i.putExtra(Yorum.YORUM_ID, nodeIDString);
                startActivity(i);
            }
        });

        if (GYConfiguration.checkInternetConnectionShowDialog(BlogIcerikAcitivity.this)) {
            yuklenmeEkran.surecBasla();
        }


        jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, urlString + nodeIDString, null, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {

                activityBlogIcerikAcitivityBinding.webViewBlogDetayBlogIcerikActivity.getSettings().setJavaScriptEnabled(true);
                yuklenmeEkran.surecDurdur();
                try {
                    //Blog baþlýðý baþlangýç
                    baslikString = response.getJSONObject(0).getString("title");
                    activityBlogIcerikAcitivityBinding.textViewBaslikBlogIcerikActivity.setText(baslikString);

                    String yazarIsim = response.getJSONObject(0).getString("adSoyad");
                    String authorID = response.getJSONObject(0).getString("authorID");

                    activityBlogIcerikAcitivityBinding.textViewYazarIsimBlogIcerikActivity.setText(yazarIsim);
                    activityBlogIcerikAcitivityBinding.textViewYazarIDBlogIcerikActivity.setText(authorID);
                    //Avatar baþlangýç

                    AvatarYukle(response.getJSONObject(0).getString("authorAvatarUrl"));

                    //Avatar bitiþ

                    activityBlogIcerikAcitivityBinding.webViewBlogDetayBlogIcerikActivity.setWebViewClient(new WebViewClient() {

                        @Override
                        public void onPageFinished(WebView view, String url) {
                            super.onPageFinished(view, url);
                        }

                        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                            Toast.makeText(getApplicationContext(), R.string.hata_olustu_mesaji, Toast.LENGTH_SHORT).show();

                        }
                    });


                    //Blog içerik baþlangýç
                    activityBlogIcerikAcitivityBinding.webViewBlogDetayBlogIcerikActivity.getSettings().setBuiltInZoomControls(true); //zoom yapýlmasýna izin verir
                    activityBlogIcerikAcitivityBinding.webViewBlogDetayBlogIcerikActivity.getSettings().setSupportZoom(true);
                    activityBlogIcerikAcitivityBinding.webViewBlogDetayBlogIcerikActivity.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
                    activityBlogIcerikAcitivityBinding.webViewBlogDetayBlogIcerikActivity.getSettings().setAllowFileAccess(true);
                    activityBlogIcerikAcitivityBinding.webViewBlogDetayBlogIcerikActivity.getSettings().setDomStorageEnabled(true);
                    activityBlogIcerikAcitivityBinding.webViewBlogDetayBlogIcerikActivity.getSettings().setJavaScriptEnabled(true);
                    activityBlogIcerikAcitivityBinding.webViewBlogDetayBlogIcerikActivity.getSettings().setUseWideViewPort(true);
                    activityBlogIcerikAcitivityBinding.webViewBlogDetayBlogIcerikActivity.getSettings().setLoadWithOverviewMode(true);
                    activityBlogIcerikAcitivityBinding.webViewBlogDetayBlogIcerikActivity.getSettings().setDefaultFontSize(40);

                    Log.d("TAG", response.getJSONObject(0).getString("content"));
                    activityBlogIcerikAcitivityBinding.webViewBlogDetayBlogIcerikActivity.loadData(response.getJSONObject(0).getString("content")
                            , "text/html; charset=utf-8", null);
                    //Blog içerik bitiþ


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

    public void AvatarYukle(String avatar) {
        imageRequest = new ImageRequest(avatar, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                activityBlogIcerikAcitivityBinding.circleImageViewAvatarBlogIcerikActivity.setImageBitmap(response);
            }
        }, 0, 0, null, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        AppController.getInstance().addToRequestQueue(imageRequest);


        activityBlogIcerikAcitivityBinding.circleImageViewAvatarBlogIcerikActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (activityBlogIcerikAcitivityBinding.textViewYazarIDBlogIcerikActivity.getText() != null) {
                    Intent i = new Intent(BlogIcerikAcitivity.this, ProfilActivity.class);
                    i.putExtra(Kisi.PROFIL_ID, activityBlogIcerikAcitivityBinding.textViewYazarIDBlogIcerikActivity.getText());
                    startActivity(i);
                }
            }
        });
    }

}
