package com.hiveview.pms.entity;

import com.hiveview.base.common.BaseEntity;

/**
 * 
 * @author hiveview
 * @date 2017-11-03 17:24:06
 * @version 1.0.0
 * @copyright www.hiveview.com
 */
public class SysRoleResource extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 角色编码.
     */
    private String roleCode;

    /**
     * 资源编码.
     */
    private String resourceCode;

    /**
     * 
     * {@linkplain #roleCode}
     *
     * @return the value of sys_role_resource.role_code
     */
    public String getRoleCode() {
        return roleCode;
    }

    /**
     * {@linkplain #roleCode}
     * @param roleCode the value for sys_role_resource.role_code
     */
    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode == null ? null : roleCode.trim();
    }

    /**
     * 
     * {@linkplain #resourceCode}
     *
     * @return the value of sys_role_resource.resource_code
     */
    public String getResourceCode() {
        return resourceCode;
    }

    /**
     * {@linkplain #resourceCode}
     * @param resourceCode the value for sys_role_resource.resource_code
     */
    public void setResourceCode(String resourceCode) {
        this.resourceCode = resourceCode == null ? null : resourceCode.trim();
    }
}