package com.hiveview.pms.api;

import com.hiveview.common.api.PageDto;
import com.hiveview.pms.dto.SysUserDto;
import com.hiveview.pms.entity.SysUser;
import com.hiveview.pms.service.SysUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by leo on 2017/11/6.
 */
@Service
public class SysUserApiServiceImpl implements SysUserApiService {

    @Autowired
    private SysUserService sysUserService;

    @Override
    @Transactional
    public int saveData(SysUserDto data) {
        SysUser entity=new SysUser();
        BeanUtils.copyProperties(data,entity);
        return sysUserService.saveData(entity);
    }

    @Override
    public int deleteData(SysUserDto data) {
        return 0;
    }

    @Override
    public List<SysUserDto> findList(SysUserDto params) {
        return null;
    }

    @Override
    public PageDto<SysUserDto> findPage(PageDto<SysUserDto> page, SysUserDto params) {
        return null;
    }
}
