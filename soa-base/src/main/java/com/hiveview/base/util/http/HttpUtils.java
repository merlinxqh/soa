package com.hiveview.base.util.http;

import java.util.Map;

/**
 * Created by leo on 2017/10/23.
 * http操作工具类 封装
 *  目前使用okHttp
 */
public class HttpUtils {

    /**
     * @param url
     * @param param
     * @return
     */
    public static String doPost(String url,Map<String,String> param){
        return OkHttp3Utils.getInstance().doPost(url,param);
    }

    public static String doPost(String url){
        return doPost(url,null);
    }

    public static String doGet(String url,Map<String,String> param){
        return OkHttp3Utils.getInstance().doGet(url,param);
    }

    public static String doGet(String url){
        return doGet(url,null);
    }
}
