package com.hiveview.pms.api;

import com.hiveview.common.api.PageDto;
import com.hiveview.pms.dto.SysResourceDto;
import com.hiveview.pms.service.SysResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by leo on 2017/11/6.
 */
@Service
public class SysResourceApiServiceImpl implements SysResourceApiService {

    @Autowired
    private SysResourceService sysResourceService;

    @Override
    public List<SysResourceDto> getResourceByRole(String roleSn) {
        return null;
    }

    @Override
    public int saveData(SysResourceDto data) {
        return 0;
    }

    @Override
    public int deleteData(SysResourceDto data) {
        return 0;
    }

    @Override
    public List<SysResourceDto> findList(SysResourceDto params) {
        return null;
    }

    @Override
    public PageDto<SysResourceDto> findPage(PageDto<SysResourceDto> page, SysResourceDto params) {
        return null;
    }
}
