package com.turkcell.gelecegiyazanlar.Model;

/**
 * Created by macbook on 9/9/15.
 */
public class Yorum {
    private String adsoyad;
    private String yorum;
    private String foto;
    private String tarih;
    private String id;

    public Yorum(String adsoyad,String yorum,String foto,String tarih,String id){

        super();
        this.adsoyad = adsoyad;
        this.yorum = yorum;
        this.foto=foto;
        this.tarih=tarih;
        this.id=id;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    @Override
    public String toString() { return adsoyad; }

    public String getAdsoyad(){ return adsoyad; }

    public void setAdsoyad(String adsoyad){
        this.adsoyad=adsoyad;
    }

    public String getYorum(){
        return yorum;
    }

    public void setYorum(String yorum){
        this.yorum=yorum;
    }

    public String getFoto(){
        return foto;
    }

    public void setFoto(String foto){
        this.foto=foto;
    }

    public String getTarih(){
        return tarih;
    }

    public void setTarih(String tarih){
        this.tarih=tarih;
    }


}
