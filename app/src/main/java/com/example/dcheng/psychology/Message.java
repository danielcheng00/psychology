package com.example.dcheng.psychology;

/**
 * Created by dcheng on 10/8/15.
 */
public class Message {
    public String text;
    public Direct direction;
    public Message()
    {
        direction = Direct.RECEIVE;
    }
    public static enum Direct {
        SEND,
        RECEIVE;

        private Direct() {
        }
    }
}
