package com.turkcell.gelecegiyazanlar.Model;

/**
 * Created by dyildirim76 on 10.09.2015.
 */
public class Etkinlik {


    private String nodeID;
    private String title;
    private String startDate;
    private String endDate;
    private String sonBasvuruTarihi;
    private String kalanGun;
    private String image;

    public Etkinlik() {

    }


    public Etkinlik(String nodeID, String title, String startDate, String endDate, String thumbnail, String day) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.image = thumbnail;
        this.nodeID = nodeID;
        this.kalanGun = day;

    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public String getNodeID() {

        return nodeID;
    }

    public void setNodeID(String nodeID) {
        this.nodeID = nodeID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getSonBasvuruTarihi() {
        return sonBasvuruTarihi;
    }

    public void setSonBasvuruTarihi(String sonBasvuruTarihi) {
        this.sonBasvuruTarihi = sonBasvuruTarihi;
    }


    public String getKalanGun() {
        return kalanGun;
    }

    public void setKalanGun(String kalanGun) {
        this.kalanGun = kalanGun;
    }


}
