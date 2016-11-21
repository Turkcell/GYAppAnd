package com.turkcell.gelecegiyazanlar.fragments;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
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
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.turkcell.gelecegiyazanlar.R;
import com.turkcell.gelecegiyazanlar.configurations.AppController;
import com.turkcell.gelecegiyazanlar.configurations.GYConfiguration;
import com.turkcell.gelecegiyazanlar.databinding.FragmentProfilBinding;
import com.turkcell.gelecegiyazanlar.designs.SlidingTabLayout;
import com.turkcell.gelecegiyazanlar.models.Kisi;
import com.turkcell.gelecegiyazanlar.utilities.YuklenmeEkran;

import org.json.JSONException;
import org.json.JSONObject;


public class ProfilFragment extends Fragment implements View.OnClickListener {

    private FragmentProfilBinding fragmentProfilBinding;

    private JsonObjectRequest jsonObjectRequest;
    private ImageRequest imageRequest;

    private String kategoriString;
    private String hakkindaTemizString;
    private String avatarUrlString;
    private String idString;
    private String urlString;
    private String facebookUrlString;
    private String twitterUrlString;
    private String googleplusUrlString;
    private String linkedinUrlString;
    private String githubUrlString;
    private String blogUrlString;

    private YuklenmeEkran yuklenmeEkran;

    private TextView isimTextView, yasadigiSegirTextView, universiteTextView, hakkindaTextView;
    private ImageView avatarImageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        fragmentProfilBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_profil, container, false);
        View rootView = fragmentProfilBinding.getRoot();

        urlString = GYConfiguration.getDomain() + "profil/retrieve?userID=";

        yuklenmeEkran = new YuklenmeEkran(getActivity());

        isimTextView = (TextView) getActivity().findViewById(R.id.textViewAdSoyadProfilActivity);
        yasadigiSegirTextView = (TextView) getActivity().findViewById(R.id.textViewKonumProfilActivity);
        universiteTextView = (TextView) getActivity().findViewById(R.id.textViewUniversiteProfilActivity);
        hakkindaTextView = (TextView) rootView.findViewById(R.id.textViewHakkindaProfilFragment);
        avatarImageView = (ImageView) getActivity().findViewById(R.id.circleImageViewAvatarProfilActivity);

        SlidingTabLayout tabs = (SlidingTabLayout) getActivity().findViewById(R.id.slidingTabLayoutTabsBlogFragment);

        final FrameLayout frameLayout = (FrameLayout) rootView.findViewById(R.id.frameLay);
        final FloatingActionsMenu fabMenu = (FloatingActionsMenu) rootView.findViewById(R.id.floatActionButtonMenuProfilFragment);

        fragmentProfilBinding.floatActionButtonFacebookProfilFragment.setOnClickListener(this);
        fragmentProfilBinding.floatActionButtonTwitterProfilFragment.setOnClickListener(this);
        fragmentProfilBinding.floatActionButtonLinkedinProfilFragment.setOnClickListener(this);
        fragmentProfilBinding.floatActionButtonGoogleProfilFragment.setOnClickListener(this);

        fabMenu.setOnFloatingActionsMenuUpdateListener(new FloatingActionsMenu.OnFloatingActionsMenuUpdateListener() {

            @Override
            public void onMenuExpanded() {
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

                frameLayout.setOnTouchListener(null);
            }
        });


        Bundle extra = getActivity().getIntent().getExtras();
        idString = extra.getString(Kisi.PROFIL_ID);

        tabs.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                if (position == 1) {
                    fragmentProfilBinding.linearLayoutBasariBelgeleriProfilFragment.setVisibility(View.VISIBLE);
                    fragmentProfilBinding.linearLayoutBasariBelgeleriCizgiProfilFragment.setVisibility(View.VISIBLE);
                    fragmentProfilBinding.linearLayoutHakkindaProfilFragment.setVisibility(View.INVISIBLE);
                    fragmentProfilBinding.linearLayoutHakkindaCizgiProfilFragment.setVisibility(View.INVISIBLE);
                    fabMenu.setVisibility(View.GONE);
                } else {
                    fragmentProfilBinding.linearLayoutBasariBelgeleriProfilFragment.setVisibility(View.INVISIBLE);
                    fragmentProfilBinding.linearLayoutBasariBelgeleriCizgiProfilFragment.setVisibility(View.INVISIBLE);
                    fragmentProfilBinding.linearLayoutHakkindaProfilFragment.setVisibility(View.VISIBLE);
                    fragmentProfilBinding.linearLayoutHakkindaCizgiProfilFragment.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        EkleYazi(idString);

        return rootView;
    }


    public void EkleYazi(String id) {

        yuklenmeEkran.surecBasla();

        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, urlString + id, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                yuklenmeEkran.surecDurdur();
                try {

                    isimTextView.setText(response.getString("adSoyad"));
                    yasadigiSegirTextView.setText(response.getString("yasadigiSehir"));
                    universiteTextView.setText(response.getString("universite"));
                    avatarUrlString = response.getString("avatarUrl");

                    facebookUrlString = response.getJSONObject("sosyalAglar").getString("facebook");
                    twitterUrlString = response.getJSONObject("sosyalAglar").getString("twitter");
                    googleplusUrlString = response.getJSONObject("sosyalAglar").getString("googleplus");
                    linkedinUrlString = response.getJSONObject("sosyalAglar").getString("linkedin");
                    githubUrlString = response.getJSONObject("sosyalAglar").getString("github");
                    blogUrlString = response.getJSONObject("sosyalAglar").getString("blog");

                    hakkindaTemizString = response.getString("hakkinda").replace("&#039;", "'");
                    hakkindaTemizString = hakkindaTemizString.replace("&amp", "&");
                    hakkindaTemizString = hakkindaTemizString.replace(";amp;", " ");
                    hakkindaTemizString = hakkindaTemizString.replace("&quot;", "\"");
                    if (hakkindaTemizString != "null") {
                        hakkindaTextView.setText(hakkindaTemizString);
                    } else
                        hakkindaTextView.setText("");

                    for (int i = 0; i < response.getJSONObject("basariBelgeleri").length(); i++) {

                        kategoriString = response.getJSONObject("basariBelgeleri").getJSONObject(Integer.toString(i + 1)).getString("kategori");

                        if (kategoriString.equals("Android")) {

                            if (response.getJSONObject("basariBelgeleri").getJSONObject(Integer.toString(i + 1)).getString("zorlukSeviyesi").equals("101")) {

                                fragmentProfilBinding.imageViewAndroid101ProfilFragment.setVisibility(View.VISIBLE);
                            } else if (response.getJSONObject("basariBelgeleri").getJSONObject(Integer.toString(i + 1)).getString("zorlukSeviyesi").equals("201")) {
                                fragmentProfilBinding.imageViewAndroid201ProfilFragment.setVisibility(View.VISIBLE);
                            } else if (response.getJSONObject("basariBelgeleri").getJSONObject(Integer.toString(i + 1)).getString("zorlukSeviyesi").equals("301")) {
                                fragmentProfilBinding.imageViewAndroid301ProfilFragment.setVisibility(View.VISIBLE);
                            } else if (response.getJSONObject("basariBelgeleri").getJSONObject(Integer.toString(i + 1)).getString("zorlukSeviyesi").equals("401")) {
                                fragmentProfilBinding.imageViewAndroid401ProfilFragment.setVisibility(View.VISIBLE);
                            }

                        } else if (kategoriString.equals("iOS")) {

                            if (response.getJSONObject("basariBelgeleri").getJSONObject(Integer.toString(i + 1)).getString("zorlukSeviyesi").equals("101")) {
                                fragmentProfilBinding.imageViewIos101ProfilFragment.setVisibility(View.VISIBLE);
                            } else if (response.getJSONObject("basariBelgeleri").getJSONObject(Integer.toString(i + 1)).getString("zorlukSeviyesi").equals("201")) {
                                fragmentProfilBinding.imageViewIos201ProfilFragment.setVisibility(View.VISIBLE);
                            } else if (response.getJSONObject("basariBelgeleri").getJSONObject(Integer.toString(i + 1)).getString("zorlukSeviyesi").equals("301")) {
                                fragmentProfilBinding.imageViewIos301ProfilFragment.setVisibility(View.VISIBLE);
                            } else if (response.getJSONObject("basariBelgeleri").getJSONObject(Integer.toString(i + 1)).getString("zorlukSeviyesi").equals("401")) {
                                fragmentProfilBinding.imageViewIos401ProfilFragment.setVisibility(View.VISIBLE);
                            }

                        } else if (kategoriString.equals("Windows Phone")) {

                            if (response.getJSONObject("basariBelgeleri").getJSONObject(Integer.toString(i + 1)).getString("zorlukSeviyesi").equals("101")) {
                                fragmentProfilBinding.imageViewWp101ProfilFragment.setVisibility(View.VISIBLE);
                            } else if (response.getJSONObject("basariBelgeleri").getJSONObject(Integer.toString(i + 1)).getString("zorlukSeviyesi").equals("201")) {
                                fragmentProfilBinding.imageViewWp201ProfilFragment.setVisibility(View.VISIBLE);
                            }

                        } else if (kategoriString.equals("Mobil Oyun")) {

                            if (response.getJSONObject("basariBelgeleri").getJSONObject(Integer.toString(i + 1)).getString("zorlukSeviyesi").equals("101")) {
                                fragmentProfilBinding.imageViewMobilOyun101ProfilFragment.setVisibility(View.VISIBLE);
                            } else if (response.getJSONObject("basariBelgeleri").getJSONObject(Integer.toString(i + 1)).getString("zorlukSeviyesi").equals("201")) {
                                fragmentProfilBinding.imageViewMobilOyun201ProfilFragment.setVisibility(View.VISIBLE);
                            }

                        } else if (kategoriString.equals("Web Programlama")) {

                            if (response.getJSONObject("basariBelgeleri").getJSONObject(Integer.toString(i + 1)).getString("zorlukSeviyesi").equals("101")) {
                                fragmentProfilBinding.imageViewWeb101ProfilFragment.setVisibility(View.VISIBLE);
                            } else if (response.getJSONObject("basariBelgeleri").getJSONObject(Integer.toString(i + 1)).getString("zorlukSeviyesi").equals("201")) {
                                fragmentProfilBinding.imageViewWeb201ProfilFragment.setVisibility(View.VISIBLE);
                            } else if (response.getJSONObject("basariBelgeleri").getJSONObject(Integer.toString(i + 1)).getString("zorlukSeviyesi").equals("301")) {
                                fragmentProfilBinding.imageViewWeb301ProfilFragment.setVisibility(View.VISIBLE);
                            } else if (response.getJSONObject("basariBelgeleri").getJSONObject(Integer.toString(i + 1)).getString("zorlukSeviyesi").equals("401")) {
                                fragmentProfilBinding.imageViewWeb401ProfilFragment.setVisibility(View.VISIBLE);
                            }

                        } else if (kategoriString.equals("Scratch")) {

                            if (response.getJSONObject("basariBelgeleri").getJSONObject(Integer.toString(i + 1)).getString("zorlukSeviyesi").equals("101")) {
                                fragmentProfilBinding.imageViewScratch101ProfilFragment.setVisibility(View.VISIBLE);
                            } else if (response.getJSONObject("basariBelgeleri").getJSONObject(Integer.toString(i + 1)).getString("zorlukSeviyesi").equals("201")) {
                                fragmentProfilBinding.imageViewScratch201ProfilFragment.setVisibility(View.VISIBLE);
                            }

                        } else if (kategoriString.equals("App Inventor")) {

                            if (response.getJSONObject("basariBelgeleri").getJSONObject(Integer.toString(i + 1)).getString("zorlukSeviyesi").equals("101")) {
                                fragmentProfilBinding.imageViewAi101ProfilFragment.setVisibility(View.VISIBLE);
                            } else if (response.getJSONObject("basariBelgeleri").getJSONObject(Integer.toString(i + 1)).getString("zorlukSeviyesi").equals("201")) {
                                fragmentProfilBinding.imageViewAi201ProfilFragment.setVisibility(View.VISIBLE);
                            } else if (response.getJSONObject("basariBelgeleri").getJSONObject(Integer.toString(i + 1)).getString("zorlukSeviyesi").equals("301")) {
                                fragmentProfilBinding.imageViewAi301ProfilFragment.setVisibility(View.VISIBLE);
                            }
                        } else if (kategoriString.equals("Arduino")) {

                            if (response.getJSONObject("basariBelgeleri").getJSONObject(Integer.toString(i + 1)).getString("zorlukSeviyesi").equals("101")) {
                                fragmentProfilBinding.imageViewArduino101ProfilFragment.setVisibility(View.VISIBLE);
                            } else if (response.getJSONObject("basariBelgeleri").getJSONObject(Integer.toString(i + 1)).getString("zorlukSeviyesi").equals("201")) {
                                fragmentProfilBinding.imageViewArduino101ProfilFragment.setVisibility(View.VISIBLE);
                            } else if (response.getJSONObject("basariBelgeleri").getJSONObject(Integer.toString(i + 1)).getString("zorlukSeviyesi").equals("301")) {
                                fragmentProfilBinding.imageViewArduino101ProfilFragment.setVisibility(View.VISIBLE);
                            } else if (response.getJSONObject("basariBelgeleri").getJSONObject(Integer.toString(i + 1)).getString("zorlukSeviyesi").equals("401")) {
                                fragmentProfilBinding.imageViewArduino101ProfilFragment.setVisibility(View.VISIBLE);
                            }

                        }


                    }
                    ResimGetir();

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        AppController.getInstance().addToRequestQueue(jsonObjectRequest, "profilTag");
    }

    public void ResimGetir() {

        imageRequest = new ImageRequest(avatarUrlString, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {

                avatarImageView.setImageBitmap(response);
            }
        }, 0, 0, null, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        AppController.getInstance().addToRequestQueue(imageRequest, "profilResimTag");

    }

    @Override
    public void onStop() {
        super.onStop();
        AppController.getInstance().cancelPendingRequests("profilTag");
        AppController.getInstance().cancelPendingRequests("profilResimTag");
    }


    private void SosyalPlatformAc(String platform, String Url) {


        if (Url != "null") {
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
            Toast.makeText(getActivity(), "Kullanicinin " + platform + " hesabi kayitli degil.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.floatActionButtonFacebookProfilFragment:
                SosyalPlatformAc("facebook", facebookUrlString);
                break;

            case R.id.floatActionButtonGoogleProfilFragment:
                SosyalPlatformAc("googleplus", googleplusUrlString);
                break;

            case R.id.floatActionButtonLinkedinProfilFragment:
                SosyalPlatformAc("linkedin", linkedinUrlString);
                break;
            case R.id.floatActionButtonTwitterProfilFragment:
                SosyalPlatformAc("twitter", twitterUrlString);
                break;
        }
    }
}
