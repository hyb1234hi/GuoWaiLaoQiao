package com.yunbao.main.bean;

import java.util.List;

public class HomeVideoTItleBean {

    private List<ListBean> list;

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * des :
         * id : 3
         * name : 233
         * orderno : 0
         * thumb : http://qiniu.kulehu.com/20190522/5ce42daa3de56.jpg
         */

        private String des;
        private String id;
        private String name;
        private String orderno;
        private String thumb;

        public String getDes() {
            return des;
        }

        public void setDes(String des) {
            this.des = des;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOrderno() {
            return orderno;
        }

        public void setOrderno(String orderno) {
            this.orderno = orderno;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }
    }
}
