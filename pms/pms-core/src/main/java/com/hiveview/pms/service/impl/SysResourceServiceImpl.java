package com.hiveview.pms.service.impl;

import com.hiveview.base.dao.CrudMapper;
import com.hiveview.base.service.impl.BaseCrudServiceImpl;
import com.hiveview.pms.dao.SysResourceMapper;
import com.hiveview.pms.entity.SysResource;
import com.hiveview.pms.service.SysResourceService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * 
 * @author hiveview
 * @date 2017-11-03 17:24:06
 * @version 1.0.0
 * @copyright www.hiveview.com
 */
@Service("sysResourceService")
public class SysResourceServiceImpl extends BaseCrudServiceImpl<SysResource> implements SysResourceService {

    @Resource
    private SysResourceMapper sysResourceMapper;

    @Override
    public CrudMapper init() {
        return sysResourceMapper;
    }
}