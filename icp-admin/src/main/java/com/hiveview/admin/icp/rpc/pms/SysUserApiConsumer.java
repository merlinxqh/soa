package com.hiveview.admin.icp.rpc.pms;

import com.hiveview.pms.api.SysUserApiService;
import com.hiveview.pms.dto.SysUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by leo on 2017/11/6.
 */
@Component
public class SysUserApiConsumer {

    @Autowired
    private SysUserApiService sysUserApiService;

    public SysUserDto getUserByUserName(String userName){
        return sysUserApiService.getUserByUserName(userName);
    }


}
