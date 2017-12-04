package com.hiveview.pms.api;

import com.alibaba.fastjson.JSON;
import com.hiveview.base.mybatis.page.Page;
import com.hiveview.base.util.serializer.ObjectUtils;
import com.hiveview.common.api.PageDto;
import com.hiveview.pms.dto.SysResourceDto;
import com.hiveview.pms.dto.SysRoleDto;
import com.hiveview.pms.entity.SysRole;
import com.hiveview.pms.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by leo on 2017/11/6.
 */
@Service
public class SysRoleApiServiceImpl implements SysRoleApiService{

    @Autowired
    private SysRoleService roleService;


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
        Page _page= ObjectUtils.copyObject(page,Page.class);
        roleService.findByPage(_page,ObjectUtils.changeToMap(params));
        List<SysRole> list=_page.getRecords();
        if(!CollectionUtils.isEmpty(list)){
            page=ObjectUtils.copyObject(_page,PageDto.class);
            page.setRecords(ObjectUtils.copyListObject(list,SysRoleDto.class));
        }
        return page;
    }
}
