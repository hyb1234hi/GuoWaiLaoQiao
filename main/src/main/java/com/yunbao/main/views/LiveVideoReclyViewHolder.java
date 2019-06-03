package com.yunbao.main.views;

import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup;

import com.yunbao.common.expand.ButterKnifeAbsViewHolder;
import com.yunbao.common.expand.RefreshView;
import com.yunbao.common.interfaces.OnItemClickListener;
import com.yunbao.live.bean.LiveBean;
import com.yunbao.live.bean.LiveVideoBean;
import com.yunbao.main.R;
import com.yunbao.main.R2;
import com.yunbao.main.adapter.MainHomeLiveAdapter;
import com.yunbao.main.adapter.MainHomeLiveVideoAdapter;
import com.yunbao.video.activity.newvideo.PLVideoTextureActivity;

import java.util.List;

import butterknife.BindView;
import io.reactivex.Observable;

public abstract class LiveVideoReclyViewHolder extends ButterKnifeAbsViewHolder implements OnItemClickListener<LiveVideoBean> {
    private MainHomeLiveVideoAdapter adapter;
    @BindView(R2.id.refreshView)
    RefreshView refreshView;

    public LiveVideoReclyViewHolder(Context context, ViewGroup parentView) {
        super(context, parentView);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.view_recly_view;
    }

    @Override
    public void initView() {
        super.initView();
        adapter = new MainHomeLiveVideoAdapter(mContext);
        adapter.setOnItemClickListener(this);
        refreshView.setAdapter(adapter);
        refreshView.defaultGridSetting(2);
        refreshView.setDataListner(new RefreshView.DataListner<LiveVideoBean>() {
            @Override
            public Observable<List<LiveVideoBean>> loadData(int p) {



                return requestData(p);
            }

            @Override
            public void compelete(List data) {


            }

            @Override
            public void error(Throwable e) {
            }
        });

    }

    @Override
    public void onItemClick(LiveVideoBean bean, int position) {
        Intent intent = new Intent();
        intent.putExtra("videoPath", bean.getHref());
        intent.putExtra("imagePath",bean.getThumb());
        intent.putExtra("title", bean.getTitle());
        intent.putExtra("videoid", bean.getId());
        intent.setClass(mContext, PLVideoTextureActivity.class);
        mContext.startActivity(intent);
    }

    @Override
    public void onFirstVisibiby() {
        super.onFirstVisibiby();
        refreshView.initData();
    }

    public abstract Observable<List<LiveVideoBean>> requestData(int p);

}
