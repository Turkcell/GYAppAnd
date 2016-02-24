package com.turkcell.gelecegiyazanlar.Activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.splunk.mint.Mint;
import com.turkcell.gelecegiyazanlar.AdapterListener.ViewPagerAdapterProfil;
import com.turkcell.gelecegiyazanlar.DesignEklentileri.SlidingTabLayout;
import com.turkcell.gelecegiyazanlar.R;

public class ProfilActivity extends ActionBarActivity {

    public SlidingTabLayout tabs;
    CharSequence Titles[]={"Hakkýnda","Baþarý Belgeleri"};
    int Numboftabs =2;

    ViewPager pager;
    ViewPagerAdapterProfil adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        Mint.initAndStartSession(ProfilActivity.this, "75ff8154");
        Toolbar toolbar=(Toolbar)findViewById(R.id.tool_bar_back);
        setSupportActionBar(toolbar);
        

        adapter =  new ViewPagerAdapterProfil(getSupportFragmentManager(),Titles,Numboftabs);


        pager = (ViewPager)findViewById(R.id.pagerProfil);
        pager.setAdapter(adapter);


        tabs = (SlidingTabLayout)findViewById(R.id.tabsBlog);
        tabs.setDistributeEvenly(true); // tablar?n d?zenlenebilir olmas?n? sa?lar
        tabs.setSelectedIndicatorColors(getResources().getColor(R.color.beyaz_renk));

        tabs.setViewPager(pager);
    }



}
