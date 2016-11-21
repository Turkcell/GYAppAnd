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
import com.turkcell.gelecegiyazanlar.databinding.FragmentMobilBinding;
import com.turkcell.gelecegiyazanlar.designs.SlidingTabLayoutIcon;
import com.turkcell.gelecegiyazanlar.models.Egitim;


/**
 * Mobil Sayfasýnýn Fragmentý
 */

public class MobilFragment extends Fragment implements View.OnClickListener {


    private FragmentMobilBinding fragmentMobilBinding;

    private LinearLayout ustLinearLayout;
    private SlidingTabLayoutIcon slidingTabLayoutIcon;
    private Toolbar toolbar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbarMainActivity);

        fragmentMobilBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_mobil, container, false);
        View rootView = fragmentMobilBinding.getRoot();


        ustLinearLayout = (LinearLayout) getActivity().findViewById(R.id.linearLayoutUstEkranEgitimFragment);
        slidingTabLayoutIcon = (SlidingTabLayoutIcon) getActivity().findViewById(R.id.slidingTabLayoutIconEgitimFragment);


        fragmentMobilBinding.imageViewEgitimialAndroid101BtnMobilFragment.setOnClickListener(this);
        fragmentMobilBinding.imageViewEgitimialAndroid201BtnMobilFragment.setOnClickListener(this);
        fragmentMobilBinding.imageViewEgitimialAndroid301BtnMobilFragment.setOnClickListener(this);
        fragmentMobilBinding.imageViewEgitimialAndroid401BtnMobilFragment.setOnClickListener(this);

        fragmentMobilBinding.imageViewEgitimialIos101BtnMobilFragment.setOnClickListener(this);
        fragmentMobilBinding.imageViewEgitimialIos102BtnMobilFragment.setOnClickListener(this);
        fragmentMobilBinding.imageViewEgitimialIos201BtnMobilFragment.setOnClickListener(this);
        fragmentMobilBinding.imageViewEgitimialIos301BtnMobilFragment.setOnClickListener(this);
        fragmentMobilBinding.imageViewEgitimialIos401BtnMobilFragment.setOnClickListener(this);

        fragmentMobilBinding.imageViewEgitimialWindows101BtnMobilFragment.setOnClickListener(this);
        fragmentMobilBinding.imageViewEgitimialWindows201BtnMobilFragment.setOnClickListener(this);

        fragmentMobilBinding.imageViewEgitimialScratch101BtnMobilFragment.setOnClickListener(this);
        fragmentMobilBinding.imageViewEgitimialScratch201BtnMobilFragment.setOnClickListener(this);

        fragmentMobilBinding.imageViewEgitimialAppinventor101BtnMobilFragment.setOnClickListener(this);
        fragmentMobilBinding.imageViewEgitimialAppinventor201BtnMobilFragment.setOnClickListener(this);
        fragmentMobilBinding.imageViewEgitimialAppinventor301BtnMobilFragment.setOnClickListener(this);
        fragmentMobilBinding.imageViewEgitimialAppinventor401BtnMobilFragment.setOnClickListener(this);

        fragmentMobilBinding.imageViewEgitimialArduino101BtnMobilFragment.setOnClickListener(this);
        fragmentMobilBinding.imageViewEgitimialArduino201BtnMobilFragment.setOnClickListener(this);
        fragmentMobilBinding.imageViewEgitimialArduino301BtnMobilFragment.setOnClickListener(this);
        fragmentMobilBinding.imageViewEgitimialArduino401BtnMobilFragment.setOnClickListener(this);


        fragmentMobilBinding.linearLayoutAndroidMobilFragment.setOnClickListener(this);
        fragmentMobilBinding.linearLayoutAndroid101MobilFragment.setOnClickListener(this);
        fragmentMobilBinding.linearLayoutAndroid201MobilFragment.setOnClickListener(this);
        fragmentMobilBinding.linearLayoutAndroid301MobilFragment.setOnClickListener(this);
        fragmentMobilBinding.linearLayoutAndroid401MobilFragment.setOnClickListener(this);

        fragmentMobilBinding.linearLayoutIosMobilFragment.setOnClickListener(this);
        fragmentMobilBinding.linearLayoutIos101MobilFragment.setOnClickListener(this);
        fragmentMobilBinding.linearLayoutIos102MobilFragment.setOnClickListener(this);
        fragmentMobilBinding.linearLayoutIos201MobilFragment.setOnClickListener(this);
        fragmentMobilBinding.linearLayoutIos301MobilFragment.setOnClickListener(this);
        fragmentMobilBinding.linearLayoutIos401MobilFragment.setOnClickListener(this);

        fragmentMobilBinding.linearLayoutWindowsMobilFragment.setOnClickListener(this);
        fragmentMobilBinding.linearLayoutWindows101MobilFragment.setOnClickListener(this);
        fragmentMobilBinding.linearLayoutWindows201MobilFragment.setOnClickListener(this);

        fragmentMobilBinding.linearLayoutAppinventorMobilFragment.setOnClickListener(this);
        fragmentMobilBinding.linearLayoutAppinventor101MobilFragment.setOnClickListener(this);
        fragmentMobilBinding.linearLayoutAppinventor201MobilFragment.setOnClickListener(this);
        fragmentMobilBinding.linearLayoutAppinventor301MobilFragment.setOnClickListener(this);
        fragmentMobilBinding.linearLayoutAppinventor401MobilFragment.setOnClickListener(this);

        fragmentMobilBinding.linearLayoutScratchMobilFragment.setOnClickListener(this);
        fragmentMobilBinding.linearLayoutScratch101MobilFragment.setOnClickListener(this);
        fragmentMobilBinding.linearLayoutScratch201MobilFragment.setOnClickListener(this);

        fragmentMobilBinding.linearLayoutArduinoMobilFragment.setOnClickListener(this);
        fragmentMobilBinding.linearLayoutArduino101MobilFragment.setOnClickListener(this);
        fragmentMobilBinding.linearLayoutArduino201MobilFragment.setOnClickListener(this);
        fragmentMobilBinding.linearLayoutArduino301MobilFragment.setOnClickListener(this);
        fragmentMobilBinding.linearLayoutArduino401MobilFragment.setOnClickListener(this);


        return rootView;
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.imageViewEgitimialAndroid101BtnMobilFragment:
                openEgitimBaslikActivity("Android 101", "android", getResources().getString(R.string.android101));
                break;
            case R.id.imageViewEgitimialAndroid201BtnMobilFragment:
                openEgitimBaslikActivity("Android 201", "android", getResources().getString(R.string.android201));
                break;
            case R.id.imageViewEgitimialAndroid301BtnMobilFragment:
                openEgitimBaslikActivity("Android 301", "android", getResources().getString(R.string.android301));
                break;
            case R.id.imageViewEgitimialAndroid401BtnMobilFragment:
                openEgitimBaslikActivity("Android 401", "android", getResources().getString(R.string.android401));
                break;
            case R.id.imageViewEgitimialIos102BtnMobilFragment:
                openEgitimBaslikActivity("IOS 102", "ios", getResources().getString(R.string.ios102));
                break;
            case R.id.imageViewEgitimialIos101BtnMobilFragment:
                openEgitimBaslikActivity("IOS 101", "ios", getResources().getString(R.string.ios101));
                break;
            case R.id.imageViewEgitimialIos201BtnMobilFragment:
                openEgitimBaslikActivity("IOS 201", "ios", getResources().getString(R.string.ios201));
                break;
            case R.id.imageViewEgitimialIos301BtnMobilFragment:
                openEgitimBaslikActivity("IOS 301", "ios", getResources().getString(R.string.ios301));
                break;
            case R.id.imageViewEgitimialIos401BtnMobilFragment:
                openEgitimBaslikActivity("IOS 401", "ios", getResources().getString(R.string.ios401));
                break;
            case R.id.imageViewEgitimialWindows101BtnMobilFragment:
                openEgitimBaslikActivity("Windows Phone 101", "win", getResources().getString(R.string.win101));
                break;
            case R.id.imageViewEgitimialWindows201BtnMobilFragment:
                openEgitimBaslikActivity("Windows Phone 201", "win", getResources().getString(R.string.win201));
                break;
            case R.id.imageViewEgitimialAppinventor101BtnMobilFragment:
                openEgitimBaslikActivity("App Inventor 101", "app", getResources().getString(R.string.inventor101));
                break;
            case R.id.imageViewEgitimialAppinventor201BtnMobilFragment:
                openEgitimBaslikActivity("App Inventor 201", "app", getResources().getString(R.string.inventor201));
                break;
            case R.id.imageViewEgitimialAppinventor301BtnMobilFragment:
                openEgitimBaslikActivity("App Inventor 301", "app", getResources().getString(R.string.inventor301));
                break;
            case R.id.imageViewEgitimialAppinventor401BtnMobilFragment:
                openEgitimBaslikActivity("App Inventor 401", "app", getResources().getString(R.string.inventor401));
                break;
            case R.id.imageViewEgitimialArduino101BtnMobilFragment:
                openEgitimBaslikActivity("Arduino 101", "arduino", getResources().getString(R.string.arduino101));
                break;
            case R.id.imageViewEgitimialArduino201BtnMobilFragment:
                openEgitimBaslikActivity("Arduino 201", "arduino", getResources().getString(R.string.arduino201));
                break;
            case R.id.imageViewEgitimialArduino301BtnMobilFragment:
                openEgitimBaslikActivity("Arduino 301", "arduino", getResources().getString(R.string.arduino301));
                break;
            case R.id.imageViewEgitimialArduino401BtnMobilFragment:
                openEgitimBaslikActivity("Arduino 401", "arduino", getResources().getString(R.string.arduino401));
                break;
            case R.id.imageViewEgitimialScratch101BtnMobilFragment:
                openEgitimBaslikActivity("Scratch 101", "scratch", getResources().getString(R.string.scratch101));
                break;
            case R.id.imageViewEgitimialScratch201BtnMobilFragment:
                openEgitimBaslikActivity("Scratch 201", "scratch", getResources().getString(R.string.scratch201));
                break;

            case R.id.linearLayoutAndroidMobilFragment:
                if (fragmentMobilBinding.linearLayoutAndroidIcerikMobilFragment.getVisibility() == View.VISIBLE) {
                    fragmentMobilBinding.linearLayoutAndroidIcerikMobilFragment.setVisibility(View.GONE);
                    goster();
                    slidingTabLayoutIcon.setVisibility(View.VISIBLE);
                    fragmentMobilBinding.imageViewAndroidSagOkMobilFragment.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.sagok, null));
                } else {
                    fragmentMobilBinding.linearLayoutAndroidIcerikMobilFragment.setVisibility(View.VISIBLE);
                    sakla();
                    slidingTabLayoutIcon.setVisibility(View.GONE);
                    fragmentMobilBinding.imageViewAndroidSagOkMobilFragment.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.asagiok, null));

                    fragmentMobilBinding.linearLayoutIosIcerikMobilFragment.setVisibility(View.GONE);
                    fragmentMobilBinding.linearLayoutWindowsIcerikMobilFragment.setVisibility(View.GONE);
                    fragmentMobilBinding.linearLayoutScratchIcerikMobilFragment.setVisibility(View.GONE);
                    fragmentMobilBinding.linearLayoutAppinventorIcerikMobilFragment.setVisibility(View.GONE);
                    fragmentMobilBinding.linearLayoutArduinoIcerikMobilFragment.setVisibility(View.GONE);


                }
                break;


            case R.id.linearLayoutAndroid101MobilFragment:
                if (fragmentMobilBinding.linearLayoutEgitimialAndroid101MobilFragment.getVisibility() == View.VISIBLE) {
                    fragmentMobilBinding.linearLayoutEgitimialAndroid101MobilFragment.setVisibility(View.GONE);
                    fragmentMobilBinding.imageViewAsagiImage101AndroidMobilFragment.setImageResource(R.drawable.asagiikon);
                } else {
                    fragmentMobilBinding.linearLayoutEgitimialAndroid101MobilFragment.setVisibility(View.VISIBLE);
                    fragmentMobilBinding.imageViewAsagiImage101AndroidMobilFragment.setImageResource(R.drawable.yukariikon);
                }
                break;

            case R.id.linearLayoutAndroid201MobilFragment:
                if (fragmentMobilBinding.linearLayoutEgitimialAndroid201MobilFragment.getVisibility() == View.VISIBLE) {
                    fragmentMobilBinding.linearLayoutEgitimialAndroid201MobilFragment.setVisibility(View.GONE);
                    fragmentMobilBinding.imageViewAsagiImage201AndroidMobilFragment.setImageResource(R.drawable.asagiikon);
                } else {
                    fragmentMobilBinding.linearLayoutEgitimialAndroid201MobilFragment.setVisibility(View.VISIBLE);
                    fragmentMobilBinding.imageViewAsagiImage201AndroidMobilFragment.setImageResource(R.drawable.yukariikon);
                }
                break;

            case R.id.linearLayoutAndroid301MobilFragment:
                if (fragmentMobilBinding.linearLayoutEgitimialAndroid301MobilFragment.getVisibility() == View.VISIBLE) {
                    fragmentMobilBinding.linearLayoutEgitimialAndroid301MobilFragment.setVisibility(View.GONE);
                    fragmentMobilBinding.imageViewAsagiImage301AndroidMobilFragment.setImageResource(R.drawable.asagiikon);
                } else {
                    fragmentMobilBinding.linearLayoutEgitimialAndroid301MobilFragment.setVisibility(View.VISIBLE);
                    fragmentMobilBinding.imageViewAsagiImage301AndroidMobilFragment.setImageResource(R.drawable.yukariikon);
                }
                break;


            case R.id.linearLayoutAndroid401MobilFragment:
                if (fragmentMobilBinding.linearLayoutEgitimialAndroid401MobilFragment.getVisibility() == View.VISIBLE) {
                    fragmentMobilBinding.linearLayoutEgitimialAndroid401MobilFragment.setVisibility(View.GONE);
                    fragmentMobilBinding.imageViewAsagiImage401AndroidMobilFragment.setImageResource(R.drawable.asagiikon);
                } else {
                    fragmentMobilBinding.linearLayoutEgitimialAndroid401MobilFragment.setVisibility(View.VISIBLE);
                    fragmentMobilBinding.imageViewAsagiImage401AndroidMobilFragment.setImageResource(R.drawable.yukariikon);
                }
                break;


            case R.id.linearLayoutIosMobilFragment:
                if (fragmentMobilBinding.linearLayoutIosIcerikMobilFragment.getVisibility() == View.VISIBLE) {
                    fragmentMobilBinding.linearLayoutIosIcerikMobilFragment.setVisibility(View.GONE);
                    goster();
                    slidingTabLayoutIcon.setVisibility(View.VISIBLE);
                    fragmentMobilBinding.imageViewIosSagOkMobilFragment.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.sagok, null));
                } else {
                    fragmentMobilBinding.linearLayoutIosIcerikMobilFragment.setVisibility(View.VISIBLE);
                    sakla();
                    slidingTabLayoutIcon.setVisibility(View.GONE);
                    fragmentMobilBinding.imageViewIosSagOkMobilFragment.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.asagiok, null));

                    fragmentMobilBinding.linearLayoutAndroidIcerikMobilFragment.setVisibility(View.GONE);
                    fragmentMobilBinding.linearLayoutWindowsIcerikMobilFragment.setVisibility(View.GONE);
                    fragmentMobilBinding.linearLayoutScratchIcerikMobilFragment.setVisibility(View.GONE);
                    fragmentMobilBinding.linearLayoutAppinventorIcerikMobilFragment.setVisibility(View.GONE);
                    fragmentMobilBinding.linearLayoutArduinoIcerikMobilFragment.setVisibility(View.GONE);

                }
                break;

            case R.id.linearLayoutIos101MobilFragment:
                if (fragmentMobilBinding.linearLayoutEgitimialIos101MobilFragment.getVisibility() == View.VISIBLE) {
                    fragmentMobilBinding.linearLayoutEgitimialIos101MobilFragment.setVisibility(View.GONE);
                    fragmentMobilBinding.imageViewAsagiImage101IosMobilFragment.setImageResource(R.drawable.asagiikon);
                } else {
                    fragmentMobilBinding.linearLayoutEgitimialIos101MobilFragment.setVisibility(View.VISIBLE);
                    fragmentMobilBinding.imageViewAsagiImage101IosMobilFragment.setImageResource(R.drawable.yukariikon);
                }
                break;

            case R.id.linearLayoutIos102MobilFragment:
                if (fragmentMobilBinding.linearLayoutEgitimialIos102MobilFragment.getVisibility() == View.VISIBLE) {
                    fragmentMobilBinding.linearLayoutEgitimialIos102MobilFragment.setVisibility(View.GONE);
                    fragmentMobilBinding.imageViewAsagiImage102IosMobilFragment.setImageResource(R.drawable.asagiikon);
                } else {
                    fragmentMobilBinding.linearLayoutEgitimialIos102MobilFragment.setVisibility(View.VISIBLE);
                    fragmentMobilBinding.imageViewAsagiImage102IosMobilFragment.setImageResource(R.drawable.yukariikon);
                }
                break;

            case R.id.linearLayoutIos201MobilFragment:
                if (fragmentMobilBinding.linearLayoutEgitimialIos201MobilFragment.getVisibility() == View.VISIBLE) {
                    fragmentMobilBinding.linearLayoutEgitimialIos201MobilFragment.setVisibility(View.GONE);
                    fragmentMobilBinding.imageViewAsagiImage201IosMobilFragment.setImageResource(R.drawable.asagiikon);
                } else {
                    fragmentMobilBinding.linearLayoutEgitimialIos201MobilFragment.setVisibility(View.VISIBLE);
                    fragmentMobilBinding.imageViewAsagiImage201IosMobilFragment.setImageResource(R.drawable.yukariikon);
                }
                break;

            case R.id.linearLayoutIos301MobilFragment:
                if (fragmentMobilBinding.linearLayoutEgitimialIos301MobilFragment.getVisibility() == View.VISIBLE) {
                    fragmentMobilBinding.linearLayoutEgitimialIos301MobilFragment.setVisibility(View.GONE);
                    fragmentMobilBinding.imageViewAsagiImage301IosMobilFragment.setImageResource(R.drawable.asagiikon);
                } else {
                    fragmentMobilBinding.linearLayoutEgitimialIos301MobilFragment.setVisibility(View.VISIBLE);
                    fragmentMobilBinding.imageViewAsagiImage301IosMobilFragment.setImageResource(R.drawable.yukariikon);
                }
                break;

            case R.id.linearLayoutIos401MobilFragment:
                if (fragmentMobilBinding.linearLayoutEgitimialIos401MobilFragment.getVisibility() == View.VISIBLE) {
                    fragmentMobilBinding.linearLayoutEgitimialIos401MobilFragment.setVisibility(View.GONE);
                    fragmentMobilBinding.imageViewAsagiImage401IosMobilFragment.setImageResource(R.drawable.asagiikon);
                } else {
                    fragmentMobilBinding.linearLayoutEgitimialIos401MobilFragment.setVisibility(View.VISIBLE);
                    fragmentMobilBinding.imageViewAsagiImage401IosMobilFragment.setImageResource(R.drawable.yukariikon);
                }
                break;


            case R.id.linearLayoutWindowsMobilFragment:
                if (fragmentMobilBinding.linearLayoutWindowsIcerikMobilFragment.getVisibility() == View.VISIBLE) {
                    fragmentMobilBinding.linearLayoutWindowsIcerikMobilFragment.setVisibility(View.GONE);
                    goster();
                    slidingTabLayoutIcon.setVisibility(View.VISIBLE);
                    fragmentMobilBinding.imageViewWindowsSagOkMobilFragment.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.sagok, null));
                } else {
                    fragmentMobilBinding.linearLayoutWindowsIcerikMobilFragment.setVisibility(View.VISIBLE);
                    sakla();
                    slidingTabLayoutIcon.setVisibility(View.GONE);
                    fragmentMobilBinding.imageViewWindowsSagOkMobilFragment.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.asagiok, null));

                    fragmentMobilBinding.linearLayoutIosIcerikMobilFragment.setVisibility(View.GONE);
                    fragmentMobilBinding.linearLayoutAndroidIcerikMobilFragment.setVisibility(View.GONE);
                    fragmentMobilBinding.linearLayoutScratchIcerikMobilFragment.setVisibility(View.GONE);
                    fragmentMobilBinding.linearLayoutAppinventorIcerikMobilFragment.setVisibility(View.GONE);
                    fragmentMobilBinding.linearLayoutArduinoIcerikMobilFragment.setVisibility(View.GONE);
                }
                break;

            case R.id.linearLayoutWindows101MobilFragment:
                if (fragmentMobilBinding.linearLayoutEgitimialWindows101MobilFragment.getVisibility() == View.VISIBLE) {
                    fragmentMobilBinding.linearLayoutEgitimialWindows101MobilFragment.setVisibility(View.GONE);
                    fragmentMobilBinding.imageViewAsagiImage101WindowsMobilFragment.setImageResource(R.drawable.asagiikon);
                } else {
                    fragmentMobilBinding.linearLayoutEgitimialWindows101MobilFragment.setVisibility(View.VISIBLE);
                    fragmentMobilBinding.imageViewAsagiImage101WindowsMobilFragment.setImageResource(R.drawable.yukariikon);
                }
                break;

            case R.id.linearLayoutWindows201MobilFragment:
                if (fragmentMobilBinding.linearLayoutEgitimialWindows201MobilFragment.getVisibility() == View.VISIBLE) {
                    fragmentMobilBinding.linearLayoutEgitimialWindows201MobilFragment.setVisibility(View.GONE);
                    fragmentMobilBinding.imageViewAsagiImage201WindowsMobilFragment.setImageResource(R.drawable.asagiikon);
                } else {
                    fragmentMobilBinding.linearLayoutEgitimialWindows201MobilFragment.setVisibility(View.VISIBLE);
                    fragmentMobilBinding.imageViewAsagiImage201WindowsMobilFragment.setImageResource(R.drawable.yukariikon);
                }
                break;

            case R.id.linearLayoutAppinventorMobilFragment:
                if (fragmentMobilBinding.linearLayoutAppinventorIcerikMobilFragment.getVisibility() == View.VISIBLE) {
                    fragmentMobilBinding.linearLayoutAppinventorIcerikMobilFragment.setVisibility(View.GONE);
                    goster();
                    slidingTabLayoutIcon.setVisibility(View.VISIBLE);
                    fragmentMobilBinding.imageViewAppSagOkMobilFragment.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.sagok, null));
                } else {
                    fragmentMobilBinding.linearLayoutAppinventorIcerikMobilFragment.setVisibility(View.VISIBLE);
                    sakla();
                    slidingTabLayoutIcon.setVisibility(View.GONE);
                    fragmentMobilBinding.imageViewAppSagOkMobilFragment.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.asagiok, null));

                    fragmentMobilBinding.linearLayoutIosIcerikMobilFragment.setVisibility(View.GONE);
                    fragmentMobilBinding.linearLayoutWindowsIcerikMobilFragment.setVisibility(View.GONE);
                    fragmentMobilBinding.linearLayoutScratchIcerikMobilFragment.setVisibility(View.GONE);
                    fragmentMobilBinding.linearLayoutAndroidIcerikMobilFragment.setVisibility(View.GONE);
                    fragmentMobilBinding.linearLayoutArduinoIcerikMobilFragment.setVisibility(View.GONE);
                }
                break;

            case R.id.linearLayoutAppinventor101MobilFragment:
                if (fragmentMobilBinding.linearLayoutEgitimialAppinventor101MobilFragment.getVisibility() == View.VISIBLE) {
                    fragmentMobilBinding.linearLayoutEgitimialAppinventor101MobilFragment.setVisibility(View.GONE);
                    fragmentMobilBinding.imageViewAsagiImage101AppinventorMobilFragment.setImageResource(R.drawable.asagiikon);
                } else {
                    fragmentMobilBinding.linearLayoutEgitimialAppinventor101MobilFragment.setVisibility(View.VISIBLE);
                    fragmentMobilBinding.imageViewAsagiImage101AppinventorMobilFragment.setImageResource(R.drawable.yukariikon);
                }
                break;

            case R.id.linearLayoutAppinventor201MobilFragment:
                if (fragmentMobilBinding.linearLayoutEgitimialAppinventor201MobilFragment.getVisibility() == View.VISIBLE) {
                    fragmentMobilBinding.linearLayoutEgitimialAppinventor201MobilFragment.setVisibility(View.GONE);
                    fragmentMobilBinding.imageViewAsagiImage201AppinventorMobilFragment.setImageResource(R.drawable.asagiikon);
                } else {
                    fragmentMobilBinding.linearLayoutEgitimialAppinventor201MobilFragment.setVisibility(View.VISIBLE);
                    fragmentMobilBinding.imageViewAsagiImage201AppinventorMobilFragment.setImageResource(R.drawable.yukariikon);
                }
                break;

            case R.id.linearLayoutAppinventor301MobilFragment:
                if (fragmentMobilBinding.linearLayoutEgitimialAppinventor301MobilFragment.getVisibility() == View.VISIBLE) {
                    fragmentMobilBinding.linearLayoutEgitimialAppinventor301MobilFragment.setVisibility(View.GONE);
                    fragmentMobilBinding.imageViewAsagiImage301AppinventorMobilFragment.setImageResource(R.drawable.asagiikon);
                } else {
                    fragmentMobilBinding.linearLayoutEgitimialAppinventor301MobilFragment.setVisibility(View.VISIBLE);
                    fragmentMobilBinding.imageViewAsagiImage301AppinventorMobilFragment.setImageResource(R.drawable.yukariikon);
                }
                break;

            case R.id.linearLayoutAppinventor401MobilFragment:
                if (fragmentMobilBinding.linearLayoutEgitimialAppinventor401MobilFragment.getVisibility() == View.VISIBLE) {
                    fragmentMobilBinding.linearLayoutEgitimialAppinventor401MobilFragment.setVisibility(View.GONE);
                    fragmentMobilBinding.imageViewAsagiImage401AppinventorMobilFragment.setImageResource(R.drawable.asagiikon);
                } else {
                    fragmentMobilBinding.linearLayoutEgitimialAppinventor401MobilFragment.setVisibility(View.VISIBLE);
                    fragmentMobilBinding.imageViewAsagiImage401AppinventorMobilFragment.setImageResource(R.drawable.yukariikon);
                }
                break;


            case R.id.linearLayoutScratchMobilFragment:
                if (fragmentMobilBinding.linearLayoutScratchIcerikMobilFragment.getVisibility() == View.VISIBLE) {
                    fragmentMobilBinding.linearLayoutScratchIcerikMobilFragment.setVisibility(View.GONE);
                    goster();
                    slidingTabLayoutIcon.setVisibility(View.VISIBLE);
                    fragmentMobilBinding.imageViewScratchSagOkMobilFragment.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.sagok, null));
                } else {
                    fragmentMobilBinding.linearLayoutScratchIcerikMobilFragment.setVisibility(View.VISIBLE);
                    sakla();
                    slidingTabLayoutIcon.setVisibility(View.GONE);
                    fragmentMobilBinding.imageViewScratchSagOkMobilFragment.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.asagiok, null));


                    fragmentMobilBinding.linearLayoutIosIcerikMobilFragment.setVisibility(View.GONE);
                    fragmentMobilBinding.linearLayoutWindowsIcerikMobilFragment.setVisibility(View.GONE);
                    fragmentMobilBinding.linearLayoutAndroidIcerikMobilFragment.setVisibility(View.GONE);
                    fragmentMobilBinding.linearLayoutAppinventorIcerikMobilFragment.setVisibility(View.GONE);
                    fragmentMobilBinding.linearLayoutArduinoIcerikMobilFragment.setVisibility(View.GONE);
                }
                break;

            case R.id.linearLayoutScratch101MobilFragment:
                if (fragmentMobilBinding.linearLayoutEgitimialScratch101MobilFragment.getVisibility() == View.VISIBLE) {
                    fragmentMobilBinding.linearLayoutEgitimialScratch101MobilFragment.setVisibility(View.GONE);
                    fragmentMobilBinding.imageViewAsagiImage101ScratchMobilFragment.setImageResource(R.drawable.asagiikon);
                } else {
                    fragmentMobilBinding.linearLayoutEgitimialScratch101MobilFragment.setVisibility(View.VISIBLE);
                    fragmentMobilBinding.imageViewAsagiImage101ScratchMobilFragment.setImageResource(R.drawable.yukariikon);
                }
                break;

            case R.id.linearLayoutScratch201MobilFragment:
                if (fragmentMobilBinding.linearLayoutEgitimialScratch201MobilFragment.getVisibility() == View.VISIBLE) {
                    fragmentMobilBinding.linearLayoutEgitimialScratch201MobilFragment.setVisibility(View.GONE);
                    fragmentMobilBinding.imageViewAsagiImage201ScratchMobilFragment.setImageResource(R.drawable.asagiikon);
                } else {
                    fragmentMobilBinding.linearLayoutEgitimialScratch201MobilFragment.setVisibility(View.VISIBLE);
                    fragmentMobilBinding.imageViewAsagiImage201ScratchMobilFragment.setImageResource(R.drawable.yukariikon);
                }
                break;

            case R.id.linearLayoutArduinoMobilFragment:
                if (fragmentMobilBinding.linearLayoutArduinoIcerikMobilFragment.getVisibility() == View.VISIBLE) {
                    fragmentMobilBinding.linearLayoutArduinoIcerikMobilFragment.setVisibility(View.GONE);
                    goster();
                    slidingTabLayoutIcon.setVisibility(View.VISIBLE);
                    fragmentMobilBinding.imageViewArduinoSagOkMobilFragment.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.sagok, null));
                } else {
                    fragmentMobilBinding.linearLayoutArduinoIcerikMobilFragment.setVisibility(View.VISIBLE);
                    sakla();
                    slidingTabLayoutIcon.setVisibility(View.GONE);
                    fragmentMobilBinding.imageViewArduinoSagOkMobilFragment.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.asagiok, null));

                    fragmentMobilBinding.linearLayoutIosIcerikMobilFragment.setVisibility(View.GONE);
                    fragmentMobilBinding.linearLayoutWindowsIcerikMobilFragment.setVisibility(View.GONE);
                    fragmentMobilBinding.linearLayoutScratchIcerikMobilFragment.setVisibility(View.GONE);
                    fragmentMobilBinding.linearLayoutAppinventorIcerikMobilFragment.setVisibility(View.GONE);
                    fragmentMobilBinding.linearLayoutAndroidIcerikMobilFragment.setVisibility(View.GONE);
                }
                break;

            case R.id.linearLayoutArduino101MobilFragment:
                if (fragmentMobilBinding.linearLayoutEgitimialArduino101MobilFragment.getVisibility() == View.VISIBLE) {
                    fragmentMobilBinding.linearLayoutEgitimialArduino101MobilFragment.setVisibility(View.GONE);
                    fragmentMobilBinding.imageViewAsagiImage101ArduinoMobilFragment.setImageResource(R.drawable.asagiikon);
                } else {
                    fragmentMobilBinding.linearLayoutEgitimialArduino101MobilFragment.setVisibility(View.VISIBLE);
                    fragmentMobilBinding.imageViewAsagiImage101ArduinoMobilFragment.setImageResource(R.drawable.yukariikon);
                }
                break;


            case R.id.linearLayoutArduino201MobilFragment:
                if (fragmentMobilBinding.linearLayoutEgitimialArduino201MobilFragment.getVisibility() == View.VISIBLE) {
                    fragmentMobilBinding.linearLayoutEgitimialArduino201MobilFragment.setVisibility(View.GONE);
                    fragmentMobilBinding.imageViewAsagiImage401ArduinoMobilFragment.setImageResource(R.drawable.asagiikon);
                } else {
                    fragmentMobilBinding.linearLayoutEgitimialArduino201MobilFragment.setVisibility(View.VISIBLE);
                    fragmentMobilBinding.imageViewAsagiImage401ArduinoMobilFragment.setImageResource(R.drawable.yukariikon);
                }
                break;


            case R.id.linearLayoutArduino301MobilFragment:
                if (fragmentMobilBinding.linearLayoutEgitimialArduino301MobilFragment.getVisibility() == View.VISIBLE) {
                    fragmentMobilBinding.linearLayoutEgitimialArduino301MobilFragment.setVisibility(View.GONE);
                    fragmentMobilBinding.imageViewAsagiImage301ArduinoMobilFragment.setImageResource(R.drawable.asagiikon);
                } else {
                    fragmentMobilBinding.linearLayoutEgitimialArduino301MobilFragment.setVisibility(View.VISIBLE);
                    fragmentMobilBinding.imageViewAsagiImage301ArduinoMobilFragment.setImageResource(R.drawable.yukariikon);
                }
                break;


            case R.id.linearLayoutArduino401MobilFragment:
                if (fragmentMobilBinding.linearLayoutEgitimialArduino401MobilFragment.getVisibility() == View.VISIBLE) {
                    fragmentMobilBinding.linearLayoutEgitimialArduino401MobilFragment.setVisibility(View.GONE);
                    fragmentMobilBinding.imageViewAsagiImage401ArduinoMobilFragment.setImageResource(R.drawable.asagiikon);
                } else {
                    fragmentMobilBinding.linearLayoutEgitimialArduino401MobilFragment.setVisibility(View.VISIBLE);
                    fragmentMobilBinding.imageViewAsagiImage401ArduinoMobilFragment.setImageResource(R.drawable.yukariikon);
                }
                break;
        }
    }

    private void openEgitimBaslikActivity(String titleTag, String colorTag, String nodeId) {

        Intent i = new Intent(getActivity(), EgitimBaslikActivity.class);
        i.putExtra(Egitim.TITLE_TAG, titleTag);
        i.putExtra(Egitim.COLOR_TAG, colorTag);
        i.putExtra(Egitim.NODE_ID, nodeId);
        startActivity(i);

    }

    public void sakla() {
        ustLinearLayout.animate().translationY(-ustLinearLayout.getBottom() - toolbar.getBottom()).setInterpolator(new AccelerateInterpolator(2))
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        ustLinearLayout.setVisibility(View.GONE);
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
        ustLinearLayout.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2))
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        ustLinearLayout.setVisibility(View.VISIBLE);
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