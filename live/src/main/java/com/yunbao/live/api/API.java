package com.yunbao.live.api;

import android.util.Log;

import com.google.gson.internal.LinkedTreeMap;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.yunbao.common.CommonAppConfig;
import com.yunbao.common.server.RequestFactory;
import com.yunbao.common.utils.MapBuilder;
import com.yunbao.live.LiveContainer;
import com.yunbao.live.LiveVideoContainer;
import com.yunbao.live.bean.LiveBean;
import com.yunbao.live.bean.LiveVideoBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class API {

    public static Observable<List<LinkedTreeMap>> openGoodsWeb(String liveuid, String shoplink, String stream, String filelink) {
        Map<String, Object> parmMap = MapBuilder.factory().put("liveuid", liveuid)
                .put("token", CommonAppConfig.getInstance().getToken())
                .put("shoplink", shoplink).
                        put("stream", stream).
                        put("filelink", filelink).
                        build();
        return RequestFactory.getRequestManager().get(appendUrl("Shop.addShoplink"), parmMap, LinkedTreeMap.class);
    }

    public static Observable<Boolean> addShoplinkview(String stream, String shopid) {
        Map<String, Object> parmMap = MapBuilder.factory().put("uid", CommonAppConfig.getInstance().getUid())
                .put("token", CommonAppConfig.getInstance().getToken())
                .put("stream", stream).
                        put("shopid", shopid).
                        build();
        return RequestFactory.getRequestManager().noReturnPost(appendUrl("Shop.addShoplinkview"), false, parmMap);
    }


    public static Observable<List<LinkedTreeMap>> getToken() {
        return RequestFactory.getRequestManager().get(appendUrl("Video.getQiniuToken"), null, LinkedTreeMap.class);
    }


    public static Observable<Boolean> setShopstatus(String status, String stream) {
        Map<String, Object> parmMap = MapBuilder.factory()
                .put("uid", CommonAppConfig.getInstance().getUid())
                .put("token", CommonAppConfig.getInstance().getToken())
                .put("status", status).
                        put("stream", stream).
                        build();
        return RequestFactory.getRequestManager().noReturnPost(appendUrl("Shop.setShopstatus"), parmMap);
    }

    public static Observable<Boolean> setShopstatus() {
        Map<String, Object> parmMap = MapBuilder.factory()
                .put("uid", CommonAppConfig.getInstance().getUid())
                .put("token", CommonAppConfig.getInstance().getToken())
                .put("city", CommonAppConfig.getInstance().getCity()).
                        build();
        return RequestFactory.getRequestManager().noReturnPost(appendUrl("Shop.isOpenCoupon"), parmMap);
    }


    public static Observable<List<LiveBean>> getHot(int p) {
        Map<String, Object> parmMap = MapBuilder.factory()
                .put("uid", CommonAppConfig.getInstance().getUid())
                .put("token", CommonAppConfig.getInstance().getToken())
                .put("p", p).
                        build();
        return RequestFactory.getRequestManager().
                get(appendUrl("Home.getHot"), parmMap, LiveContainer.class)
                .map(new Function<List<LiveContainer>, List<LiveBean>>() {
                    @Override
                    public List<LiveBean> apply(List<LiveContainer> liveBeans) throws Exception {
                        return liveBeans.get(0).getList();
                    }
                });
    }


    public static Observable<List<LiveBean>> getNewlive(int p) {
        Map<String, Object> parmMap = MapBuilder.factory()
                .put("uid", CommonAppConfig.getInstance().getUid())
                .put("token", CommonAppConfig.getInstance().getToken())
                .put("p", p).
                        build();
        return RequestFactory.getRequestManager().get(appendUrl("Home.getNewlive"), parmMap, LiveContainer.class)
                .map(new Function<List<LiveContainer>, List<LiveBean>>() {
                    @Override
                    public List<LiveBean> apply(List<LiveContainer> liveBeans) throws Exception {
                        return liveBeans.get(0).getList();
                    }
                });
    }


    public static Observable<List<LiveBean>> getPopular(int p) {
        Map<String, Object> parmMap = MapBuilder.factory()
                .put("uid", CommonAppConfig.getInstance().getUid())
                .put("token", CommonAppConfig.getInstance().getToken())
                .put("p", p).
                        build();
        return RequestFactory.getRequestManager().get(appendUrl("Home.getPopular"), parmMap, LiveContainer.class)
                .map(new Function<List<LiveContainer>, List<LiveBean>>() {
                    @Override
                    public List<LiveBean> apply(List<LiveContainer> liveBeans) throws Exception {
                        Log.e("aa", "--------试试===" + liveBeans.get(0).getList().size());
                        return liveBeans.get(0).getList();
                    }
                });
    }


    public static Observable<List<LiveBean>> getCityHot(int p) {
        Map<String, Object> parmMap = MapBuilder.factory()
                .put("uid", CommonAppConfig.getInstance().getUid())
                .put("token", CommonAppConfig.getInstance().getToken())
                .put("p", p).
                        put("city", CommonAppConfig.getInstance().getCity()).
                        build();
        return RequestFactory.getRequestManager().get(appendUrl("Home.getCityHot"), parmMap, LiveContainer.class).map(new Function<List<LiveContainer>, List<LiveBean>>() {
            @Override
            public List<LiveBean> apply(List<LiveContainer> liveBeans) throws Exception {
                return liveBeans.get(0).getList();
            }
        });

    }


    public static Observable<List<LiveBean>> getCityNewlive(int p) {
        Map<String, Object> parmMap = MapBuilder.factory()
                .put("uid", CommonAppConfig.getInstance().getUid())
                .put("token", CommonAppConfig.getInstance().getToken())
                .put("p", p).
                        put("city", CommonAppConfig.getInstance().getCity()).
                        build();
        return RequestFactory.getRequestManager().get(appendUrl("Home.getCityNewlive"), parmMap, LiveContainer.class).map(new Function<List<LiveContainer>, List<LiveBean>>() {
            @Override
            public List<LiveBean> apply(List<LiveContainer> liveBeans) throws Exception {
                return liveBeans.get(0).getList();
            }
        });
    }


    public static Observable<List<LiveBean>> getCityPopular(int p) {
        Map<String, Object> parmMap = MapBuilder.factory()
                .put("uid", CommonAppConfig.getInstance().getUid())
                .put("token", CommonAppConfig.getInstance().getToken())
                .put("p", p).
                        put("city", CommonAppConfig.getInstance().getCity()).
                        build();
        return RequestFactory.getRequestManager().get(appendUrl("Home.getCityPopular"), parmMap, LiveContainer.class).map(new Function<List<LiveContainer>, List<LiveBean>>() {
            @Override
            public List<LiveBean> apply(List<LiveContainer> liveBeans) throws Exception {
                return liveBeans.get(0).getList();
            }
        });
    }


    public static Observable<List<LinkedTreeMap>> getIsCity() {
        Map<String, Object> parmMap = MapBuilder.factory()
                .put("city", CommonAppConfig.getInstance().getCity()).
                        build();
        return RequestFactory.getRequestManager().get(appendUrl("Home.getIsCity"), parmMap, LinkedTreeMap.class);
    }

   /* public static  Observable<List<LinkedTreeMap>> isOpenCoupon(){
        Map<String,Object> parmMap= MapBuilder.factory()
                .put("city",CommonAppConfig.getInstance().getCity()).
                         put("uid",CommonAppConfig.getInstance().getUid())
                .put("token", CommonAppConfig.getInstance().getToken()).
                        build();
        return RequestFactory.getRequestManager().get(appendUrl("Shop.isOpenCoupon"),parmMap,LinkedTreeMap.class);
    }*/


    public static Observable<List<LinkedTreeMap>> isOpenCoupon(String stream, int isOpen) {
        Map<String, Object> parmMap = MapBuilder.factory()
                .put("city", CommonAppConfig.getInstance().getCity()).
                        put("uid", CommonAppConfig.getInstance().getUid())
                .put("token", CommonAppConfig.getInstance().getToken()).
                        put("stream", stream).
                        put("isopen", isOpen).
                        build();
        return RequestFactory.getRequestManager().get(appendUrl("Shop.isOpenCoupon"), parmMap, LinkedTreeMap.class);
    }


    public static String appendUrl(String service) {
        return new StringBuilder(CommonAppConfig.HOST).append("/api/public/?service=")
                .append(service).toString();
    }

//    public static Observable<List<LiveVideoBean>> getVideoGetVideoList(int p) {
//        Map<String, Object> parmMap = MapBuilder.factory()
//                .put("uid", CommonAppConfig.getInstance().getUid())
//                .put("token", CommonAppConfig.getInstance().getToken())
//                .put("orderby", p).
//                        build();
//        return  RequestFactory.getRequestManager().
//                get(appendUrl("Video.GetVideoList"),parmMap, LiveVideoBean.class)
//                .map(new Function<List<LiveVideoBean>, List<LiveVideoBean>>() {
//                    @Override
//                    public List<LiveVideoBean> apply(List<LiveVideoBean> liveBeans) throws Exception {
//                        Log.e("aa","--------视频--人气-"+liveBeans.size());
//                        return liveBeans;
//                    }
//                });

    /**
     * 人气
     *
     * @param p
     * @return
     */
    public static Observable<List<LiveVideoBean>> getVideoGetVideoList(int p,String orderby) {
        Map<String, Object> parmMap = MapBuilder.factory()
                .put("uid", CommonAppConfig.getInstance().getUid())
                .put("token", CommonAppConfig.getInstance().getToken())
                .put("classify_id", "0")
                .put("p", p)
                .put("orderby", orderby)
                .build();
        return RequestFactory.getRequestManager().get(appendUrl("Video.GetVideoList"), parmMap, LiveVideoContainer.class)
                .map(new Function<List<LiveVideoContainer>, List<LiveVideoBean>>() {
                    @Override
                    public List<LiveVideoBean> apply(List<LiveVideoContainer> liveBeans) throws Exception {
                        return liveBeans.get(0).getList();
                    }
                });
    }
}
