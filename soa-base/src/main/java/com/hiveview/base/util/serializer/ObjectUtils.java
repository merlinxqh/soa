package com.hiveview.base.util.serializer;

/**
 * Created by mike on 16-5-24.
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.hiveview.base.util.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 对象操作工具类, 继承org.apache.commons.lang3.ObjectUtils类
 * Li.XiaoChao
 * @version 2014-6-29
 */
public class ObjectUtils extends org.apache.commons.lang3.ObjectUtils {

    /**
     * 注解到对象复制，只复制能匹配上的方法。
     * @param annotation
     * @param object
     */
    public static void annotationToObject(final Object annotation, Object object){
        if (annotation != null){
            Class<?> annotationClass = annotation.getClass();
            Class<?> objectClass = object.getClass();
            for (Method m : objectClass.getMethods()){
                if (StringUtils.startsWith(m.getName(), "set")){
                    try {
                        String s = StringUtils.uncapitalize(StringUtils.substring(m.getName(), 3));
                        Object obj = annotationClass.getMethod(s).invoke(annotation);
                        if (obj != null && !"".equals(obj.toString())){
                            if (object == null){
                                object = objectClass.newInstance();
                            }
                            m.invoke(object, obj);
                        }
                    } catch (Exception e) {
                        // 忽略所有设置失败方法
                    }
                }
            }
        }
    }

    /**
     * 序列化对象
     * @param object
     * @return
     */
    public static byte[] serialize(final Object object) {
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        try {
            if (object != null){
                baos = new ByteArrayOutputStream();
                oos = new ObjectOutputStream(baos);
                oos.writeObject(object);
                return baos.toByteArray();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 反序列化对象
     * @param bytes
     * @return
     */
    public static Object unserialize(final byte[] bytes) {
        ByteArrayInputStream bais = null;
        try {
            if (bytes != null && bytes.length > 0){
                bais = new ByteArrayInputStream(bytes);
                ObjectInputStream ois = new ObjectInputStream(bais);
                return ois.readObject();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T parseObject(String json,Class<T> clz){
        if(StringUtils.isNotEmpty(json)){
            return JSON.parseObject(json,clz);
        }
        return null;
    }

    /**
     * Copy对象
     * 经测试 通过fastJson 序列化 比 该方法高效
     * @param resourceObj
     * @param targetObject
     * @param <R>
     * @param <T>
     * @return
     */
    @Deprecated
    public static <R,T> T copyObject(R resourceObj,T targetObject){
        BeanUtils.copyProperties(resourceObj,targetObject);
        return targetObject;
    }


    /**
     * 通过fastJson copy对象
     * @param resourceObj
     * @param clz
     * @param <R>
     * @param <T>
     * @return
     */
    public static <R,T> T copyObject(R resourceObj,Class<T> clz){
        return JSON.parseObject(JSON.toJSONString(resourceObj),clz);
    }

    /**
     * copy list
     * @param rList
     * @param clz
     * @param <R>
     * @param <T>
     * @return
     */
    public static <R,T> List<T> copyListObject(List<R> rList,Class<T> clz){
        return JSONArray.parseArray(JSON.toJSONString(rList),clz);
    }

    /**
     * 将对象转map 用于dto转查询参数
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> Map<String,Object> changeToMap(T obj){
        if(null != obj){
            Map<String,Object> params=copyObject(obj,Map.class);
            /**
             * 字符串去空格符
             */
            for(String key:params.keySet()){
                Object object=params.get(key);
                if(object instanceof String){
                    object=((String) object).trim();
                    params.put(key,object);
                }
            }
            return params;
        }
        return null;
    }

    /**
     * 根据key获取value 处理 key为 obj.objItem.key 这种情况
     * @param map
     * @param key
     * @return
     */
    public static String getMapValue(Map map,String key){
        if(map.containsKey(key)){
            return map.get(key).toString();
        }
        if(key.contains(".")){
            String subKey=key.substring(0,key.indexOf("."));
            if(null != map && map.containsKey(subKey)){
                Map subMap= changeToMap(map.get(subKey));
                key=key.substring(key.indexOf(".")+1);//去除 第一个key
                return getMapValue(subMap,key);
            }
        }else{
            if(null != map && map.containsKey(key)){
                return map.get(key).toString();
            }
        }
        return "";
    }

    /**
     * 对时间格式化 (时间戳格式)
     * @param map
     * @param key
     */
    public static void mapFormatDate(Map<String,Object> map,String key){
        String dateVal=getMapValue(map,key);
        if(org.springframework.util.StringUtils.hasText(dateVal)){
            Date date=new Date(Long.valueOf(dateVal));
            if(null != date){
                map.put(key, DateUtils.formatDate(date,DateUtils.DATE_PATTERN_COMPLEX));
            }
        }
    }
}
