package com.example.dcheng.psychology.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.easemob.chat.EMChatManager;
import com.easemob.chat.EMConversation;
import com.easemob.chat.EMMessage;
import com.easemob.chat.TextMessageBody;
import com.example.dcheng.psychology.Message;
import com.example.dcheng.psychology.R;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Timer;

/**
 * Created by dcheng on 10/7/15.
 */
public class MessageAdapter extends BaseAdapter {
    private String username;
    private LayoutInflater inflater;
    private Activity activity;

    // reference to conversation object in chatsdk
    private List<Message> conversation;

    private Context context;

    private Map<String, Timer> timers = new Hashtable<String, Timer>();

    public MessageAdapter(Context context, String username,List<Message> conversation) {
        this.username = username;
        this.context = context;
        inflater = LayoutInflater.from(context);
        activity = (Activity) context;
        this.conversation = conversation;
    }

    public int getCount() {
        return conversation.size();
    }

    /**
     * 刷新页面
     */
    public void refresh() {
        notifyDataSetChanged();
    }

    public Message getItem(int position) {
        return conversation.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public static class ViewHolder {
        ImageView iv;
        TextView tv;
        ProgressBar pb;
        ImageView staus_iv;
        ImageView head_iv;
        TextView tv_userId;
        ImageView playBtn;
        TextView timeLength;
        TextView size;
        LinearLayout container_status_btn;
        LinearLayout ll_container;
        ImageView iv_read_status;
        // 显示已读回执状态
        TextView tv_ack;
        // 显示送达回执状态
        TextView tv_delivered;

        TextView tv_file_name;
        TextView tv_file_size;
        TextView tv_file_download_state;
    }

    @SuppressLint("NewApi")
    public View getView(final int position, View convertView, ViewGroup parent) {
        final Message message = getItem(position);
        final ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = message.direction == Message.Direct.RECEIVE ? inflater
                    .inflate(R.layout.row_received_message, null) : inflater
                    .inflate(R.layout.row_sent_message, null);
            holder.pb = (ProgressBar) convertView
                    .findViewById(R.id.pb_sending);
            holder.staus_iv = (ImageView) convertView
                    .findViewById(R.id.msg_status);
            holder.head_iv = (ImageView) convertView
                    .findViewById(R.id.iv_userhead);
            // 这里是文字内容
            holder.tv = (TextView) convertView
                    .findViewById(R.id.tv_chatcontent);
            holder.tv_userId = (TextView) convertView
                    .findViewById(R.id.tv_userid);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        // 设置内容
        holder.tv.setText(message.text);
        return convertView;
    }
}

