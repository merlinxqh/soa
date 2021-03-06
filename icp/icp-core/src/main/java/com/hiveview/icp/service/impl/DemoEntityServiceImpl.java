package com.hiveview.icp.service.impl;

import com.hiveview.base.dao.CrudMapper;
import com.hiveview.base.service.impl.BaseCrudServiceImpl;
import com.hiveview.icp.dao.DemoEntityMapper;
import com.hiveview.icp.entity.DemoEntity;
import com.hiveview.icp.service.DemoEntityService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * 
 * @author hiveview
 * @date 2017-10-23 18:14:29
 * @version 1.0.0
 * @copyright www.hiveview.com
 */
@Service("demoEntityService")
public class DemoEntityServiceImpl extends BaseCrudServiceImpl<DemoEntity> implements DemoEntityService {

    @Resource
    private DemoEntityMapper demoEntityMapper;

    @Override
    public CrudMapper init() {
        return demoEntityMapper;
    }
}