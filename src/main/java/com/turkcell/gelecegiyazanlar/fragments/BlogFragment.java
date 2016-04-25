package com.turkcell.gelecegiyazanlar.fragments;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.turkcell.gelecegiyazanlar.R;
import com.turkcell.gelecegiyazanlar.adapterlisteners.ViewPagerAdapterBlogEtkinlik;
import com.turkcell.gelecegiyazanlar.designs.SlidingTabLayout;


public class BlogFragment extends android.support.v4.app.Fragment {
    public SlidingTabLayout tabs;
    Toolbar toolbar;
    CharSequence titles[];
    int numbOfTabs = 8;

    ViewPager pager;
    ViewPagerAdapterBlogEtkinlik adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        toolbar = (Toolbar) getActivity().findViewById(R.id.tool_bar);
        View rootView = inflater.inflate(R.layout.fragment_blog, container, false);
        //ViewPager'a ait tab'larda görünecek yazýlar
        titles = new CharSequence[]{
                getString(R.string.blog_kategori_tumu),
                getString(R.string.blog_kategori_gelecegi_yazanlar),
                getString(R.string.blog_kategori_mobil),
                getString(R.string.blog_kategori_android),
                getString(R.string.blog_kategori_ios),
                getString(R.string.blog_kategori_wp),
                getString(R.string.blog_kategori_oyun),
                getString(R.string.blog_kategori_tasarim)

        };

        // Baþlýklarý,tab sayýsýný adapterda tanýmlar
        adapter = new ViewPagerAdapterBlogEtkinlik(getFragmentManager(), titles, numbOfTabs);


        pager = (ViewPager) rootView.findViewById(R.id.pagerBlog);
        pager.setAdapter(adapter);


        tabs = (SlidingTabLayout) rootView.findViewById(R.id.tabsBlog);
        tabs.setDistributeEvenly(true); // tablarýn düzenlenebilir olmasýný saðlar
        //tabs.setSelectedIndicatorColors(getResources().getColor(R.color.beyaz_renk));
        //bkz: http://stackoverflow.com/questions/31590714/getcolorint-id-deprecated-on-android-6-0-marshmallow-api-23
        tabs.setSelectedIndicatorColors(ContextCompat.getColor(getActivity(),R.color.beyaz_renk));

        tabs.setViewPager(pager);


        return rootView;
    }


}


