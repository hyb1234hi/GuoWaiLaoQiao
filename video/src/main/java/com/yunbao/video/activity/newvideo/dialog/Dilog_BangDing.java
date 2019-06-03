package com.yunbao.video.activity.newvideo.dialog;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.yunbao.video.R;

/**
 * 检测用户是否已输入报名信息
 */
public class Dilog_BangDing extends BaseDialog {
    public OnBackCenter onBackTime;
    private TextView title;
    private String price;
    private long time;

    public Dilog_BangDing(Context context, OnBackCenter onBackTime1, String price1, long time1) {
        super(context);
        this.onBackTime = onBackTime1;
        price = price1;
        time = time1;
    }

    @Override
    protected int initLayoutId() {
        return R.layout.dilog_bangding;
    }

    @Override
    protected void initWindow() {
        windowDeploy(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT, Gravity.CENTER);
    }

    @Override
    protected void initView() {
        setOnClickListener(R.id.cancel);
        setOnClickListener(R.id.center);
        setOnClickListener(R.id.bangding_vip);
        title = getView(R.id.tv_title);
    }
    @Override
    protected void initData() {
        title.setText("本视频免费观看" + time  + "秒，继续观看需要" + price + "钻石");
    }

    @Override
    protected void onViewClick(View v) {
        int i = v.getId();//确认
        if (i == R.id.cancel) {
            dismiss();
            onBackTime.onBackCancle();

        } else if (i == R.id.center) {
            dismiss();
            onBackTime.onBackCenter();

        } else if (i == R.id.bangding_vip) {
            dismiss();
            onBackTime.onVipVip();
        }
    }

    public interface OnBackCenter {
        void onBackCenter();

        void onBackCancle();

        void onVipVip();
    }
}
