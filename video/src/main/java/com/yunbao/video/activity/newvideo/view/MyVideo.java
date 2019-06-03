package com.yunbao.video.activity.newvideo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;

import cn.jzvd.JZUtils;
import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

public class MyVideo extends JZVideoPlayerStandard {
    public onBackProgress onBackProgress;

    public void setOnBackProgress(MyVideo.onBackProgress onBackProgress) {
        this.onBackProgress = onBackProgress;
    }

    public MyVideo(Context context) {
        super(context);
    }

    public MyVideo(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setProgressAndText(int progress, long position, long duration) {
        if (!mTouchingProgressBar) {
            if (onBackProgress != null) {
                onBackProgress.onBackprogress(position);
            }
            if (progress != 0) progressBar.setProgress(progress);
        }
        if (position != 0) currentTimeTextView.setText(JZUtils.stringForTime(position));
        totalTimeTextView.setText(JZUtils.stringForTime(duration));
    }

    public interface onBackProgress {
        void onBackprogress(long progress);
    }
}
