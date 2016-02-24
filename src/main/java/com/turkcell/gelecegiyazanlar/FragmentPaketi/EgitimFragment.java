package com.turkcell.gelecegiyazanlar.FragmentPaketi;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.turkcell.gelecegiyazanlar.DesignEklentileri.SlidingTabLayout;
import com.turkcell.gelecegiyazanlar.R;
import com.turkcell.gelecegiyazanlar.DesignEklentileri.SlidingTabLayoutIcon;
import com.turkcell.gelecegiyazanlar.AdapterVeListenerPaketi.ViewPagerAdapter;


/**
 * Eðitim sayfasýnýn fragment ý
 */
public class EgitimFragment extends Fragment {

    SharedPreferences preferences;

    android.support.v7.widget.Toolbar toolbar;
    ViewPager pager;
    ViewPagerAdapter adapter;
    public SlidingTabLayoutIcon tabs;
    CharSequence Titles[]={"Mobil","Web","Oyun"};
    int Numboftabs =3;
    ImageView ust_logo;

    public EgitimFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_egitim, container, false);

        ust_logo=(ImageView)rootView.findViewById(R.id.logo_ust_ekran);

        //Baslangýc resmi
        ust_logo.setImageResource(R.drawable.mobil_ust_logo);

        // Baþlýklarý,tab sayýsýný adapterda tanýmlar
        adapter =  new ViewPagerAdapter(getFragmentManager(),Titles,Numboftabs);


        pager = (ViewPager) rootView.findViewById(R.id.pager);
        pager.setAdapter(adapter);

        // Tablarýn görünüm menüsü
        tabs = (SlidingTabLayoutIcon) rootView.findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true); // tablarýn düzenlenebilir olmasýný saðlar

      tabs.setSelectedIndicatorColors(getResources().getColor(R.color.selector));

        // pagerý tablara baðladýk.
        tabs.setViewPager(pager);

        resimDegisikligiTabDinleyici();

        return rootView;
    }

    /**
     * Resim deðiþikliði saðlar..
     */
    public void resimDegisikligiTabDinleyici(){
        tabs.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        ust_logo.setImageResource(R.drawable.mobil_ust_logo);
                        break;
                    case 1:
                        ust_logo.setImageResource(R.drawable.web_ust_logo);
                        break;
                    case 2:
                        ust_logo.setImageResource(R.drawable.oyun_ust_logo);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }



}
