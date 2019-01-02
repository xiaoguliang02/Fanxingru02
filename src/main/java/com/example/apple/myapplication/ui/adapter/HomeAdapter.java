package com.example.apple.myapplication.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.apple.myapplication.R;
import com.example.apple.myapplication.data.bean.HomeData;
import com.example.apple.myapplication.ui.activity.ShoopHomeActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.SubViewHolder> {
    ShoopHomeActivity shoopHomeActivity;
    List<HomeData> data;
    private OnItemClickLister onItemClickLister;

    @NonNull
    public void SetData(ShoopHomeActivity shoopHomeActivity, List<HomeData> data) {
        this.shoopHomeActivity = shoopHomeActivity;
        this.data = data;
    }

    @Override
    public SubViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(shoopHomeActivity, R.layout.home_layout, null);
        //设置布局
        SubViewHolder subViewHolder = new SubViewHolder(view);
        return subViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final SubViewHolder subViewHolder, int i) {
        subViewHolder.textView.setText(data.get(i).getName());
        Glide.with(shoopHomeActivity).load(data.get(i).getIcon()).into(subViewHolder.imageIcon);
//        if (onItemClickLister != null) {
//            subViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    int position=subViewHolder.getLayoutPosition();
//                    onItemClickLister.OnItemClick(subViewHolder)
//                }
//            });
//        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class SubViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.text_view)
        TextView textView;
        @BindView(R.id.image_icon)
        ImageView imageIcon;
        public SubViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
    public void SetOnClickLister(OnItemClickLister onItemClickLister){
        this.onItemClickLister=onItemClickLister;
    }
    public interface OnItemClickLister{
        void OnItemClick(View view,int position);
    }
}
