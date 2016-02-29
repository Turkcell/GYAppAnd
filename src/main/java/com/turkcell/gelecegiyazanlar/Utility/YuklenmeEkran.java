package com.turkcell.gelecegiyazanlar.utility;

import android.app.Activity;
import android.app.ProgressDialog;

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
        pDialog.setMessage("Yükleniyor...");
        pDialog.show();
    }

    public void surecDurdur() {

        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }

    }

}
