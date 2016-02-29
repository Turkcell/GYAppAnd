package com.turkcell.gelecegiyazanlar.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.splunk.mint.Mint;
import com.turkcell.gelecegiyazanlar.R;
import com.turkcell.gelecegiyazanlar.adapterlistener.ViewPagerAdapterArama;
import com.turkcell.gelecegiyazanlar.configuration.GYConfiguration;
import com.turkcell.gelecegiyazanlar.fragment.AramaFragment;
import com.turkcell.gelecegiyazanlar.fragment.IcerikAramaFragment;

public class AramaActivity extends AppCompatActivity {

    public TabLayout tabs;

    ViewPager pager;
    ViewPagerAdapterArama adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arama);

        Mint.initAndStartSession(AramaActivity.this, GYConfiguration.SPLUNK_ID);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar_ara);
        setSupportActionBar(toolbar);


        if (!GYConfiguration.isNetworkAvailable(AramaActivity.this)) {
            final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage(getResources().getString(R.string.internet_uyari));

            alertDialogBuilder.setPositiveButton(getResources().getString(R.string.tamam), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                    arg0.dismiss();
                }
            });


            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }


        pager = (ViewPager) findViewById(R.id.pagerArama);
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                managePageChanged();
            }

            @Override
            public void onPageSelected(int position) {
                managePageChanged();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        MyPagerAdapter pagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(pagerAdapter);


        tabs = (TabLayout) findViewById(R.id.tabsArama);
        tabs.setTabsFromPagerAdapter(pagerAdapter);


        tabs.setupWithViewPager(pager);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.left_back));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public Fragment getCurrentFragment() {
        Fragment page = getSupportFragmentManager().findFragmentByTag("android:switcher:" + R.id.pagerArama + ":" + pager.getCurrentItem());
        return page;
    }

    private void managePageChanged() {
        IArama aramaFragment = (IArama) getCurrentFragment();
        if (aramaFragment != null)
            aramaFragment.onPageActivated();
    }

    public static interface IArama {
        void onPageActivated();
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int pos) {
            switch (pos) {

                case 0:
                    return IcerikAramaFragment.newInstance();
                case 1:
                    return AramaFragment.newInstance();
                default:
                    return IcerikAramaFragment.newInstance();
            }
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            String title;
            if (position == 0) {
                title = "ÝÇERÝKLER";
            } else {
                title = "KULLANICILAR";
            }
            return title;
        }
    }


}
