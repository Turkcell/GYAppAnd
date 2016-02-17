package com.turkcell.gelecegiyazanlar.FragmentPaketi;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.turkcell.gelecegiyazanlar.ActivityPaketi.MainActivity;
import com.turkcell.gelecegiyazanlar.ActivityPaketi.ProfilActivity;
import com.turkcell.gelecegiyazanlar.R;


public class ElcilerFragment extends android.support.v4.app.Fragment {

    LinearLayout ahmedUstem;
    LinearLayout ahmetAnil;
    LinearLayout cerenCoskun;
    LinearLayout dogukanYildirim;
    LinearLayout gizemYurdagul;
    LinearLayout abdullahSarikaya;
    LinearLayout halilOncen;
    LinearLayout ibrahimHobekkaya;
    LinearLayout ilkanEngin;
    LinearLayout ismailArslan;
    LinearLayout kadirhanEkmekcioglu;
    LinearLayout oguzBilgener;
    LinearLayout tanerUtku;
    LinearLayout tugceGursoy;
    LinearLayout erenUtku;
    LinearLayout volkanKilic;

    String id;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView=inflater.inflate(R.layout.fragment_elciler, container, false);


        ahmedUstem = (LinearLayout) rootView.findViewById(R.id.ahmedUstem);
        ahmetAnil = (LinearLayout) rootView.findViewById(R.id.ahmetAnil);
        cerenCoskun = (LinearLayout) rootView.findViewById(R.id.cerenCoskun);
        dogukanYildirim = (LinearLayout) rootView.findViewById(R.id.dogukanYildirim);
        gizemYurdagul = (LinearLayout) rootView.findViewById(R.id.gizemYurdagul);
        abdullahSarikaya = (LinearLayout) rootView.findViewById(R.id.abdullahSarikaya);
        halilOncen = (LinearLayout) rootView.findViewById(R.id.halilOncen);
        ibrahimHobekkaya = (LinearLayout) rootView.findViewById(R.id.ibrahimHobekkaya);
        ilkanEngin = (LinearLayout) rootView.findViewById(R.id.ilkanEngin);
        ismailArslan = (LinearLayout) rootView.findViewById(R.id.ismailArslan);
        kadirhanEkmekcioglu = (LinearLayout)rootView. findViewById(R.id.kadirhanEkmekcioglu);
        oguzBilgener = (LinearLayout) rootView.findViewById(R.id.oguzBilgener);
        tanerUtku = (LinearLayout) rootView.findViewById(R.id.tanerUtku);
        tugceGursoy = (LinearLayout) rootView.findViewById(R.id.tugceGursoy);
        erenUtku = (LinearLayout)rootView. findViewById(R.id.erenUtku);
        volkanKilic = (LinearLayout) rootView.findViewById(R.id.volkanKilic);


        ahmedUstem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = "7292";

                Intent intent = new Intent(getActivity(), ProfilActivity.class);
                intent.putExtra(getResources().getString(R.string.profilID), id);
                startActivity(intent);

            }
        });

        ahmetAnil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = "15363";

                Intent intent = new Intent(getActivity(), ProfilActivity.class);
                intent.putExtra(getResources().getString(R.string.profilID), id);
                startActivity(intent);
            }
        });

        cerenCoskun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = "29472";

                Intent intent = new Intent(getActivity(), ProfilActivity.class);
                intent.putExtra(getResources().getString(R.string.profilID), id);
                startActivity(intent);

            }
        });

        dogukanYildirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = "21294";

                Intent intent = new Intent(getActivity(), ProfilActivity.class);
                intent.putExtra(getResources().getString(R.string.profilID), id);
                startActivity(intent);
            }
        });

        gizemYurdagul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = "36644";

                Intent intent = new Intent(getActivity(), ProfilActivity.class);
                intent.putExtra(getResources().getString(R.string.profilID), id);
                startActivity(intent);
            }
        });

        abdullahSarikaya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = "17846";

                Intent intent = new Intent(getActivity(), ProfilActivity.class);
                intent.putExtra(getResources().getString(R.string.profilID), id);
                startActivity(intent);
            }
        });

        halilOncen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = "10880";

                Intent intent = new Intent(getActivity(), ProfilActivity.class);
                intent.putExtra(getResources().getString(R.string.profilID), id);
                startActivity(intent);
            }
        });

        ibrahimHobekkaya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = "3646";

                Intent intent = new Intent(getActivity(), ProfilActivity.class);
                intent.putExtra(getResources().getString(R.string.profilID), id);
                startActivity(intent);
            }
        });

        ilkanEngin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = "13420";

                Intent intent = new Intent(getActivity(), ProfilActivity.class);
                intent.putExtra(getResources().getString(R.string.profilID), id);
                startActivity(intent);
            }
        });

        ismailArslan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = "30717";

                Intent intent = new Intent(getActivity(), ProfilActivity.class);
                intent.putExtra(getResources().getString(R.string.profilID), id);
                startActivity(intent);
            }
        });

        kadirhanEkmekcioglu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = "10678";

                Intent intent = new Intent(getActivity(), ProfilActivity.class);
                intent.putExtra(getResources().getString(R.string.profilID), id);
                startActivity(intent);
            }
        });

        oguzBilgener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = "18711";

                Intent intent = new Intent(getActivity(), ProfilActivity.class);
                intent.putExtra(getResources().getString(R.string.profilID), id);
                startActivity(intent);
            }
        });

        tanerUtku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = "7934";

                Intent intent = new Intent(getActivity(), ProfilActivity.class);
                intent.putExtra(getResources().getString(R.string.profilID), id);
                startActivity(intent);
            }
        });

        tugceGursoy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = "7736";

                Intent intent = new Intent(getActivity(), ProfilActivity.class);
                intent.putExtra(getResources().getString(R.string.profilID), id);
                startActivity(intent);
            }
        });

        erenUtku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = "35522";

                Intent intent = new Intent(getActivity(), ProfilActivity.class);
                intent.putExtra(getResources().getString(R.string.profilID), id);
                startActivity(intent);
            }
        });

        volkanKilic.setOnClickListener(new View.OnClickListener() {
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
