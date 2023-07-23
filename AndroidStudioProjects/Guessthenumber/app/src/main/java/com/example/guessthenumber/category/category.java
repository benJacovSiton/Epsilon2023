package com.example.guessthenumber.category;

public class category {
    int icon;
    String title;


    public category(String title, int icon) {
        this.title = title;
        this.icon = icon;
    }

    public int getIcon() {
        return icon;
    }

    public String getTitle() {
        return title;
    }
}
