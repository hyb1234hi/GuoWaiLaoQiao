package com.yunbao.video.activity.newvideo;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Debug;
import android.util.Log;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.yunbao.common.CommonAppConfig;
import com.yunbao.common.activity.WebViewActivity;
import com.yunbao.common.http.HttpClient;
import com.yunbao.common.utils.RouteUtil;
import com.yunbao.video.R;
import com.yunbao.video.activity.newvideo.bean.VideoGetVideo;
import com.yunbao.video.activity.newvideo.dialog.BalanceDing;
import com.yunbao.video.activity.newvideo.dialog.Dilog_BangDing;
import com.yunbao.video.activity.newvideo.view.MyVideo;

import java.lang.reflect.Constructor;

import cn.jzvd.JZMediaInterface;
import cn.jzvd.JZMediaManager;
import cn.jzvd.JZUserAction;
import cn.jzvd.JZUtils;
import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerManager;
import cn.jzvd.JZVideoPlayerStandard;

/**
 * This is a demo activity of PLVideoTextureView
 */
public class PLVideoTextureActivity extends VideoPlayerBaseActivity {
    String videoPath, imagePath, title;
    private MyVideo videoPlayerStandard;
    private Dilog_BangDing dilog_bangDing;
    private String videoid;
    private BalanceDing balanceDing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTranslucentStatus();
        setContentView(R.layout.activity_pl_video_texture);
        videoid = getIntent().getStringExtra("videoid");
        videoPlayerStandard = findViewById(R.id.videoplayer);
        balanceDing = new BalanceDing(PLVideoTextureActivity.this, new BalanceDing.OnBackCenter() {
            @Override
            public void onBackCenter() {//余额不足跳转
                RouteUtil.forwardMyCoin(PLVideoTextureActivity.this);
                finish();
            }
        });
        JZVideoPlayer.FULLSCREEN_ORIENTATION = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
        JZVideoPlayer.NORMAL_ORIENTATION = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
        findViewById(R.id.back_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        backTime();
    }

    /**
     * 倒计时
     * 当前时间长curr
     * 免费时长：time
     */
    private boolean timeStatus = false;

    public void timerStart(long curr, long time, String jingbi) {
        curr = curr / 1000;
        Log.e("aa", "---------当前进度时间 =====" + curr + "------------免费时长====" + time);
        if (curr > time - 1) {
            if (timeStatus) {
                return;
            }
            dilog_bangDing = new Dilog_BangDing(PLVideoTextureActivity.this, new Dilog_BangDing.OnBackCenter() {
                @Override
                public void onBackCenter() {
                    payPrice();
                }

                @Override
                public void onBackCancle() {
                    finish();
                }

                @Override
                public void onVipVip() {
                    finish();
                    WebViewActivity.forward(PLVideoTextureActivity.this, CommonAppConfig.HOST +"/index.php?g=Appapi&m=Mall&a=index");
                }
            }, jingbi, time);
            if (dilog_bangDing != null) {
                videoPlayerStandard.goOnPlayOnPause();
                dilog_bangDing.show();
                timeStatus = true;
            }
        }
    }

    public void backTime() {
        OkGo.<String>get(new HttpClient().mUrl + "Video.GetVideo")
                .params("videoid", videoid)
                .params("uid", CommonAppConfig.getInstance().getUid())
                .params("token", CommonAppConfig.getInstance().getToken())
                .tag(this)//
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        //注意这里已经是在主线程了
                        String data = response.body();//这个就是返回来的结果
                        Gson gson = new Gson();
                        final VideoGetVideo videoGetVideo = gson.fromJson(data, VideoGetVideo.class);
                        if (videoGetVideo.getRet() == 200) {
                            if (videoGetVideo.getData().getCode() == 0) {
                                videoPlayerStandard.setUp(videoGetVideo.getData().getInfo().get(0).getHref(), JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, videoGetVideo.getData().getInfo().get(0).getTitle());
                                Glide.with(getApplicationContext()).load(videoGetVideo.getData().getInfo().get(0).getThumb()).into(videoPlayerStandard.thumbImageView);
                                videoPlayerStandard.SAVE_PROGRESS = false;
                                videoPlayerStandard.startButton.performClick();
                                Log.e("aa", "------11免费时长==-----" + videoGetVideo.getData().getInfo().get(0).getFree_time());
                                videoPlayerStandard.setOnBackProgress(new MyVideo.onBackProgress() {
                                    @Override
                                    public void onBackprogress(long progress) {
                                        if (videoGetVideo.getData().getInfo().get(0).getVideo_price().equals("0") || videoGetVideo.getData().getInfo().get(0).getIs_buy() == 1
                                                || videoGetVideo.getData().getInfo().get(0).getVideo_vip_status() == 1) {
                                        } else {
                                            timerStart(progress, (Integer.valueOf(videoGetVideo.getData().getInfo().get(0).getFree_time())), videoGetVideo.getData().getInfo().get(0).getVideo_price());
                                        }
                                    }
                                });


                            } else {
                                Toast.makeText(PLVideoTextureActivity.this, videoGetVideo.getData().getMsg(), Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(PLVideoTextureActivity.this, videoGetVideo.getMsg(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        Toast.makeText(getApplicationContext(), response.message(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void payPrice() {
        OkGo.<String>get(new HttpClient().mUrl + "Video.SetVideoPay")
                .params("video_id", videoid)
                .params("uid", CommonAppConfig.getInstance().getUid())
                .params("token", CommonAppConfig.getInstance().getToken())
                .tag(this)//
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        //注意这里已经是在主线程了
                        String data = response.body();//这个就是返回来的结果
                        Gson gson = new Gson();
                        VideoGetVideo videoGetVideo = gson.fromJson(data, VideoGetVideo.class);
                        if (videoGetVideo.getRet() == 200) {
                            if (videoGetVideo.getData().getCode() == 0) {
                                Toast.makeText(PLVideoTextureActivity.this, "支付成功、继续观看！", Toast.LENGTH_SHORT).show();
                                videoPlayerStandard.goOnPlayOnResume();
                            } else if (videoGetVideo.getData().getCode() == 1005) {
                                Toast.makeText(PLVideoTextureActivity.this, videoGetVideo.getData().getMsg(), Toast.LENGTH_SHORT).show();
                            } else if (videoGetVideo.getData().getCode() == 1002) {
                                balanceDing.show();
                            } else {
                                Toast.makeText(PLVideoTextureActivity.this, videoGetVideo.getData().getMsg(), Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        } else {
                            finish();
                            Toast.makeText(getApplicationContext(), videoGetVideo.getMsg(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        Toast.makeText(getApplicationContext(), response.message(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void setTranslucentStatus() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//5.0 全透明实现
            Window window = getWindow();
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        } else {//4.4 全透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    @Override
    public void onBackPressed() {
        if (JZVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() { //选择适当的声明周期释放
        super.onPause();
        JZVideoPlayer.releaseAllVideos();
    }
}