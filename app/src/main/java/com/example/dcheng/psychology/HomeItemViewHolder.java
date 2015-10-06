package com.example.dcheng.psychology;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by dcheng on 10/5/15.
 */
public class HomeItemViewHolder extends RecyclerView.ViewHolder {
    public TextView title;
    public TextView info;
    public ImageView image;
    public HomeItemViewHolder(View v) {
        super(v);
        CardView cardView = (CardView)v.findViewById(R.id.home_item);
        image = (ImageView) cardView.findViewById(R.id.home_item_image);
        title = (TextView) cardView.findViewById(R.id.home_item_title);
        info = (TextView) cardView.findViewById(R.id.home_item_info);
    }
}
