package com.turkcell.gelecegiyazanlar.models;


public class Icerik {
    private String nodeID, title, date, nodetype, excerpt;

    public Icerik() {
        this.nodeID = "";
        this.title = "";
        this.date = "";
        this.nodetype = "";
        this.excerpt = "";
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNodetype() {
        return nodetype;
    }

    public void setNodetype(String nodetype) {
        this.nodetype = nodetype;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String exerpt) {
        this.excerpt = exerpt;
    }
}