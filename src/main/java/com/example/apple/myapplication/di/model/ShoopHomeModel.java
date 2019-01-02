package com.example.apple.myapplication.di.model;

import com.example.apple.myapplication.data.constant.Constant;
import com.example.apple.myapplication.data.utile.OKHttpUtile;
import com.example.apple.myapplication.di.contract.IShoopHomeContract;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Response;

public class ShoopHomeModel implements IShoopHomeContract.IShoopHomeModel {
    @Override
    public void constainShoopHomeData(CallBack callBack) {
        requestDataEnqueue(callBack);
    }

    private void requestDataEnqueue(final CallBack callBack) {
        //创建一个空的消息体
        FormBody body = new FormBody.Builder().build();
        OKHttpUtile.getinstance().post(body,Constant.SHOOP_HOME,new Callback(){

            @Override
            public void onFailure(Call call, IOException e) {
                callBack.responseData(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                callBack.responseData(response.body().string());
            }
        });
    }
}
