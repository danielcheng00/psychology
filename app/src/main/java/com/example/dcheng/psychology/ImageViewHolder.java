package com.example.dcheng.psychology;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by dcheng on 10/5/15.
 */
public class ImageViewHolder extends RecyclerView.ViewHolder{
    public ImageView image;
    public ImageViewHolder(View v)
    {
        super(v);
        image = (ImageView)v.findViewById(R.id.image_id);
    }
}
