package com.turkcell.gelecegiyazanlar.utilities;

import android.app.Activity;
import android.app.ProgressDialog;

import com.turkcell.gelecegiyazanlar.R;

/**
 * Created by asus on 16.9.2015.
 */
public class YuklenmeEkran {
    Activity activity;
    ProgressDialog pDialog;

    public YuklenmeEkran(Activity mActivity) {
        this.activity = mActivity;
    }

    public void surecBasla() {
        pDialog = new ProgressDialog(activity);
        pDialog.setMessage(activity.getString(R.string.yukleniyor));
        pDialog.show();
    }

    public void surecDurdur() {

        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }

    }

}
