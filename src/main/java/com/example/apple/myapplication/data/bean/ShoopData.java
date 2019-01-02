package com.example.apple.myapplication.data.bean;

import java.util.List;

public class ShoopData {
    private List<HomeData> fenlei;

    public ShoopData(List<HomeData> fenlei) {
        this.fenlei = fenlei;
    }
    public ShoopData(){
        super();
    }

    public List<HomeData> getFenlei() {
        return fenlei;
    }

    public void setFenlei(List<HomeData> fenlei) {
        this.fenlei = fenlei;
    }
}
