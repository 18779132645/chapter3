package org.smart.framework.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * ������ͼ����
 * @author HP
 *
 */
public class View {

	/**
	 * ��ͼ·��
	 */
	private String path;
	
	/**
	 * ����ģ��
	 */
	private Map<String, Object> model;
	
	public View (String path){
		this.path = path;
		model = new HashMap<String, Object>();
	}

	public String getPath() {
		return path;
	}

	public Map<String, Object> getModel() {
		return model;
	}
	
	
	
}
