package com.hiveview.pms.api;

import com.hiveview.common.api.PageDto;
import com.hiveview.pms.dto.SysRoleDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by leo on 2017/11/6.
 */
@Service
public class SysRoleApiServiceImpl implements SysRoleApiService{
    @Override
    public int saveData(SysRoleDto data) {
        return 0;
    }

    @Override
    public int deleteData(SysRoleDto data) {
        return 0;
    }

    @Override
    public List<SysRoleDto> findList(SysRoleDto params) {
        return null;
    }

    @Override
    public PageDto<SysRoleDto> findPage(PageDto<SysRoleDto> page, SysRoleDto params) {
        return null;
    }
}
