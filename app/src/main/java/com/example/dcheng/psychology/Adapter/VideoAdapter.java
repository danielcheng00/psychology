package com.example.dcheng.psychology.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.dcheng.psychology.Activity.ChatActivity;
import com.example.dcheng.psychology.HomeItemViewHolder;
import com.example.dcheng.psychology.ImageViewHolder;
import com.example.dcheng.psychology.ItemType;
import com.example.dcheng.psychology.Message;
import com.example.dcheng.psychology.Model.VideoData;
import com.example.dcheng.psychology.PsychologyTestActivity;
import com.example.dcheng.psychology.R;
import com.example.dcheng.psychology.VideoPlayActivity;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Timer;

/**
 * Created by dcheng on 10/9/15.
 */
public class VideoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private LayoutInflater inflater;
    private Activity activity;

    // reference to conversation object in chatsdk
    private List<VideoData> videoDataList;

    private Context context;

    private Map<String, Timer> timers = new Hashtable<String, Timer>();

    public VideoAdapter(Context context,List<VideoData> videoDataList) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        activity = (Activity) context;
        this.videoDataList = videoDataList;
    }
    public VideoData getItem(int position) {
        return videoDataList.get(position);
    }
    public int getItemCount() {
        return videoDataList.size();
    }
    public void refresh() {
        notifyDataSetChanged();
    }

    public static class VideoViewHolder extends RecyclerView.ViewHolder{
        ImageView iv;
        TextView tv;
        public VideoViewHolder(View view)
        {
            super(view);
            CardView cardView = (CardView)view.findViewById(R.id.video_view);
            iv = (ImageView) cardView.findViewById(R.id.video_thumb);
            tv = (TextView) cardView.findViewById(R.id.video_title);
        }
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        VideoData videoData = getItem(position);
        VideoViewHolder videoViewHolder = (VideoViewHolder) holder;
        videoViewHolder.tv.setText(videoData.title);
        videoViewHolder.iv.setImageResource(R.drawable.home_main);
        videoViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, VideoPlayActivity.class);
                context.startActivity(intent);
            }
        });

    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.video_view, parent, false);
            return new VideoViewHolder(view);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
