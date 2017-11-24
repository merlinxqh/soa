package com.hiveview.admin.controller.pms;

import com.hiveview.admin.commom.BaseController;
import com.hiveview.admin.rpc.pms.SysResourceApiConsumer;
import com.hiveview.base.util.response.RespMsg;
import com.hiveview.common.api.PageDto;
import com.hiveview.pms.dto.SysResourceDto;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
    @RequiresPermissions("sys:resource:list")
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


    /**
     * 添加
     * @return
     */
    @RequiresPermissions("sys:permission:edit")
    @RequestMapping(value = "addResource",method = RequestMethod.GET)
    public ModelAndView addResource(ModelMap model,SysResourceDto dto){
        model.put("isMenu","2");//权限数据
        putParentData(model,dto);
        return new ModelAndView("pms/resource_edit");
    }

    /**
     * 添加下级菜单
     * @return
     */
    @RequiresPermissions("sys:menu:edit")
    @RequestMapping(value = "addChildMenu",method = RequestMethod.GET)
    public ModelAndView addChildMenu(ModelMap model,SysResourceDto dto){
        model.put("isMenu","1");//权限数据
        putParentData(model,dto);
        return new ModelAndView("pms/resource_edit");
    }

    /**
     * 数据编辑
     * @param model
     * @return
     */
    @RequiresPermissions(value = {"sys:permission:edit","sys:menu:edit"},logical = Logical.OR)
    @RequestMapping(value="edit",method = RequestMethod.GET)
    public ModelAndView edit(ModelMap model,SysResourceDto dto){
        if(StringUtils.hasText(dto.getId())){
           model.put("data",sysResourceApiConsumer.findList(dto).get(0));
        }
        return  new ModelAndView("pms/resource_edit");
    }


    /**
     * 查找上级数据
     * @param model
     * @param dto
     */
    public void putParentData(ModelMap model,SysResourceDto dto){
        if(StringUtils.hasText(dto.getCode())){
            List<SysResourceDto> dtoList=sysResourceApiConsumer.findList(dto);
            if(!CollectionUtils.isEmpty(dtoList)){
                model.put("parent",dtoList.get(0));//父节点数据
            }
        }
    }


    /**
     * 资源数据保存
     * @return
     */
    @RequestMapping(value = "saveData",method = RequestMethod.POST)
    public @ResponseBody RespMsg<?> saveData(SysResourceDto dto){
        try {
            sysResourceApiConsumer.saveData(dto);
        }catch (Exception e){
            return RespMsg.failResp(e.getMessage());
        }
        return RespMsg.successResp();
    }


}
