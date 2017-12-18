package com.hiveview.base.util.http;

import com.hiveview.base.util.serializer.ObjectUtils;

import java.util.Map;

/**
 * Created by leo on 2017/10/23.
 * http操作工具类 封装
 */
public class WrapperHttpUtils {

    /**
     * @param url
     * @param param
     * @return
     */
    public static String doPost(String url,Map<String,String> param){
//        return OkHttp3Utils.getInstance().doPost(url,param);
          return HttpClientUtils.post(url,param);
    }


    public static String doPost(String url){
        return doPost(url,null);
    }

    public static String doGet(String url,Map<String,String> param){
//        return OkHttp3Utils.getInstance().doGet(url,param);
        return HttpClientUtils.get(url,param);
    }

    public static String doGet(String url){
        return doGet(url,null);
    }

    /**
     * POST返回具体类型
     * @param url
     * @param param
     * @param clz
     * @param <T>
     * @return
     */
    public static <T> T postReturnObj(String url,Map<String,String> param,Class<T> clz){
        String resp=doPost(url,param);
        return ObjectUtils.parseObject(resp,clz);
    }

    public static <T> T postReturnObj(String url,Class<T> clz){
        return postReturnObj(url,null,clz);
    }

    /**
     * GET返回具体类型
     * @param url
     * @param param
     * @param clz
     * @param <T>
     * @return
     */
    public static <T> T getReturnObj(String url,Map<String,String> param,Class<T> clz){
        String resp=doGet(url,param);
        return ObjectUtils.parseObject(resp,clz);
    }

    public static <T> T getReturnObj(String url,Class<T> clz){
        return getReturnObj(url,null,clz);
    }
}
