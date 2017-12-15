package com.hiveview.base.util;

import java.math.BigDecimal;

/**
 * Created by leo on 2017/11/23.
 */
public class NumberUtils {

    /**
     * 乘法 默认保留两位
     * @param a
     * @param b
     * @return
     */
    public static BigDecimal multiply(BigDecimal a, BigDecimal b){
       return multiply(a,b,2);
    }

    /**
     * 乘法
     * @param a
     * @param b
     * @param scale 小数点位数
     * @return
     */
    public static BigDecimal multiply(BigDecimal a, BigDecimal b, int scale){
        if(null != a && null != b){
            return a.multiply(b).setScale(scale,BigDecimal.ROUND_HALF_UP);
        }
        return null;
    }

    /**
     * 除法 默认保留两位小数点
     * @param a
     * @param b
     * @return
     */
    public static BigDecimal divide(BigDecimal a, BigDecimal b){
        return divide(a,b,2);
    }


    /**
     * 除法
     * @param a
     * @param b
     * @param scale 小数点位数
     * @return
     */
    public static BigDecimal divide(BigDecimal a, BigDecimal b, int scale){
        if(null != a && null != b){
            return a.divide(b,scale, BigDecimal.ROUND_HALF_UP);
        }
        return null;
    }

    /**
     * 设置小数点位数
     * @param a
     * @return
     */
    public static BigDecimal setScale(BigDecimal a){
        return setScale(a,2);
    }

    /**
     * 设置小数点位数
     * @param a
     * @param scale
     * @return
     */
    public static BigDecimal setScale(BigDecimal a, int scale){
        if(null != a){
            return a.setScale(scale,BigDecimal.ROUND_HALF_UP);
        }
        return null;
    }

    public static void main(String[] args) {
        BigDecimal a=new BigDecimal("2");
        BigDecimal b=new BigDecimal("3");
        System.out.println(multiply(a,b));
    }
}
