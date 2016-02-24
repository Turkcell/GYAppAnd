package com.turkcell.gelecegiyazanlar.Utility;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by asus on 16.9.2015.
 */
public class TarihCevir {
    long tarih;
    String tarihformat;
    public TarihCevir(){

    }

    public String Cevir(String timestamp){


         tarih= Long.parseLong(timestamp) * 1000;

        java.text.DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date netDate = (new Date(tarih));


        tarihformat= sdf.format(netDate);

        return tarihformat;
    }

}
