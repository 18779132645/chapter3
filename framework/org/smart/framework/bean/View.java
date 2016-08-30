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
		this.model = new HashMap<String, Object>();
	}

	public View data(String key, Object value){
		this.model.put(key, value);
		return this;
	}
	
	public String getPath() {
		return path;
	}

	public Map<String, Object> getModel() {
		return model;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setModel(Map<String, Object> model) {
		this.model = model;
	}
	
	
	
}
