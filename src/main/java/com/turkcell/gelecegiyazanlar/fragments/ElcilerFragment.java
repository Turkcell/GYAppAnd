package com.turkcell.gelecegiyazanlar.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.turkcell.gelecegiyazanlar.R;
import com.turkcell.gelecegiyazanlar.activities.ProfilActivity;


public class ElcilerFragment extends android.support.v4.app.Fragment {

    LinearLayout lyDogukanYildirim;
    LinearLayout lyGizemYurdagul;
    LinearLayout lyAbdullahSarikaya;
    LinearLayout lyKadirhanEkmekcioglu;
    LinearLayout lyTanerUtku;
    LinearLayout lyErenUtku;
    LinearLayout lyVolkanKilic;
    LinearLayout lyFeyzaOkumus;
    String id;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_gelistiriciler, container, false);


        lyFeyzaOkumus = (LinearLayout) rootView.findViewById(R.id.feyza);
        lyDogukanYildirim = (LinearLayout) rootView.findViewById(R.id.dogukanYildirim);
        lyGizemYurdagul = (LinearLayout) rootView.findViewById(R.id.gizemYurdagul);
        lyAbdullahSarikaya = (LinearLayout) rootView.findViewById(R.id.abdullahSarikaya);
        lyKadirhanEkmekcioglu = (LinearLayout) rootView.findViewById(R.id.kadirhanEkmekcioglu);
        lyTanerUtku = (LinearLayout) rootView.findViewById(R.id.tanerUtku);
        lyErenUtku = (LinearLayout) rootView.findViewById(R.id.erenUtku);
        lyVolkanKilic = (LinearLayout) rootView.findViewById(R.id.volkanKilic);


        lyFeyzaOkumus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = "59885";

                Intent intent = new Intent(getActivity(), ProfilActivity.class);
                intent.putExtra(getResources().getString(R.string.profilID), id);
                startActivity(intent);

            }
        });


        lyDogukanYildirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = "21294";

                Intent intent = new Intent(getActivity(), ProfilActivity.class);
                intent.putExtra(getResources().getString(R.string.profilID), id);
                startActivity(intent);
            }
        });

        lyGizemYurdagul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = "36644";

                Intent intent = new Intent(getActivity(), ProfilActivity.class);
                intent.putExtra(getResources().getString(R.string.profilID), id);
                startActivity(intent);
            }
        });

        lyAbdullahSarikaya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = "17846";

                Intent intent = new Intent(getActivity(), ProfilActivity.class);
                intent.putExtra(getResources().getString(R.string.profilID), id);
                startActivity(intent);
            }
        });


        lyKadirhanEkmekcioglu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = "10678";

                Intent intent = new Intent(getActivity(), ProfilActivity.class);
                intent.putExtra(getResources().getString(R.string.profilID), id);
                startActivity(intent);
            }
        });

        lyTanerUtku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = "7934";

                Intent intent = new Intent(getActivity(), ProfilActivity.class);
                intent.putExtra(getResources().getString(R.string.profilID), id);
                startActivity(intent);
            }
        });


        lyErenUtku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = "35522";

                Intent intent = new Intent(getActivity(), ProfilActivity.class);
                intent.putExtra(getResources().getString(R.string.profilID), id);
                startActivity(intent);
            }
        });

        lyVolkanKilic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = "2681";

                Intent intent = new Intent(getActivity(), ProfilActivity.class);
                intent.putExtra(getResources().getString(R.string.profilID), id);
                startActivity(intent);
            }
        });
        return rootView;
    }


}
