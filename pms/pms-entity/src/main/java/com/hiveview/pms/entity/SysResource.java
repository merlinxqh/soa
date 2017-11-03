package com.hiveview.pms.entity;

import com.hiveview.base.common.BaseEntity;

/**
 * 
 * @author hiveview
 * @date 2017-11-03 17:24:06
 * @version 1.0.0
 * @copyright www.hiveview.com
 */
public class SysResource extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 编码.
     */
    private String code;

    /**
     * 长编码.
     */
    private String longCode;

    /**
     * 状态(1:启用,2:禁用).
     */
    private Integer status;

    /**
     * 关联子系统.
     */
    private String subSystemCode;

    /**
     * 父编码.
     */
    private String parentCode;

    /**
     * 访问路径.
     */
    private String url;

    /**
     * 1:菜单,2:权限项.
     */
    private Integer isMenu;

    /**
     * 排序字段.
     */
    private Integer orders;

    /**
     * 级别.
     */
    private Integer level;

    /**
     * 菜单样式.
     */
    private String iconCode;

    /**
     * 权限标识.
     */
    private String permission;

    /**
     * 
     * {@linkplain #code}
     *
     * @return the value of sys_resource.code
     */
    public String getCode() {
        return code;
    }

    /**
     * {@linkplain #code}
     * @param code the value for sys_resource.code
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 
     * {@linkplain #longCode}
     *
     * @return the value of sys_resource.long_code
     */
    public String getLongCode() {
        return longCode;
    }

    /**
     * {@linkplain #longCode}
     * @param longCode the value for sys_resource.long_code
     */
    public void setLongCode(String longCode) {
        this.longCode = longCode == null ? null : longCode.trim();
    }

    /**
     * 
     * {@linkplain #status}
     *
     * @return the value of sys_resource.status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * {@linkplain #status}
     * @param status the value for sys_resource.status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 
     * {@linkplain #subSystemCode}
     *
     * @return the value of sys_resource.sub_system_code
     */
    public String getSubSystemCode() {
        return subSystemCode;
    }

    /**
     * {@linkplain #subSystemCode}
     * @param subSystemCode the value for sys_resource.sub_system_code
     */
    public void setSubSystemCode(String subSystemCode) {
        this.subSystemCode = subSystemCode == null ? null : subSystemCode.trim();
    }

    /**
     * 
     * {@linkplain #parentCode}
     *
     * @return the value of sys_resource.parent_code
     */
    public String getParentCode() {
        return parentCode;
    }

    /**
     * {@linkplain #parentCode}
     * @param parentCode the value for sys_resource.parent_code
     */
    public void setParentCode(String parentCode) {
        this.parentCode = parentCode == null ? null : parentCode.trim();
    }

    /**
     * 
     * {@linkplain #url}
     *
     * @return the value of sys_resource.url
     */
    public String getUrl() {
        return url;
    }

    /**
     * {@linkplain #url}
     * @param url the value for sys_resource.url
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 
     * {@linkplain #isMenu}
     *
     * @return the value of sys_resource.is_menu
     */
    public Integer getIsMenu() {
        return isMenu;
    }

    /**
     * {@linkplain #isMenu}
     * @param isMenu the value for sys_resource.is_menu
     */
    public void setIsMenu(Integer isMenu) {
        this.isMenu = isMenu;
    }

    /**
     * 
     * {@linkplain #orders}
     *
     * @return the value of sys_resource.orders
     */
    public Integer getOrders() {
        return orders;
    }

    /**
     * {@linkplain #orders}
     * @param orders the value for sys_resource.orders
     */
    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    /**
     * 
     * {@linkplain #level}
     *
     * @return the value of sys_resource.level
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * {@linkplain #level}
     * @param level the value for sys_resource.level
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * 
     * {@linkplain #iconCode}
     *
     * @return the value of sys_resource.icon_code
     */
    public String getIconCode() {
        return iconCode;
    }

    /**
     * {@linkplain #iconCode}
     * @param iconCode the value for sys_resource.icon_code
     */
    public void setIconCode(String iconCode) {
        this.iconCode = iconCode == null ? null : iconCode.trim();
    }

    /**
     * 
     * {@linkplain #permission}
     *
     * @return the value of sys_resource.permission
     */
    public String getPermission() {
        return permission;
    }

    /**
     * {@linkplain #permission}
     * @param permission the value for sys_resource.permission
     */
    public void setPermission(String permission) {
        this.permission = permission == null ? null : permission.trim();
    }
}