package com.lightning.demo.ui.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lightning.demo.R;
import com.lightning.demo.util.LaunchTimer;

import java.util.List;

public class GirlAdapter extends RecyclerView.Adapter<GirlAdapter.ViewHolder> {

    private List<GirlModel> mItems;
    private boolean mHasRecorded;
    private OnFeedShowCallBack mCallBack;

    public GirlAdapter(List<GirlModel> items) {
        this.mItems = items;
    }

    @Override
    public int getItemCount() {
        return mItems == null ? 0 : mItems.size();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item_constrainlayout, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        if (position == 0 && !mHasRecorded) {
            mHasRecorded = true;
            holder.layout.getViewTreeObserver()
                    .addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                        @Override
                        public boolean onPreDraw() {
                            holder.layout.getViewTreeObserver().removeOnPreDrawListener(this);
                            LaunchTimer.endRecord("第一个条目展示 ");
                            if (mCallBack != null) {
                                mCallBack.onFeedShow();
                            }
                            return true;
                        }
                    });
        }

        GirlModel newsItem = mItems.get(position);
        holder.imageView.setImageResource(newsItem.icon);

        holder.tvLike.setText("喜欢程度:" + newsItem.like);
        holder.tvStyle.setText(newsItem.style);


        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCallBack != null) {
                    mCallBack.onItemClick(position);
                }
            }
        });
    }


    public void setItems(List<GirlModel> items) {
        this.mItems = items;
        notifyDataSetChanged();
    }


    public interface OnFeedShowCallBack {
        void onFeedShow();
        void onItemClick(int position);
    }

    public void setOnFeedShowCallBack(OnFeedShowCallBack callBack) {
        this.mCallBack = callBack;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvStyle;
        TextView tvLike;
        ImageView imageView;
        RelativeLayout layout;

        public ViewHolder(View view) {
            super(view);
            tvStyle = view.findViewById(R.id.tv_style);
            tvLike = view.findViewById(R.id.tv_like);
            imageView = view.findViewById(R.id.iv_icon);
            layout = view.findViewById(R.id.ll_out);

        }
    }

}
