package com.example.apple.myapplication.di.presenter;

import com.example.apple.myapplication.di.contract.IShoopHomeContract;
import com.example.apple.myapplication.di.model.ShoopHomeModel;

import java.lang.ref.SoftReference;

public class ShoopHomePresenter implements IShoopHomeContract.IShoopHomePresenter<IShoopHomeContract.IShoopHomeView> {
    IShoopHomeContract.IShoopHomeView homeView;
    private IShoopHomeContract.IShoopHomeModel homeModel;
    private SoftReference<IShoopHomeContract.IShoopHomeView> reference;

    @Override
    public void attachView(IShoopHomeContract.IShoopHomeView iShoopHomeView) {
        this.homeView=iShoopHomeView;
        homeModel = new ShoopHomeModel();
        //软引用包裹
        reference = new SoftReference<>(homeView);
    }

    @Override
    public void detachView(IShoopHomeContract.IShoopHomeView iShoopHomeView) {
        reference.clear();
    }

    @Override
    public void requestData() {
        homeModel.constainShoopHomeData(new IShoopHomeContract.IShoopHomeModel.CallBack() {
            @Override
            public void responseData(String message) {
                homeView.showData(message);
            }
        });
    }
}
