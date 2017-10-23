package com.hiveview.base.util.redis;

/**
 * Created by leo on 2017/6/6.
 * redis lock key constant
 */
public class RedisLockConstants {

    /**
     * 库存新增 lock key
     */
    public static final String STOCK_ADD_LOCK_KEY="stock:add:lock:key";

    /**
     * 库存修改 lock key
     */
    public static final String STOCK_UPDATE_LOCK_KEY="stock:update:lock:key";

    /**
     * 校验订单更改库存信息
     */
    public static final String ORDER_STOCK_CHECK_KEY="order:stock:check:%s";

    /**
     * 订单修改LOCK KEY
     */
    public static final String ORDER_UPDATE_LOCK_KEY="order:update:status:key";

    /**
     * 订单子项
     */
    public static final String ORDERITEM_UPDATE_LOCK_KEY="orderitem:update:status:key";

    /**
     * 售后
     */
    public static final String REFUND_UPDATE_LOCK_KEY="refund:update:status:key";

    /**
     * 售后
     */
    public static final String EXCHANGE_UPDATE_LOCK_KEY="exchange:update:status:key";

}
