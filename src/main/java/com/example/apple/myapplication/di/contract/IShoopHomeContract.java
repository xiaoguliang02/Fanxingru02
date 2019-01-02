package com.example.apple.myapplication.di.contract;

public interface IShoopHomeContract {
    //V层
    public interface IShoopHomeView{
        //接受参数
        public void showData(String message);
    }
    //P层
    public interface IShoopHomePresenter<IShoopHomeView>{
        //绑定
        public void attachView(IShoopHomeView iShoopHomeView);
        //解绑
        public void detachView(IShoopHomeView iShoopHomeView);
        //获取参数
        public void requestData();
    }
    //M层
    public interface IShoopHomeModel{
        public void constainShoopHomeData(CallBack callBack);
        //接口回调
        public interface CallBack{
            public void responseData(String message);
        }
    }
}
