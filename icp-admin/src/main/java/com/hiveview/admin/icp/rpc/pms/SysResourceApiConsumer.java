package com.hiveview.admin.icp.rpc.pms;

import com.hiveview.pms.api.SysResourceApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by leo on 2017/11/6.
 */
@Component
public class SysResourceApiConsumer {

    @Autowired
    private SysResourceApiService sysResourceApiService;

}
