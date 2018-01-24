package com.mp4.daggerdemo;

/**
 * Created by mopengfei on 2018-01-24.
 */

public class Constants {
    //    http://www.kuaidi100.com/query?type=快递公司代号&postid=快递单号
//    ps:快递公司编码:申通="shentong" EMS="ems" 顺丰="shunfeng" 圆通="yuantong" 中通="zhongtong" 韵达="yunda" 天天="tiantian"
// 汇通="huitongkuaidi" 全峰="quanfengkuaidi" 德邦="debangwuliu" 宅急送="zhaijisong"
    public static final String URL = "http://www.kuaidi100.com/";

    // 连接超时时间
    public static final int CONNECTTIMEOUT = 15;

    //网络请求log输出Tag
    public static final String NET_LOG_TAG = "NET_LOG_TAG";
    //bean类Log输出Tag
    public static final String BEAN_LOG_TAG = "BEAN_LOG_TAG";
    //线程问题
    public static final String THREAD_LOG_TAG = "THREAD_LOG_TAG";
}
