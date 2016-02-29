package com.turkcell.gelecegiyazanlar.Model;

/**
 * Created by Eren on 9.9.2015.
 */
public class Kisi {

    private String kullaniciAdi;
    private String kullaniciAvatarUrl;
    private String AdSoyad;
    private String kullaniciID;


    public Kisi() {

    }

    public String getAdSoyad() {
        return AdSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        AdSoyad = adSoyad;
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
