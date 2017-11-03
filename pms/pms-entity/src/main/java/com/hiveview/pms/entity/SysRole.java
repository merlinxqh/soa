package com.hiveview.pms.entity;

import com.hiveview.base.common.BaseEntity;

/**
 * 
 * @author hiveview
 * @date 2017-11-03 17:24:06
 * @version 1.0.0
 * @copyright www.hiveview.com
 */
public class SysRole extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 编码.
     */
    private String code;

    /**
     * 名称.
     */
    private String name;

    /**
     * 状态(1:启用,2:禁用).
     */
    private Integer status;

    /**
     * 角色类型.
     */
    private String roleType;

    /**
     * 备注.
     */
    private String remark;

    /**
     * 
     * {@linkplain #code}
     *
     * @return the value of sys_role.code
     */
    public String getCode() {
        return code;
    }

    /**
     * {@linkplain #code}
     * @param code the value for sys_role.code
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 
     * {@linkplain #name}
     *
     * @return the value of sys_role.name
     */
    public String getName() {
        return name;
    }

    /**
     * {@linkplain #name}
     * @param name the value for sys_role.name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 
     * {@linkplain #status}
     *
     * @return the value of sys_role.status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * {@linkplain #status}
     * @param status the value for sys_role.status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 
     * {@linkplain #roleType}
     *
     * @return the value of sys_role.role_type
     */
    public String getRoleType() {
        return roleType;
    }

    /**
     * {@linkplain #roleType}
     * @param roleType the value for sys_role.role_type
     */
    public void setRoleType(String roleType) {
        this.roleType = roleType == null ? null : roleType.trim();
    }

    /**
     * 
     * {@linkplain #remark}
     *
     * @return the value of sys_role.remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * {@linkplain #remark}
     * @param remark the value for sys_role.remark
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}