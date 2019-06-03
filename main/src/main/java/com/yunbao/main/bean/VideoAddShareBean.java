package com.yunbao.main.bean;

public class VideoAddShareBean {

    /**
     * ret : 200
     * data : {"share_num":"6","share_upper_limit":"4","share_surplus":"0"}
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
         * share_num : 6
         * share_upper_limit : 4
         * share_surplus : 0
         */

        private String share_num;
        private String share_upper_limit;
        private String share_surplus;

        public String getShare_num() {
            return share_num;
        }

        public void setShare_num(String share_num) {
            this.share_num = share_num;
        }

        public String getShare_upper_limit() {
            return share_upper_limit;
        }

        public void setShare_upper_limit(String share_upper_limit) {
            this.share_upper_limit = share_upper_limit;
        }

        public String getShare_surplus() {
            return share_surplus;
        }

        public void setShare_surplus(String share_surplus) {
            this.share_surplus = share_surplus;
        }
    }
}
