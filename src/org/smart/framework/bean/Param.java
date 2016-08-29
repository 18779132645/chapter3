package org.smart.framework.bean;

import java.util.Map;

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
	 * ��ȡ�����ֶ���Ϣ
	 * @return
	 */
	public Map<String, Object> getMap(){
		return paramMap;
	}
}
