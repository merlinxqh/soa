package com.hiveview.admin.icp.security;

import com.hiveview.admin.icp.security.session.SessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户权限 相关业务
 * @author leo
 *
 */
@Service
public class SystemService {
	
	@Autowired
	private SessionDAO sessionDao;
	
	
	public SessionDAO getSessionDao(){
		return sessionDao;
	}
   
	
	/**
	 * 根据登录账号获取 用户信息
	 * @return
	 */
//	public DomyAdmin getUserByLoginName(String userName){
//        Map<String,String> map=RequestUtils.getCommonMap();
//        map.put("userName", userName);
//        List<DomyAdmin> userList=getUserList(map);
//        if(!CollectionUtils.isEmpty(userList)){
//        	return userList.get(0);
//        }
//		return null;
//	}
	
	/**
	 * 登录并 返回用户对象
	 * @param userName
	 * @param password
	 * @return
	 */
//	public DomyAdmin loginAndReturnUser(String userName,String password){
//		Map<String,String> map=RequestUtils.getCommonMap();
//        map.put("userName", userName);
//        map.put("password",password);
//        RespMessage res= JSON.parseObject(OkHttp3Utils.getInstance().doPost(Global.getServiceUrl()+ HttpApiConstant.USER_LOGIN_API, map), RespMessage.class);
//        if(res.hasError()){
//        	throw new RuntimeException(res.getData().toString());
//        }
//        DomyAdmin user= JSON.parseObject(JSON.toJSONString(res.getData()), DomyAdmin.class);
//        return user;
//	}
	
	
	/**
	 * 获取用户信息
	 * @param map
	 * @return
	 */
//	public List<DomyAdmin> getUserList(Map<String,String> map){
//		@SuppressWarnings("rawtypes")
//		RespMessage res= JSON.parseObject(OkHttp3Utils.getInstance().doPost(Global.getServiceUrl()+ HttpApiConstant.USER_FIND_DATA, map), RespMessage.class);
//        List<DomyAdmin> list= JSONArray.parseArray(JSON.toJSONString(res.getData()),DomyAdmin.class);
//        return list;
//	}
}
