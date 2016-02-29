package com.turkcell.gelecegiyazanlar.models;


public class Kisi {


    public static final String PROFIL_ID = "profilID";

    private String kullaniciAdi;
    private String kullaniciAvatarUrl;
    private String adSoyad;
    private String kullaniciID;


    public Kisi() {

    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getKullaniciID() {
        return kullaniciID;
    }

    public void setKullaniciID(String kullaniciID) {
        this.kullaniciID = kullaniciID;
    }

    public String getKullaniciAvatarUrl() {
        return kullaniciAvatarUrl;
    }

    public void setKullaniciAvatarUrl(String kullaniciAvatarUrl) {
        this.kullaniciAvatarUrl = kullaniciAvatarUrl;
    }


}
