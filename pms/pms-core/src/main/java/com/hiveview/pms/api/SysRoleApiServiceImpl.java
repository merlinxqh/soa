package com.hiveview.pms.api;

import com.hiveview.base.mybatis.page.Page;
import com.hiveview.base.util.serializer.ObjectUtils;
import com.hiveview.common.api.PageDto;
import com.hiveview.pms.dto.RoleResourceDto;
import com.hiveview.pms.dto.SysRoleDto;
import com.hiveview.pms.entity.SysRole;
import com.hiveview.pms.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by leo on 2017/11/6.
 */
@Service
public class SysRoleApiServiceImpl implements SysRoleApiService{

    @Autowired
    private SysRoleService roleService;


    @Override
    @Transactional
    public int saveData(SysRoleDto data) {
        return roleService.saveData(ObjectUtils.copyObject(data,SysRole.class));
    }

    @Override
    @Transactional
    public int deleteData(SysRoleDto data) {
        SysRole role=ObjectUtils.copyObject(data,SysRole.class);
        return roleService.deleteById(role.getId());
    }

    @Override
    public List<SysRoleDto> findList(SysRoleDto params) {
        List<SysRole> list=roleService.findByBiz(ObjectUtils.changeToMap(params));
        return ObjectUtils.copyListObject(list,SysRoleDto.class);
    }

    @Override
    public PageDto<SysRoleDto> findPage(PageDto<SysRoleDto> page, SysRoleDto params) {
        Page _page= ObjectUtils.copyObject(page,Page.class);
        roleService.findByPage(_page,ObjectUtils.changeToMap(params));
        List<SysRole> list=_page.getRecords();
        page=ObjectUtils.copyObject(_page,PageDto.class);
        page.setRecords(ObjectUtils.copyListObject(list,SysRoleDto.class));
        return page;
    }

    @Override
    @Transactional
    public int modifyData(SysRoleDto dto) {
        return roleService.modifyData(ObjectUtils.copyObject(dto,SysRole.class));
    }

    @Override
    @Transactional
    public void roleResourceSave(RoleResourceDto dto) {
       roleService.roleResourceSave(dto);
    }
}
