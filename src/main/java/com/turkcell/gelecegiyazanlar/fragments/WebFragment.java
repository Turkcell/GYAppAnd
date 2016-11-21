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
import android.widget.LinearLayout;

import com.turkcell.gelecegiyazanlar.R;
import com.turkcell.gelecegiyazanlar.activities.EgitimBaslikActivity;
import com.turkcell.gelecegiyazanlar.databinding.FragmentWebBinding;
import com.turkcell.gelecegiyazanlar.designs.SlidingTabLayoutIcon;
import com.turkcell.gelecegiyazanlar.models.Egitim;

/**
 * Web Sayfasýnýn Fragmentý
 */

public class WebFragment extends Fragment implements View.OnClickListener {

    private FragmentWebBinding fragmentWebBinding;

    private LinearLayout ustEkranLinearLayout;
    private Toolbar toolbar;
    private SlidingTabLayoutIcon slidingTabLayoutIcon;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbarMainActivity);

        fragmentWebBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_web, container, false);
        View rootView = fragmentWebBinding.getRoot();

        ustEkranLinearLayout = (LinearLayout) getActivity().findViewById(R.id.linearLayoutUstEkranEgitimFragment);
        slidingTabLayoutIcon = (SlidingTabLayoutIcon) getActivity().findViewById(R.id.slidingTabLayoutIconEgitimFragment);


        fragmentWebBinding.linearLayotWebWebFragment.setOnClickListener(this);
        fragmentWebBinding.linearLayoutWeb101WebFragment.setOnClickListener(this);
        fragmentWebBinding.linearLayoutWeb201WebFragment.setOnClickListener(this);
        fragmentWebBinding.linearLayoutWeb301WebFragment.setOnClickListener(this);
        fragmentWebBinding.linearLayoutWeb302WebFragment.setOnClickListener(this);
        fragmentWebBinding.linearLayoutWeb401WebFragment.setOnClickListener(this);
        fragmentWebBinding.linearLayoutWeb402WebFragment.setOnClickListener(this);

        fragmentWebBinding.linearLayoutEgitimAlWeb101WebFragment.setOnClickListener(this);
        fragmentWebBinding.linearLayoutEgitimAlWeb201WebFragment.setOnClickListener(this);
        fragmentWebBinding.linearLayoutEgitimAlWeb301WebFragment.setOnClickListener(this);
        fragmentWebBinding.linearLayoutEgitimAlWeb302WebFragment.setOnClickListener(this);
        fragmentWebBinding.linearLayoutEgitimAlWeb401WebFragment.setOnClickListener(this);
        fragmentWebBinding.linearLayoutEgitimAlWeb402WebFragment.setOnClickListener(this);

        return rootView;
    }


    @Override
    public void onClick(View v) {
        Intent i = null;
        switch (v.getId()) {

            case R.id.linearLayotWebWebFragment:
                if (fragmentWebBinding.linearLayoutWebIcerikWebFragment.getVisibility() == View.VISIBLE) {
                    fragmentWebBinding.linearLayoutWebIcerikWebFragment.setVisibility(View.GONE);
                    goster();
                    slidingTabLayoutIcon.setVisibility(View.VISIBLE);
                    fragmentWebBinding.imageViewWebSagokWebFragment.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.sagok, null));
                } else {
                    fragmentWebBinding.linearLayoutWebIcerikWebFragment.setVisibility(View.VISIBLE);
                    sakla();
                    slidingTabLayoutIcon.setVisibility(View.GONE);
                    fragmentWebBinding.imageViewWebSagokWebFragment.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.asagiok, null));
                }
                break;


            case R.id.linearLayoutWeb101WebFragment:
                if (fragmentWebBinding.linearLayoutEgitimAlWeb101WebFragment.getVisibility() == View.VISIBLE) {
                    fragmentWebBinding.linearLayoutEgitimAlWeb101WebFragment.setVisibility(View.GONE);
                    fragmentWebBinding.imageViewAsagiImage101WebFragment.setImageResource(R.drawable.asagiikon);
                } else {
                    fragmentWebBinding.linearLayoutEgitimAlWeb101WebFragment.setVisibility(View.VISIBLE);
                    fragmentWebBinding.imageViewAsagiImage101WebFragment.setImageResource(R.drawable.yukariikon);
                }
                break;

            case R.id.linearLayoutWeb201WebFragment:
                if (fragmentWebBinding.linearLayoutEgitimAlWeb201WebFragment.getVisibility() == View.VISIBLE) {
                    fragmentWebBinding.linearLayoutEgitimAlWeb201WebFragment.setVisibility(View.GONE);
                    fragmentWebBinding.imageViewAsagiImage201WebFragment.setImageResource(R.drawable.asagiikon);
                } else {
                    fragmentWebBinding.linearLayoutEgitimAlWeb201WebFragment.setVisibility(View.VISIBLE);
                    fragmentWebBinding.imageViewAsagiImage201WebFragment.setImageResource(R.drawable.yukariikon);
                }
                break;

            case R.id.linearLayoutWeb301WebFragment:
                if (fragmentWebBinding.linearLayoutEgitimAlWeb301WebFragment.getVisibility() == View.VISIBLE) {
                    fragmentWebBinding.linearLayoutEgitimAlWeb301WebFragment.setVisibility(View.GONE);
                    fragmentWebBinding.imageViewAsagiImage301WebFragment.setImageResource(R.drawable.asagiikon);
                } else {
                    fragmentWebBinding.linearLayoutEgitimAlWeb301WebFragment.setVisibility(View.VISIBLE);
                    fragmentWebBinding.imageViewAsagiImage301WebFragment.setImageResource(R.drawable.yukariikon);
                }
                break;

            case R.id.linearLayoutWeb302WebFragment:
                if (fragmentWebBinding.linearLayoutEgitimAlWeb302WebFragment.getVisibility() == View.VISIBLE) {
                    fragmentWebBinding.linearLayoutEgitimAlWeb302WebFragment.setVisibility(View.GONE);
                    fragmentWebBinding.imageViewAsagiImage302WebFragment.setImageResource(R.drawable.asagiikon);
                } else {
                    fragmentWebBinding.linearLayoutEgitimAlWeb302WebFragment.setVisibility(View.VISIBLE);
                    fragmentWebBinding.imageViewAsagiImage302WebFragment.setImageResource(R.drawable.yukariikon);
                }
                break;


            case R.id.linearLayoutWeb401WebFragment:
                if (fragmentWebBinding.linearLayoutEgitimAlWeb401WebFragment.getVisibility() == View.VISIBLE) {
                    fragmentWebBinding.linearLayoutEgitimAlWeb401WebFragment.setVisibility(View.GONE);
                    fragmentWebBinding.imageViewAsagiImage401WebFragment.setImageResource(R.drawable.asagiikon);
                } else {
                    fragmentWebBinding.linearLayoutEgitimAlWeb401WebFragment.setVisibility(View.VISIBLE);
                    fragmentWebBinding.imageViewAsagiImage401WebFragment.setImageResource(R.drawable.yukariikon);
                }
                break;

            case R.id.linearLayoutWeb402WebFragment:
                if (fragmentWebBinding.linearLayoutEgitimAlWeb402WebFragment.getVisibility() == View.VISIBLE) {
                    fragmentWebBinding.linearLayoutEgitimAlWeb402WebFragment.setVisibility(View.GONE);
                    fragmentWebBinding.imageViewAsagiImage402WebFragment.setImageResource(R.drawable.asagiikon);
                } else {
                    fragmentWebBinding.linearLayoutEgitimAlWeb402WebFragment.setVisibility(View.VISIBLE);
                    fragmentWebBinding.imageViewAsagiImage402WebFragment.setImageResource(R.drawable.yukariikon);
                }
                break;


            case R.id.linearLayoutEgitimAlWeb101WebFragment:
                i = new Intent(getActivity(), EgitimBaslikActivity.class);
                i.putExtra(Egitim.TITLE_TAG, "Web Programlama 101");
                i.putExtra(Egitim.COLOR_TAG, "web");
                i.putExtra(Egitim.NODE_ID, getResources().getString(R.string.web101));
                startActivity(i);
                break;
            case R.id.linearLayoutEgitimAlWeb201WebFragment:
                i = new Intent(getActivity(), EgitimBaslikActivity.class);
                i.putExtra(Egitim.TITLE_TAG, "Web Programlama 201");
                i.putExtra(Egitim.COLOR_TAG, "web");
                i.putExtra(Egitim.NODE_ID, getResources().getString(R.string.web201));
                startActivity(i);
                break;
            case R.id.linearLayoutEgitimAlWeb301WebFragment:
                i = new Intent(getActivity(), EgitimBaslikActivity.class);
                i.putExtra(Egitim.TITLE_TAG, "Web Programlama 301");
                i.putExtra(Egitim.COLOR_TAG, "web");
                i.putExtra(Egitim.NODE_ID, getResources().getString(R.string.web301));
                startActivity(i);
                break;

            case R.id.linearLayoutEgitimAlWeb302WebFragment:
                i = new Intent(getActivity(), EgitimBaslikActivity.class);
                i.putExtra(Egitim.TITLE_TAG, "Web Programlama 302");
                i.putExtra(Egitim.COLOR_TAG, "web");
                i.putExtra(Egitim.NODE_ID, getResources().getString(R.string.web302));
                startActivity(i);
                break;

            case R.id.linearLayoutEgitimAlWeb401WebFragment:
                i = new Intent(getActivity(), EgitimBaslikActivity.class);
                i.putExtra(Egitim.TITLE_TAG, "Web Programlama 401");
                i.putExtra(Egitim.COLOR_TAG, "web");
                i.putExtra(Egitim.NODE_ID, getResources().getString(R.string.web401));
                startActivity(i);
                break;

            case R.id.linearLayoutEgitimAlWeb402WebFragment:
                i = new Intent(getActivity(), EgitimBaslikActivity.class);
                i.putExtra(Egitim.TITLE_TAG, "Web Programlama 402");
                i.putExtra(Egitim.COLOR_TAG, "web");
                i.putExtra(Egitim.NODE_ID, getResources().getString(R.string.web402));
                startActivity(i);
                break;


        }
    }

    public void sakla() {
        ustEkranLinearLayout.animate().translationY(-ustEkranLinearLayout.getBottom() - toolbar.getBottom()).setInterpolator(new AccelerateInterpolator(2))
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        ustEkranLinearLayout.setVisibility(View.GONE);
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
        ustEkranLinearLayout.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2))
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        ustEkranLinearLayout.setVisibility(View.VISIBLE);
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