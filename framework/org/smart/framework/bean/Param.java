package org.smart.framework.bean;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.smart.framework.util.CastUtil;

/**
 * �����������
 * @author HP
 *
 */
public class Param {

	private Map<String, Object> paramMap;
	
	public Param(Map<String, Object> paramMap){
		this.paramMap = paramMap;
	}
	
	/**
	 * ���ݲ�������ȡ long �Ͳ���ֵ
	 * @param name
	 * @return
	 */
	public long getLong(String name){
		return CastUtil.castLong(paramMap.get(name));
	}
	/**
	 * ���ݲ�������ȡ Int �Ͳ���ֵ
	 * @param name
	 * @return
	 */
	public int getInt(String name){
		return CastUtil.castInt(paramMap.get(name));
	}
	/**
	 * ���ݲ�������ȡ Double �Ͳ���ֵ
	 * @param name
	 * @return
	 */
	public Double getDouble(String name){
		return CastUtil.castDouble(paramMap.get(name));
	}
	/**
	 * ���ݲ�������ȡ Boolean �Ͳ���ֵ
	 * @param name
	 * @return
	 */
	public boolean getBoolean(String name){
		return CastUtil.castBoolean(paramMap.get(name));
	}
	
	/**
	 * ���ݲ�������ȡ request
	 * @return
	 */
	public HttpServletRequest getRequest(){
		return (HttpServletRequest) paramMap.get("request");
	}
	/**
	 * ���ݲ�������ȡ response
	 * @return
	 */
	public HttpServletResponse getResponse(){
		return (HttpServletResponse) paramMap.get("response");
	}
	
	/**
	 * ��ȡ�����ֶ���Ϣ
	 * @return
	 */
	public Map<String, Object> getMap(){
		return paramMap;
	}
}
