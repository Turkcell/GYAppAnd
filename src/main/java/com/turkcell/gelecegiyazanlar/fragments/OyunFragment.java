package com.turkcell.gelecegiyazanlar.fragments;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import com.turkcell.gelecegiyazanlar.designs.SlidingTabLayoutIcon;

/**
 * Web Sayfasýnýn Fragmentý
 */

public class OyunFragment extends Fragment implements View.OnClickListener {


    LinearLayout ust_layout, oyun, oyunIcerik;


    LinearLayout oyun101, oyun101Layout, oyun201, oyun201Layout;

    SlidingTabLayoutIcon tablar;
    ImageView oyunSagOk, oyun101AsagiOk, oyun201AsagiOk, egitimiAl101, egitimiAl201;
    Toolbar toolbar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        toolbar = (Toolbar) getActivity().findViewById(R.id.tool_bar);
        View rootView = inflater.inflate(R.layout.fragment_oyun, container, false);

        oyun = (LinearLayout) rootView.findViewById(R.id.oyun);
        oyunIcerik = (LinearLayout) rootView.findViewById(R.id.layout_oyun_icerik);
        oyunSagOk = (ImageView) rootView.findViewById(R.id.oyunsagok);

        oyun101AsagiOk = (ImageView) rootView.findViewById(R.id.asagi_image_101_oyun);
        oyun101 = (LinearLayout) rootView.findViewById(R.id.egitimal_oyun_101);
        oyun101Layout = (LinearLayout) rootView.findViewById(R.id.layout_oyun_101);

        oyun201AsagiOk = (ImageView) rootView.findViewById(R.id.asagi_image_201_oyun);
        oyun201 = (LinearLayout) rootView.findViewById(R.id.egitimal_oyun_201);
        oyun201Layout = (LinearLayout) rootView.findViewById(R.id.layout_oyun_201);


        ust_layout = (LinearLayout) getActivity().findViewById(R.id.ustekran);
        tablar = (SlidingTabLayoutIcon) getActivity().findViewById(R.id.tabs);


        oyun.setOnClickListener(this);
        oyun101Layout.setOnClickListener(this);
        oyun201Layout.setOnClickListener(this);
        oyun101.setOnClickListener(this);
        oyun201.setOnClickListener(this);

        return rootView;
    }


    @Override
    public void onClick(View v) {
        Intent i = null;
        switch (v.getId()) {

            case R.id.oyun:
                if (oyunIcerik.getVisibility() == View.VISIBLE) {
                    oyunIcerik.setVisibility(View.GONE);
                    goster();
                    tablar.setVisibility(View.VISIBLE);
                    oyunSagOk.setImageDrawable(getResources().getDrawable(R.drawable.sagok));
                } else {
                    oyunIcerik.setVisibility(View.VISIBLE);
                    sakla();
                    tablar.setVisibility(View.GONE);
                    oyunSagOk.setImageDrawable(getResources().getDrawable(R.drawable.asagiok));
                }
                break;


            case R.id.layout_oyun_101:
                if (oyun101.getVisibility() == View.VISIBLE) {
                    oyun101.setVisibility(View.GONE);
                    oyun101AsagiOk.setImageResource(R.drawable.asagiikon);
                } else {
                    oyun101.setVisibility(View.VISIBLE);
                    oyun101AsagiOk.setImageResource(R.drawable.yukariikon);
                }
                break;

            case R.id.layout_oyun_201:
                if (oyun201.getVisibility() == View.VISIBLE) {
                    oyun201.setVisibility(View.GONE);
                    oyun201AsagiOk.setImageResource(R.drawable.asagiikon);
                } else {
                    oyun201.setVisibility(View.VISIBLE);
                    oyun201AsagiOk.setImageResource(R.drawable.yukariikon);
                }
                break;
            case R.id.egitimal_oyun_101:
                i = new Intent(getActivity(), EgitimBaslikActivity.class);
                i.putExtra("title", "Oyun Geliþtirme 101");
                i.putExtra("color", "oyun");
                i.putExtra("nodeID", getResources().getString(R.string.oyun101));
                startActivity(i);
                break;

            case R.id.egitimal_oyun_201:
                i = new Intent(getActivity(), EgitimBaslikActivity.class);
                i.putExtra("title", "Oyun Geliþtirme 201");
                i.putExtra("color", "oyun");
                i.putExtra("nodeID", getResources().getString(R.string.oyun201));
                startActivity(i);
                break;


        }

    }

    public void sakla() {
        ust_layout.animate().translationY(-ust_layout.getBottom() - toolbar.getBottom()).setInterpolator(new AccelerateInterpolator(2))
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        ust_layout.setVisibility(View.GONE);
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
        ust_layout.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2))
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        ust_layout.setVisibility(View.VISIBLE);
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

