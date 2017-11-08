package com.hiveview.pms.api;

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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
            if(role.getRemark().equals(RoleTypeEnums.SUPER_ADMIN.toString())){//超级管理员
                //返回所有资源数据
                List<SysResource> resourceList=sysResourceService.findByBiz(null);
                return resourceList.stream().map(res-> ObjectUtils.copyObject(res,new SysResourceDto())).collect(Collectors.toList());
            }else{
                //从
            }
        }
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
