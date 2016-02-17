package com.turkcell.gelecegiyazanlar.FragmentPaketi;

import android.animation.Animator;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonArrayRequest;
import com.turkcell.gelecegiyazanlar.AdapterVeListenerPaketi.RecyclerAdapterBlog;
import com.turkcell.gelecegiyazanlar.AnimasyonPaketi.DerinSayfaDegisimi;
import com.turkcell.gelecegiyazanlar.AppController;
import com.turkcell.gelecegiyazanlar.ClassPaketi.Blog;
import com.turkcell.gelecegiyazanlar.ClassPaketi.Kisi;
import com.turkcell.gelecegiyazanlar.DesignEklentileri.SlidingTabLayout;
import com.turkcell.gelecegiyazanlar.GYConfiguration;
import com.turkcell.gelecegiyazanlar.R;
import com.turkcell.gelecegiyazanlar.Utils.TarihCevir;
import com.turkcell.gelecegiyazanlar.Utils.YuklenmeEkran;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;


public class BlogEtkinlikListeFragment extends Fragment{

    JsonArrayRequest request;

    String url;
    YuklenmeEkran yuklenmeEkran;
    TarihCevir tarihCevir;

    List<Blog> itemList = new ArrayList<>();
    RecyclerView recyclerView;


    private int index = -1;
    LinearLayout layout;
    Toolbar toolbar;

    private int maksSize ;
    RecyclerAdapterBlog recyclerAdapterBlog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



       ViewPager viewPager=(ViewPager)getActivity().findViewById(R.id.pagerBlog);
        SlidingTabLayout tabLayout=(SlidingTabLayout)getActivity().findViewById(R.id.tabsBlog);

        toolbar=(Toolbar)getActivity().findViewById(R.id.tool_bar);
        layout=(LinearLayout)getActivity().findViewById(R.id.ust_blok);
        View rootView= inflater.inflate(R.layout.fragment_blog_liste, container, false);
         recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getBaseContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        url= GYConfiguration.getDomain()+"article/retrieve?nitems=10&index=";
        yuklenmeEkran=new YuklenmeEkran(getActivity());
        tarihCevir=new TarihCevir();



    if(viewPager.getCurrentItem()==0){
        Listele(718,-1);
       Scroll(718);
    }
        Log.d("log1", String.valueOf(viewPager.getCurrentItem()));
    tabLayout.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            itemList.clear();
            switch (position){
                case 0:
                    Log.d("log1", "gy");
                    Listele(718, 0);
                    Scroll(718);
                    break;
                case 1:
                    Log.d("log2", "mobildeyim");
                    Listele(31, 0);
                    Scroll(31);
                    break;
                case 2:
                    Log.d("log3", "android");
                    Listele(29, 0);
                     Scroll(29);

                    break;
                case 3:
                    Listele(28, 0);
                    Scroll(28);

                    break;
                case 4:
                    Listele(738, 0);
                      Scroll(738);

                    break;
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    });





        return rootView;

    }
    Bitmap avatarIcon;
int a=0;

    public void Listele(int kategori,int x){

        if(GYConfiguration.checkInternetConnectionShowDialog(getActivity())){
            yuklenmeEkran.surecBasla();
        }

        Log.d("urlBlog:", url+(1+x)+"&kategoriID="+kategori);
        request = new JsonArrayRequest(Request.Method.GET, url+(1+x)+"&kategoriID="+kategori, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                yuklenmeEkran.surecDurdur();

                Log.d("Json:", response.toString());
                for (int i = 0; i < response.length(); i++) {



                    try {
                        String blogID=response.getJSONObject(i).getString("id");
                        String title = response.getJSONObject(i).getString("title");
                        String date = response.getJSONObject(i).getString("date");
                        String author = response.getJSONObject(i).getString("author");
                        String authorUrl = response.getJSONObject(i).getString("authorAvatarUrl");
                        String excerpt = response.getJSONObject(i).getString("excerpt").replace("<p>", "");
                        excerpt=excerpt.replace("</p>","");
                        excerpt=excerpt.replace("&nbsp;"," ");
                        excerpt=excerpt.replace("&#039;", "'");
                        excerpt=excerpt.replace("&quot;", "\"");
                        String categories = response.getJSONObject(i).getString("categories");
                        String image=response.getJSONObject(i).getString("thumbnail");
                        String profilID=response.getJSONObject(i).getString("authorID");

                        Log.d("tag:", authorUrl);

                        String tarih=tarihCevir.Cevir(date);

                            itemList.add(i,new Blog(title, tarih, author, excerpt,categories,authorUrl,image,profilID,blogID));



                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                 recyclerAdapterBlog =
                        new RecyclerAdapterBlog(itemList, getActivity());
                recyclerView.setAdapter(recyclerAdapterBlog);
                maksSize=itemList.size();
                recyclerAdapterBlog.notifyDataSetChanged();

            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Json:", "hata");
            }
        });
        AppController.getInstance().addToRequestQueue(request);

    }


    public void dahaFazla(int kategori,int x){

        yuklenmeEkran.surecBasla();

        Log.d("urlDaha:", url+(1+x)+"&kategoriID="+kategori);
        request = new JsonArrayRequest(Request.Method.GET, url+(1+x)+"&kategoriID="+kategori, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                yuklenmeEkran.surecDurdur();

                Log.d("Json:", response.toString());
                for (int i = 0; i < response.length(); i++) {



                    try {
                        String blogID=response.getJSONObject(i).getString("id");
                        String title = response.getJSONObject(i).getString("title");
                        String date = response.getJSONObject(i).getString("date");
                        String author = response.getJSONObject(i).getString("author");
                        String authorUrl = response.getJSONObject(i).getString("authorAvatarUrl");
                        String excerpt = response.getJSONObject(i).getString("excerpt").replace("<p>", "");
                        excerpt=excerpt.replace("</p>","");
                        excerpt=excerpt.replace("&nbsp;"," ");
                        excerpt=excerpt.replace("&#039;", "'");
                        excerpt=excerpt.replace("&quot;", "\"");
                        String categories = response.getJSONObject(i).getString("categories");
                        String image=response.getJSONObject(i).getString("thumbnail");
                        String profilID=response.getJSONObject(i).getString("authorID");

                        Log.d("tag:", authorUrl);

                        String tarih=tarihCevir.Cevir(date);

                        itemList.add(i + maksSize, new Blog(title, tarih, author, excerpt, categories, authorUrl, image, profilID, blogID));



                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                maksSize=maksSize+10;
                recyclerAdapterBlog.notifyDataSetChanged();


            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Json:", "hata");
            }
        });
        AppController.getInstance().addToRequestQueue(request);

    }

    public void Scroll(final int kategori){

        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                /**
                 * Sürüklenme bittiðinde
                 */
                if (!recyclerView.canScrollVertically(1)) {
                    index++;
                    dahaFazla(kategori,index);

                    /**
                     * Aþaðý Sürüklendiðinde
                     */
                } else if (dy > 0) {
                    layout.animate()
                            .translationY(-layout.getBottom()-toolbar.getBottom())
                            .setInterpolator(new AccelerateInterpolator(2))
                            .setListener(new Animator.AnimatorListener() {
                                @Override
                                public void onAnimationStart(Animator animation) {

                                }

                                @Override
                                public void onAnimationEnd(Animator animation) {
                                    layout.setVisibility(View.GONE);
                                }

                                @Override
                                public void onAnimationCancel(Animator animation) {

                                }

                                @Override
                                public void onAnimationRepeat(Animator animation) {

                                }
                            })
                            .start();


                }
            }
        });
    }



}


