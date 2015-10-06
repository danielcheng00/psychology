package com.example.dcheng.psychology;

import android.content.Intent;
import android.provider.SyncStateContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter mAdapter;
    private List<HomeItemData> itemDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerList);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        initializeData();
        mAdapter = new HomeItemAdapter(this,itemDataList);
        recyclerView.setAdapter(mAdapter);
    }

    public void onPsychologyTestClick(View view) {
        Intent intent = new Intent(this, PsychologyTestActivity.class);
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initializeData() {
        itemDataList = new ArrayList<HomeItemData>();
        itemDataList.add(new HomeItemData(ItemType.IMAGE,"","",R.drawable.home_main));
        itemDataList.add(new HomeItemData(ItemType.CARD,"心理测试","开始测试吧",R.drawable.bird));
        itemDataList.add(new HomeItemData(ItemType.CARD,"心理测试","开始测试吧",R.drawable.bird));
        itemDataList.add(new HomeItemData(ItemType.CARD,"心理测试","开始测试吧",R.drawable.bird));
        itemDataList.add(new HomeItemData(ItemType.CARD,"心理测试","开始测试吧",R.drawable.bird));
    }
}
