package com.hiveview.pms.api;

import com.hiveview.base.mybatis.page.Page;
import com.hiveview.base.util.id.IdWorker;
import com.hiveview.base.util.serializer.ObjectUtils;
import com.hiveview.common.api.PageDto;
import com.hiveview.pms.dto.SysResourceDto;
import com.hiveview.pms.entity.SysResource;
import com.hiveview.pms.entity.SysRole;
import com.hiveview.pms.enums.RoleTypeEnums;
import com.hiveview.pms.service.SysResourceService;
import com.hiveview.pms.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by leo on 2017/11/6.
 */
@Service
public class SysResourceApiServiceImpl implements SysResourceApiService {

    @Autowired
    private SysResourceService sysResourceService;

    @Autowired
    private SysRoleService roleService;

    @Override
    public List<SysResourceDto> getResourceByRole(String roleCode) {
        Map<String,Object> params=new HashMap<>();
        params.put("code",roleCode);
        SysRole role=roleService.findOneByBiz(params);
        if(null != role){
            Map<String,Object> map=new HashMap<>();
            if(!role.getRoleType().equals(RoleTypeEnums.SUPER_ADMIN.toString())){
                //非超级管理员
                map.put("roleCode",roleCode);
            }
            List<SysResource> resourceList=sysResourceService.findByBiz(map);
            return ObjectUtils.copyListObject(resourceList,SysResourceDto.class);
        }
        return null;
    }

    @Override
    @Transactional
    public int saveData(SysResourceDto data) {
        return sysResourceService.saveData(ObjectUtils.copyObject(data,SysResource.class));
    }

    @Override
    @Transactional
    public int deleteData(SysResourceDto data) {
        Assert.notNull(data,"参数不能为空");
        Assert.hasText(data.getId(),"ID不能为空");
        return sysResourceService.deleteById(Long.valueOf(data.getId()));
    }

    @Override
    public List<SysResourceDto> findList(SysResourceDto params) {
        List<SysResource> resList=sysResourceService.findByBiz(ObjectUtils.changeToMap(params));
        return resList.stream().map(res-> ObjectUtils.copyObject(res,SysResourceDto.class)).collect(Collectors.toList());
    }

    @Override
    public PageDto<SysResourceDto> findPage(PageDto<SysResourceDto> page, SysResourceDto params) {
        Page<SysResource> _page=ObjectUtils.copyObject(page,Page.class);
        sysResourceService.findByPage(_page,ObjectUtils.copyObject(params,Map.class));
        List<SysResource> resList=_page.getRecords();
        if(!CollectionUtils.isEmpty(resList)){
            page=ObjectUtils.copyObject(_page,PageDto.class);
            page.setRecords(ObjectUtils.copyListObject(resList,SysResourceDto.class));
        }
        return page;
    }
}
