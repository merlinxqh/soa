package com.hiveview.pms.api;

import com.hiveview.base.util.serializer.ObjectUtils;
import com.hiveview.common.api.PageDto;
import com.hiveview.pms.dto.SysUserDto;
import com.hiveview.pms.entity.SysUser;
import com.hiveview.pms.service.SysUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by leo on 2017/11/6.
 */
@Service
public class SysUserApiServiceImpl implements SysUserApiService {

    @Autowired
    private SysUserService sysUserService;

    @Override
    public SysUserDto getUserByUserName(String userName) {
        Map<String,Object> params=new HashMap<>();
        params.put("username",userName);
        List<SysUser> ulist=sysUserService.findByBiz(params);
        if(!CollectionUtils.isEmpty(ulist)){
            return ObjectUtils.copyObject(ulist.get(0),SysUserDto.class);
        }
        return null;
    }

    @Override
    @Transactional
    public int saveData(SysUserDto data) {
        return sysUserService.saveData(ObjectUtils.copyObject(data,SysUser.class));
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
