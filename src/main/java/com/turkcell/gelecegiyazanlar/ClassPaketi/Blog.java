package com.turkcell.gelecegiyazanlar.ClassPaketi;

import android.graphics.Bitmap;
import android.widget.ImageView;

/**
 * Created by user on 10.9.2015.
 */
public class Blog {


    public String getProfilID() {
        return profilID;
    }

    public void setProfilID(String profilID) {
        this.profilID = profilID;
    }

    String profilID;

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

    String blogID;

    public Blog(String title, String date, String author, String excerpt,String categories,String avatar,String image,String profilID,String blogID) {
        this.author = author;
        this.excerpt = excerpt;
        this.date = date;
        this.title = title;
        this.categories=categories;
        this.image=image;
        this.avatar=avatar;
        this.profilID=profilID;
        this.blogID=blogID;

    }

    String author;
    String excerpt;
    String date;
    String title;
    String categories;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }


 String avatar;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    String image;





}
