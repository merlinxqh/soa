package com.hiveview.pms.api;

import com.hiveview.base.util.serializer.ObjectUtils;
import com.hiveview.common.api.PageDto;
import com.hiveview.pms.dto.BasicDataTypeDto;
import com.hiveview.pms.entity.basic.BasicDataType;
import com.hiveview.pms.service.BasicDataTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by leo on 2018/1/15.
 */
@Service("basicDataTypeApiService")
public class BasicDataTypeApiServiceImpl implements BasicDataTypeApiService {

    @Autowired
    private BasicDataTypeService basicDataTypeService;

    @Override
    public int saveData(BasicDataTypeDto data) {
        return 0;
    }

    @Override
    public int deleteData(BasicDataTypeDto data) {
        return 0;
    }

    @Override
    public List<BasicDataTypeDto> findList(BasicDataTypeDto params) {
        List<BasicDataType> typeList = basicDataTypeService.findByBiz(ObjectUtils.changeToMap(params));
        if(!CollectionUtils.isEmpty(typeList)){
            return ObjectUtils.copyListObject(typeList,BasicDataTypeDto.class);
        }
        return null;
    }

    @Override
    public BasicDataTypeDto findById(Long id) {
        return null;
    }

    @Override
    public PageDto<BasicDataTypeDto> findPage(PageDto<BasicDataTypeDto> page, BasicDataTypeDto params) {
        return null;
    }
}
