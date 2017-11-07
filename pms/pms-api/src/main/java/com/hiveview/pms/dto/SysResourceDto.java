package com.hiveview.pms.dto;

import com.hiveview.common.api.BaseEntityDto;

import java.util.List;

/**
 * Created by leo on 2017/10/24.
 * 系统权限项
 */
public class SysResourceDto extends BaseEntityDto{

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


    //////////
    private List<SysResourceDto> childList;

    public List<SysResourceDto> getChildList() {
        return childList;
    }

    public void setChildList(List<SysResourceDto> childList) {
        this.childList = childList;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLongCode() {
        return longCode;
    }

    public void setLongCode(String longCode) {
        this.longCode = longCode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSubSystemCode() {
        return subSystemCode;
    }

    public void setSubSystemCode(String subSystemCode) {
        this.subSystemCode = subSystemCode;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getIsMenu() {
        return isMenu;
    }

    public void setIsMenu(Integer isMenu) {
        this.isMenu = isMenu;
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getIconCode() {
        return iconCode;
    }

    public void setIconCode(String iconCode) {
        this.iconCode = iconCode;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
