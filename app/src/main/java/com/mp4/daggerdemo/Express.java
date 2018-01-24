package com.mp4.daggerdemo;

import java.util.List;

/**
 * Created by mopengfei on 2018-01-24.
 */

public class Express {

    /**
     * message : ok
     * nu : 888193610542153875
     * ischeck : 1
     * condition : F00
     * com : yuantong
     * status : 200
     * state : 3
     * data : [{"time":"2018-01-24 13:33:01","ftime":"2018-01-24 13:33:01","context":"广东省珠海市唐家金鼎公司 已签收","location":""},{"time":"2018-01-24 13:15:07","ftime":"2018-01-24 13:15:07","context":"广东省珠海市唐家金鼎公司 派件中","location":""},{"time":"2018-01-24 06:39:14","ftime":"2018-01-24 06:39:14","context":"广东省珠海市公司 已发出","location":""},{"time":"2018-01-24 05:03:55","ftime":"2018-01-24 05:03:55","context":"江门转运中心公司 已发出","location":""},{"time":"2018-01-24 04:24:39","ftime":"2018-01-24 04:24:39","context":"江门转运中心公司 已收入","location":""},{"time":"2018-01-22 21:47:34","ftime":"2018-01-22 21:47:34","context":"杭州转运中心公司 已发出","location":""},{"time":"2018-01-22 21:44:28","ftime":"2018-01-22 21:44:28","context":"杭州转运中心公司 已收入","location":""},{"time":"2018-01-22 19:37:00","ftime":"2018-01-22 19:37:00","context":"浙江省杭州市滨江区滨和公司 已发出","location":""},{"time":"2018-01-22 19:02:57","ftime":"2018-01-22 19:02:57","context":"浙江省杭州市滨江区滨和公司 已收件","location":""},{"time":"2018-01-22 19:02:57","ftime":"2018-01-22 19:02:57","context":"浙江省杭州市滨江区滨和公司 已打包","location":""},{"time":"2018-01-22 19:00:20","ftime":"2018-01-22 19:00:20","context":"浙江省杭州市滨江区滨和公司 已收件","location":""}]
     */

    private String message;
    private String nu;
    private String ischeck;
    private String condition;
    private String com;
    private String status;
    private String state;
    private List<DataBean> data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNu() {
        return nu;
    }

    public void setNu(String nu) {
        this.nu = nu;
    }

    public String getIscheck() {
        return ischeck;
    }

    public void setIscheck(String ischeck) {
        this.ischeck = ischeck;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getCom() {
        return com;
    }

    public void setCom(String com) {
        this.com = com;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * time : 2018-01-24 13:33:01
         * ftime : 2018-01-24 13:33:01
         * context : 广东省珠海市唐家金鼎公司 已签收
         * location :
         */

        private String time;
        private String ftime;
        private String context;
        private String location;

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getFtime() {
            return ftime;
        }

        public void setFtime(String ftime) {
            this.ftime = ftime;
        }

        public String getContext() {
            return context;
        }

        public void setContext(String context) {
            this.context = context;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }
    }
}
