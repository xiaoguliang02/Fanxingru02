package com.example.apple.myapplication.data.utile;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class OKHttpUtile {
    public volatile static OKHttpUtile okHttpUtile;
    private final OkHttpClient client;

    private OKHttpUtile(){
        client = new OkHttpClient.Builder().build();
    }
    public static OKHttpUtile getinstance(){
        if (okHttpUtile == null) {
            synchronized (OKHttpUtile.class) {
                if (okHttpUtile == null) {
                    okHttpUtile=new OKHttpUtile();
                }
            }
        }
        return okHttpUtile;
    }
    public void post(FormBody body, String shoopHome, Callback callback){
        Request request = new Request.Builder()
                .method("POST",body)
                .url(shoopHome)
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }
}
