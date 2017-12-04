package com.hiveview.admin.rpc.pms;

import com.hiveview.common.api.PageDto;
import com.hiveview.pms.api.SysRoleApiService;
import com.hiveview.pms.dto.SysResourceDto;
import com.hiveview.pms.dto.SysRoleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by leo on 2017/11/6.
 */
@Component
public class SysRoleApiConsumer {

    @Autowired
    private SysRoleApiService sysRoleApiService;


    /**
     * 查询分页数据
     * @param page
     * @param
     * @return
     */
    public PageDto<SysRoleDto> getPageData(PageDto<SysRoleDto> page, SysRoleDto dto){
        return sysRoleApiService.findPage(page,dto);
    }


}
