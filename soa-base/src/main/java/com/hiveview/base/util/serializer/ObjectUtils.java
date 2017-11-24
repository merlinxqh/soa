package com.hiveview.base.util.serializer;

/**
 * Created by mike on 16-5-24.
 */

import com.alibaba.fastjson.JSON;
import com.hiveview.base.common.BaseEntity;
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
import java.util.stream.Collectors;

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

    /**
     * Copy对象
     * @param resourceObj
     * @param targetObject
     * @param <R>
     * @param <T>
     * @return
     */
    public static <R,T> T copyObject(R resourceObj,T targetObject){
        BeanUtils.copyProperties(resourceObj,targetObject);
        return targetObject;
    }

    /**
     *
     * @param rList
     * @param clz
     * @param <R>
     * @param <T>
     * @return
     */
    public static <R,T> List<T> copyListObject(List<R> rList,Class<T> clz){
           return rList.stream().map(r -> {
                try {
                    return copyObject(r, clz.newInstance());
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                return null;
            }).collect(Collectors.toList());
    }

    /**
     * 将对象转map
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> Map<String,Object> changeToMap(T obj){
        if(null != obj){
            return JSON.parseObject(JSON.toJSONString(obj),Map.class);
        }
        return null;
    }

    public static void main(String[] args) {
        BaseEntity b=new BaseEntity();
        b.setCreateBy("dbbbb");
        b.setCreateDate(new Date());
        System.out.println(changeToMap(b).get("createBy"));
    }
}
