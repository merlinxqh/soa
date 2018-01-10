package com.hiveview.schedule.job;

import com.alibaba.dubbo.config.spring.ReferenceBean;
import com.alibaba.dubbo.rpc.service.GenericService;

/**
 * JobDubboServiceUtils
 * 
 * @author CMM
 *
 * 2016年6月1日 下午6:11:36
 */
public class JobDubboServiceUtils {

	/**
	 * 把job转换成可以被泛化调用的服务对象，并把这些服务存放到Map中。
	 * 在job执行时，再从Map中获取出服务，再以泛化的方式调用dubbo的服务。
	 * @param beanClass 类名
	 * @param methodName 发明
	 */
	public static void setService(String beanClass, String methodName){
		ReferenceBean<GenericService> referenceConfig = new ReferenceBean<GenericService>();
		referenceConfig.setInterface(beanClass);
		referenceConfig.setGeneric(Boolean.TRUE);
		referenceConfig.setVersion("1.0.0");
		referenceConfig.setId(beanClass.concat(".").concat(methodName));
		SingletonDubboApplication.getInstance().destroyBean(referenceConfig.getId());
		SingletonDubboApplication.getInstance().addReferenceBean(referenceConfig.getId(), referenceConfig);
		GenericService myService = (GenericService) SingletonDubboApplication.getInstance().getReferenceObject(referenceConfig.getId());
		
		JobDubboGenericServiceMap.getInstance().serviceMap.put(referenceConfig.getId(), myService);
	}

}
