package org.smart.framework.bean;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;


/**
 * 封闭请求信息
 * @author HP
 *
 */
public class Request {

	/**
	 * 请求方法
	 */
	private String requestMethod;
	
	/**
	 * 请求地址
	 */
	private String requestPath;
	
	public Request(String requestMethod, String requestPath){
		this.requestMethod = requestMethod;
		this.requestPath = requestPath;
	}
	
	public String getRequestMethod() {
		return requestMethod;
	}

	public String getRequestPath() {
		return requestPath;
	}

	public int hashCode(){
		return HashCodeBuilder.reflectionHashCode(this);
	}
	
	public boolean equals(Object obj){
		return EqualsBuilder.reflectionEquals(this, obj);
	}
}
