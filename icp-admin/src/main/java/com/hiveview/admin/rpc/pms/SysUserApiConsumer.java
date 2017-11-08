package com.hiveview.admin.rpc.pms;

import com.hiveview.pms.api.SysUserApiService;
import com.hiveview.pms.dto.SysUserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by leo on 2017/11/6.
 */
@Component
public class SysUserApiConsumer {
    private static final Logger logger= LoggerFactory.getLogger(SysUserApiConsumer.class);

    @Autowired
    private SysUserApiService sysUserApiService;

    public SysUserDto getUserByUserName(String userName){
       return sysUserApiService.getUserByUserName(userName);
    }


}
