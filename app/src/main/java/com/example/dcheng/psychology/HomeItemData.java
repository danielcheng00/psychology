package com.example.dcheng.psychology;

/**
 * Created by dcheng on 10/5/15.
 */

public class HomeItemData {
    String title;
    String info;
    int photoId;
    ItemType type;
    HomeItemData(ItemType type,String title, String info, int photoId) {
        this.type = type;
        this.title = title;
        this.info = info;
        this.photoId = photoId;
    }
}
