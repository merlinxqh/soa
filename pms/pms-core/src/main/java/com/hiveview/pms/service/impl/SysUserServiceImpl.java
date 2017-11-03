package com.hiveview.pms.service.impl;

import com.hiveview.base.dao.CrudMapper;
import com.hiveview.base.service.impl.BaseCrudServiceImpl;
import com.hiveview.pms.dao.SysUserMapper;
import com.hiveview.pms.entity.SysUser;
import com.hiveview.pms.service.SysUserService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * 
 * @author hiveview
 * @date 2017-11-03 17:24:06
 * @version 1.0.0
 * @copyright www.hiveview.com
 */
@Service("sysUserService")
public class SysUserServiceImpl extends BaseCrudServiceImpl<SysUser> implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public CrudMapper init() {
        return sysUserMapper;
    }
}