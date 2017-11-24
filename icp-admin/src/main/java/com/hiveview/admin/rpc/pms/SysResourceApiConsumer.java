package com.hiveview.admin.rpc.pms;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hiveview.common.api.PageDto;
import com.hiveview.pms.api.SysResourceApiService;
import com.hiveview.pms.dto.SysResourceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
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


    /**
     * 查询分页数据
     * @param page
     * @param params
     * @return
     */
    public PageDto<SysResourceDto> getPageData(PageDto<SysResourceDto> page, SysResourceDto params){
        return sysResourceApiService.findPage(page,params);
    }


    /**
     * 获取树结构数据
     * @param params
     * @return
     */
    public JSONArray getTreeData(SysResourceDto params){
        List<SysResourceDto> resourceDtoList=sysResourceApiService.findList(params);
        List<SysResourceDto> flist=getFirstList(resourceDtoList);

        JSONArray resArray=new JSONArray();
        flist.forEach(f->{
            JSONObject json=new JSONObject();
            json.put("text", f.getName());
            json.put("code", f.getCode());
            json.put("level",1);
            json.put("id",f.getId());
            json.put("longCode", f.getLongCode());
            resArray.add(json);

        });
        recursionTreeData(resourceDtoList,resArray);

        if(null != params && StringUtils.hasText(params.getRoleCode())){
            //这里需要查出 角色绑定的所有资源
            List<SysResourceDto> exists=sysResourceApiService.getResourceByRole(params.getRoleCode());
            if(!CollectionUtils.isEmpty(exists)){
                for(Object obj:resArray){
                    recursionCheckData((JSONObject)obj, exists);
                }
            }
        }
        return setTreeHomeNode(resArray);
    }

    /**
     * 设置默认HOME节点
     */
    public JSONArray setTreeHomeNode(JSONArray array){
        JSONArray res=new JSONArray();
        JSONObject home=new JSONObject();
        home.put("code", 0);
        home.put("level",0);
        home.put("id","ROOT");//标识 根节点
        home.put("text", "HOME");
        JSONObject state=new JSONObject();
        state.put("checked", true);
        home.put("state", state);
        if(array.size()>0){
            home.put("nodes", array);
            home.put("tags", "["+array.size()+"]");
        }else{
            home.put("tags", "[0]");
        }
        res.add(home);
        return res;
    }

    /**
     * 对已该角色 已经拥有权限 做绑定 设置默认选中
     * @param json
     * @param hasResource
     */
    private void recursionCheckData(JSONObject json, List<SysResourceDto> hasResource) {
        json.put("text", json.getString("text"));
        for(SysResourceDto vo:hasResource){
            if(vo.getCode().equals(json.getString("code"))){
                JSONObject state=new JSONObject();
                state.put("checked", true);
                json.put("state", state);
            }
        }
        if(json.containsKey("nodes")){
            JSONArray childArray=json.getJSONArray("nodes");
            json.put("tags", "["+childArray.size()+"]");
            for(Object obj:childArray){
                recursionCheckData((JSONObject)obj, hasResource);
            }
        }else{
            json.put("tags", "[0]");
        }
    }


    /**
     * 递归 获取 树结构数据
     * @param all
     * @param array
     */
    private void recursionTreeData(List<SysResourceDto> all, JSONArray array) {
        for(Object obj:array){
            JSONObject json=(JSONObject) obj;
            JSONArray carray=new JSONArray();
            for(SysResourceDto vo:all){
                if(json.getString("code").equals(vo.getParentCode())){
                    JSONObject cjson=new JSONObject();
                    cjson.put("text", vo.getName());
                    cjson.put("code", vo.getCode());
                    cjson.put("level",vo.getLevel());
                    cjson.put("id",vo.getId());
                    cjson.put("parentCode",vo.getParentCode());
                    cjson.put("longCode", vo.getLongCode());
                    carray.add(cjson);
                }
            }
            if(carray.size()>0){
                recursionTreeData(all,carray);
                json.put("nodes", carray);
                json.put("tags", "["+carray.size()+"]");
            }
        }
    }

    private List<SysResourceDto> getFirstList(List<SysResourceDto> list) {
        List<SysResourceDto> reslist=new ArrayList<>();
        //获取所有一级分类数据
        list.stream().filter(i-> null != i.getLevel() && i.getLevel() == 1).forEach(item->{
            reslist.add(item);
        });
        return reslist;
    }


}
