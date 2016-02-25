package com.turkcell.gelecegiyazanlar.Fragment;
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

import com.turkcell.gelecegiyazanlar.Activity.EgitimBaslikActivity;
import com.turkcell.gelecegiyazanlar.DesignEklentileri.SlidingTabLayoutIcon;
import com.turkcell.gelecegiyazanlar.R;

/**
 * Web Sayfasýnýn Fragmentý
 */

public class WebFragment extends Fragment implements View.OnClickListener {


    LinearLayout ust_layout,web,webIcerik;

    Toolbar toolbar;

    LinearLayout web101,web101Layout,web201,web201Layout,web301,web301Layout,web302,web302Layout
            ,web401,web401Layout;


    SlidingTabLayoutIcon tablar;
    ImageView webSagOk,web101AsagiOk,web201AsagiOk,web301AsagiOk,web302AsagiOk,web401AsagiOk;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

           toolbar=(Toolbar)getActivity().findViewById(R.id.tool_bar);
        View rootView=inflater.inflate(R.layout.fragment_web, container, false);

        web=(LinearLayout)rootView.findViewById(R.id.web);
        webIcerik=(LinearLayout)rootView.findViewById(R.id.layout_web_icerik);
        webSagOk=(ImageView)rootView.findViewById(R.id.websagok);

        web101AsagiOk=(ImageView)rootView.findViewById(R.id.asagi_image_101_web);
        web101=(LinearLayout)rootView.findViewById(R.id.egitimal_web_101);
        web101Layout=(LinearLayout)rootView.findViewById(R.id.layout_web_101);

        web201AsagiOk=(ImageView)rootView.findViewById(R.id.asagi_image_201_web);
        web201=(LinearLayout)rootView.findViewById(R.id.egitimal_web_201);
        web201Layout=(LinearLayout)rootView.findViewById(R.id.layout_web_201);

        web301AsagiOk=(ImageView)rootView.findViewById(R.id.asagi_image_301_android);
        web301=(LinearLayout)rootView.findViewById(R.id.egitimal_web_301);
        web301Layout=(LinearLayout)rootView.findViewById(R.id.layout_web_301);

        web302AsagiOk=(ImageView)rootView.findViewById(R.id.asagi_image_302_web);
        web302=(LinearLayout)rootView.findViewById(R.id.egitimal_web_302);
        web302Layout=(LinearLayout)rootView.findViewById(R.id.layout_web_302);

        web401AsagiOk=(ImageView)rootView.findViewById(R.id.asagi_image_401_web);
        web401=(LinearLayout)rootView.findViewById(R.id.egitimal_web_401);
        web401Layout=(LinearLayout)rootView.findViewById(R.id.layout_web_401);

        ust_layout=(LinearLayout)getActivity().findViewById(R.id.ustekran);
        tablar=(SlidingTabLayoutIcon)getActivity().findViewById(R.id.tabs);



        web.setOnClickListener(this);
        web101Layout.setOnClickListener(this);
        web201Layout.setOnClickListener(this);
        web301Layout.setOnClickListener(this);
        web302Layout.setOnClickListener(this);
        web401Layout.setOnClickListener(this);

        web101.setOnClickListener(this);
        web201.setOnClickListener(this);
        web301.setOnClickListener(this);
        web302.setOnClickListener(this);
        web401.setOnClickListener(this);

        return rootView;
    }


    @Override
    public void onClick(View v) {
        Intent i=null;
        switch (v.getId()){

            case R.id.web:
                if(webIcerik.getVisibility()==View.VISIBLE){
                    webIcerik.setVisibility(View.GONE);
                    goster();
                    tablar.setVisibility(View.VISIBLE);
                    webSagOk.setImageDrawable(getResources().getDrawable(R.drawable.sagok));
                }
                else{
                    webIcerik.setVisibility(View.VISIBLE);
                    sakla();
                    tablar.setVisibility(View.GONE);
                    webSagOk.setImageDrawable(getResources().getDrawable(R.drawable.asagiok));
                }
                break;



            case R.id.layout_web_101:
                if(web101.getVisibility()==View.VISIBLE){
                    web101.setVisibility(View.GONE);
                    web101AsagiOk.setImageResource(R.drawable.asagiikon);
                }else {
                    web101.setVisibility(View.VISIBLE);
                    web101AsagiOk.setImageResource(R.drawable.yukariikon);
                }
                break;

            case R.id.layout_web_201:
                if(web201.getVisibility()==View.VISIBLE){
                    web201.setVisibility(View.GONE);
                    web201AsagiOk.setImageResource(R.drawable.asagiikon);
                }else {
                    web201.setVisibility(View.VISIBLE);
                    web201AsagiOk.setImageResource(R.drawable.yukariikon);
                }
                break;

            case R.id.layout_web_301:
                if(web301.getVisibility()==View.VISIBLE){
                    web301.setVisibility(View.GONE);
                    web301AsagiOk.setImageResource(R.drawable.asagiikon);
                }else {
                    web301.setVisibility(View.VISIBLE);
                    web301AsagiOk.setImageResource(R.drawable.yukariikon);
                }
                break;

            case R.id.layout_web_302:
                if(web302.getVisibility()==View.VISIBLE){
                    web302.setVisibility(View.GONE);
                    web302AsagiOk.setImageResource(R.drawable.asagiikon);
                }else {
                    web302.setVisibility(View.VISIBLE);
                    web302AsagiOk.setImageResource(R.drawable.yukariikon);
                }
                break;


            case R.id.layout_web_401:
                if(web401.getVisibility()==View.VISIBLE){
                    web401.setVisibility(View.GONE);
                    web401AsagiOk.setImageResource(R.drawable.asagiikon);
                }else {
                    web401.setVisibility(View.VISIBLE);
                    web401AsagiOk.setImageResource(R.drawable.yukariikon);
                }
                break;

            case R.id.egitimal_web_101:
                i=new Intent(getActivity(), EgitimBaslikActivity.class);
                i.putExtra("title","Web Programlama 101");
                i.putExtra("color","web");
                i.putExtra("nodeID",getResources().getString(R.string.web101));
                startActivity(i);
                break;
            case R.id.egitimal_web_201:
                i=new Intent(getActivity(), EgitimBaslikActivity.class);
                i.putExtra("title","Web Programlama 201");
                i.putExtra("color","web");
                i.putExtra("nodeID",getResources().getString(R.string.web201));
                startActivity(i);
                break;
            case R.id.egitimal_web_301:
                i=new Intent(getActivity(), EgitimBaslikActivity.class);
                i.putExtra("title","Web Programlama 301");
                i.putExtra("color","web");
                i.putExtra("nodeID",getResources().getString(R.string.web301));
                startActivity(i);
                break;

            case R.id.egitimal_web_302:
                i=new Intent(getActivity(), EgitimBaslikActivity.class);
                i.putExtra("title","Web Programlama 302");
                i.putExtra("color","web");
                i.putExtra("nodeID",getResources().getString(R.string.web302));
                startActivity(i);
                break;

            case R.id.egitimal_web_401:
                i=new Intent(getActivity(), EgitimBaslikActivity.class);
                i.putExtra("title","Web Programlama 401");
                i.putExtra("color","web");
                i.putExtra("nodeID",getResources().getString(R.string.web401));
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