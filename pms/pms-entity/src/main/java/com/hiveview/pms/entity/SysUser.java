package com.hiveview.pms.entity;

import com.hiveview.base.common.BaseEntity;

/**
 * 
 * @author hiveview
 * @date 2017-11-03 17:24:06
 * @version 1.0.0
 * @copyright www.hiveview.com
 */
public class SysUser extends BaseEntity {

    private static final long serialVersionUID = 1L;

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
     * 
     * {@linkplain #username}
     *
     * @return the value of sys_user.username
     */
    public String getUsername() {
        return username;
    }

    /**
     * {@linkplain #username}
     * @param username the value for sys_user.username
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 
     * {@linkplain #password}
     *
     * @return the value of sys_user.password
     */
    public String getPassword() {
        return password;
    }

    /**
     * {@linkplain #password}
     * @param password the value for sys_user.password
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 
     * {@linkplain #name}
     *
     * @return the value of sys_user.name
     */
    public String getName() {
        return name;
    }

    /**
     * {@linkplain #name}
     * @param name the value for sys_user.name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 
     * {@linkplain #status}
     *
     * @return the value of sys_user.status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * {@linkplain #status}
     * @param status the value for sys_user.status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 
     * {@linkplain #email}
     *
     * @return the value of sys_user.email
     */
    public String getEmail() {
        return email;
    }

    /**
     * {@linkplain #email}
     * @param email the value for sys_user.email
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }
}