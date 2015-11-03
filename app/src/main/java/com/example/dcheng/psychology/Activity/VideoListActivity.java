package com.example.dcheng.psychology.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import com.example.dcheng.psychology.Adapter.VideoAdapter;
import com.example.dcheng.psychology.HomeItemAdapter;
import com.example.dcheng.psychology.Model.VideoData;
import com.example.dcheng.psychology.R;

import java.util.ArrayList;
import java.util.List;

public class VideoListActivity extends Activity {
    private RecyclerView.Adapter mAdapter;
    private RecyclerView videList;
    private List<VideoData> videoDataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_list);
        videList = (RecyclerView) findViewById(R.id.video_list);
        videList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        videList.setLayoutManager(llm);
        initializeData();
        mAdapter = new VideoAdapter(this,videoDataList);
        videList.setAdapter(mAdapter);
    }
    void initializeData()
    {
        videoDataList = new ArrayList<VideoData>();
        videoDataList.add(new VideoData(R.raw.moon, "Trip to moon"));
        videoDataList.add(new VideoData(R.raw.vid, "Play VID"));
    }
}
