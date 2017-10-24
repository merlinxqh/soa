package com.hiveview.admin.icp.util;

import com.hiveview.admin.icp.commom.SpringContextHolder;
import com.hiveview.base.cache.RedisService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.core.NamedThreadLocal;

import java.util.Map;

/**
 * 系统 用户工具类
 * @author leo
 *
 */
public class SystemUserUtils {
	
	private static RedisService redisService= SpringContextHolder.getBean(RedisService.class);

	private static ThreadLocal<Map<String,String>> currentPermissionMap=new NamedThreadLocal<>("current permission map...");
	
//	private static ThreadLocal<DomyAdmin> currentUser=new NamedThreadLocal<>("current user info...");
	
	/**
	 * 获取当前登录用户
	 * @return
	 */
//    public static DomyAdmin getCurrentUser(){
//		if(null != currentUser.get()){
//    		return currentUser.get();
//		}
//    	DomyAdmin user=null;
//    	String userName=(String) SecurityUtils.getSubject().getPrincipal();
//    	if(redisService.mapExists(RedisKeyConstants.SECURITY_USER_MAP_KEY, userName)){
//    		user=redisService.getHashObject(RedisKeyConstants.SECURITY_USER_MAP_KEY, userName, DomyAdmin.class);
//    	}
//    	currentUser.set(user);
//    	return user;
//    }
    
    
    /**
     * 初始threadLocal化信息
     */
//    public static void setInitInfo(){
//    	getCurrentUser();
//    	getPermissionMap();
//    }
    
    /**
     * 清空threadLocal信息
     */
//    public static void clearInitInfo(){
//		currentPermissionMap.remove();
//		currentUser.remove();
//    }
    
    /**
     * 获取当前登录人 资源数据
     * @return
     */
    @SuppressWarnings("rawtypes")
//	public static List<DomyResource> getResourceList(){
//    	List<DomyResource> resourceList=null;
//    	DomyAdmin user = getCurrentUser();
//    	if(null != user && null != user.getDefaultRole()){
//    		String resourceKey=String.format(RedisKeyConstants.SECURITY_RESOURCE_KEY,user.getDefaultRole().getSn());
//    		if(redisService.exists(resourceKey)){
//    			resourceList=redisService.getListObj(resourceKey,DomyResource.class);
//			}else{
//    			// 从DB中查询资源数据
//				Map<String,String> map=RequestUtils.getCommonMap();
//				map.put("roleSn",user.getDefaultRole().getSn());
//				RespMessage resp= JSON.parseObject(OkHttp3Utils.getInstance().doPost(Global.getServiceUrl()+ HttpApiConstant.FIND_RESOURCE_BYROLE, map), RespMessage.class);
//				resourceList= JSONArray.parseArray(JSON.toJSONString(resp.getData()),DomyResource.class);
//			}
//    	}
//    	return resourceList;
//    }

	/**
	 * 获取权限项
	 * @return
	 */
//	public static Map<String,String> getPermissionMap(){
//		if(null != currentPermissionMap.get()){
//			return currentPermissionMap.get();
//		}
//		List<DomyResource> resourceList=getResourceList();
//		Map<String,String> permissionMap=new HashMap<>();
//		if(!CollectionUtils.isEmpty(resourceList)){
//			resourceList.forEach(re->{
//				if(org.springframework.util.StringUtils.hasText(re.getPermission())){
//					permissionMap.put(re.getPermission().trim(),"");
//				}
//			});
//		}
//		currentPermissionMap.set(permissionMap);
//		return permissionMap;
//	}

	/**
	 * 是否包含权限
	 * @param permission
	 * @return
	 */
//	public static boolean hasPermission(String permission){
//		return getPermissionMap().containsKey(permission);
//	}
    
    /**
     * 获取当前登录用户 角色
     * @return
     */
//    public static List<DomyRole> getUserRoleList(){
//    	List<DomyRole> roleList=null;
//    	DomyAdmin curUser=getCurrentUser();
//    	if(null != curUser){
//    		String redisKey=String.format(RedisKeyConstants.SECURITY_ROLE_KEY, curUser.getUserName());
//    		if(redisService.exists(redisKey)){
//    			roleList=redisService.getListObj(redisKey, DomyRole.class);
//    		}
//    	}
//    	return roleList;
//    }
    
	public static Session getSession(){
		try{
			Subject subject = SecurityUtils.getSubject();
			Session session = subject.getSession(false);
			if (session == null){
				session = subject.getSession();
			}
			if (session != null){
				return session;
			}
		}catch (InvalidSessionException e){
			
		}
		return null;
	}
	
	/**
	 * 获取授权主要对象
	 */
	public static Subject getSubject(){
		return SecurityUtils.getSubject();
	}
	
	
	/**
	 * 用户缓存 操作
	 * @param key
	 * @return
	 */
	public static Object getCache(String key) {
		return getCache(key, null);
	}
	
	public static Object getCache(String key, Object defaultValue) {
		Object obj = getSession().getAttribute(key);
		return obj==null?defaultValue:obj;
	}

	public static void putCache(String key, Object value) {
		getSession().setAttribute(key, value);
	}

	public static void removeCache(String key) {
		getSession().removeAttribute(key);
	}
}