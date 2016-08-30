package org.smart.framework.bean;

import java.util.Map;

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
	 * 获取所有字段信息
	 * @return
	 */
	public Map<String, Object> getMap(){
		return paramMap;
	}
}
