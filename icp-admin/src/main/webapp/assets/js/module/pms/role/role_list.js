/**
 * Created by leo on 2017/5/22.
 */

$(document).ready(function(){
    $(".select2").select2({

    });
});
function operateRender(value, row, index){
    if(row.roleType == 'SUPER_ADMIN'){
        return '';
    }
    var action='';
    if($("#editRolePermission").length>0){
        action+='<a data-toggle="modal" data-target="#base_modal" href="'+rootPath+'/pms/role/edit?id='+row.id+'"  class="view-link">编辑</a>';
    }
    if($("#enableRolePermission").length>0){
        if(row.status == '1'){
            action+=' <a href="javascript:void(0);" onclick="ajaxDel(\''+rootPath+'/pms/role/modifyData?modifyType=disable&id='+row.id+'\')" class="view-link">禁用</a>';
        }else{
            action+=' <a href="javascript:void(0);" onclick="ajaxDel(\''+rootPath+'/pms/role/modifyData?modifyType=enable&id='+row.id+'\')" class="view-link">启用</a>';
        }
    }
    if($("#setRolePermission").length>0){
        action+=' <a data-toggle="modal" data-target="#base_modal" href="'+rootPath+'/role/resourceSetting?roleSn='+row.sn+'"  class="view-link">权限设置</a>';
    }
    return action;
}

var roleTypeEnum={ADMIN:'系统用户',OPERATE:'运营角色',MERCHANT:'商户角色',COMMON:'普通角色',SUPER_ADMIN:'超级管理员'};
function roleTypeRender(value, row, index){
    return roleTypeEnum[value];
}

