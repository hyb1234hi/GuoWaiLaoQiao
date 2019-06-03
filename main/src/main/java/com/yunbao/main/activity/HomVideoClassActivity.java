package com.yunbao.main.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.yunbao.common.Constants;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.adapter.RefreshAdapter;
import com.yunbao.common.custom.CommonRefreshView;
import com.yunbao.common.custom.ItemDecoration;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.common.interfaces.OnItemClickListener;
import com.yunbao.live.bean.LiveBean;
import com.yunbao.live.utils.LiveStorge;
import com.yunbao.main.R;
import com.yunbao.main.adapter.MainHomeFollowAdapter;
import com.yunbao.main.adapter.MainHomeVideoAdapter;
import com.yunbao.main.http.MainHttpConsts;
import com.yunbao.main.http.MainHttpUtil;
import com.yunbao.main.presenter.CheckLivePresenter;
import com.yunbao.main.views.MainHomeVideoViewHolder;
import com.yunbao.video.activity.newvideo.PLVideoTextureActivity;
import com.yunbao.video.bean.VideoBean;
import com.yunbao.video.http.VideoHttpUtil;
import com.yunbao.video.utils.VideoStorge;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;

/**
 * Created by cxf on 2018/10/27.
 */

public class HomVideoClassActivity extends AbsActivity implements OnItemClickListener<VideoBean> {

    private int mClassId;
    private CommonRefreshView mRefreshView;
    private MainHomeVideoAdapter mAdapter;
    private CheckLivePresenter mCheckLivePresenter;

    public static void forward(Context context, int classId, String className) {
        Intent intent = new Intent(context, HomVideoClassActivity.class);
        intent.putExtra(Constants.CLASS_ID, classId);
        intent.putExtra(Constants.CLASS_NAME, className);
        context.startActivity(intent);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_live_class;
    }

    List<VideoBean> videoDatas;

    @Override
    protected void main() {
        Intent intent = getIntent();
        mClassId = intent.getIntExtra(Constants.CLASS_ID, -1);
        if (mClassId < 0) {
            return;
        }
        String liveClassName = intent.getStringExtra(Constants.CLASS_NAME);
        setTitle(liveClassName);
        mRefreshView = findViewById(R.id.refreshView);
        mRefreshView.setEmptyLayoutId(R.layout.view_no_data_live_class);
        mRefreshView.setLayoutManager(new GridLayoutManager(mContext, 2, GridLayoutManager.VERTICAL, false));


        ItemDecoration decoration = new ItemDecoration(mContext, 0x00000000, 5, 0);
        decoration.setOnlySetItemOffsetsButNoDraw(true);
        mRefreshView.setDataHelper(new CommonRefreshView.DataHelper<VideoBean>() {
            @Override
            public RefreshAdapter<VideoBean> getAdapter() {
                if (mAdapter == null) {
                    mAdapter = new MainHomeVideoAdapter(getApplicationContext());
                    mAdapter.setOnItemClickListener(HomVideoClassActivity.this);
                }
                return mAdapter;
            }

            @Override
            public void loadData(int p, HttpCallback callback) {


                VideoHttpUtil.VideoGetVideoList(p, mClassId + "", callback);
            }

            @Override
            public List<VideoBean> processData(String[] info) {
                try {
                    JSONObject jsonObject = new JSONObject(info[0]);
                    String list = jsonObject.getString("list");
                    videoDatas = JSON.parseArray(list, VideoBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return videoDatas;
            }

            @Override
            public void onRefreshSuccess(List<VideoBean> list, int listCount) {
                VideoStorge.getInstance().put(Constants.VIDEO_HOME, list);
            }

            @Override
            public void onRefreshFailure() {

            }

            @Override
            public void onLoadMoreSuccess(List<VideoBean> loadItemList, int loadItemCount) {

            }

            @Override
            public void onLoadMoreFailure() {

            }
        });
    }

    @Override
    public void onItemClick(VideoBean bean, int position) {

        Intent intent = new Intent();
        intent.putExtra("videoPath", bean.getHref());
        intent.putExtra("imagePath", bean.getThumb());
        intent.putExtra("title", bean.getTitle());
        intent.putExtra("videoid", bean.getId());
        intent.setClass(mContext, PLVideoTextureActivity.class);
        mContext.startActivity(intent);
    }


    /**
     * 观看直播
     */
    public void watchLive(LiveBean liveBean, int position) {
        if (mCheckLivePresenter == null) {
            mCheckLivePresenter = new CheckLivePresenter(mContext);
        }
        mCheckLivePresenter.watchLive(liveBean, Constants.LIVE_CLASS_PREFIX + mClassId, position);
    }

    @Override
    protected void onDestroy() {
        LiveStorge.getInstance().remove(Constants.LIVE_CLASS_PREFIX + mClassId);
        MainHttpUtil.cancel(MainHttpConsts.GET_CLASS_LIVE);
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mRefreshView.initData();
    }

}
