package com.turkcell.gelecegiyazanlar.models;


public class Blog {

    public static final String BLOG_ID = "blogID";

    private String author;
    private String excerpt;
    private String date;
    private String title;
    private String categories;
    private String blogID;
    private String profilID;
    private String avatar;
    private String image;


    public Blog(String title, String date, String author, String excerpt, String categories, String avatar, String image, String profilID, String blogID) {
        this.author = author;
        this.excerpt = excerpt;
        this.date = date;
        this.title = title;
        this.categories = categories;
        this.image = image;
        this.avatar = avatar;
        this.profilID = profilID;
        this.blogID = blogID;

    }

    public String getProfilID() {
        return profilID;
    }

    public void setProfilID(String profilID) {
        this.profilID = profilID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getBlogID() {
        return blogID;
    }

    public void setBlogID(String blogID) {
        this.blogID = blogID;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


}
