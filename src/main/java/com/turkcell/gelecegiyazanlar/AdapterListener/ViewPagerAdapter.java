package com.turkcell.gelecegiyazanlar.adapterlistener;

/**
 * Created by asus on 24.8.2015.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import com.turkcell.gelecegiyazanlar.R;
import com.turkcell.gelecegiyazanlar.fragment.MobilFragment;
import com.turkcell.gelecegiyazanlar.fragment.OyunFragment;
import com.turkcell.gelecegiyazanlar.fragment.WebFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {


    private static int[] ICONS = new int[]{
            R.drawable.mobil_gri,
            R.drawable.web_gri,
            R.drawable.oyun_gri
    };
    CharSequence Titles[]; //ViewPager de�i�ti�i zaman ba�l�klar� depolar
    int NumbOfTabs; //  Tabs ta ka� eleman oldu�unu g�sterir


    public ViewPagerAdapter(FragmentManager fm, CharSequence mTitles[], int mNumbOfTabsumb) {
        super(fm);

        this.Titles = mTitles;
        this.NumbOfTabs = mNumbOfTabsumb;

    }

    //Hangi taba a t�klad�ysam o fragmenta ge�er.
    @Override
    public Fragment getItem(int position) {
        Log.d("log egitim", String.valueOf(position));
        if (position == 0) {

            MobilFragment tab1 = new MobilFragment();
            return tab1;

        } else if (position == 1)            //�rnek Tab
        {
            WebFragment tab2 = new WebFragment();
            return tab2;
        } else {

            OyunFragment tab3 = new OyunFragment();
            return tab3;
        }


    }


    @Override
    public CharSequence getPageTitle(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return ICONS.length;
    }

    public int getDrawableId(int position) {
        return ICONS[position];
    }
}
