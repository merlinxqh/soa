package com.hiveview.admin.controller.pms;

import com.hiveview.admin.commom.BaseController;
import com.hiveview.admin.rpc.pms.SysResourceApiConsumer;
import com.hiveview.common.api.PageDto;
import com.hiveview.pms.dto.SysResourceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by leo on 2017/11/6.
 */
@RequestMapping("/pms/resource")
@Controller
public class SysResourceController extends BaseController{

    @Autowired
    private SysResourceApiConsumer sysResourceApiConsumer;

    /**
     * 资源列表
     * @return
     */
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public ModelAndView list(){
        return new ModelAndView("pms/resource_list");
    }

    @RequestMapping(value = "listData")
    public @ResponseBody PageDto listData(PageDto page, SysResourceDto params){
        return sysResourceApiConsumer.getPageData(page,params);
    }

    /**
     * 获取树结构数据
     * @return
     */
    @RequestMapping(value = "treeData",method = RequestMethod.POST)
    public @ResponseBody Object treeData(SysResourceDto dto){
        return sysResourceApiConsumer.getTreeData(dto);
    }

}
