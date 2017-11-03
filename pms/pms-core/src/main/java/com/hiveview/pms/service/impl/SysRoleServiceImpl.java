package com.hiveview.pms.service.impl;

import com.hiveview.base.dao.CrudMapper;
import com.hiveview.base.service.impl.BaseCrudServiceImpl;
import com.hiveview.pms.dao.SysRoleMapper;
import com.hiveview.pms.entity.SysRole;
import com.hiveview.pms.service.SysRoleService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * 
 * @author hiveview
 * @date 2017-11-03 17:24:06
 * @version 1.0.0
 * @copyright www.hiveview.com
 */
@Service("sysRoleService")
public class SysRoleServiceImpl extends BaseCrudServiceImpl<SysRole> implements SysRoleService {

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Override
    public CrudMapper init() {
        return sysRoleMapper;
    }
}