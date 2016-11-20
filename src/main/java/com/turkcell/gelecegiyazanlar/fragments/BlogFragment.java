package com.turkcell.gelecegiyazanlar.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.turkcell.gelecegiyazanlar.R;
import com.turkcell.gelecegiyazanlar.adapterlisteners.ViewPagerAdapterBlogEtkinlik;
import com.turkcell.gelecegiyazanlar.databinding.FragmentBlogBinding;


public class BlogFragment extends Fragment {
    private FragmentBlogBinding fragmentBlogBinding;

    private CharSequence titlesCharSequences[];
    private int numbOfTabsAnInt = 5;
    private ViewPagerAdapterBlogEtkinlik viewPagerAdapterBlogEtkinlik;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_blog, container, false);

        fragmentBlogBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_blog, container, false);


        titlesCharSequences = new CharSequence[]{
                getString(R.string.blog_kategori_gelecegi_yazanlar),
                getString(R.string.blog_kategori_mobil),
                getString(R.string.blog_kategori_android),
                getString(R.string.blog_kategori_ios),
                getString(R.string.blog_kategori_wp)
        };

        viewPagerAdapterBlogEtkinlik = new ViewPagerAdapterBlogEtkinlik(getFragmentManager(), titlesCharSequences, numbOfTabsAnInt);

        fragmentBlogBinding.viewPagerBlogFragment.setAdapter(viewPagerAdapterBlogEtkinlik);
        fragmentBlogBinding.slidingTabLayoutTabsBlogFragment.setDistributeEvenly(true);
        fragmentBlogBinding.slidingTabLayoutTabsBlogFragment.setSelectedIndicatorColors(ContextCompat.getColor(getActivity(), R.color.beyaz_renk));
        fragmentBlogBinding.slidingTabLayoutTabsBlogFragment.setViewPager(fragmentBlogBinding.viewPagerBlogFragment);


        return rootView;
    }


}


