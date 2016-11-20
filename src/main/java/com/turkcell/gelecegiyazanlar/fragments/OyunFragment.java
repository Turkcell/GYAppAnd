package com.turkcell.gelecegiyazanlar.fragments;

import android.animation.Animator;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.turkcell.gelecegiyazanlar.R;
import com.turkcell.gelecegiyazanlar.activities.EgitimBaslikActivity;
import com.turkcell.gelecegiyazanlar.databinding.FragmentOyunBinding;
import com.turkcell.gelecegiyazanlar.designs.SlidingTabLayoutIcon;
import com.turkcell.gelecegiyazanlar.models.Egitim;

/**
 * Web Sayfasýnýn Fragmentý
 */

public class OyunFragment extends Fragment implements View.OnClickListener {

    private FragmentOyunBinding fragmentOyunBinding;
    
    private LinearLayout linearLayoutUstEkran;
    private SlidingTabLayoutIcon slidingTabLayoutIcon;
    Toolbar toolbar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbarMainActivity);

        fragmentOyunBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_oyun, container, false);

        View rootView = fragmentOyunBinding.getRoot();


        linearLayoutUstEkran = (LinearLayout) getActivity().findViewById(R.id.linearLayoutUstEkranEgitimFragment);
        slidingTabLayoutIcon = (SlidingTabLayoutIcon) getActivity().findViewById(R.id.slidingTabLayoutIconEgitimFragment);


        fragmentOyunBinding.linearLayoutOyunOyunFragment.setOnClickListener(this);
        fragmentOyunBinding.linearLayoutOyun101OyunFragment.setOnClickListener(this);
        fragmentOyunBinding.linearLayoutOyun201OyunFragment.setOnClickListener(this);
        fragmentOyunBinding.linearLayoutEgitimalOyun101OyunFragment.setOnClickListener(this);
        fragmentOyunBinding.linearLayoutEgitimalOyun201OyunFragment.setOnClickListener(this);

        return rootView;
    }


    @Override
    public void onClick(View v) {
        Intent i = null;
        switch (v.getId()) {

            case R.id.linearLayoutOyunOyunFragment:
                if (fragmentOyunBinding.linearLayoutOyunIcerikOyunFragment.getVisibility() == View.VISIBLE) {
                    fragmentOyunBinding.linearLayoutOyunIcerikOyunFragment.setVisibility(View.GONE);
                    goster();
                    slidingTabLayoutIcon.setVisibility(View.VISIBLE);
                    fragmentOyunBinding.imageViewOyunsagokOyunFragment.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.sagok, null));
                } else {
                    fragmentOyunBinding.linearLayoutOyunIcerikOyunFragment.setVisibility(View.VISIBLE);
                    sakla();
                    slidingTabLayoutIcon.setVisibility(View.GONE);
                    fragmentOyunBinding.imageViewOyunsagokOyunFragment.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.asagiok, null));
                }
                break;


            case R.id.linearLayoutOyun101OyunFragment:
                if (fragmentOyunBinding.linearLayoutEgitimalOyun101OyunFragment.getVisibility() == View.VISIBLE) {
                    fragmentOyunBinding.linearLayoutEgitimalOyun101OyunFragment.setVisibility(View.GONE);
                    fragmentOyunBinding.imageViewAsagiImage101OyunOyunFragment.setImageResource(R.drawable.asagiikon);
                } else {
                    fragmentOyunBinding.linearLayoutEgitimalOyun101OyunFragment.setVisibility(View.VISIBLE);
                    fragmentOyunBinding.imageViewAsagiImage101OyunOyunFragment.setImageResource(R.drawable.yukariikon);
                }
                break;

            case R.id.linearLayoutOyun201OyunFragment:
                if (fragmentOyunBinding.linearLayoutEgitimalOyun201OyunFragment.getVisibility() == View.VISIBLE) {
                    fragmentOyunBinding.linearLayoutEgitimalOyun201OyunFragment.setVisibility(View.GONE);
                    fragmentOyunBinding.imageViewAsagiImage201OyunOyunFragment.setImageResource(R.drawable.asagiikon);
                } else {
                    fragmentOyunBinding.linearLayoutEgitimalOyun201OyunFragment.setVisibility(View.VISIBLE);
                    fragmentOyunBinding.imageViewAsagiImage201OyunOyunFragment.setImageResource(R.drawable.yukariikon);
                }
                break;
            case R.id.linearLayoutEgitimalOyun101OyunFragment:
                i = new Intent(getActivity(), EgitimBaslikActivity.class);
                i.putExtra(Egitim.TITLE_TAG, "Oyun Geliþtirme 101");
                i.putExtra(Egitim.COLOR_TAG, "oyun");
                i.putExtra(Egitim.NODE_ID, getResources().getString(R.string.oyun101));
                startActivity(i);
                break;

            case R.id.linearLayoutEgitimalOyun201OyunFragment:
                i = new Intent(getActivity(), EgitimBaslikActivity.class);
                i.putExtra(Egitim.TITLE_TAG, "Oyun Geliþtirme 201");
                i.putExtra(Egitim.COLOR_TAG, "oyun");
                i.putExtra(Egitim.NODE_ID, getResources().getString(R.string.oyun201));
                startActivity(i);
                break;


        }

    }

    public void sakla() {
        linearLayoutUstEkran.animate().translationY(-linearLayoutUstEkran.getBottom() - toolbar.getBottom()).setInterpolator(new AccelerateInterpolator(2))
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        linearLayoutUstEkran.setVisibility(View.GONE);
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                }).start();
    }

    public void goster() {
        linearLayoutUstEkran.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2))
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        linearLayoutUstEkran.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {

                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                }).start();
    }
}

