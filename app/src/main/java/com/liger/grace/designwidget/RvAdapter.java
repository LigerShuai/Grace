package com.liger.grace.designwidget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.liger.grace.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Liger on 2017/4/28 20:54.
 */

public class RvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private String[] mData;

    public RvAdapter(Context context, String[] data) {
        this.mContext = context;
        this.mData = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.rv_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder) {
            MyViewHolder viewHolder = (MyViewHolder) holder;
            viewHolder.mTextView.setText(mData[position]);
        }
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.rv_item_tv)
        TextView mTextView;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}