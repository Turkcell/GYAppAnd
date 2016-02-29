package com.turkcell.gelecegiyazanlar.activities;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

import com.splunk.mint.Mint;
import com.turkcell.gelecegiyazanlar.R;
import com.turkcell.gelecegiyazanlar.adapterlisteners.ViewPagerAdapterProfil;
import com.turkcell.gelecegiyazanlar.configurations.GYConfiguration;
import com.turkcell.gelecegiyazanlar.designs.SlidingTabLayout;

public class ProfilActivity extends ActionBarActivity {

    public SlidingTabLayout tabs;
    CharSequence Titles[] = {getString(R.string.profil_baslik_hakkinda), getString(R.string.profil_baslik_basari_belgeleri)};
    int Numboftabs = 2;

    ViewPager pager;
    ViewPagerAdapterProfil adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        Mint.initAndStartSession(ProfilActivity.this, GYConfiguration.SPLUNK_ID);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar_back);
        setSupportActionBar(toolbar);


        adapter = new ViewPagerAdapterProfil(getSupportFragmentManager(), Titles, Numboftabs);

        pager = (ViewPager) findViewById(R.id.pagerProfil);
        pager.setAdapter(adapter);


        tabs = (SlidingTabLayout) findViewById(R.id.tabsBlog);
        tabs.setDistributeEvenly(true); // tablar?n d?zenlenebilir olmas?n? sa?lar
        tabs.setSelectedIndicatorColors(getResources().getColor(R.color.beyaz_renk));

        tabs.setViewPager(pager);
    }


}