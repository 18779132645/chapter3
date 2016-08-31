package org.smart.framework.bean;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.smart.framework.util.CastUtil;

/**
 * 请求参数对象
 * @author HP
 *
 */
public class Param {

	private Map<String, Object> paramMap;
	
	public Param(Map<String, Object> paramMap){
		this.paramMap = paramMap;
	}
	
	/**
	 * 根据参数名获取 long 型参数值
	 * @param name
	 * @return
	 */
	public long getLong(String name){
		return CastUtil.castLong(paramMap.get(name));
	}
	/**
	 * 根据参数名获取 Int 型参数值
	 * @param name
	 * @return
	 */
	public int getInt(String name){
		return CastUtil.castInt(paramMap.get(name));
	}
	/**
	 * 根据参数名获取 Double 型参数值
	 * @param name
	 * @return
	 */
	public Double getDouble(String name){
		return CastUtil.castDouble(paramMap.get(name));
	}
	/**
	 * 根据参数名获取 Boolean 型参数值
	 * @param name
	 * @return
	 */
	public boolean getBoolean(String name){
		return CastUtil.castBoolean(paramMap.get(name));
	}
	
	/**
	 * 根据参数名获取 request
	 * @return
	 */
	public HttpServletRequest getRequest(){
		return (HttpServletRequest) paramMap.get("request");
	}
	/**
	 * 根据参数名获取 response
	 * @return
	 */
	public HttpServletResponse getResponse(){
		return (HttpServletResponse) paramMap.get("response");
	}
	
	/**
	 * 获取所有字段信息
	 * @return
	 */
	public Map<String, Object> getMap(){
		return paramMap;
	}
}
