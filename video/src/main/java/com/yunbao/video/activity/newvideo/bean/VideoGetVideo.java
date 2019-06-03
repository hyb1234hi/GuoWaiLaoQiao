package com.yunbao.video.activity.newvideo.bean;

import java.util.List;

public class VideoGetVideo {

    /**
     * ret : 200
     * data : {"code":0,"msg":"","info":[{"id":"30","uid":"25663","title":"999","thumb":"http://qiniu.kulehu.com/20190522/5ce4331a5ec0a.jpg","thumb_s":"http://qiniu.kulehu.com/20190522/5ce4331a5ec0a.jpg","href":"http://qiniu.kulehu.com/20190522/5ce43349d2f8a.mp4","likes":"0","views":"1","comments":"0","steps":"0","shares":"0","addtime":"1558459209","lat":"","lng":"","city":"","isdel":"0","status":"1","music_id":"0","xiajia_reason":"","show_val":null,"nopass_time":"0","watch_ok":"1","is_ad":"0","ad_endtime":"0","ad_url":"","orderno":"0","free_time":"5","video_price":"5","videoclass_id":"1","is_buy":0,"video_vip_status":0,"video_share_status":0,"userinfo":{"id":"25663","user_nicename":"手机用户9320","avatar":"http://live.kulehu.com/default.jpg","avatar_thumb":"http://live.kulehu.com/default_thumb.jpg","sex":"2","signature":"这家伙很懒，什么都没留下","coin":"200030","consumption":"0","votestotal":"0","province":"","city":"成都市","birthday":"","user_status":"1","issuper":"0","level":"1","level_anchor":"1","vip":{"type":"0"},"liang":{"name":"0"}},"isattent":"0","datetime":"5天前","islike":"0","isstep":"0"}]}
     * msg :
     */

    private int ret;
    private DataBean data;
    private String msg;

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class DataBean {
        /**
         * code : 0
         * msg :
         * info : [{"id":"30","uid":"25663","title":"999","thumb":"http://qiniu.kulehu.com/20190522/5ce4331a5ec0a.jpg","thumb_s":"http://qiniu.kulehu.com/20190522/5ce4331a5ec0a.jpg","href":"http://qiniu.kulehu.com/20190522/5ce43349d2f8a.mp4","likes":"0","views":"1","comments":"0","steps":"0","shares":"0","addtime":"1558459209","lat":"","lng":"","city":"","isdel":"0","status":"1","music_id":"0","xiajia_reason":"","show_val":null,"nopass_time":"0","watch_ok":"1","is_ad":"0","ad_endtime":"0","ad_url":"","orderno":"0","free_time":"5","video_price":"5","videoclass_id":"1","is_buy":0,"video_vip_status":0,"video_share_status":0,"userinfo":{"id":"25663","user_nicename":"手机用户9320","avatar":"http://live.kulehu.com/default.jpg","avatar_thumb":"http://live.kulehu.com/default_thumb.jpg","sex":"2","signature":"这家伙很懒，什么都没留下","coin":"200030","consumption":"0","votestotal":"0","province":"","city":"成都市","birthday":"","user_status":"1","issuper":"0","level":"1","level_anchor":"1","vip":{"type":"0"},"liang":{"name":"0"}},"isattent":"0","datetime":"5天前","islike":"0","isstep":"0"}]
         */

        private int code;
        private String msg;
        private List<InfoBean> info;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public List<InfoBean> getInfo() {
            return info;
        }

        public void setInfo(List<InfoBean> info) {
            this.info = info;
        }

        public static class InfoBean {
            /**
             * id : 30
             * uid : 25663
             * title : 999
             * thumb : http://qiniu.kulehu.com/20190522/5ce4331a5ec0a.jpg
             * thumb_s : http://qiniu.kulehu.com/20190522/5ce4331a5ec0a.jpg
             * href : http://qiniu.kulehu.com/20190522/5ce43349d2f8a.mp4
             * likes : 0
             * views : 1
             * comments : 0
             * steps : 0
             * shares : 0
             * addtime : 1558459209
             * lat :
             * lng :
             * city :
             * isdel : 0
             * status : 1
             * music_id : 0
             * xiajia_reason :
             * show_val : null
             * nopass_time : 0
             * watch_ok : 1
             * is_ad : 0
             * ad_endtime : 0
             * ad_url :
             * orderno : 0
             * free_time : 5
             * video_price : 5
             * videoclass_id : 1
             * is_buy : 0
             * video_vip_status : 0
             * video_share_status : 0
             * userinfo : {"id":"25663","user_nicename":"手机用户9320","avatar":"http://live.kulehu.com/default.jpg","avatar_thumb":"http://live.kulehu.com/default_thumb.jpg","sex":"2","signature":"这家伙很懒，什么都没留下","coin":"200030","consumption":"0","votestotal":"0","province":"","city":"成都市","birthday":"","user_status":"1","issuper":"0","level":"1","level_anchor":"1","vip":{"type":"0"},"liang":{"name":"0"}}
             * isattent : 0
             * datetime : 5天前
             * islike : 0
             * isstep : 0
             */

            private String id;
            private String uid;
            private String title;
            private String thumb;
            private String thumb_s;
            private String href;
            private String likes;
            private String views;
            private String comments;
            private String steps;
            private String shares;
            private String addtime;
            private String lat;
            private String lng;
            private String city;
            private String isdel;
            private String status;
            private String music_id;
            private String xiajia_reason;
            private Object show_val;
            private String nopass_time;
            private String watch_ok;
            private String is_ad;
            private String ad_endtime;
            private String ad_url;
            private String orderno;
            private String free_time;
            private String video_price;
            private String videoclass_id;
            private int is_buy;
            private int video_vip_status;
            private int video_share_status;
            private UserinfoBean userinfo;
            private String isattent;
            private String datetime;
            private String islike;
            private String isstep;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getThumb() {
                return thumb;
            }

            public void setThumb(String thumb) {
                this.thumb = thumb;
            }

            public String getThumb_s() {
                return thumb_s;
            }

            public void setThumb_s(String thumb_s) {
                this.thumb_s = thumb_s;
            }

            public String getHref() {
                return href;
            }

            public void setHref(String href) {
                this.href = href;
            }

            public String getLikes() {
                return likes;
            }

            public void setLikes(String likes) {
                this.likes = likes;
            }

            public String getViews() {
                return views;
            }

            public void setViews(String views) {
                this.views = views;
            }

            public String getComments() {
                return comments;
            }

            public void setComments(String comments) {
                this.comments = comments;
            }

            public String getSteps() {
                return steps;
            }

            public void setSteps(String steps) {
                this.steps = steps;
            }

            public String getShares() {
                return shares;
            }

            public void setShares(String shares) {
                this.shares = shares;
            }

            public String getAddtime() {
                return addtime;
            }

            public void setAddtime(String addtime) {
                this.addtime = addtime;
            }

            public String getLat() {
                return lat;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public String getLng() {
                return lng;
            }

            public void setLng(String lng) {
                this.lng = lng;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getIsdel() {
                return isdel;
            }

            public void setIsdel(String isdel) {
                this.isdel = isdel;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getMusic_id() {
                return music_id;
            }

            public void setMusic_id(String music_id) {
                this.music_id = music_id;
            }

            public String getXiajia_reason() {
                return xiajia_reason;
            }

            public void setXiajia_reason(String xiajia_reason) {
                this.xiajia_reason = xiajia_reason;
            }

            public Object getShow_val() {
                return show_val;
            }

            public void setShow_val(Object show_val) {
                this.show_val = show_val;
            }

            public String getNopass_time() {
                return nopass_time;
            }

            public void setNopass_time(String nopass_time) {
                this.nopass_time = nopass_time;
            }

            public String getWatch_ok() {
                return watch_ok;
            }

            public void setWatch_ok(String watch_ok) {
                this.watch_ok = watch_ok;
            }

            public String getIs_ad() {
                return is_ad;
            }

            public void setIs_ad(String is_ad) {
                this.is_ad = is_ad;
            }

            public String getAd_endtime() {
                return ad_endtime;
            }

            public void setAd_endtime(String ad_endtime) {
                this.ad_endtime = ad_endtime;
            }

            public String getAd_url() {
                return ad_url;
            }

            public void setAd_url(String ad_url) {
                this.ad_url = ad_url;
            }

            public String getOrderno() {
                return orderno;
            }

            public void setOrderno(String orderno) {
                this.orderno = orderno;
            }

            public String getFree_time() {
                return free_time;
            }

            public void setFree_time(String free_time) {
                this.free_time = free_time;
            }

            public String getVideo_price() {
                return video_price;
            }

            public void setVideo_price(String video_price) {
                this.video_price = video_price;
            }

            public String getVideoclass_id() {
                return videoclass_id;
            }

            public void setVideoclass_id(String videoclass_id) {
                this.videoclass_id = videoclass_id;
            }

            public int getIs_buy() {
                return is_buy;
            }

            public void setIs_buy(int is_buy) {
                this.is_buy = is_buy;
            }

            public int getVideo_vip_status() {
                return video_vip_status;
            }

            public void setVideo_vip_status(int video_vip_status) {
                this.video_vip_status = video_vip_status;
            }

            public int getVideo_share_status() {
                return video_share_status;
            }

            public void setVideo_share_status(int video_share_status) {
                this.video_share_status = video_share_status;
            }

            public UserinfoBean getUserinfo() {
                return userinfo;
            }

            public void setUserinfo(UserinfoBean userinfo) {
                this.userinfo = userinfo;
            }

            public String getIsattent() {
                return isattent;
            }

            public void setIsattent(String isattent) {
                this.isattent = isattent;
            }

            public String getDatetime() {
                return datetime;
            }

            public void setDatetime(String datetime) {
                this.datetime = datetime;
            }

            public String getIslike() {
                return islike;
            }

            public void setIslike(String islike) {
                this.islike = islike;
            }

            public String getIsstep() {
                return isstep;
            }

            public void setIsstep(String isstep) {
                this.isstep = isstep;
            }

            public static class UserinfoBean {
                /**
                 * id : 25663
                 * user_nicename : 手机用户9320
                 * avatar : http://live.kulehu.com/default.jpg
                 * avatar_thumb : http://live.kulehu.com/default_thumb.jpg
                 * sex : 2
                 * signature : 这家伙很懒，什么都没留下
                 * coin : 200030
                 * consumption : 0
                 * votestotal : 0
                 * province :
                 * city : 成都市
                 * birthday :
                 * user_status : 1
                 * issuper : 0
                 * level : 1
                 * level_anchor : 1
                 * vip : {"type":"0"}
                 * liang : {"name":"0"}
                 */

                private String id;
                private String user_nicename;
                private String avatar;
                private String avatar_thumb;
                private String sex;
                private String signature;
                private String coin;
                private String consumption;
                private String votestotal;
                private String province;
                private String city;
                private String birthday;
                private String user_status;
                private String issuper;
                private String level;
                private String level_anchor;
                private VipBean vip;
                private LiangBean liang;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getUser_nicename() {
                    return user_nicename;
                }

                public void setUser_nicename(String user_nicename) {
                    this.user_nicename = user_nicename;
                }

                public String getAvatar() {
                    return avatar;
                }

                public void setAvatar(String avatar) {
                    this.avatar = avatar;
                }

                public String getAvatar_thumb() {
                    return avatar_thumb;
                }

                public void setAvatar_thumb(String avatar_thumb) {
                    this.avatar_thumb = avatar_thumb;
                }

                public String getSex() {
                    return sex;
                }

                public void setSex(String sex) {
                    this.sex = sex;
                }

                public String getSignature() {
                    return signature;
                }

                public void setSignature(String signature) {
                    this.signature = signature;
                }

                public String getCoin() {
                    return coin;
                }

                public void setCoin(String coin) {
                    this.coin = coin;
                }

                public String getConsumption() {
                    return consumption;
                }

                public void setConsumption(String consumption) {
                    this.consumption = consumption;
                }

                public String getVotestotal() {
                    return votestotal;
                }

                public void setVotestotal(String votestotal) {
                    this.votestotal = votestotal;
                }

                public String getProvince() {
                    return province;
                }

                public void setProvince(String province) {
                    this.province = province;
                }

                public String getCity() {
                    return city;
                }

                public void setCity(String city) {
                    this.city = city;
                }

                public String getBirthday() {
                    return birthday;
                }

                public void setBirthday(String birthday) {
                    this.birthday = birthday;
                }

                public String getUser_status() {
                    return user_status;
                }

                public void setUser_status(String user_status) {
                    this.user_status = user_status;
                }

                public String getIssuper() {
                    return issuper;
                }

                public void setIssuper(String issuper) {
                    this.issuper = issuper;
                }

                public String getLevel() {
                    return level;
                }

                public void setLevel(String level) {
                    this.level = level;
                }

                public String getLevel_anchor() {
                    return level_anchor;
                }

                public void setLevel_anchor(String level_anchor) {
                    this.level_anchor = level_anchor;
                }

                public VipBean getVip() {
                    return vip;
                }

                public void setVip(VipBean vip) {
                    this.vip = vip;
                }

                public LiangBean getLiang() {
                    return liang;
                }

                public void setLiang(LiangBean liang) {
                    this.liang = liang;
                }

                public static class VipBean {
                    /**
                     * type : 0
                     */

                    private String type;

                    public String getType() {
                        return type;
                    }

                    public void setType(String type) {
                        this.type = type;
                    }
                }

                public static class LiangBean {
                    /**
                     * name : 0
                     */

                    private String name;

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }
                }
            }
        }
    }
}
