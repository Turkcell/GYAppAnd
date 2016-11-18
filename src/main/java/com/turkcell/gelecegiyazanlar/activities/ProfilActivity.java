package com.turkcell.gelecegiyazanlar.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.splunk.mint.Mint;
import com.turkcell.gelecegiyazanlar.R;
import com.turkcell.gelecegiyazanlar.adapterlisteners.ViewPagerAdapterProfil;
import com.turkcell.gelecegiyazanlar.configurations.GYConfiguration;
import com.turkcell.gelecegiyazanlar.databinding.ActivityProfilBinding;
import com.turkcell.gelecegiyazanlar.designs.SlidingTabLayout;

public class ProfilActivity extends AppCompatActivity {

    private ActivityProfilBinding activityProfilBinding;

    private CharSequence titleCharSequences[];
    private int tabSayisiAnInt = 2;

    private ViewPagerAdapterProfil viewPagerAdapterProfil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityProfilBinding = DataBindingUtil.setContentView(this,R.layout.activity_profil);

        Mint.initAndStartSession(ProfilActivity.this, GYConfiguration.SPLUNK_ID);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar_back);
        setSupportActionBar(toolbar);

        titleCharSequences = new CharSequence[]{getString(R.string.profil_baslik_hakkinda),
                getString(R.string.profil_baslik_basari_belgeleri)};

        viewPagerAdapterProfil = new ViewPagerAdapterProfil(getSupportFragmentManager(), titleCharSequences, tabSayisiAnInt);

        activityProfilBinding.viewPagerPagerProfil.setAdapter(viewPagerAdapterProfil);

        activityProfilBinding.slidingTabLayoutTabsBlog.setDistributeEvenly(true);
        activityProfilBinding.slidingTabLayoutTabsBlog.setSelectedIndicatorColors(ContextCompat.getColor(getApplicationContext(), R.color.beyaz_renk));

        activityProfilBinding.slidingTabLayoutTabsBlog.setViewPager(activityProfilBinding.viewPagerPagerProfil);
    }


}