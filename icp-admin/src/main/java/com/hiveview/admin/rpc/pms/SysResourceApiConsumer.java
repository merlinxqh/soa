package com.hiveview.admin.rpc.pms;

import com.hiveview.pms.api.SysResourceApiService;
import com.hiveview.pms.dto.SysResourceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by leo on 2017/11/6.
 */
@Component
public class SysResourceApiConsumer {

    @Autowired
    private SysResourceApiService sysResourceApiService;

    public List<SysResourceDto> getResourceByRole(String roleCode){
        return sysResourceApiService.getResourceByRole(roleCode);
    }

}
