package org.smart.framework.bean;

/**
 * 返回数据对象
 * @author HP
 *
 */
public class Data {

	/**
	 * 数据模型
	 */
	private Object model;
	private boolean success;
	private int error;
	
	public Data(){
	}
	
	public Data(boolean success){
		this.success = success;
	}
	
	public Data(Object data){
		this.model = data;
	}

	public Data error(int error){
		this.error = error;
		return this;
	}
	
	public Data data(Object data){
		this.model = data;
		return this;
	}
	
	public Object getModel() {
		return model;
	}

	public void setModel(Object model) {
		this.model = model;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public int getError() {
		return error;
	}

	public void setError(int error) {
		this.error = error;
	}
	
	
}
