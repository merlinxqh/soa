package com.hiveview.pms.dto;

import com.hiveview.common.api.BaseEntityDto;

/**
 * Created by leo on 2017/10/24.
 * 系统用户
 */
public class SysUserDto extends BaseEntityDto{
    /**
     * 用户名.
     */
    private String username;

    /**
     * 密码.
     */
    private String password;

    /**
     * 名称.
     */
    private String name;

    /**
     * 状态(1:启用,2:禁用).
     */
    private Integer status;

    /**
     * 邮箱.
     */
    private String email;

    /**
     * 默认角色
     */
    private SysRoleDto defaultRole;


    public SysRoleDto getDefaultRole() {
        return defaultRole;
    }

    public void setDefaultRole(SysRoleDto defaultRole) {
        this.defaultRole = defaultRole;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
