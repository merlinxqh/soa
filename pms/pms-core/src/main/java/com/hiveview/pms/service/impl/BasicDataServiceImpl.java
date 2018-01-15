package com.hiveview.pms.service.impl;

import com.hiveview.base.dao.CrudMapper;
import com.hiveview.base.service.impl.BaseCrudServiceImpl;
import com.hiveview.pms.dao.BasicDataMapper;
import com.hiveview.pms.entity.basic.BasicData;
import com.hiveview.pms.service.BasicDataService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * 
 * @author hiveview
 * @date 2018-01-15 17:01:06
 * @version 1.0.0
 * @copyright www.hiveview.com
 */
@Service("basicDataService")
public class BasicDataServiceImpl extends BaseCrudServiceImpl<BasicData> implements BasicDataService {

    @Resource
    private BasicDataMapper basicDataMapper;

    @Override
    public CrudMapper init() {
        return basicDataMapper;
    }
}