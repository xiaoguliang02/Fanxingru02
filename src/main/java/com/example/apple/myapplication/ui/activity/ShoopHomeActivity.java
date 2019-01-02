package com.example.apple.myapplication.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.apple.myapplication.R;
import com.example.apple.myapplication.data.bean.HomeData;
import com.example.apple.myapplication.data.bean.ShoopHomeBean;
import com.example.apple.myapplication.di.contract.IShoopHomeContract;
import com.example.apple.myapplication.di.presenter.ShoopHomePresenter;
import com.example.apple.myapplication.ui.adapter.HomeAdapter;
import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShoopHomeActivity extends AppCompatActivity implements IShoopHomeContract.IShoopHomeView {

    @BindView(R.id.recycle_view)
    RecyclerView recycleView;
    private IShoopHomeContract.IShoopHomePresenter homePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        homePresenter = new ShoopHomePresenter();
        homePresenter.attachView(this);
        homePresenter.requestData();
    }

    @Override
    public void showData(final String message) {
        runOnUiThread(new Runnable() {

            private List<HomeData> data;

            @Override
            public void run() {
                //解析
                Gson gson = new Gson();
                ShoopHomeBean homeBean = gson.fromJson(message, ShoopHomeBean.class);
                data = homeBean.getData().getFenlei();
                Toast.makeText(ShoopHomeActivity.this, "data:" + data, Toast.LENGTH_SHORT).show();
                //创建适配器
                HomeAdapter adapter = new HomeAdapter();
                adapter.SetData(ShoopHomeActivity.this,data);
                recycleView.setAdapter(adapter);
                GridLayoutManager manager = new GridLayoutManager(ShoopHomeActivity.this, 3);
                recycleView.setLayoutManager(manager);
                //刷新适配器
                adapter.SetOnClickLister();
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        homePresenter.detachView(this);
    }
}
