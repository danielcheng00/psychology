package com.example.dcheng.psychology.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.PowerManager;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.text.ClipboardManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.easemob.chat.EMChatManager;
import com.easemob.chat.EMConversation;
import com.easemob.chat.EMGroupManager;
import com.easemob.chat.EMMessage;
import com.easemob.chat.TextMessageBody;
import com.example.dcheng.psychology.Adapter.MessageAdapter;
import com.example.dcheng.psychology.Message;
import com.example.dcheng.psychology.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dcheng on 10/7/15.
 */
public class ChatActivity extends FragmentActivity implements View.OnClickListener{
    private ListView listView;
    private View buttonSend;
    private List<Message> conversation;
    private EditText mEditTextContent;
    private InputMethodManager manager;
    private MessageAdapter adapter;
    private String toChatUsername;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        initView();
        setUpView();

    }
    protected void initView() {
        listView = (ListView) findViewById(R.id.list);
        mEditTextContent = (EditText) findViewById(R.id.et_sendmessage);
        buttonSend = findViewById(R.id.btn_send);
        mEditTextContent.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            }
        });
        mEditTextContent.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                if (!TextUtils.isEmpty(s)) {
                    buttonSend.setVisibility(View.VISIBLE);
                } else {
                    buttonSend.setVisibility(View.GONE);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void setUpView() {
        toChatUsername = "test";
        manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        conversation = new ArrayList<Message>();
        // 把此会话的未读数置为0
        //conversation.resetUnreadMsgCount();
        adapter = new MessageAdapter(this, toChatUsername, conversation);
        // 显示消息
        listView.setAdapter(adapter);
        //listView.setOnScrollListener(new ListScrollListener());
        int count = listView.getCount();
        if (count > 0) {
            listView.setSelection(count);
        }

        listView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                hideKeyboard();
                return false;
            }
        });
    }
    @Override
    public void onClick(View view) {
//        hideKeyboard();
        int id = view.getId();
        switch (id) {
            case R.id.btn_send:
                // 点击发送按钮(发文字和表情)
                String s = mEditTextContent.getText().toString();
                sendText(s);
                break;
            default:
                break;
        }
    }

    /**
     * 发送文本消息
     *
     * @param content
     *            message content
     * @param isResend
     *            boolean resend
     */
    private void sendText(String content) {

        if (content.length() > 0) {
            Message message = new Message();
            message.text = content;
            // 把messgage加到conversation中
            conversation.add(message);
            // 通知adapter有消息变动，adapter会根据加入的这条message显示消息和调用sdk的发送方法
            adapter.refresh();
            listView.setSelection(listView.getCount() - 1);
            mEditTextContent.setText("");

            setResult(RESULT_OK);

        }
    }

    /**
     * 隐藏软键盘
     */
    private void hideKeyboard() {
        if (getWindow().getAttributes().softInputMode != WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN) {
            if (getCurrentFocus() != null)
                manager.hideSoftInputFromWindow(getCurrentFocus()
                        .getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
}
