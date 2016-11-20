package com.turkcell.gelecegiyazanlar.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.turkcell.gelecegiyazanlar.R;
import com.turkcell.gelecegiyazanlar.adapterlisteners.ViewPagerAdapter;
import com.turkcell.gelecegiyazanlar.databinding.FragmentEgitimBinding;


/**
 * Eðitim sayfasýnýn fragment ý
 */
public class EgitimFragment extends Fragment {

    private FragmentEgitimBinding fragmentEgitimBinding;

    private CharSequence[] titlesCharSequences;
    private int numbOfTabsAnInt = 3;

    public EgitimFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        fragmentEgitimBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_egitim, container, false);

        View rootView = fragmentEgitimBinding.getRoot();

        titlesCharSequences = new CharSequence[]{
                getString(R.string.egitim_kategori_mobil),
                getString(R.string.egitim_kategori_web),
                getString(R.string.egitim_kategori_oyun)
        };

        // Baþlýklarý,tab sayýsýný adapterda tanýmlar
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getFragmentManager(), titlesCharSequences, numbOfTabsAnInt);
        fragmentEgitimBinding.viewPagerEgitimFragment.setAdapter(viewPagerAdapter);

        // Tablarýn görünüm menüsü

        fragmentEgitimBinding.slidingTabLayoutIconEgitimFragment.setDistributeEvenly(true); // tablarýn düzenlenebilir olmasýný saðlar

        fragmentEgitimBinding.slidingTabLayoutIconEgitimFragment.setSelectedIndicatorColors(ContextCompat.getColor(getActivity(), R.color.selector));

        // pagerý tablara baðladýk.
        fragmentEgitimBinding.slidingTabLayoutIconEgitimFragment.setViewPager(fragmentEgitimBinding.viewPagerEgitimFragment);

        resimDegisikligiTabDinleyici();

        return rootView;
    }

    /**
     * Resim deðiþikliði saðlar..
     */
    public void resimDegisikligiTabDinleyici() {
        fragmentEgitimBinding.slidingTabLayoutIconEgitimFragment.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        fragmentEgitimBinding.imageViewLogoUstEkranEgitimFragment.setImageResource(R.drawable.mobil_ust_logo);
                        break;
                    case 1:
                        fragmentEgitimBinding.imageViewLogoUstEkranEgitimFragment.setImageResource(R.drawable.web_ust_logo);
                        break;
                    case 2:
                        fragmentEgitimBinding.imageViewLogoUstEkranEgitimFragment.setImageResource(R.drawable.oyun_ust_logo);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


}
