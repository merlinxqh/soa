package com.hiveview.admin.controller.pms;

import com.hiveview.admin.commom.BaseController;
import com.hiveview.admin.rpc.pms.SysRoleApiConsumer;
import com.hiveview.common.api.PageDto;
import com.hiveview.pms.dto.SysRoleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by leo on 2017/11/6.
 * 系统角色管理
 */
@RequestMapping("/pms/role")
@Controller
public class SysRoleController extends BaseController{

    @Autowired
    private SysRoleApiConsumer roleApiConsumer;


    @RequestMapping(value = "list",method = RequestMethod.GET)
    public ModelAndView list(){
        return new ModelAndView("pms/role/role_list");
    }

    @RequestMapping(value = "listData")
    public @ResponseBody
    PageDto listData(PageDto page, SysRoleDto dto){
        return roleApiConsumer.getPageData(page,dto);
    }

    @RequestMapping(value = "edit",method = RequestMethod.GET)
    public ModelAndView edit(){
        return new ModelAndView("pms/role/role_edit");
    }
}
