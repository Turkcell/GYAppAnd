package com.turkcell.gelecegiyazanlar.fragments;


import android.animation.Animator;
import android.content.Intent;
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
import com.turkcell.gelecegiyazanlar.designs.SlidingTabLayoutIcon;
import com.turkcell.gelecegiyazanlar.models.Egitim;


/**
 * Mobil Sayfasýnýn Fragmentý
 */

public class MobilFragment extends Fragment implements View.OnClickListener {


    LinearLayout ust_layout, android, androidIcerik, ios, iosIcerik, win, winIcerik, appinventor, appinventorIcerik, scratch, scratchIcerik, arduino, arduinoIcerik;


    LinearLayout android101, android101Layout, android201, android201Layout, android301, android301Layout, android401, android401Layout;
    LinearLayout ios101, ios101Layout, ios102, ios102Layout, ios201, ios201Layout, ios301, ios301Layout, ios401, ios401Layout;
    LinearLayout win101, win101Layout, win201, win201Layout;
    LinearLayout app101, app101Layout, app201, app201Layout, app301, app301Layout, app401, app401Layout;
    LinearLayout scratch101, scratch101Layout, scratch201, scratch201Layout;
    LinearLayout arduino101, arduino101Layout, arduino201, arduino201Layout, arduino301, arduino301Layout, arduino401, arduino401Layout;


    SlidingTabLayoutIcon tablar;
    ImageView androidSagOk, android101AsagiOk, android201AsagiOk, android301AsagiOk, android401AsagiOk;
    ImageView iosSagOk, ios101AsagiOk, ios102AsagiOk, ios201AsagiOk, ios301AsagiOk, ios401AsagiOk;
    ImageView winSagOk, win101AsagiOk, win201AsagiOk;
    ImageView appSagOk, app101AsagiOk, app201AsagiOk, app301AsagiOk, app401AsagiOk;
    ImageView scratchSagOk, scratch101AsagiOk, scratch201AsagiOk;
    ImageView arduinoSagOk, arduino101AsagiOk, arduino201AsagiOk, arduino301AsagiOk, arduino401AsagiOk;

    ImageView android101Button, android201Button, android301Button, android401Button,
            ios101Button, ios102Button, ios201Button, ios301Button, ios401Button,
            win101Button, win201Button,
            scratch101Button, scratch201Button,
            app101Button, app201Button, app301Button, app401Button,
            arduino101Button, arduino201Button, arduino301Button, arduino401Button;
    Toolbar toolbar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbarMainActivity);
        View rootView = inflater.inflate(R.layout.fragment_mobil, container, false);

        android = (LinearLayout) rootView.findViewById(R.id.linearLayoutAndroidMobilFragment);
        androidIcerik = (LinearLayout) rootView.findViewById(R.id.linearLayoutAndroidIcerikMobilFragment);
        androidSagOk = (ImageView) rootView.findViewById(R.id.imageViewAndroidSagOkMobilFragment);

        android101AsagiOk = (ImageView) rootView.findViewById(R.id.imageViewAsagiImage101AndroidMobilFragment);
        android101 = (LinearLayout) rootView.findViewById(R.id.linearLayoutEgitimialAndroid101MobilFragment);
        android101Layout = (LinearLayout) rootView.findViewById(R.id.linearLayoutAndroid101MobilFragment);

        android201AsagiOk = (ImageView) rootView.findViewById(R.id.imageViewAsagiImage201AndroidMobilFragment);
        android201 = (LinearLayout) rootView.findViewById(R.id.linearLayoutEgitimialAndroid201MobilFragment);
        android201Layout = (LinearLayout) rootView.findViewById(R.id.linearLayoutAndroid201MobilFragment);

        android301AsagiOk = (ImageView) rootView.findViewById(R.id.imageViewAsagiImage301AndroidMobilFragment);
        android301 = (LinearLayout) rootView.findViewById(R.id.linearLayoutEgitimialAndroid301MobilFragment);
        android301Layout = (LinearLayout) rootView.findViewById(R.id.linearLayoutAndroid301MobilFragment);

        android401AsagiOk = (ImageView) rootView.findViewById(R.id.imageViewAsagiImage401AndroidMobilFragment);
        android401 = (LinearLayout) rootView.findViewById(R.id.linearLayoutEgitimialAndroid401MobilFragment);
        android401Layout = (LinearLayout) rootView.findViewById(R.id.linearLayoutAndroid401MobilFragment);

        ust_layout = (LinearLayout) getActivity().findViewById(R.id.linearLayoutUstEkranEgitimFragment);
        tablar = (SlidingTabLayoutIcon) getActivity().findViewById(R.id.slidingTabLayoutIconEgitimFragment);


        ios = (LinearLayout) rootView.findViewById(R.id.linearLayoutIosMobilFragment);
        iosIcerik = (LinearLayout) rootView.findViewById(R.id.linearLayoutIosIcerikMobilFragment);
        iosSagOk = (ImageView) rootView.findViewById(R.id.imageViewIosSagOkMobilFragment);

        ios101AsagiOk = (ImageView) rootView.findViewById(R.id.imageViewAsagiImage101IosMobilFragment);
        ios101 = (LinearLayout) rootView.findViewById(R.id.linearLayoutEgitimialIos101MobilFragment);
        ios101Layout = (LinearLayout) rootView.findViewById(R.id.linearLayoutIos101MobilFragment);

        ios102AsagiOk = (ImageView) rootView.findViewById(R.id.imageViewAsagiImage102IosMobilFragment);
        ios102 = (LinearLayout) rootView.findViewById(R.id.linearLayoutEgitimialIos102MobilFragment);
        ios102Layout = (LinearLayout) rootView.findViewById(R.id.linearLayoutIos102MobilFragment);

        ios201AsagiOk = (ImageView) rootView.findViewById(R.id.imageViewAsagiImage201IosMobilFragment);
        ios201 = (LinearLayout) rootView.findViewById(R.id.linearLayoutEgitimialIos201MobilFragment);
        ios201Layout = (LinearLayout) rootView.findViewById(R.id.linearLayoutIos201MobilFragment);

        ios301AsagiOk = (ImageView) rootView.findViewById(R.id.imageViewAsagiImage301IosMobilFragment);
        ios301 = (LinearLayout) rootView.findViewById(R.id.linearLayoutEgitimialIos301MobilFragment);
        ios301Layout = (LinearLayout) rootView.findViewById(R.id.linearLayoutIos301MobilFragment);

        ios401AsagiOk = (ImageView) rootView.findViewById(R.id.imageViewAsagiImage401IosMobilFragment);
        ios401 = (LinearLayout) rootView.findViewById(R.id.linearLayoutEgitimialIos401MobilFragment);
        ios401Layout = (LinearLayout) rootView.findViewById(R.id.linearLayoutIos401MobilFragment);

        win = (LinearLayout) rootView.findViewById(R.id.linearLayoutWindowsMobilFragment);
        winIcerik = (LinearLayout) rootView.findViewById(R.id.linearLayoutWindowsIcerikMobilFragment);
        winSagOk = (ImageView) rootView.findViewById(R.id.imageViewWindowsSagOkMobilFragment);

        win101AsagiOk = (ImageView) rootView.findViewById(R.id.imageViewAsagiImage101WindowsMobilFragment);
        win101 = (LinearLayout) rootView.findViewById(R.id.linearLayoutEgitimialWindows101MobilFragment);
        win101Layout = (LinearLayout) rootView.findViewById(R.id.linearLayoutWindows101MobilFragment);

        win201AsagiOk = (ImageView) rootView.findViewById(R.id.imageViewAsagiImage201WindowsMobilFragment);
        win201 = (LinearLayout) rootView.findViewById(R.id.linearLayoutEgitimialWindows201MobilFragment);
        win201Layout = (LinearLayout) rootView.findViewById(R.id.linearLayoutWindows201MobilFragment);

        appinventor = (LinearLayout) rootView.findViewById(R.id.linearLayoutAppinventorMobilFragment);
        appinventorIcerik = (LinearLayout) rootView.findViewById(R.id.linearLayoutAppinventorIcerikMobilFragment);
        appSagOk = (ImageView) rootView.findViewById(R.id.imageViewAppSagOkMobilFragment);

        app101AsagiOk = (ImageView) rootView.findViewById(R.id.imageViewAsagiImage101AppinventorMobilFragment);
        app101 = (LinearLayout) rootView.findViewById(R.id.linearLayoutEgitimialAppinventor101MobilFragment);
        app101Layout = (LinearLayout) rootView.findViewById(R.id.linearLayoutAppinventor101MobilFragment);

        app201AsagiOk = (ImageView) rootView.findViewById(R.id.imageViewAsagiImage201AppinventorMobilFragment);
        app201 = (LinearLayout) rootView.findViewById(R.id.linearLayoutEgitimialAppinventor201MobilFragment);
        app201Layout = (LinearLayout) rootView.findViewById(R.id.linearLayoutAppinventor201MobilFragment);


        app301AsagiOk = (ImageView) rootView.findViewById(R.id.imageViewAsagiImage301AppinventorMobilFragment);
        app301 = (LinearLayout) rootView.findViewById(R.id.linearLayoutEgitimialAppinventor301MobilFragment);
        app301Layout = (LinearLayout) rootView.findViewById(R.id.linearLayoutAppinventor301MobilFragment);

        app401AsagiOk = (ImageView) rootView.findViewById(R.id.imageViewAsagiImage401AppinventorMobilFragment);
        app401 = (LinearLayout) rootView.findViewById(R.id.linearLayoutEgitimialAppinventor401MobilFragment);
        app401Layout = (LinearLayout) rootView.findViewById(R.id.linearLayoutAppinventor401MobilFragment);

        scratch = (LinearLayout) rootView.findViewById(R.id.linearLayoutScratchMobilFragment);
        scratchIcerik = (LinearLayout) rootView.findViewById(R.id.linearLayoutScratchIcerikMobilFragment);
        scratchSagOk = (ImageView) rootView.findViewById(R.id.imageViewScratchSagOkMobilFragment);

        scratch101AsagiOk = (ImageView) rootView.findViewById(R.id.imageViewAsagiImage101ScratchMobilFragment);
        scratch101 = (LinearLayout) rootView.findViewById(R.id.linearLayoutEgitimialScratch101MobilFragment);
        scratch101Layout = (LinearLayout) rootView.findViewById(R.id.linearLayoutScratch101MobilFragment);

        scratch201AsagiOk = (ImageView) rootView.findViewById(R.id.imageViewAsagiImage201ScratchMobilFragment);
        scratch201 = (LinearLayout) rootView.findViewById(R.id.linearLayoutEgitimialScratch201MobilFragment);
        scratch201Layout = (LinearLayout) rootView.findViewById(R.id.linearLayoutScratch201MobilFragment);

        arduino = (LinearLayout) rootView.findViewById(R.id.linearLayoutArduinoMobilFragment);
        arduinoIcerik = (LinearLayout) rootView.findViewById(R.id.linearLayoutArduinoIcerikMobilFragment);
        arduinoSagOk = (ImageView) rootView.findViewById(R.id.imageViewArduinoSagOkMobilFragment);

        arduino101AsagiOk = (ImageView) rootView.findViewById(R.id.imageViewAsagiImage101ArduinoMobilFragment);
        arduino101 = (LinearLayout) rootView.findViewById(R.id.linearLayoutEgitimialArduino101MobilFragment);
        arduino101Layout = (LinearLayout) rootView.findViewById(R.id.linearLayoutArduino101MobilFragment);

        arduino201AsagiOk = (ImageView) rootView.findViewById(R.id.imageViewAsagiImage401ArduinoMobilFragment);
        arduino201 = (LinearLayout) rootView.findViewById(R.id.linearLayoutEgitimialArduino201MobilFragment);
        arduino201Layout = (LinearLayout) rootView.findViewById(R.id.linearLayoutArduino201MobilFragment);

        arduino301AsagiOk = (ImageView) rootView.findViewById(R.id.imageViewAsagiImage301ArduinoMobilFragment);
        arduino301 = (LinearLayout) rootView.findViewById(R.id.linearLayoutEgitimialArduino301MobilFragment);
        arduino301Layout = (LinearLayout) rootView.findViewById(R.id.linearLayoutArduino301MobilFragment);

        arduino401AsagiOk = (ImageView) rootView.findViewById(R.id.imageViewAsagiImage401ArduinoMobilFragment);
        arduino401 = (LinearLayout) rootView.findViewById(R.id.linearLayoutEgitimialArduino401MobilFragment);
        arduino401Layout = (LinearLayout) rootView.findViewById(R.id.linearLayoutArduino401MobilFragment);


        android101Button = (ImageView) rootView.findViewById(R.id.imageViewEgitimialAndroid101BtnMobilFragment);
        android201Button = (ImageView) rootView.findViewById(R.id.imageViewEgitimialAndroid201BtnMobilFragment);
        android301Button = (ImageView) rootView.findViewById(R.id.imageViewEgitimialAndroid301BtnMobilFragment);
        android401Button = (ImageView) rootView.findViewById(R.id.imageViewEgitimialAndroid401BtnMobilFragment);
        ios101Button = (ImageView) rootView.findViewById(R.id.imageViewEgitimialIos101BtnMobilFragment);
        ios102Button = (ImageView) rootView.findViewById(R.id.imageViewEgitimialIos102BtnMobilFragment);
        ios201Button = (ImageView) rootView.findViewById(R.id.imageViewEgitimialIos201BtnMobilFragment);
        ios301Button = (ImageView) rootView.findViewById(R.id.imageViewEgitimialIos301BtnMobilFragment);
        ios401Button = (ImageView) rootView.findViewById(R.id.imageViewEgitimialIos401BtnMobilFragment);
        win101Button = (ImageView) rootView.findViewById(R.id.imageViewEgitimialWindows101BtnMobilFragment);
        win201Button = (ImageView) rootView.findViewById(R.id.imageViewEgitimialWindows201BtnMobilFragment);
        scratch101Button = (ImageView) rootView.findViewById(R.id.imageViewEgitimialScratch101BtnMobilFragment);
        scratch201Button = (ImageView) rootView.findViewById(R.id.imageViewEgitimialScratch201BtnMobilFragment);
        app101Button = (ImageView) rootView.findViewById(R.id.imageViewEgitimialAppinventor101BtnMobilFragment);
        app201Button = (ImageView) rootView.findViewById(R.id.imageViewEgitimialAppinventor201BtnMobilFragment);
        app301Button = (ImageView) rootView.findViewById(R.id.imageViewEgitimialAppinventor301BtnMobilFragment);
        app401Button = (ImageView) rootView.findViewById(R.id.imageViewEgitimialAppinventor401BtnMobilFragment);
        arduino101Button = (ImageView) rootView.findViewById(R.id.imageViewEgitimialArduino101BtnMobilFragment);
        arduino201Button = (ImageView) rootView.findViewById(R.id.imageViewEgitimialArduino201BtnMobilFragment);
        arduino301Button = (ImageView) rootView.findViewById(R.id.imageViewEgitimialArduino301BtnMobilFragment);
        arduino401Button = (ImageView) rootView.findViewById(R.id.imageViewEgitimialArduino401BtnMobilFragment);


        android101Button.setOnClickListener(this);
        android201Button.setOnClickListener(this);
        android301Button.setOnClickListener(this);
        android401Button.setOnClickListener(this);
        ios101Button.setOnClickListener(this);
        ios102Button.setOnClickListener(this);
        ios201Button.setOnClickListener(this);
        ios301Button.setOnClickListener(this);
        ios401Button.setOnClickListener(this);
        win101Button.setOnClickListener(this);
        win201Button.setOnClickListener(this);
        scratch101Button.setOnClickListener(this);
        scratch201Button.setOnClickListener(this);
        app101Button.setOnClickListener(this);
        app201Button.setOnClickListener(this);
        app301Button.setOnClickListener(this);
        app401Button.setOnClickListener(this);
        arduino101Button.setOnClickListener(this);
        arduino201Button.setOnClickListener(this);
        arduino301Button.setOnClickListener(this);
        arduino401Button.setOnClickListener(this);


        android.setOnClickListener(this);
        android101Layout.setOnClickListener(this);
        android201Layout.setOnClickListener(this);
        android301Layout.setOnClickListener(this);
        android401Layout.setOnClickListener(this);

        ios.setOnClickListener(this);
        ios101Layout.setOnClickListener(this);
        ios102Layout.setOnClickListener(this);
        ios201Layout.setOnClickListener(this);
        ios301Layout.setOnClickListener(this);
        ios401Layout.setOnClickListener(this);

        win.setOnClickListener(this);
        win101Layout.setOnClickListener(this);
        win201Layout.setOnClickListener(this);

        appinventor.setOnClickListener(this);
        app101Layout.setOnClickListener(this);
        app201Layout.setOnClickListener(this);
        app301Layout.setOnClickListener(this);
        app401Layout.setOnClickListener(this);

        scratch.setOnClickListener(this);
        scratch101Layout.setOnClickListener(this);
        scratch201Layout.setOnClickListener(this);

        arduino.setOnClickListener(this);
        arduino101Layout.setOnClickListener(this);
        arduino201Layout.setOnClickListener(this);
        arduino301Layout.setOnClickListener(this);
        arduino401Layout.setOnClickListener(this);


        return rootView;
    }


    @Override
    public void onClick(View v) {
        Intent i = null;
        switch (v.getId()) {

            case R.id.imageViewEgitimialAndroid101BtnMobilFragment:
                i = new Intent(getActivity(), EgitimBaslikActivity.class);
                i.putExtra(Egitim.TITLE_TAG, "Android 101");
                i.putExtra(Egitim.COLOR_TAG, "android");
                i.putExtra(Egitim.NODE_ID, getResources().getString(R.string.android101));
                startActivity(i);
                break;
            case R.id.imageViewEgitimialAndroid201BtnMobilFragment:
                i = new Intent(getActivity(), EgitimBaslikActivity.class);
                i.putExtra(Egitim.TITLE_TAG, "Android 201");
                i.putExtra(Egitim.COLOR_TAG, "android");
                i.putExtra(Egitim.NODE_ID, getResources().getString(R.string.android201));
                startActivity(i);
                break;
            case R.id.imageViewEgitimialAndroid301BtnMobilFragment:
                i = new Intent(getActivity(), EgitimBaslikActivity.class);
                i.putExtra(Egitim.TITLE_TAG, "Android 301");
                i.putExtra(Egitim.COLOR_TAG, "android");
                i.putExtra(Egitim.NODE_ID, getResources().getString(R.string.android301));
                startActivity(i);
                break;
            case R.id.imageViewEgitimialAndroid401BtnMobilFragment:
                i = new Intent(getActivity(), EgitimBaslikActivity.class);
                i.putExtra(Egitim.TITLE_TAG, "Android 401");
                i.putExtra(Egitim.COLOR_TAG, "android");
                i.putExtra(Egitim.NODE_ID, getResources().getString(R.string.android401));
                startActivity(i);
                break;
            case R.id.imageViewEgitimialIos102BtnMobilFragment:
                i = new Intent(getActivity(), EgitimBaslikActivity.class);
                i.putExtra(Egitim.TITLE_TAG, "IOS 102");
                i.putExtra(Egitim.COLOR_TAG, "ios");
                i.putExtra(Egitim.NODE_ID, getResources().getString(R.string.ios102));
                startActivity(i);
                break;
            case R.id.imageViewEgitimialIos101BtnMobilFragment:
                i = new Intent(getActivity(), EgitimBaslikActivity.class);
                i.putExtra(Egitim.TITLE_TAG, "IOS 101");
                i.putExtra(Egitim.COLOR_TAG, "ios");
                i.putExtra(Egitim.NODE_ID, getResources().getString(R.string.ios101));
                startActivity(i);
                break;
            case R.id.imageViewEgitimialIos201BtnMobilFragment:
                i = new Intent(getActivity(), EgitimBaslikActivity.class);
                i.putExtra(Egitim.TITLE_TAG, "IOS 201");
                i.putExtra(Egitim.COLOR_TAG, "ios");
                i.putExtra(Egitim.NODE_ID, getResources().getString(R.string.ios201));
                startActivity(i);
                break;
            case R.id.imageViewEgitimialIos301BtnMobilFragment:
                i = new Intent(getActivity(), EgitimBaslikActivity.class);
                i.putExtra(Egitim.TITLE_TAG, "IOS 301");
                i.putExtra(Egitim.COLOR_TAG, "ios");
                i.putExtra(Egitim.NODE_ID, getResources().getString(R.string.ios301));
                startActivity(i);
                break;
            case R.id.imageViewEgitimialIos401BtnMobilFragment:
                i = new Intent(getActivity(), EgitimBaslikActivity.class);
                i.putExtra(Egitim.TITLE_TAG, "IOS 401");
                i.putExtra(Egitim.COLOR_TAG, "ios");
                i.putExtra(Egitim.NODE_ID, getResources().getString(R.string.ios401));
                startActivity(i);
                break;

            case R.id.imageViewEgitimialWindows101BtnMobilFragment:
                i = new Intent(getActivity(), EgitimBaslikActivity.class);
                i.putExtra(Egitim.TITLE_TAG, "Windows Phone 101");
                i.putExtra(Egitim.COLOR_TAG, "win");
                i.putExtra(Egitim.NODE_ID, getResources().getString(R.string.win101));
                startActivity(i);
                break;
            case R.id.imageViewEgitimialWindows201BtnMobilFragment:
                i = new Intent(getActivity(), EgitimBaslikActivity.class);
                i.putExtra(Egitim.TITLE_TAG, "Windows Phone 201");
                i.putExtra(Egitim.COLOR_TAG, "win");
                i.putExtra(Egitim.NODE_ID, getResources().getString(R.string.win201));
                startActivity(i);
                break;

            case R.id.imageViewEgitimialAppinventor101BtnMobilFragment:
                i = new Intent(getActivity(), EgitimBaslikActivity.class);
                i.putExtra(Egitim.TITLE_TAG, "App Inventor 101");
                i.putExtra(Egitim.COLOR_TAG, "app");
                i.putExtra(Egitim.NODE_ID, getResources().getString(R.string.inventor101));
                startActivity(i);
                break;
            case R.id.imageViewEgitimialAppinventor201BtnMobilFragment:
                i = new Intent(getActivity(), EgitimBaslikActivity.class);
                i.putExtra(Egitim.TITLE_TAG, "App Inventor 201");
                i.putExtra(Egitim.COLOR_TAG, "app");
                i.putExtra(Egitim.NODE_ID, getResources().getString(R.string.inventor201));
                startActivity(i);
                break;
            case R.id.imageViewEgitimialAppinventor301BtnMobilFragment:
                i = new Intent(getActivity(), EgitimBaslikActivity.class);
                i.putExtra(Egitim.TITLE_TAG, "App Inventor 301");
                i.putExtra(Egitim.COLOR_TAG, "app");
                i.putExtra(Egitim.NODE_ID, getResources().getString(R.string.inventor301));
                startActivity(i);
                break;

            case R.id.imageViewEgitimialAppinventor401BtnMobilFragment:
                i = new Intent(getActivity(), EgitimBaslikActivity.class);
                i.putExtra(Egitim.TITLE_TAG, "App Inventor 401");
                i.putExtra(Egitim.COLOR_TAG, "app");
                i.putExtra(Egitim.NODE_ID, getResources().getString(R.string.inventor401));
                startActivity(i);
                break;

            case R.id.imageViewEgitimialArduino101BtnMobilFragment:
                i = new Intent(getActivity(), EgitimBaslikActivity.class);
                i.putExtra(Egitim.TITLE_TAG, "Arduino 101");
                i.putExtra(Egitim.COLOR_TAG, "arduino");
                i.putExtra(Egitim.NODE_ID, getResources().getString(R.string.arduino101));
                startActivity(i);
                break;
            case R.id.imageViewEgitimialArduino201BtnMobilFragment:
                i = new Intent(getActivity(), EgitimBaslikActivity.class);
                i.putExtra(Egitim.TITLE_TAG, "Arduino 201");
                i.putExtra(Egitim.COLOR_TAG, "arduino");
                i.putExtra(Egitim.NODE_ID, getResources().getString(R.string.arduino201));
                startActivity(i);
                break;
            case R.id.imageViewEgitimialArduino301BtnMobilFragment:
                i = new Intent(getActivity(), EgitimBaslikActivity.class);
                i.putExtra(Egitim.TITLE_TAG, "Arduino 301");
                i.putExtra(Egitim.COLOR_TAG, "arduino");
                i.putExtra(Egitim.NODE_ID, getResources().getString(R.string.arduino301));
                startActivity(i);
                break;
            case R.id.imageViewEgitimialArduino401BtnMobilFragment:
                i = new Intent(getActivity(), EgitimBaslikActivity.class);
                i.putExtra(Egitim.TITLE_TAG, "Arduino 401");
                i.putExtra(Egitim.COLOR_TAG, "arduino");
                i.putExtra(Egitim.NODE_ID, getResources().getString(R.string.arduino401));
                startActivity(i);
                break;


            case R.id.imageViewEgitimialScratch101BtnMobilFragment:
                i = new Intent(getActivity(), EgitimBaslikActivity.class);
                i.putExtra(Egitim.TITLE_TAG, "Scratch 101");
                i.putExtra(Egitim.COLOR_TAG, "scratch");
                i.putExtra(Egitim.NODE_ID, getResources().getString(R.string.scratch101));
                startActivity(i);
                break;
            case R.id.imageViewEgitimialScratch201BtnMobilFragment:
                i = new Intent(getActivity(), EgitimBaslikActivity.class);
                i.putExtra(Egitim.TITLE_TAG, "Scratch 201");
                i.putExtra(Egitim.COLOR_TAG, "scratch");
                i.putExtra(Egitim.NODE_ID, getResources().getString(R.string.scratch201));
                startActivity(i);
                break;

            case R.id.linearLayoutAndroidMobilFragment:
                if (androidIcerik.getVisibility() == View.VISIBLE) {
                    androidIcerik.setVisibility(View.GONE);
                    goster();
                    tablar.setVisibility(View.VISIBLE);
                    androidSagOk.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.sagok, null));
                } else {
                    androidIcerik.setVisibility(View.VISIBLE);
                    sakla();
                    tablar.setVisibility(View.GONE);
                    androidSagOk.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.asagiok, null));

                    iosIcerik.setVisibility(View.GONE);
                    winIcerik.setVisibility(View.GONE);
                    scratchIcerik.setVisibility(View.GONE);
                    appinventorIcerik.setVisibility(View.GONE);
                    arduinoIcerik.setVisibility(View.GONE);


                }
                break;


            case R.id.linearLayoutAndroid101MobilFragment:
                if (android101.getVisibility() == View.VISIBLE) {
                    android101.setVisibility(View.GONE);
                    android101AsagiOk.setImageResource(R.drawable.asagiikon);
                } else {
                    android101.setVisibility(View.VISIBLE);
                    android101AsagiOk.setImageResource(R.drawable.yukariikon);
                }
                break;

            case R.id.linearLayoutAndroid201MobilFragment:
                if (android201.getVisibility() == View.VISIBLE) {
                    android201.setVisibility(View.GONE);
                    android201AsagiOk.setImageResource(R.drawable.asagiikon);
                } else {
                    android201.setVisibility(View.VISIBLE);
                    android201AsagiOk.setImageResource(R.drawable.yukariikon);
                }
                break;

            case R.id.linearLayoutAndroid301MobilFragment:
                if (android301.getVisibility() == View.VISIBLE) {
                    android301.setVisibility(View.GONE);
                    android301AsagiOk.setImageResource(R.drawable.asagiikon);
                } else {
                    android301.setVisibility(View.VISIBLE);
                    android301AsagiOk.setImageResource(R.drawable.yukariikon);
                }
                break;


            case R.id.linearLayoutAndroid401MobilFragment:
                if (android401.getVisibility() == View.VISIBLE) {
                    android401.setVisibility(View.GONE);
                    android401AsagiOk.setImageResource(R.drawable.asagiikon);
                } else {
                    android401.setVisibility(View.VISIBLE);
                    android401AsagiOk.setImageResource(R.drawable.yukariikon);
                }
                break;


            case R.id.linearLayoutIosMobilFragment:
                if (iosIcerik.getVisibility() == View.VISIBLE) {
                    iosIcerik.setVisibility(View.GONE);
                    goster();
                    tablar.setVisibility(View.VISIBLE);
                    iosSagOk.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.sagok, null));
                } else {
                    iosIcerik.setVisibility(View.VISIBLE);
                    sakla();
                    tablar.setVisibility(View.GONE);
                    iosSagOk.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.asagiok, null));

                    androidIcerik.setVisibility(View.GONE);
                    winIcerik.setVisibility(View.GONE);
                    scratchIcerik.setVisibility(View.GONE);
                    appinventorIcerik.setVisibility(View.GONE);
                    arduinoIcerik.setVisibility(View.GONE);

                }
                break;

            case R.id.linearLayoutIos101MobilFragment:
                if (ios101.getVisibility() == View.VISIBLE) {
                    ios101.setVisibility(View.GONE);
                    ios101AsagiOk.setImageResource(R.drawable.asagiikon);
                } else {
                    ios101.setVisibility(View.VISIBLE);
                    ios101AsagiOk.setImageResource(R.drawable.yukariikon);
                }
                break;

            case R.id.linearLayoutIos102MobilFragment:
                if (ios102.getVisibility() == View.VISIBLE) {
                    ios102.setVisibility(View.GONE);
                    ios102AsagiOk.setImageResource(R.drawable.asagiikon);
                } else {
                    ios102.setVisibility(View.VISIBLE);
                    ios102AsagiOk.setImageResource(R.drawable.yukariikon);
                }
                break;

            case R.id.linearLayoutIos201MobilFragment:
                if (ios201.getVisibility() == View.VISIBLE) {
                    ios201.setVisibility(View.GONE);
                    ios201AsagiOk.setImageResource(R.drawable.asagiikon);
                } else {
                    ios201.setVisibility(View.VISIBLE);
                    ios201AsagiOk.setImageResource(R.drawable.yukariikon);
                }
                break;

            case R.id.linearLayoutIos301MobilFragment:
                if (ios301.getVisibility() == View.VISIBLE) {
                    ios301.setVisibility(View.GONE);
                    ios301AsagiOk.setImageResource(R.drawable.asagiikon);
                } else {
                    ios301.setVisibility(View.VISIBLE);
                    ios301AsagiOk.setImageResource(R.drawable.yukariikon);
                }
                break;

            case R.id.linearLayoutIos401MobilFragment:
                if (ios401.getVisibility() == View.VISIBLE) {
                    ios401.setVisibility(View.GONE);
                    ios401AsagiOk.setImageResource(R.drawable.asagiikon);
                } else {
                    ios401.setVisibility(View.VISIBLE);
                    ios401AsagiOk.setImageResource(R.drawable.yukariikon);
                }
                break;


            case R.id.linearLayoutWindowsMobilFragment:
                if (winIcerik.getVisibility() == View.VISIBLE) {
                    winIcerik.setVisibility(View.GONE);
                    goster();
                    tablar.setVisibility(View.VISIBLE);
                    winSagOk.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.sagok, null));
                } else {
                    winIcerik.setVisibility(View.VISIBLE);
                    sakla();
                    tablar.setVisibility(View.GONE);
                    winSagOk.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.asagiok, null));

                    iosIcerik.setVisibility(View.GONE);
                    androidIcerik.setVisibility(View.GONE);
                    scratchIcerik.setVisibility(View.GONE);
                    appinventorIcerik.setVisibility(View.GONE);
                    arduinoIcerik.setVisibility(View.GONE);
                }
                break;

            case R.id.linearLayoutWindows101MobilFragment:
                if (win101.getVisibility() == View.VISIBLE) {
                    win101.setVisibility(View.GONE);
                    win101AsagiOk.setImageResource(R.drawable.asagiikon);
                } else {
                    win101.setVisibility(View.VISIBLE);
                    win101AsagiOk.setImageResource(R.drawable.yukariikon);
                }
                break;

            case R.id.linearLayoutWindows201MobilFragment:
                if (win201.getVisibility() == View.VISIBLE) {
                    win201.setVisibility(View.GONE);
                    win201AsagiOk.setImageResource(R.drawable.asagiikon);
                } else {
                    win201.setVisibility(View.VISIBLE);
                    win201AsagiOk.setImageResource(R.drawable.yukariikon);
                }
                break;

            case R.id.linearLayoutAppinventorMobilFragment:
                if (appinventorIcerik.getVisibility() == View.VISIBLE) {
                    appinventorIcerik.setVisibility(View.GONE);
                    goster();
                    tablar.setVisibility(View.VISIBLE);
                    appSagOk.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.sagok, null));
                } else {
                    appinventorIcerik.setVisibility(View.VISIBLE);
                    sakla();
                    tablar.setVisibility(View.GONE);
                    appSagOk.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.asagiok, null));

                    iosIcerik.setVisibility(View.GONE);
                    winIcerik.setVisibility(View.GONE);
                    scratchIcerik.setVisibility(View.GONE);
                    androidIcerik.setVisibility(View.GONE);
                    arduinoIcerik.setVisibility(View.GONE);
                }
                break;

            case R.id.linearLayoutAppinventor101MobilFragment:
                if (app101.getVisibility() == View.VISIBLE) {
                    app101.setVisibility(View.GONE);
                    app101AsagiOk.setImageResource(R.drawable.asagiikon);
                } else {
                    app101.setVisibility(View.VISIBLE);
                    app101AsagiOk.setImageResource(R.drawable.yukariikon);
                }
                break;

            case R.id.linearLayoutAppinventor201MobilFragment:
                if (app201.getVisibility() == View.VISIBLE) {
                    app201.setVisibility(View.GONE);
                    app201AsagiOk.setImageResource(R.drawable.asagiikon);
                } else {
                    app201.setVisibility(View.VISIBLE);
                    app201AsagiOk.setImageResource(R.drawable.yukariikon);
                }
                break;

            case R.id.linearLayoutAppinventor301MobilFragment:
                if (app301.getVisibility() == View.VISIBLE) {
                    app301.setVisibility(View.GONE);
                    app301AsagiOk.setImageResource(R.drawable.asagiikon);
                } else {
                    app301.setVisibility(View.VISIBLE);
                    app301AsagiOk.setImageResource(R.drawable.yukariikon);
                }
                break;

            case R.id.linearLayoutAppinventor401MobilFragment:
                if (app401.getVisibility() == View.VISIBLE) {
                    app401.setVisibility(View.GONE);
                    app401AsagiOk.setImageResource(R.drawable.asagiikon);
                } else {
                    app401.setVisibility(View.VISIBLE);
                    app401AsagiOk.setImageResource(R.drawable.yukariikon);
                }
                break;


            case R.id.linearLayoutScratchMobilFragment:
                if (scratchIcerik.getVisibility() == View.VISIBLE) {
                    scratchIcerik.setVisibility(View.GONE);
                    goster();
                    tablar.setVisibility(View.VISIBLE);
                    scratchSagOk.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.sagok, null));
                } else {
                    scratchIcerik.setVisibility(View.VISIBLE);
                    sakla();
                    tablar.setVisibility(View.GONE);
                    scratchSagOk.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.asagiok, null));


                    iosIcerik.setVisibility(View.GONE);
                    winIcerik.setVisibility(View.GONE);
                    androidIcerik.setVisibility(View.GONE);
                    appinventorIcerik.setVisibility(View.GONE);
                    arduinoIcerik.setVisibility(View.GONE);
                }
                break;

            case R.id.linearLayoutScratch101MobilFragment:
                if (scratch101.getVisibility() == View.VISIBLE) {
                    scratch101.setVisibility(View.GONE);
                    scratch101AsagiOk.setImageResource(R.drawable.asagiikon);
                } else {
                    scratch101.setVisibility(View.VISIBLE);
                    scratch101AsagiOk.setImageResource(R.drawable.yukariikon);
                }
                break;

            case R.id.linearLayoutScratch201MobilFragment:
                if (scratch201.getVisibility() == View.VISIBLE) {
                    scratch201.setVisibility(View.GONE);
                    scratch201AsagiOk.setImageResource(R.drawable.asagiikon);
                } else {
                    scratch201.setVisibility(View.VISIBLE);
                    scratch201AsagiOk.setImageResource(R.drawable.yukariikon);
                }
                break;

            case R.id.linearLayoutArduinoMobilFragment:
                if (arduinoIcerik.getVisibility() == View.VISIBLE) {
                    arduinoIcerik.setVisibility(View.GONE);
                    goster();
                    tablar.setVisibility(View.VISIBLE);
                    arduinoSagOk.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.sagok, null));
                } else {
                    arduinoIcerik.setVisibility(View.VISIBLE);
                    sakla();
                    tablar.setVisibility(View.GONE);
                    arduinoSagOk.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.asagiok, null));

                    iosIcerik.setVisibility(View.GONE);
                    winIcerik.setVisibility(View.GONE);
                    scratchIcerik.setVisibility(View.GONE);
                    appinventorIcerik.setVisibility(View.GONE);
                    androidIcerik.setVisibility(View.GONE);
                }
                break;

            case R.id.linearLayoutArduino101MobilFragment:
                if (arduino101.getVisibility() == View.VISIBLE) {
                    arduino101.setVisibility(View.GONE);
                    arduino101AsagiOk.setImageResource(R.drawable.asagiikon);
                } else {
                    arduino101.setVisibility(View.VISIBLE);
                    arduino101AsagiOk.setImageResource(R.drawable.yukariikon);
                }
                break;


            case R.id.linearLayoutArduino201MobilFragment:
                if (arduino201.getVisibility() == View.VISIBLE) {
                    arduino201.setVisibility(View.GONE);
                    arduino201AsagiOk.setImageResource(R.drawable.asagiikon);
                } else {
                    arduino201.setVisibility(View.VISIBLE);
                    arduino201AsagiOk.setImageResource(R.drawable.yukariikon);
                }
                break;


            case R.id.linearLayoutArduino301MobilFragment:
                if (arduino301.getVisibility() == View.VISIBLE) {
                    arduino301.setVisibility(View.GONE);
                    arduino301AsagiOk.setImageResource(R.drawable.asagiikon);
                } else {
                    arduino301.setVisibility(View.VISIBLE);
                    arduino301AsagiOk.setImageResource(R.drawable.yukariikon);
                }
                break;


            case R.id.linearLayoutArduino401MobilFragment:
                if (arduino401.getVisibility() == View.VISIBLE) {
                    arduino401.setVisibility(View.GONE);
                    arduino401AsagiOk.setImageResource(R.drawable.asagiikon);
                } else {
                    arduino401.setVisibility(View.VISIBLE);
                    arduino401AsagiOk.setImageResource(R.drawable.yukariikon);
                }
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