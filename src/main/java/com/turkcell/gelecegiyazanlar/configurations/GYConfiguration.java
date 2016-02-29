package com.turkcell.gelecegiyazanlar.configurations;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;

/**
 * Created by asus on 3.12.2015.
 */
enum Domain {
    TESTOZGUR, TESTTURKCELL, PRP, PROD
};


public class GYConfiguration {

    //Dinamik
    static Domain domain = Domain.PROD;
    public static String SPLUNK_ID="75ff8154";

    public static String getDomain() {

        String url = null;

        if (domain == Domain.PROD) {
            url = "https://gelecegiyazanlar.turkcell.com.tr/gypservis/";
        } else if (domain == Domain.TESTOZGUR) {
            url = "https://gelecegiyazanlar.turkcell.com.tr/gypservis/";
        } else if (domain == Domain.TESTTURKCELL) {
            url = "https://gelecegiyazanlar.turkcell.com.tr/gypservis/";
        } else if (domain == Domain.PRP) {
            url = "https://gelecegiyazanlar.turkcell.com.tr/gypservis/";
        }

        return url;
    }

    public static boolean isNetworkAvailable(Activity activity) {
        ConnectivityManager connectivityManager = (ConnectivityManager) activity.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager
                .getActiveNetworkInfo();
        return activeNetworkInfo != null;
    }

    public static void showDialog(Activity activity, String message) {

        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(activity);
        alertDialogBuilder.setMessage(message);

        alertDialogBuilder.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                arg0.dismiss();
            }
        });


        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public static boolean checkInternetConnectionShowDialog(Activity activity) {

        if (!isNetworkAvailable(activity)) {
            showDialog(activity, "Lütfen Internet Baðlantýnýzý Kontrol Ediniz.");
            return false;
        } else {
            return true;
        }


    }

}


