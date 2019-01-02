package com.example.apple.myapplication.data.bean;

public class HomeData {
    private String icon;
    private String name;

    public HomeData(String icon, String name) {
        this.icon = icon;
        this.name = name;
    }
    public HomeData(){
        super();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
