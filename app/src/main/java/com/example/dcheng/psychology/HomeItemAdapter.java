package com.example.dcheng.psychology;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dcheng on 10/5/15.
 */

public class HomeItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<HomeItemData> mItemList;
    private Context mContext;
    public HomeItemAdapter(Context context,List<HomeItemData> itemDataList) {
        mItemList = itemDataList;
        mContext = context;
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }
    @Override
    public int getItemViewType(int position) {
        if(mItemList.get(position).type == ItemType.IMAGE)
            return 0;
        return 1;
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(mItemList.get(position).type == ItemType.IMAGE)
        {
            ImageViewHolder imageViewHolder = (ImageViewHolder) holder;
            imageViewHolder.image.setImageResource(mItemList.get(position).photoId);
        }
        else {
            HomeItemViewHolder homeItemViewHolder = (HomeItemViewHolder)holder;
            homeItemViewHolder.title.setText(mItemList.get(position).title);
            homeItemViewHolder.info.setText(mItemList.get(position).info);
            homeItemViewHolder.image.setImageResource(mItemList.get(position).photoId);
            homeItemViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, PsychologyTestActivity.class);
                    mContext.startActivity(intent);
                }
            });
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.image, parent, false);
            return new ImageViewHolder(view);
        }
        else {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.activity_card_view, parent, false);
            return new HomeItemViewHolder(view);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
