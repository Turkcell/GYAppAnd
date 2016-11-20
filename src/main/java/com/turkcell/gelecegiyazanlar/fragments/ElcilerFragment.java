package com.turkcell.gelecegiyazanlar.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.turkcell.gelecegiyazanlar.R;
import com.turkcell.gelecegiyazanlar.activities.ProfilActivity;
import com.turkcell.gelecegiyazanlar.models.Kisi;


public class ElcilerFragment extends Fragment {

    private LinearLayout lyDogukanYildirim;
    private LinearLayout lyGizemYurdagul;
    private LinearLayout lyAbdullahSarikaya;
    private LinearLayout lyKadirhanEkmekcioglu;
    private LinearLayout lyTanerUtku;
    private LinearLayout lyErenUtku;
    private LinearLayout lyVolkanKilic;
    private LinearLayout lyFeyzaOkumus;
    private String id;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_gelistiriciler, container, false);

        lyFeyzaOkumus = (LinearLayout) rootView.findViewById(R.id.linearLayoutFeyza);
        lyDogukanYildirim = (LinearLayout) rootView.findViewById(R.id.linearLayoutDogukanYildirim);
        lyGizemYurdagul = (LinearLayout) rootView.findViewById(R.id.linearLayoutGizemYurdagul);
        lyAbdullahSarikaya = (LinearLayout) rootView.findViewById(R.id.linearLayoutAbdullahSarikaya);
        lyKadirhanEkmekcioglu = (LinearLayout) rootView.findViewById(R.id.linearLayoutKadirhanEkmekcioglu);
        lyTanerUtku = (LinearLayout) rootView.findViewById(R.id.linearLayoutTanerUtku);
        lyErenUtku = (LinearLayout) rootView.findViewById(R.id.linearLayoutErenUtku);
        lyVolkanKilic = (LinearLayout) rootView.findViewById(R.id.linearLayoutVolkanKilic);


        lyFeyzaOkumus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = "59885";

                Intent intent = new Intent(getActivity(), ProfilActivity.class);
                intent.putExtra(Kisi.PROFIL_ID, id);
                startActivity(intent);

            }
        });


        lyDogukanYildirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = "21294";

                Intent intent = new Intent(getActivity(), ProfilActivity.class);
                intent.putExtra(Kisi.PROFIL_ID, id);
                startActivity(intent);
            }
        });

        lyGizemYurdagul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = "36644";

                Intent intent = new Intent(getActivity(), ProfilActivity.class);
                intent.putExtra(Kisi.PROFIL_ID, id);
                startActivity(intent);
            }
        });

        lyAbdullahSarikaya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = "17846";

                Intent intent = new Intent(getActivity(), ProfilActivity.class);
                intent.putExtra(Kisi.PROFIL_ID, id);
                startActivity(intent);
            }
        });


        lyKadirhanEkmekcioglu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = "10678";

                Intent intent = new Intent(getActivity(), ProfilActivity.class);
                intent.putExtra(Kisi.PROFIL_ID, id);
                startActivity(intent);
            }
        });

        lyTanerUtku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = "7934";

                Intent intent = new Intent(getActivity(), ProfilActivity.class);
                intent.putExtra(Kisi.PROFIL_ID, id);
                startActivity(intent);
            }
        });


        lyErenUtku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = "35522";

                Intent intent = new Intent(getActivity(), ProfilActivity.class);
                intent.putExtra(Kisi.PROFIL_ID, id);
                startActivity(intent);
            }
        });

        lyVolkanKilic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = "2681";

                Intent intent = new Intent(getActivity(), ProfilActivity.class);
                intent.putExtra(Kisi.PROFIL_ID, id);
                startActivity(intent);
            }
        });
        return rootView;
    }


}
