package com.example.apple.myapplication.data.bean;

public class ShoopHomeBean {
    private ShoopData data;

    public ShoopData getData() {
        return data;
    }

    public void setData(ShoopData data) {
        this.data = data;
    }

    public ShoopHomeBean(ShoopData data) {
        this.data = data;
    }
    public ShoopHomeBean(){
        super();
    }
}
