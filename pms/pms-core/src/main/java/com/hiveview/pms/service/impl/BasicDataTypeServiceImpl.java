package com.hiveview.pms.service.impl;

import com.hiveview.base.dao.CrudMapper;
import com.hiveview.base.service.impl.BaseCrudServiceImpl;
import com.hiveview.pms.dao.BasicDataTypeMapper;
import com.hiveview.pms.entity.basic.BasicDataType;
import com.hiveview.pms.service.BasicDataTypeService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * 
 * @author hiveview
 * @date 2018-01-15 17:01:06
 * @version 1.0.0
 * @copyright www.hiveview.com
 */
@Service("basicDataTypeService")
public class BasicDataTypeServiceImpl extends BaseCrudServiceImpl<BasicDataType> implements BasicDataTypeService {

    @Resource
    private BasicDataTypeMapper basicDataTypeMapper;

    @Override
    public CrudMapper init() {
        return basicDataTypeMapper;
    }
}