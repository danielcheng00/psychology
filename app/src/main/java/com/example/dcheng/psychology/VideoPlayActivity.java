package com.example.dcheng.psychology;

import android.app.Activity;
import android.media.MediaPlayer;
import android.widget.MediaController;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

/**
 * Created by dcheng on 10/9/15.
 */
public class VideoPlayActivity extends Activity {
    VideoView mVideoView = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_play);

    // Get a reference to the VideoView

    mVideoView = (VideoView) findViewById(R.id.video_viewer);

    // Add a Media controller to allow forward/reverse/pause/resume

    final MediaController mMediaController = new MediaController(this, true);

    mMediaController.setEnabled(false);

    mVideoView.setMediaController(mMediaController);

    mVideoView
            .setVideoURI(Uri
            .parse("android.resource://com.example.dcheng.psychology/raw/moon"));

    // Add an OnPreparedListener to enable the MediaController once the video is ready
    mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

        @Override
        public void onPrepared(MediaPlayer mp) {
            mMediaController.setEnabled(true);
            mVideoView.start();
        }
    });
}

    // Clean up and release resources
    @Override
    protected void onPause() {

        if (mVideoView != null && mVideoView.isPlaying()) {
            mVideoView.stopPlayback();
            mVideoView = null;
        }
        super.onPause();
    }
}
