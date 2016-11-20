package com.turkcell.gelecegiyazanlar.fragments;

import android.animation.Animator;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.LinearLayout;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.turkcell.gelecegiyazanlar.R;
import com.turkcell.gelecegiyazanlar.adapterlisteners.RecyclerAdapterBlog;
import com.turkcell.gelecegiyazanlar.configurations.AppController;
import com.turkcell.gelecegiyazanlar.configurations.GYConfiguration;
import com.turkcell.gelecegiyazanlar.databinding.FragmentBlogListeBinding;
import com.turkcell.gelecegiyazanlar.designs.SlidingTabLayout;
import com.turkcell.gelecegiyazanlar.models.Blog;
import com.turkcell.gelecegiyazanlar.utilities.TarihCevir;
import com.turkcell.gelecegiyazanlar.utilities.YuklenmeEkran;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;


public class BlogEtkinlikListeFragment extends Fragment {
    private FragmentBlogListeBinding fragmentBlogListeBinding;

    private JsonArrayRequest jsonArrayRequest;
    private String urlString;
    private YuklenmeEkran yuklenmeEkran;
    private TarihCevir tarihCevir;
    private List<Blog> blogArrayList = new ArrayList<>();
    private LinearLayout linearLayout;
    private Toolbar toolbar;
    private RecyclerAdapterBlog recyclerAdapterBlog;
    private int indexAnInt = -1;
    private int maksSizeAnInt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewPager viewPager = (ViewPager) getActivity().findViewById(R.id.viewPagerBlogFragment);
        SlidingTabLayout tabLayout = (SlidingTabLayout) getActivity().findViewById(R.id.slidingTabLayoutTabsBlogFragment);

        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbarMainActivity);
        linearLayout = (LinearLayout) getActivity().findViewById(R.id.linearLayoutUstBlokBlogFragment);

        View rootView = inflater.inflate(R.layout.fragment_blog_liste, container, false);


        fragmentBlogListeBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_blog_liste, container, false);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getBaseContext());
        fragmentBlogListeBinding.recyclerViewBlogListeFragment.setLayoutManager(linearLayoutManager);
        fragmentBlogListeBinding.recyclerViewBlogListeFragment.setHasFixedSize(true);
        fragmentBlogListeBinding.recyclerViewBlogListeFragment.setLayoutManager(new LinearLayoutManager(getActivity()));

        urlString = GYConfiguration.getDomain() + "article/retrieve?nitems=10&index=";
        yuklenmeEkran = new YuklenmeEkran(getActivity());
        tarihCevir = new TarihCevir();


        if (viewPager.getCurrentItem() == 0) {
            Listele(718, -1);
            Scroll(718);
        }
        Log.d("log1", String.valueOf(viewPager.getCurrentItem()));
        tabLayout.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                blogArrayList.clear();
                switch (position) {
                    case 0:
                        Listele(718, -1);
                        Scroll(718);
                        break;
                    case 1:
                        Listele(31, -1);
                        Scroll(31);
                        break;
                    case 2:

                        Listele(29, -1);
                        Scroll(29);

                        break;
                    case 3:
                        Listele(28, -1);
                        Scroll(28);

                        break;
                    case 4:
                        Listele(738, -1);
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

    public void Listele(int kategori, int x) {

        yuklenmeEkran.surecBasla();


        Log.d("urlBlog:", urlString + (1 + x) + "&kategoriID=" + kategori);
        jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, urlString + (1 + x) + "&kategoriID=" + kategori, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                yuklenmeEkran.surecDurdur();

                Log.d("Json:", response.toString());
                for (int i = 0; i < response.length(); i++) {


                    try {
                        String blogID = response.getJSONObject(i).getString("id");
                        String title = response.getJSONObject(i).getString("title");
                        String date = response.getJSONObject(i).getString("date");
                        String author = response.getJSONObject(i).getString("author");
                        String authorUrl = response.getJSONObject(i).getString("authorAvatarUrl");
                        String excerpt = response.getJSONObject(i).getString("excerpt").replace("<p>", "");
                        excerpt = excerpt.replace("</p>", "");
                        excerpt = excerpt.replace("&nbsp;", " ");
                        excerpt = excerpt.replace("&#039;", "'");
                        excerpt = excerpt.replace("&quot;", "\"");
                        String categories = response.getJSONObject(i).getString("categories");
                        String image = response.getJSONObject(i).getString("thumbnail");
                        String profilID = response.getJSONObject(i).getString("authorID");

                        Log.d("tag:", authorUrl);

                        String tarih = tarihCevir.Cevir(date);

                        blogArrayList.add(i, new Blog(title, tarih, author, excerpt, categories, authorUrl, image, profilID, blogID));


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                recyclerAdapterBlog =
                        new RecyclerAdapterBlog(blogArrayList, getActivity());
                fragmentBlogListeBinding.recyclerViewBlogListeFragment.setAdapter(recyclerAdapterBlog);
                maksSizeAnInt = blogArrayList.size();
                recyclerAdapterBlog.notifyDataSetChanged();

            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Json:", "hata");
            }
        });
        AppController.getInstance().addToRequestQueue(jsonArrayRequest);

    }


    public void dahaFazla(int kategori, int x) {

        yuklenmeEkran.surecBasla();

        Log.d("urlDaha:", urlString + (1 + x) + "&kategoriID=" + kategori);
        jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, urlString + (1 + x) + "&kategoriID=" + kategori, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                yuklenmeEkran.surecDurdur();

                Log.d("Json:", response.toString());
                for (int i = 0; i < response.length(); i++) {


                    try {
                        String blogID = response.getJSONObject(i).getString("id");
                        String title = response.getJSONObject(i).getString("title");
                        String date = response.getJSONObject(i).getString("date");
                        String author = response.getJSONObject(i).getString("author");
                        String authorUrl = response.getJSONObject(i).getString("authorAvatarUrl");
                        String excerpt = response.getJSONObject(i).getString("excerpt").replace("<p>", "");
                        excerpt = excerpt.replace("</p>", "");
                        excerpt = excerpt.replace("&nbsp;", " ");
                        excerpt = excerpt.replace("&#039;", "'");
                        excerpt = excerpt.replace("&quot;", "\"");
                        String categories = response.getJSONObject(i).getString("categories");
                        String image = response.getJSONObject(i).getString("thumbnail");
                        String profilID = response.getJSONObject(i).getString("authorID");

                        Log.d("tag:", authorUrl);

                        String tarih = tarihCevir.Cevir(date);

                        blogArrayList.add(i + maksSizeAnInt, new Blog(title, tarih, author, excerpt, categories, authorUrl, image, profilID, blogID));


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                maksSizeAnInt = maksSizeAnInt + 10;
                recyclerAdapterBlog.notifyDataSetChanged();


            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Json:", "hata");
            }
        });
        AppController.getInstance().addToRequestQueue(jsonArrayRequest);

    }

    public void Scroll(final int kategori) {

        fragmentBlogListeBinding.recyclerViewBlogListeFragment.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                /**
                 * Sürüklenme bittiðinde
                 */
                if (!recyclerView.canScrollVertically(1)) {
                    indexAnInt++;
                    dahaFazla(kategori, indexAnInt);

                    /**
                     * Aþaðý Sürüklendiðinde
                     */
                } else if (dy > 0) {
                    linearLayout.animate()
                            .translationY(-linearLayout.getBottom() - toolbar.getBottom())
                            .setInterpolator(new AccelerateInterpolator(2))
                            .setListener(new Animator.AnimatorListener() {
                                @Override
                                public void onAnimationStart(Animator animation) {

                                }

                                @Override
                                public void onAnimationEnd(Animator animation) {
                                    linearLayout.setVisibility(View.GONE);
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