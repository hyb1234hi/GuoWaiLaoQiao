package com.yunbao.video.activity.newvideo.dialog;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.yunbao.video.R;

/**
 * 用户余额不足
 */
public class BalanceDing extends BaseDialog {
    public OnBackCenter onBackTime;
    public BalanceDing(Context context, OnBackCenter onBackTime1) {
        super(context);
        this.onBackTime = onBackTime1;
    }

    @Override
    protected int initLayoutId() {
        return R.layout.dilog_balance;
    }

    @Override
    protected void initWindow() {
        windowDeploy(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT, Gravity.CENTER);
    }

    @Override
    protected void initView() {
        setOnClickListener(R.id.center);
    }

    @Override
    protected void initData() {
    }

    @Override
    protected void onViewClick(View v) {
        dismiss();
        onBackTime.onBackCenter();

    }

    public interface OnBackCenter {
        void onBackCenter();
    }
}
