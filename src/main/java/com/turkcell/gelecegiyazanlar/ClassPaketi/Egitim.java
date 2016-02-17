package com.turkcell.gelecegiyazanlar.ClassPaketi;

/**
 * Created by asus on 9.9.2015.
 */
public class Egitim {
    public String getYazar() {
        return yazar;
    }

    public void setYazar(String yazar) {
        this.yazar = yazar;
    }

    public String getYazarAvatar() {
        return yazarAvatar;
    }

    public void setYazarAvatar(String yazarAvatar) {
        this.yazarAvatar = yazarAvatar;
    }

    public String getIcerik() {
        return icerik;
    }

    public void setIcerik(String icerik) {
        this.icerik = icerik;
    }

    private String yazar;
    private String yazarAvatar;
    private String icerik;


    public Egitim() {

    }
}
