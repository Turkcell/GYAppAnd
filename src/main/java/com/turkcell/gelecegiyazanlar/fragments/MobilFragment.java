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

        android = (LinearLayout) rootView.findViewById(R.id.android);
        androidIcerik = (LinearLayout) rootView.findViewById(R.id.layout_android_icerik);
        androidSagOk = (ImageView) rootView.findViewById(R.id.androidsagok);

        android101AsagiOk = (ImageView) rootView.findViewById(R.id.asagi_image_101_android);
        android101 = (LinearLayout) rootView.findViewById(R.id.egitimal_android_101);
        android101Layout = (LinearLayout) rootView.findViewById(R.id.layout_android_101);

        android201AsagiOk = (ImageView) rootView.findViewById(R.id.asagi_image_201_android);
        android201 = (LinearLayout) rootView.findViewById(R.id.egitimal_android_201);
        android201Layout = (LinearLayout) rootView.findViewById(R.id.layout_android_201);

        android301AsagiOk = (ImageView) rootView.findViewById(R.id.asagi_image_301_android);
        android301 = (LinearLayout) rootView.findViewById(R.id.egitimal_android_301);
        android301Layout = (LinearLayout) rootView.findViewById(R.id.layout_android_301);

        android401AsagiOk = (ImageView) rootView.findViewById(R.id.asagi_image_401_android);
        android401 = (LinearLayout) rootView.findViewById(R.id.egitimal_android_401);
        android401Layout = (LinearLayout) rootView.findViewById(R.id.layout_android_401);

        ust_layout = (LinearLayout) getActivity().findViewById(R.id.linearLayoutUstEkranEgitimFragment);
        tablar = (SlidingTabLayoutIcon) getActivity().findViewById(R.id.slidingTabLayoutIconEgitimFragment);


        ios = (LinearLayout) rootView.findViewById(R.id.ios);
        iosIcerik = (LinearLayout) rootView.findViewById(R.id.layout_ios_icerik);
        iosSagOk = (ImageView) rootView.findViewById(R.id.iossagok);

        ios101AsagiOk = (ImageView) rootView.findViewById(R.id.asagi_image_101_ios);
        ios101 = (LinearLayout) rootView.findViewById(R.id.egitimal_ios_101);
        ios101Layout = (LinearLayout) rootView.findViewById(R.id.layout_ios_101);

        ios102AsagiOk = (ImageView) rootView.findViewById(R.id.asagi_image_102_ios);
        ios102 = (LinearLayout) rootView.findViewById(R.id.egitimal_ios_102);
        ios102Layout = (LinearLayout) rootView.findViewById(R.id.layout_ios_102);

        ios201AsagiOk = (ImageView) rootView.findViewById(R.id.asagi_image_201_ios);
        ios201 = (LinearLayout) rootView.findViewById(R.id.egitimal_ios_201);
        ios201Layout = (LinearLayout) rootView.findViewById(R.id.layout_ios_201);

        ios301AsagiOk = (ImageView) rootView.findViewById(R.id.asagi_image_301_ios);
        ios301 = (LinearLayout) rootView.findViewById(R.id.egitimal_ios_301);
        ios301Layout = (LinearLayout) rootView.findViewById(R.id.layout_ios_301);

        ios401AsagiOk = (ImageView) rootView.findViewById(R.id.asagi_image_401_ios);
        ios401 = (LinearLayout) rootView.findViewById(R.id.egitimal_ios_401);
        ios401Layout = (LinearLayout) rootView.findViewById(R.id.layout_ios_401);

        win = (LinearLayout) rootView.findViewById(R.id.win);
        winIcerik = (LinearLayout) rootView.findViewById(R.id.layout_windows_icerik);
        winSagOk = (ImageView) rootView.findViewById(R.id.windowssagok);

        win101AsagiOk = (ImageView) rootView.findViewById(R.id.asagi_image_101_windows);
        win101 = (LinearLayout) rootView.findViewById(R.id.egitimal_windows_101);
        win101Layout = (LinearLayout) rootView.findViewById(R.id.layout_windows_101);

        win201AsagiOk = (ImageView) rootView.findViewById(R.id.asagi_image_201_windows);
        win201 = (LinearLayout) rootView.findViewById(R.id.egitimal_windows_201);
        win201Layout = (LinearLayout) rootView.findViewById(R.id.layout_windows_201);

        appinventor = (LinearLayout) rootView.findViewById(R.id.appinventor);
        appinventorIcerik = (LinearLayout) rootView.findViewById(R.id.layout_appinventor_icerik);
        appSagOk = (ImageView) rootView.findViewById(R.id.appsagok);

        app101AsagiOk = (ImageView) rootView.findViewById(R.id.asagi_image_101_appinventor);
        app101 = (LinearLayout) rootView.findViewById(R.id.egitimal_appinventor_101);
        app101Layout = (LinearLayout) rootView.findViewById(R.id.layout_appinventor_101);

        app201AsagiOk = (ImageView) rootView.findViewById(R.id.asagi_image_201_appinventor);
        app201 = (LinearLayout) rootView.findViewById(R.id.egitimal_appinventor_201);
        app201Layout = (LinearLayout) rootView.findViewById(R.id.layout_appinventor_201);


        app301AsagiOk = (ImageView) rootView.findViewById(R.id.asagi_image_301_appinventor);
        app301 = (LinearLayout) rootView.findViewById(R.id.egitimal_appinventor_301);
        app301Layout = (LinearLayout) rootView.findViewById(R.id.layout_appinventor_301);

        app401AsagiOk = (ImageView) rootView.findViewById(R.id.asagi_image_401_appinventor);
        app401 = (LinearLayout) rootView.findViewById(R.id.egitimal_appinventor_401);
        app401Layout = (LinearLayout) rootView.findViewById(R.id.layout_appinventor_401);

        scratch = (LinearLayout) rootView.findViewById(R.id.scratch);
        scratchIcerik = (LinearLayout) rootView.findViewById(R.id.layout_scratch_icerik);
        scratchSagOk = (ImageView) rootView.findViewById(R.id.scratchsagok);

        scratch101AsagiOk = (ImageView) rootView.findViewById(R.id.asagi_image_101_scratch);
        scratch101 = (LinearLayout) rootView.findViewById(R.id.egitimal_scratch_101);
        scratch101Layout = (LinearLayout) rootView.findViewById(R.id.layout_scratch_101);

        scratch201AsagiOk = (ImageView) rootView.findViewById(R.id.asagi_image_201_scratch);
        scratch201 = (LinearLayout) rootView.findViewById(R.id.egitimal_scratch_201);
        scratch201Layout = (LinearLayout) rootView.findViewById(R.id.layout_scratch_201);

        arduino = (LinearLayout) rootView.findViewById(R.id.arduino);
        arduinoIcerik = (LinearLayout) rootView.findViewById(R.id.layout_arduino_icerik);
        arduinoSagOk = (ImageView) rootView.findViewById(R.id.arduinosagok);

        arduino101AsagiOk = (ImageView) rootView.findViewById(R.id.asagi_image_101_arduino);
        arduino101 = (LinearLayout) rootView.findViewById(R.id.egitimal_arduino_101);
        arduino101Layout = (LinearLayout) rootView.findViewById(R.id.layout_arduino_101);

        arduino201AsagiOk = (ImageView) rootView.findViewById(R.id.asagi_image_201_arduino);
        arduino201 = (LinearLayout) rootView.findViewById(R.id.egitimal_arduino_201);
        arduino201Layout = (LinearLayout) rootView.findViewById(R.id.layout_arduino_201);

        arduino301AsagiOk = (ImageView) rootView.findViewById(R.id.asagi_image_301_arduino);
        arduino301 = (LinearLayout) rootView.findViewById(R.id.egitimal_arduino_301);
        arduino301Layout = (LinearLayout) rootView.findViewById(R.id.layout_arduino_301);

        arduino401AsagiOk = (ImageView) rootView.findViewById(R.id.asagi_image_401_arduino);
        arduino401 = (LinearLayout) rootView.findViewById(R.id.egitimal_arduino_401);
        arduino401Layout = (LinearLayout) rootView.findViewById(R.id.layout_arduino_401);


        android101Button = (ImageView) rootView.findViewById(R.id.egitimial_android_101_button);
        android201Button = (ImageView) rootView.findViewById(R.id.egitimial_android_201_button);
        android301Button = (ImageView) rootView.findViewById(R.id.egitimial_android_301_button);
        android401Button = (ImageView) rootView.findViewById(R.id.egitimial_android_401_button);
        ios101Button = (ImageView) rootView.findViewById(R.id.egitimial_ios_101_button);
        ios102Button = (ImageView) rootView.findViewById(R.id.egitimial_ios_102_button);
        ios201Button = (ImageView) rootView.findViewById(R.id.egitimial_ios_201_button);
        ios301Button = (ImageView) rootView.findViewById(R.id.egitimial_ios_301_button);
        ios401Button = (ImageView) rootView.findViewById(R.id.egitimial_ios_401_button);
        win101Button = (ImageView) rootView.findViewById(R.id.egitimial_windows_101_button);
        win201Button = (ImageView) rootView.findViewById(R.id.egitimial_windows_201_button);
        scratch101Button = (ImageView) rootView.findViewById(R.id.egitimial_scratch_101_button);
        scratch201Button = (ImageView) rootView.findViewById(R.id.egitimial_scratch_201_button);
        app101Button = (ImageView) rootView.findViewById(R.id.egitimial_appinventor_101_button);
        app201Button = (ImageView) rootView.findViewById(R.id.egitimial_appinventor_201_button);
        app301Button = (ImageView) rootView.findViewById(R.id.egitimial_appinventor_301_button);
        app401Button = (ImageView) rootView.findViewById(R.id.egitimial_appinventor_401_button);
        arduino101Button = (ImageView) rootView.findViewById(R.id.egitimial_arduino_101_button);
        arduino201Button = (ImageView) rootView.findViewById(R.id.egitimial_arduino_201_button);
        arduino301Button = (ImageView) rootView.findViewById(R.id.egitimial_arduino_301_button);
        arduino401Button = (ImageView) rootView.findViewById(R.id.egitimial_arduino_401_button);


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

            case R.id.egitimial_android_101_button:
                i = new Intent(getActivity(), EgitimBaslikActivity.class);
                i.putExtra(Egitim.TITLE_TAG, "Android 101");
                i.putExtra(Egitim.COLOR_TAG, "android");
                i.putExtra(Egitim.NODE_ID, getResources().getString(R.string.android101));
                startActivity(i);
                break;
            case R.id.egitimial_android_201_button:
                i = new Intent(getActivity(), EgitimBaslikActivity.class);
                i.putExtra(Egitim.TITLE_TAG, "Android 201");
                i.putExtra(Egitim.COLOR_TAG, "android");
                i.putExtra(Egitim.NODE_ID, getResources().getString(R.string.android201));
                startActivity(i);
                break;
            case R.id.egitimial_android_301_button:
                i = new Intent(getActivity(), EgitimBaslikActivity.class);
                i.putExtra(Egitim.TITLE_TAG, "Android 301");
                i.putExtra(Egitim.COLOR_TAG, "android");
                i.putExtra(Egitim.NODE_ID, getResources().getString(R.string.android301));
                startActivity(i);
                break;
            case R.id.egitimial_android_401_button:
                i = new Intent(getActivity(), EgitimBaslikActivity.class);
                i.putExtra(Egitim.TITLE_TAG, "Android 401");
                i.putExtra(Egitim.COLOR_TAG, "android");
                i.putExtra(Egitim.NODE_ID, getResources().getString(R.string.android401));
                startActivity(i);
                break;
            case R.id.egitimial_ios_102_button:
                i = new Intent(getActivity(), EgitimBaslikActivity.class);
                i.putExtra(Egitim.TITLE_TAG, "IOS 102");
                i.putExtra(Egitim.COLOR_TAG, "ios");
                i.putExtra(Egitim.NODE_ID, getResources().getString(R.string.ios102));
                startActivity(i);
                break;
            case R.id.egitimial_ios_101_button:
                i = new Intent(getActivity(), EgitimBaslikActivity.class);
                i.putExtra(Egitim.TITLE_TAG, "IOS 101");
                i.putExtra(Egitim.COLOR_TAG, "ios");
                i.putExtra(Egitim.NODE_ID, getResources().getString(R.string.ios101));
                startActivity(i);
                break;
            case R.id.egitimial_ios_201_button:
                i = new Intent(getActivity(), EgitimBaslikActivity.class);
                i.putExtra(Egitim.TITLE_TAG, "IOS 201");
                i.putExtra(Egitim.COLOR_TAG, "ios");
                i.putExtra(Egitim.NODE_ID, getResources().getString(R.string.ios201));
                startActivity(i);
                break;
            case R.id.egitimial_ios_301_button:
                i = new Intent(getActivity(), EgitimBaslikActivity.class);
                i.putExtra(Egitim.TITLE_TAG, "IOS 301");
                i.putExtra(Egitim.COLOR_TAG, "ios");
                i.putExtra(Egitim.NODE_ID, getResources().getString(R.string.ios301));
                startActivity(i);
                break;
            case R.id.egitimial_ios_401_button:
                i = new Intent(getActivity(), EgitimBaslikActivity.class);
                i.putExtra(Egitim.TITLE_TAG, "IOS 401");
                i.putExtra(Egitim.COLOR_TAG, "ios");
                i.putExtra(Egitim.NODE_ID, getResources().getString(R.string.ios401));
                startActivity(i);
                break;

            case R.id.egitimial_windows_101_button:
                i = new Intent(getActivity(), EgitimBaslikActivity.class);
                i.putExtra(Egitim.TITLE_TAG, "Windows Phone 101");
                i.putExtra(Egitim.COLOR_TAG, "win");
                i.putExtra(Egitim.NODE_ID, getResources().getString(R.string.win101));
                startActivity(i);
                break;
            case R.id.egitimial_windows_201_button:
                i = new Intent(getActivity(), EgitimBaslikActivity.class);
                i.putExtra(Egitim.TITLE_TAG, "Windows Phone 201");
                i.putExtra(Egitim.COLOR_TAG, "win");
                i.putExtra(Egitim.NODE_ID, getResources().getString(R.string.win201));
                startActivity(i);
                break;

            case R.id.egitimial_appinventor_101_button:
                i = new Intent(getActivity(), EgitimBaslikActivity.class);
                i.putExtra(Egitim.TITLE_TAG, "App Inventor 101");
                i.putExtra(Egitim.COLOR_TAG, "app");
                i.putExtra(Egitim.NODE_ID, getResources().getString(R.string.inventor101));
                startActivity(i);
                break;
            case R.id.egitimial_appinventor_201_button:
                i = new Intent(getActivity(), EgitimBaslikActivity.class);
                i.putExtra(Egitim.TITLE_TAG, "App Inventor 201");
                i.putExtra(Egitim.COLOR_TAG, "app");
                i.putExtra(Egitim.NODE_ID, getResources().getString(R.string.inventor201));
                startActivity(i);
                break;
            case R.id.egitimial_appinventor_301_button:
                i = new Intent(getActivity(), EgitimBaslikActivity.class);
                i.putExtra(Egitim.TITLE_TAG, "App Inventor 301");
                i.putExtra(Egitim.COLOR_TAG, "app");
                i.putExtra(Egitim.NODE_ID, getResources().getString(R.string.inventor301));
                startActivity(i);
                break;

            case R.id.egitimial_appinventor_401_button:
                i = new Intent(getActivity(), EgitimBaslikActivity.class);
                i.putExtra(Egitim.TITLE_TAG, "App Inventor 401");
                i.putExtra(Egitim.COLOR_TAG, "app");
                i.putExtra(Egitim.NODE_ID, getResources().getString(R.string.inventor401));
                startActivity(i);
                break;

            case R.id.egitimial_arduino_101_button:
                i = new Intent(getActivity(), EgitimBaslikActivity.class);
                i.putExtra(Egitim.TITLE_TAG, "Arduino 101");
                i.putExtra(Egitim.COLOR_TAG, "arduino");
                i.putExtra(Egitim.NODE_ID, getResources().getString(R.string.arduino101));
                startActivity(i);
                break;
            case R.id.egitimial_arduino_201_button:
                i = new Intent(getActivity(), EgitimBaslikActivity.class);
                i.putExtra(Egitim.TITLE_TAG, "Arduino 201");
                i.putExtra(Egitim.COLOR_TAG, "arduino");
                i.putExtra(Egitim.NODE_ID, getResources().getString(R.string.arduino201));
                startActivity(i);
                break;
            case R.id.egitimial_arduino_301_button:
                i = new Intent(getActivity(), EgitimBaslikActivity.class);
                i.putExtra(Egitim.TITLE_TAG, "Arduino 301");
                i.putExtra(Egitim.COLOR_TAG, "arduino");
                i.putExtra(Egitim.NODE_ID, getResources().getString(R.string.arduino301));
                startActivity(i);
                break;
            case R.id.egitimial_arduino_401_button:
                i = new Intent(getActivity(), EgitimBaslikActivity.class);
                i.putExtra(Egitim.TITLE_TAG, "Arduino 401");
                i.putExtra(Egitim.COLOR_TAG, "arduino");
                i.putExtra(Egitim.NODE_ID, getResources().getString(R.string.arduino401));
                startActivity(i);
                break;


            case R.id.egitimial_scratch_101_button:
                i = new Intent(getActivity(), EgitimBaslikActivity.class);
                i.putExtra(Egitim.TITLE_TAG, "Scratch 101");
                i.putExtra(Egitim.COLOR_TAG, "scratch");
                i.putExtra(Egitim.NODE_ID, getResources().getString(R.string.scratch101));
                startActivity(i);
                break;
            case R.id.egitimial_scratch_201_button:
                i = new Intent(getActivity(), EgitimBaslikActivity.class);
                i.putExtra(Egitim.TITLE_TAG, "Scratch 201");
                i.putExtra(Egitim.COLOR_TAG, "scratch");
                i.putExtra(Egitim.NODE_ID, getResources().getString(R.string.scratch201));
                startActivity(i);
                break;

            case R.id.android:
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


            case R.id.layout_android_101:
                if (android101.getVisibility() == View.VISIBLE) {
                    android101.setVisibility(View.GONE);
                    android101AsagiOk.setImageResource(R.drawable.asagiikon);
                } else {
                    android101.setVisibility(View.VISIBLE);
                    android101AsagiOk.setImageResource(R.drawable.yukariikon);
                }
                break;

            case R.id.layout_android_201:
                if (android201.getVisibility() == View.VISIBLE) {
                    android201.setVisibility(View.GONE);
                    android201AsagiOk.setImageResource(R.drawable.asagiikon);
                } else {
                    android201.setVisibility(View.VISIBLE);
                    android201AsagiOk.setImageResource(R.drawable.yukariikon);
                }
                break;

            case R.id.layout_android_301:
                if (android301.getVisibility() == View.VISIBLE) {
                    android301.setVisibility(View.GONE);
                    android301AsagiOk.setImageResource(R.drawable.asagiikon);
                } else {
                    android301.setVisibility(View.VISIBLE);
                    android301AsagiOk.setImageResource(R.drawable.yukariikon);
                }
                break;


            case R.id.layout_android_401:
                if (android401.getVisibility() == View.VISIBLE) {
                    android401.setVisibility(View.GONE);
                    android401AsagiOk.setImageResource(R.drawable.asagiikon);
                } else {
                    android401.setVisibility(View.VISIBLE);
                    android401AsagiOk.setImageResource(R.drawable.yukariikon);
                }
                break;


            case R.id.ios:
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

            case R.id.layout_ios_101:
                if (ios101.getVisibility() == View.VISIBLE) {
                    ios101.setVisibility(View.GONE);
                    ios101AsagiOk.setImageResource(R.drawable.asagiikon);
                } else {
                    ios101.setVisibility(View.VISIBLE);
                    ios101AsagiOk.setImageResource(R.drawable.yukariikon);
                }
                break;

            case R.id.layout_ios_102:
                if (ios102.getVisibility() == View.VISIBLE) {
                    ios102.setVisibility(View.GONE);
                    ios102AsagiOk.setImageResource(R.drawable.asagiikon);
                } else {
                    ios102.setVisibility(View.VISIBLE);
                    ios102AsagiOk.setImageResource(R.drawable.yukariikon);
                }
                break;

            case R.id.layout_ios_201:
                if (ios201.getVisibility() == View.VISIBLE) {
                    ios201.setVisibility(View.GONE);
                    ios201AsagiOk.setImageResource(R.drawable.asagiikon);
                } else {
                    ios201.setVisibility(View.VISIBLE);
                    ios201AsagiOk.setImageResource(R.drawable.yukariikon);
                }
                break;

            case R.id.layout_ios_301:
                if (ios301.getVisibility() == View.VISIBLE) {
                    ios301.setVisibility(View.GONE);
                    ios301AsagiOk.setImageResource(R.drawable.asagiikon);
                } else {
                    ios301.setVisibility(View.VISIBLE);
                    ios301AsagiOk.setImageResource(R.drawable.yukariikon);
                }
                break;

            case R.id.layout_ios_401:
                if (ios401.getVisibility() == View.VISIBLE) {
                    ios401.setVisibility(View.GONE);
                    ios401AsagiOk.setImageResource(R.drawable.asagiikon);
                } else {
                    ios401.setVisibility(View.VISIBLE);
                    ios401AsagiOk.setImageResource(R.drawable.yukariikon);
                }
                break;


            case R.id.win:
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

            case R.id.layout_windows_101:
                if (win101.getVisibility() == View.VISIBLE) {
                    win101.setVisibility(View.GONE);
                    win101AsagiOk.setImageResource(R.drawable.asagiikon);
                } else {
                    win101.setVisibility(View.VISIBLE);
                    win101AsagiOk.setImageResource(R.drawable.yukariikon);
                }
                break;

            case R.id.layout_windows_201:
                if (win201.getVisibility() == View.VISIBLE) {
                    win201.setVisibility(View.GONE);
                    win201AsagiOk.setImageResource(R.drawable.asagiikon);
                } else {
                    win201.setVisibility(View.VISIBLE);
                    win201AsagiOk.setImageResource(R.drawable.yukariikon);
                }
                break;

            case R.id.appinventor:
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

            case R.id.layout_appinventor_101:
                if (app101.getVisibility() == View.VISIBLE) {
                    app101.setVisibility(View.GONE);
                    app101AsagiOk.setImageResource(R.drawable.asagiikon);
                } else {
                    app101.setVisibility(View.VISIBLE);
                    app101AsagiOk.setImageResource(R.drawable.yukariikon);
                }
                break;

            case R.id.layout_appinventor_201:
                if (app201.getVisibility() == View.VISIBLE) {
                    app201.setVisibility(View.GONE);
                    app201AsagiOk.setImageResource(R.drawable.asagiikon);
                } else {
                    app201.setVisibility(View.VISIBLE);
                    app201AsagiOk.setImageResource(R.drawable.yukariikon);
                }
                break;

            case R.id.layout_appinventor_301:
                if (app301.getVisibility() == View.VISIBLE) {
                    app301.setVisibility(View.GONE);
                    app301AsagiOk.setImageResource(R.drawable.asagiikon);
                } else {
                    app301.setVisibility(View.VISIBLE);
                    app301AsagiOk.setImageResource(R.drawable.yukariikon);
                }
                break;

            case R.id.layout_appinventor_401:
                if (app401.getVisibility() == View.VISIBLE) {
                    app401.setVisibility(View.GONE);
                    app401AsagiOk.setImageResource(R.drawable.asagiikon);
                } else {
                    app401.setVisibility(View.VISIBLE);
                    app401AsagiOk.setImageResource(R.drawable.yukariikon);
                }
                break;


            case R.id.scratch:
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

            case R.id.layout_scratch_101:
                if (scratch101.getVisibility() == View.VISIBLE) {
                    scratch101.setVisibility(View.GONE);
                    scratch101AsagiOk.setImageResource(R.drawable.asagiikon);
                } else {
                    scratch101.setVisibility(View.VISIBLE);
                    scratch101AsagiOk.setImageResource(R.drawable.yukariikon);
                }
                break;

            case R.id.layout_scratch_201:
                if (scratch201.getVisibility() == View.VISIBLE) {
                    scratch201.setVisibility(View.GONE);
                    scratch201AsagiOk.setImageResource(R.drawable.asagiikon);
                } else {
                    scratch201.setVisibility(View.VISIBLE);
                    scratch201AsagiOk.setImageResource(R.drawable.yukariikon);
                }
                break;

            case R.id.arduino:
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

            case R.id.layout_arduino_101:
                if (arduino101.getVisibility() == View.VISIBLE) {
                    arduino101.setVisibility(View.GONE);
                    arduino101AsagiOk.setImageResource(R.drawable.asagiikon);
                } else {
                    arduino101.setVisibility(View.VISIBLE);
                    arduino101AsagiOk.setImageResource(R.drawable.yukariikon);
                }
                break;


            case R.id.layout_arduino_201:
                if (arduino201.getVisibility() == View.VISIBLE) {
                    arduino201.setVisibility(View.GONE);
                    arduino201AsagiOk.setImageResource(R.drawable.asagiikon);
                } else {
                    arduino201.setVisibility(View.VISIBLE);
                    arduino201AsagiOk.setImageResource(R.drawable.yukariikon);
                }
                break;


            case R.id.layout_arduino_301:
                if (arduino301.getVisibility() == View.VISIBLE) {
                    arduino301.setVisibility(View.GONE);
                    arduino301AsagiOk.setImageResource(R.drawable.asagiikon);
                } else {
                    arduino301.setVisibility(View.VISIBLE);
                    arduino301AsagiOk.setImageResource(R.drawable.yukariikon);
                }
                break;


            case R.id.layout_arduino_401:
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