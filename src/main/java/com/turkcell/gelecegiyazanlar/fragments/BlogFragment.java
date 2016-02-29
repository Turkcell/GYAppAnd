package com.turkcell.gelecegiyazanlar.fragments;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.turkcell.gelecegiyazanlar.R;
import com.turkcell.gelecegiyazanlar.adapterlisteners.ViewPagerAdapterBlogEtkinlik;
import com.turkcell.gelecegiyazanlar.designs.SlidingTabLayout;


public class BlogFragment extends android.support.v4.app.Fragment {
    Toolbar toolbar;
    public SlidingTabLayout tabs;
    CharSequence Titles[]={"GELECEÐÝ YAZANLAR","MOBÝL","ANDROID","IOS","WINDOWS PHONE"};
    int Numboftabs =5;

    ViewPager pager;
    ViewPagerAdapterBlogEtkinlik adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        toolbar=(Toolbar)getActivity().findViewById(R.id.tool_bar);
        View rootView= inflater.inflate(R.layout.fragment_blog, container, false);


        // Baþlýklarý,tab sayýsýný adapterda tanýmlar
        adapter =  new ViewPagerAdapterBlogEtkinlik(getFragmentManager(),Titles,Numboftabs);


        pager = (ViewPager) rootView.findViewById(R.id.pagerBlog);
        pager.setAdapter(adapter);


        tabs = (SlidingTabLayout) rootView.findViewById(R.id.tabsBlog);
        tabs.setDistributeEvenly(true); // tablarýn düzenlenebilir olmasýný saðlar
        tabs.setSelectedIndicatorColors(getResources().getColor(R.color.beyaz_renk));

        tabs.setViewPager(pager);




        return rootView;
    }


}


