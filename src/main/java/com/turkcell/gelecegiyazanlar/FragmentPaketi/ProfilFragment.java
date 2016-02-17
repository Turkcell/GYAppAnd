package com.turkcell.gelecegiyazanlar.FragmentPaketi;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.turkcell.gelecegiyazanlar.AppController;
import com.turkcell.gelecegiyazanlar.DesignEklentileri.SlidingTabLayout;
import com.turkcell.gelecegiyazanlar.GYConfiguration;
import com.turkcell.gelecegiyazanlar.R;
import com.turkcell.gelecegiyazanlar.Utils.YuklenmeEkran;

import org.json.JSONException;
import org.json.JSONObject;


public class ProfilFragment extends Fragment implements View.OnClickListener {

    RequestQueue requestQueue;
    JsonObjectRequest jsonObjectRequest;
    StringRequest stringRequest;
    ImageRequest imageRequest;
    String kategori;
    String hakkindaTemiz;

    ImageRequest requestImage;
    String avatarUrl;

    String id;

    LinearLayout basariBelgeleriLayout,hakkindaLayout,basariBelgeleriCizgi,hakkindaCizgi;

    TextView isim,yasadigiSegir,universite,hakkinda;

    ImageView avatar,android101,android201,android301,android401,ios101,ios201,ios301,ios401
            ,wp101,wp201,mobiloyun101,mobiloyun201,web101,web201,web301,web401,scratch101,scratch201,ai101,ai201,ai301,arduino101
            ,arduino201,arduino301,arduino401;

    String Url ;

    FloatingActionButton facebook,google,twitter,linkedin;

    String facebookUrl;
    String twitterUrl;
    String googleplusUrl;
    String linkedinUrl;
    String githubUrl;
    String blogUrl;

    YuklenmeEkran yuklenmeEkran;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView= inflater.inflate(R.layout.fragment_profil, container, false);

        Url= GYConfiguration.getDomain()+"profil/retrieve?userID=";

        yuklenmeEkran=new YuklenmeEkran(getActivity());

         basariBelgeleriLayout = (LinearLayout) rootView.findViewById(R.id.basariBelgeleriLayout);
          hakkindaLayout = (LinearLayout) rootView.findViewById(R.id.hakkindaLayout);
         basariBelgeleriCizgi = (LinearLayout) rootView.findViewById(R.id.basaribelgeleriCizgi);
         hakkindaCizgi = (LinearLayout) rootView.findViewById(R.id.hakkindaCizgi);

          isim = (TextView) getActivity().findViewById(R.id.adSoyad);
        yasadigiSegir = (TextView) getActivity().findViewById(R.id.konum);
         universite = (TextView) getActivity().findViewById(R.id.universite);
         hakkinda = (TextView) rootView.findViewById(R.id.hakkinda);
          avatar = (ImageView) getActivity().findViewById(R.id.avatar);

         android101 = (ImageView) rootView.findViewById(R.id.android101);
        android201 = (ImageView) rootView.findViewById(R.id.android201);
        android301 = (ImageView) rootView.findViewById(R.id.android301);
        android401 = (ImageView) rootView.findViewById(R.id.android401);


        ios101 = (ImageView) rootView.findViewById(R.id.ios101);
        ios201 = (ImageView) rootView.findViewById(R.id.ios201);
        ios301 = (ImageView) rootView.findViewById(R.id.ios301);
        ios401 = (ImageView) rootView.findViewById(R.id.ios401);

        wp101 = (ImageView) rootView.findViewById(R.id.wp101);
        wp201 = (ImageView) rootView.findViewById(R.id.wp201);

        mobiloyun101 = (ImageView) rootView.findViewById(R.id.mobiloyun101);
        mobiloyun201 = (ImageView) rootView.findViewById(R.id.mobiloyun201);

        web101 = (ImageView) rootView.findViewById(R.id.web101);
        web201 = (ImageView) rootView.findViewById(R.id.web201);
        web301 = (ImageView) rootView.findViewById(R.id.web301);
        web401 = (ImageView) rootView.findViewById(R.id.web401);

        scratch101 = (ImageView) rootView.findViewById(R.id.scratch101);
        scratch201 = (ImageView) rootView.findViewById(R.id.scratch201);

        ai101 = (ImageView) rootView.findViewById(R.id.ai101);
        ai201 = (ImageView) rootView.findViewById(R.id.ai201);
        ai301 = (ImageView) rootView.findViewById(R.id.ai301);

        arduino101 = (ImageView) rootView.findViewById(R.id.arduino101);
        arduino201 = (ImageView) rootView.findViewById(R.id.arduino201);
        arduino301 = (ImageView) rootView.findViewById(R.id.arduino301);
        arduino401 = (ImageView) rootView.findViewById(R.id.arduino401);

        SlidingTabLayout tabs= (SlidingTabLayout) getActivity().findViewById(R.id.tabsBlog);

        final FrameLayout frameLayout=(FrameLayout)rootView.findViewById(R.id.frameLay);
        final FloatingActionsMenu fabMenu = (FloatingActionsMenu) rootView.findViewById(R.id.fab_menu);

        facebook=(FloatingActionButton)rootView.findViewById(R.id.fab_face);
        twitter=(FloatingActionButton)rootView.findViewById(R.id.fab_twitter);
        linkedin=(FloatingActionButton)rootView.findViewById(R.id.fab_linkedin);
        google=(FloatingActionButton)rootView.findViewById(R.id.fab_google);

        facebook.setOnClickListener(this);
        twitter.setOnClickListener(this);
        linkedin.setOnClickListener(this);
        google.setOnClickListener(this);

        fabMenu.setOnFloatingActionsMenuUpdateListener(new FloatingActionsMenu.OnFloatingActionsMenuUpdateListener() {

            @Override
            public void onMenuExpanded() {
                //   frameLayout.getBackground().setAlpha(240);
                frameLayout.setEnabled(false);
                frameLayout.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        fabMenu.collapse();
                        return true;
                    }
                });
            }

            @Override
            public void onMenuCollapsed() {

                //  frameLayout.getBackground().setAlpha(0);
                frameLayout.setOnTouchListener(null);
            }
        });


        Bundle extra=getActivity().getIntent().getExtras();
        id=extra.getString("id");

tabs.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

        if(position == 1){
            basariBelgeleriLayout.setVisibility(View.VISIBLE);
            basariBelgeleriCizgi.setVisibility(View.VISIBLE);
            hakkindaLayout.setVisibility(View.INVISIBLE);
            hakkindaCizgi.setVisibility(View.INVISIBLE);
            fabMenu.setVisibility(View.GONE);
        } else {
            basariBelgeleriLayout.setVisibility(View.INVISIBLE);
            basariBelgeleriCizgi.setVisibility(View.INVISIBLE);
            hakkindaLayout.setVisibility(View.VISIBLE);
            hakkindaCizgi.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
});


   EkleYazi(id);

        // Inflate the layout for this fragm
        return rootView;
    }


    public void EkleYazi(String id){

        yuklenmeEkran.surecBasla();
Log.d("profil:",Url+id);
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, Url+id, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                yuklenmeEkran.surecDurdur();
                try {

                    isim.setText(response.getString("adSoyad"));
                    yasadigiSegir.setText(response.getString("yasadigiSehir"));
                    universite.setText(response.getString("universite"));
                    avatarUrl = response.getString("avatarUrl");

                    facebookUrl = response.getJSONObject("sosyalAglar").getString("facebook");
                    twitterUrl = response.getJSONObject("sosyalAglar").getString("twitter");
                    googleplusUrl = response.getJSONObject("sosyalAglar").getString("googleplus");
                    linkedinUrl = response.getJSONObject("sosyalAglar").getString("linkedin");
                    githubUrl = response.getJSONObject("sosyalAglar").getString("github");
                    blogUrl = response.getJSONObject("sosyalAglar").getString("blog");

                    hakkindaTemiz = response.getString("hakkinda").replace("&#039;", "'");
                    hakkindaTemiz = hakkindaTemiz.replace("&amp", "&");
                    hakkindaTemiz = hakkindaTemiz.replace(";amp;", " ");
                    hakkindaTemiz = hakkindaTemiz.replace("&quot;", "\"");
                    if(hakkindaTemiz != "null") {
                        hakkinda.setText(hakkindaTemiz);
                    }else
                        hakkinda.setText("");

                    for(int i=0; i < response.getJSONObject("basariBelgeleri").length(); i++){
                        Log.i("sayisi: ", Integer.toString(response.getJSONObject("basariBelgeleri").length()));
                        Log.i("kategori: " ,response.getJSONObject("basariBelgeleri").getJSONObject(Integer.toString(i+1)).getString("kategori") );
                        Log.i("seviye: ", response.getJSONObject("basariBelgeleri").getJSONObject(Integer.toString(i + 1)).getString("zorlukSeviyesi"));




                        kategori = response.getJSONObject("basariBelgeleri").getJSONObject(Integer.toString(i+1)).getString("kategori");

                        if(  kategori.equals("Android")){
                            Log.i("ife", "girdi");
                            if(response.getJSONObject("basariBelgeleri").getJSONObject(Integer.toString(i+1)).getString("zorlukSeviyesi").equals("101")){
                                Log.i("içteki ife", "girdi");
                                android101.setVisibility(View.VISIBLE);
                            } else if(response.getJSONObject("basariBelgeleri").getJSONObject(Integer.toString(i+1)).getString("zorlukSeviyesi").equals("201")){
                                android201.setVisibility(View.VISIBLE);
                            } else if(response.getJSONObject("basariBelgeleri").getJSONObject(Integer.toString(i+1)).getString("zorlukSeviyesi").equals("301")){
                                android301.setVisibility(View.VISIBLE);
                            } else if(response.getJSONObject("basariBelgeleri").getJSONObject(Integer.toString(i+1)).getString("zorlukSeviyesi").equals("401")){
                                android401.setVisibility(View.VISIBLE);
                            }

                        } else if(  kategori.equals("iOS")){

                            if(response.getJSONObject("basariBelgeleri").getJSONObject(Integer.toString(i+1)).getString("zorlukSeviyesi").equals("101")){
                                ios101.setVisibility(View.VISIBLE);
                            } else if(response.getJSONObject("basariBelgeleri").getJSONObject(Integer.toString(i+1)).getString("zorlukSeviyesi").equals("201")){
                                ios201.setVisibility(View.VISIBLE);
                            } else if(response.getJSONObject("basariBelgeleri").getJSONObject(Integer.toString(i+1)).getString("zorlukSeviyesi").equals("301")){
                                ios301.setVisibility(View.VISIBLE);
                            } else if(response.getJSONObject("basariBelgeleri").getJSONObject(Integer.toString(i+1)).getString("zorlukSeviyesi").equals("401")){
                                ios401.setVisibility(View.VISIBLE);
                            }

                        } else if(  kategori.equals("Windows Phone")){

                            if(response.getJSONObject("basariBelgeleri").getJSONObject(Integer.toString(i+1)).getString("zorlukSeviyesi").equals("101")){
                                wp101.setVisibility(View.VISIBLE);
                            } else if(response.getJSONObject("basariBelgeleri").getJSONObject(Integer.toString(i+1)).getString("zorlukSeviyesi").equals("201")){
                                wp201.setVisibility(View.VISIBLE);
                            }

                        } else if(  kategori.equals("Mobil Oyun")){

                            if(response.getJSONObject("basariBelgeleri").getJSONObject(Integer.toString(i+1)).getString("zorlukSeviyesi").equals("101")){
                                mobiloyun101.setVisibility(View.VISIBLE);
                            } else if(response.getJSONObject("basariBelgeleri").getJSONObject(Integer.toString(i+1)).getString("zorlukSeviyesi").equals("201")){
                                mobiloyun201.setVisibility(View.VISIBLE);
                            }

                        } else if(  kategori.equals("Web Programlama")){

                            if(response.getJSONObject("basariBelgeleri").getJSONObject(Integer.toString(i+1)).getString("zorlukSeviyesi").equals("101")){
                                web101.setVisibility(View.VISIBLE);
                            } else if(response.getJSONObject("basariBelgeleri").getJSONObject(Integer.toString(i+1)).getString("zorlukSeviyesi").equals("201")){
                                web201.setVisibility(View.VISIBLE);
                            } else if(response.getJSONObject("basariBelgeleri").getJSONObject(Integer.toString(i+1)).getString("zorlukSeviyesi").equals("301")){
                                web301.setVisibility(View.VISIBLE);
                            } else if(response.getJSONObject("basariBelgeleri").getJSONObject(Integer.toString(i+1)).getString("zorlukSeviyesi").equals("401")){
                                web401.setVisibility(View.VISIBLE);
                            }

                        } else if(  kategori.equals("Scratch")){

                            if(response.getJSONObject("basariBelgeleri").getJSONObject(Integer.toString(i+1)).getString("zorlukSeviyesi").equals("101")){
                                scratch101.setVisibility(View.VISIBLE);
                            } else if(response.getJSONObject("basariBelgeleri").getJSONObject(Integer.toString(i+1)).getString("zorlukSeviyesi").equals("201")){
                                scratch201.setVisibility(View.VISIBLE);
                            }

                        } else if(  kategori.equals("App Inventor")){

                            if(response.getJSONObject("basariBelgeleri").getJSONObject(Integer.toString(i+1)).getString("zorlukSeviyesi").equals("101")){
                                ai101.setVisibility(View.VISIBLE);
                            } else if(response.getJSONObject("basariBelgeleri").getJSONObject(Integer.toString(i+1)).getString("zorlukSeviyesi").equals("201")){
                                ai201.setVisibility(View.VISIBLE);
                            } else if(response.getJSONObject("basariBelgeleri").getJSONObject(Integer.toString(i+1)).getString("zorlukSeviyesi").equals("301")){
                                ai301.setVisibility(View.VISIBLE);
                            }
                        } else if(  kategori.equals("Arduino")){

                            if(response.getJSONObject("basariBelgeleri").getJSONObject(Integer.toString(i+1)).getString("zorlukSeviyesi").equals("101")){
                                arduino101.setVisibility(View.VISIBLE);
                            } else if(response.getJSONObject("basariBelgeleri").getJSONObject(Integer.toString(i+1)).getString("zorlukSeviyesi").equals("201")){
                                arduino201.setVisibility(View.VISIBLE);
                            } else if(response.getJSONObject("basariBelgeleri").getJSONObject(Integer.toString(i+1)).getString("zorlukSeviyesi").equals("301")){
                                arduino301.setVisibility(View.VISIBLE);
                            } else if(response.getJSONObject("basariBelgeleri").getJSONObject(Integer.toString(i+1)).getString("zorlukSeviyesi").equals("401")){
                                arduino401.setVisibility(View.VISIBLE);
                            }

                        }



                    }


                    ResimGetir();
                    //basari1.setText(response.getJSONObject("basariBelgeleri").getJSONObject("1").getString("title"));


                } catch (JSONException e) {
                    e.printStackTrace();
                }



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        AppController.getInstance().addToRequestQueue(jsonObjectRequest,"profilTag");
    }

    public void ResimGetir(){


        //Resmi Alıcaz.
        requestImage = new ImageRequest(avatarUrl, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {

                avatar.setImageBitmap(response);
            }
        }, 0, 0, null, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

       AppController.getInstance().addToRequestQueue(requestImage,"profilResimTag");

    }

    @Override
    public void onStop() {
        super.onStop();
        AppController.getInstance().cancelPendingRequests("profilTag");
        AppController.getInstance().cancelPendingRequests("profilResimTag");
    }


    private void SosyalPlatformAc(String platform,String Url) {


        if(Url != "null") {
            String SosyalUrl = Url;
            String[] userID = SosyalUrl.split(".com/");

            switch (platform) {

                case "facebook":
                    try {
                        int versionCode = getActivity().getApplicationContext().getPackageManager().getPackageInfo("com.facebook.katana", 0).versionCode;

                        if (versionCode >= 3002850 && !Url.isEmpty()) {
                            // open Facebook app using facebook url
                            Uri uri = Uri.parse("fb://facewebmodal/f?href=" + Url);
                            startActivity(new Intent(Intent.ACTION_VIEW, uri));
                        } else {
                            // Facebook is not installed. Open the browser
                            Uri uri = Uri.parse(Url);
                            startActivity(new Intent(Intent.ACTION_VIEW, uri));
                        }
                    } catch (PackageManager.NameNotFoundException e) {
                        // Facebook is not installed. Open the browser
                        Uri uri = Uri.parse(Url);
                        startActivity(new Intent(Intent.ACTION_VIEW, uri));
                    }
                    break;

                case "twitter":
                    try {
                        Intent intent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("twitter://user?screen_name=" + userID[1]));
                        startActivity(intent);

                    } catch (Exception e) {
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://twitter.com/#!/" + userID[1])));
                    }
                    break;

                case "googleplus":
                    try {


                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setClassName("com.google.android.apps.plus",
                                "com.google.android.apps.plus.phone.UrlGatewayActivity");
                        intent.putExtra("customAppUri", userID[1]);

                        startActivity(intent);

                    } catch (Exception e) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://plus.google.com/" + userID[1] + "/posts")));
                    }
                    break;

                case "linkedin":
                    try {

                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("linkedin://profile/" + userID[1]));
                        startActivity(intent);
                    } catch (Exception e) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
                    }
                    break;

                case "blog":
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
                    break;

                case "github":
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
                    break;

            }
        } else {
            Toast.makeText(getActivity(), "Kullanicinin "+platform + " hesabi kayitli degil.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fab_face:
                SosyalPlatformAc("facebook",facebookUrl);
                break;

            case R.id.fab_google:
                SosyalPlatformAc("googleplus",googleplusUrl);
                break;

            case R.id.fab_linkedin:
                SosyalPlatformAc("linkedin",linkedinUrl);
                break;
            case R.id.fab_twitter:
                SosyalPlatformAc("twitter",twitterUrl);
                break;
        }
    }
}
