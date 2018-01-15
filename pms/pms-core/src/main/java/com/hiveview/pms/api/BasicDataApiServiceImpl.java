package com.hiveview.pms.api;

import com.hiveview.common.api.ModifyCommonDto;
import com.hiveview.common.api.PageDto;
import com.hiveview.pms.dto.BasicDataDto;
import com.hiveview.pms.service.BasicDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by leo on 2018/1/15.
 */
@Service("basicDataApiService")
public class BasicDataApiServiceImpl implements BasicDataApiService {

    @Autowired
    private BasicDataService basicDataService;

    @Override
    public int saveData(BasicDataDto data) {
        return 0;
    }

    @Override
    public int deleteData(BasicDataDto data) {
        return 0;
    }

    @Override
    public List<BasicDataDto> findList(BasicDataDto params) {
        return null;
    }

    @Override
    public BasicDataDto findById(Long id) {
        return null;
    }

    @Override
    @Transactional
    public void modifyData(ModifyCommonDto dto) {

    }

    @Override
    public PageDto<BasicDataDto> findPage(PageDto<BasicDataDto> page, BasicDataDto params) {
        return null;
    }
}
