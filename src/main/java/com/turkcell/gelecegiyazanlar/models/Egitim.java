package com.turkcell.gelecegiyazanlar.models;


public class Egitim {


    public static final String NODE_ID = "nodeID";
    public static final String TITLE_TAG = "title";
    public static final String COLOR_TAG = "color";
    public static final String NODE_ID_EGITIM = "nodeIDEgitim";
    public static final String NODE_TITLE = "nodeTitle";


    private String yazar;
    private String yazarAvatar;
    private String icerik;


    public Egitim() {

    }

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
}
