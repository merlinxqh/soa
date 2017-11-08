package com.hiveview.admin.commom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.Map;

/**
 * 控制器基类
 * @author leo
 */
public abstract class BaseController {
	public Logger logger = LoggerFactory.getLogger(getClass());
	

	public HttpServletRequest getRequest(){
		return RequestContextHolder.getRequest();
	}
	
	public HttpServletResponse getResponse(){
		return RequestContextHolder.getResponse();
	}


	/**获取指定参数*/
	public String getString(String name) {
		return getString(name, null);
	}

	public String getString(String name, String defaultValue) {
		String resultStr = getRequest().getParameter(name);
		if (resultStr == null || "".equals(resultStr)
				|| "null".equals(resultStr) || "undefined".equals(resultStr)) {
			return defaultValue;
		} else {
			return resultStr;
		}
	}
	
	public int getInt(String name) {
		return getInt(name, 0);
	}

	public int getInt(String name, int defaultValue) {
		String resultStr = getRequest().getParameter(name);
		if (resultStr != null) {
			try {
				return Integer.parseInt(resultStr);
			} catch (Exception e) {
				return defaultValue;
			}
		}
		return defaultValue;
	}

	public BigDecimal getBigDecimal(String name) {
		return getBigDecimal(name, null);
	}
	
	public BigDecimal getBigDecimal(String name, BigDecimal defaultValue) {
		String resultStr = getRequest().getParameter(name);
		if (resultStr != null) {
			try {
				return BigDecimal.valueOf(Double.parseDouble(resultStr));
			} catch (Exception e) {
				return defaultValue;
			}
		}
		return defaultValue;
	}


	/**
	 * 获取request参数map
	 * 因 admin项目 用http 所以都用string
	 * @return
	 */
	protected Map<String,String> getRequestMap(){
		return RequestContextHolder.currentParam.get();
	}

}
