package com.yunbao.main.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;

import com.yunbao.common.adapter.RefreshAdapter;
import com.yunbao.common.expand.RefreshView;
import com.yunbao.common.glide.ImgLoader;
import com.yunbao.common.utils.DpUtil;
import com.yunbao.live.bean.LiveBean;
import com.yunbao.live.bean.LiveVideoBean;
import com.yunbao.main.R;
import com.yunbao.main.utils.MainIconUtil;

import java.util.List;

/**
 * Created by cxf on 2018/9/26.
 * 首页 收费视频
 */

public class MainHomeLiveVideoAdapter extends RefreshAdapter<LiveVideoBean> implements RefreshView.DataAdapter<LiveVideoBean> {

    private static final int HEAD = 0;
    private static final int LEFT = 1;
    private static final int RIGHT = 2;
    private View.OnClickListener mOnClickListener;
    private View mHeadView;

    public MainHomeLiveVideoAdapter(Context context) {
        super(context);
        mHeadView = mInflater.inflate(R.layout.item_main_home_live_head, null, false);
        mHeadView.setLayoutParams(new ViewGroup.LayoutParams(0, DpUtil.dp2px(0)));
        mOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!canClick()) {
                    return;
                }
                Object tag = v.getTag();
                if (tag != null) {
                    int position = (int) tag;
                    if (mOnItemClickListener != null) {
                        mOnItemClickListener.onItemClick(mList.get(position), position);
                    }
                }
            }
        };
    }

    public View getHeadView() {
        return mHeadView;
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return RIGHT;
        }
        return LEFT;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == HEAD) {
            ViewParent viewParent = mHeadView.getParent();
            if (viewParent != null) {
                ((ViewGroup) viewParent).removeView(mHeadView);
            }
            HeadVh headVh = new HeadVh(mHeadView);
            headVh.setIsRecyclable(false);
            return headVh;
        }
        return new Vh(mInflater.inflate(R.layout.item_main_home_video, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder vh, int position) {
        if (vh instanceof Vh) {
            ((Vh) vh).setData(mList.get(position), position);
        }
    }

    @Override
    public int getItemCount() {
        return super.getItemCount();
    }


    @Override
    public void setData(List<LiveVideoBean> data) {
        mList = data;
        notifyDataSetChanged();
    }

    @Override
    public void appendData(List<LiveVideoBean> data) {
        mList.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public List<LiveVideoBean> getArray() {
        return mList;
    }

    @Override
    public RecyclerView.Adapter returnRecyclerAdapter() {
        return this;
    }

    @Override
    public void notifyReclyDataChange() {
        notifyDataSetChanged();
    }

    class HeadVh extends RecyclerView.ViewHolder {

        public HeadVh(View itemView) {
            super(itemView);
        }
    }

    class Vh extends RecyclerView.ViewHolder {

        ImageView mCover;
        ImageView mAvatar;
        TextView mName;
        TextView mTitle;
        TextView mNum;

        public Vh(View itemView) {
            super(itemView);
            mCover = (ImageView) itemView.findViewById(R.id.cover);
            mAvatar = (ImageView) itemView.findViewById(R.id.avatar);
            mName = (TextView) itemView.findViewById(R.id.name);
            mTitle = (TextView) itemView.findViewById(R.id.title);
            mNum = (TextView) itemView.findViewById(R.id.num);
            itemView.setOnClickListener(mOnClickListener);
        }

        void setData(LiveVideoBean bean, int position) {
            itemView.setTag(position);
            ImgLoader.display(bean.getThumb(), mCover);
            mTitle.setText(bean.getTitle());
            mNum.setText(bean.getNums());
            ImgLoader.display(bean.getUserinfo().getAvatar(), mAvatar);
            mName.setText(bean.getUserNiceName());
        }
    }


}
