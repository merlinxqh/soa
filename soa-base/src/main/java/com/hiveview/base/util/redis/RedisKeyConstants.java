package com.hiveview.base.util.redis;

/**
 *
 */
public class RedisKeyConstants {

    /**
     * 代码启用缓存宏
     */
    //public static final boolean REDIS_OPEN = false; //false;

    /**
     * 验证码在redis中存储的前缀
     */
    public static final String IMAGE_CODE = "image_code";

    /**
     * session信息过期时间 单位 秒
     */
    public static final int SECURITY_SESSION_CACHE_TIME=60*60;

    /**
     * TV APP用户ID TOKEN
     */
    public static final String DOMYSHOP_USER_AUTH = "domyshop:auth:token:%s";

    /**
     * 用户信息
     */
    public static final String SECURITY_USER_KEY="domyshop:security:user:%s";

    /**
     * 角色信息
     */
    public static final String SECURITY_ROLE_KEY="domyshop:security:role:%s";

    /**
     * 资源信息
     */
    public static final String SECURITY_RESOURCE_KEY="domyshop:security:resource:%s";
    
    /**
     * 权限信息
     */
    public static final String SECURITY_PERMISSION_KEY="domyshop:security:permission:%s";


    /**
     * 根据sessionID存用户名
     */
    public static final String SECURITY_SESSION_KEY="domyshop:security:session:%s";
    
    /**
     * 存放所有登录用户信息
     */
    public static final String SECURITY_USER_MAP_KEY="domyshop:security:user:map";

    /**
     * 上线矩阵配置信息
     */
    public static final String DOMY_SHOP_MATRIX_KEY="domyshop:matrix:online";

    /**
     * 上线专题信息
     */
    public static final String DOMY_SHOP_SPECIAL_KEY="domyshop:special:online";

    /**
     * 字段
     */
    public static final String DOMY_SHOP_SPECIAL_FIELD="%s:%d:%d";

    /**
     * 基础数据map
     */
    public static final String DOMY_SHOP_BASIC_DATA="domyshop:basic:data:map";


    /**
     * 快递物流公司选择
     */
    public static final String DOMY_DELIVERY_CORP_KEY="domyshop:delivery:corp";

    /**
     * 商城购物车
     */
    public static final String DOMY_SHOP_CART_KEY="domyshop:cart:map:%s";

    /**
     * 商城购物车分页
     */
    public static final String DOMY_COMMON_CACHE_FIELD="%d:%d";


    /**
     * 城市缓存
     */
    public static final String DOMY_SHOP_CITY_KEY="domyshop:city:map";

    /**
     * 物流缓存
     */
    public static final String DOMY_SHOP_DELIVERY_KEY="domyshop:delivery:ordersn:%s";

    /**
     * 商品品牌缓存
     */
    //public static final String DOMY_SHOP_BRAND_KEY="domyshop:brand:map:%s";

    /**
     * 商品种类缓存
     */
    public static final String DOMY_SHOP_ROOT_CATEGORY_KEY="domyshop:root:category:map";


    /**
     * 商品种类缓存
     */
    public static final String DOMY_SHOP_PARENT_CATEGORY_KEY="domyshop:parnet:category:map";


    /**
     * 商品数据
     */
    public static final String DOMY_ROOT_GOODS_DATA_KEY="domyshop:goods:map";

    /**
     * 商品数据格式
     */
    public static final String DOMY_GOODS_DATA_FIELD_KEY="%s:%d:%d";

    /**
     * 商品数据格式
     */
    public static final String DOMY_GOODS_DETAIL_KEY="domyshop:goods:detail:%s";

    /**
     * 商品SKU数据
     */
    public static final String DOMY_GOODS_SKU_FIELD_KEY="domyshop:goods:sku:%s";

    /**
     * 所有商品数据
     */
    public static final String DOMY_ALL_GOODS_FIELD_KEY="domyshop:goods:map";

    /**
     * 字段
     */
    public static final String DOMY_ALL_GOODS_FIELD="%d:%d";

    /**
     * 商品种类格式
     */
    public static final String DOMY_SHOP_CATEGORY_FIELD_KEY="%s:%d:%d";

    /**
     * 收件人
     */
    public static final String DOMY_SHOP_RECEIVER_KEY="domyshop:receiver:map:%s";

    /**
     * 收件人字段
     */
    public static final String DOMY_SHOP_RECEIVER_FIELD="%d:%d";

    /**
     * 搜索商品
     */
    public static final String DOMY_SHOP_SEARCH_GOODS="domyshop:search:goods:map:%s";

    /**
     * 搜索商品词
     */
    public static final String DOMY_SHOP_SEARCH_WORD_GOODS="domyshop:search:word:map:%s";

    /**
     * 商品字段
     */
    public static final String DOMY_SHOP_SEARCH_GOODS_FIELD="%d:%d";


    /**
     * 收藏夹商品
     */
    public static final String DOMY_SHOP_FAVORITE_GOODS="domyshop:favorite:goods:map:%s";

    /**
     * 收藏夹字段
     */
    public static final String DOMY_SHOP_FAVORITE_GOODS_FIELD="%d:%d";

    /**
     * lww
     * redis中存储每台reids当前被判断为高连接次数（Map类型，key为IP）n
     */
    public static final String REDIS_COUNTS = "redis:counts";

    /**
     * lww
     * 存储收货地址二维码是否过期的判断标志
     */
    public static final String DOMY_ADDRESS_QR_SESSION ="domyshop:address:token:%s";


}
