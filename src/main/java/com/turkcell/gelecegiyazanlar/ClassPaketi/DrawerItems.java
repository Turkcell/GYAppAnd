package com.turkcell.gelecegiyazanlar.ClassPaketi;

/**
 * Created by asus on 27.8.2015.
 */
public class DrawerItems {
    public DrawerItems(int icon, String text) {
        this.icon = icon;
        this.text = text;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    private int icon;
    private String text;


}
