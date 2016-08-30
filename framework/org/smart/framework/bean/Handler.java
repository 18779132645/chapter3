package org.smart.framework.bean;

import java.lang.reflect.Method;
import java.util.regex.Matcher;

/**
 * ��װaction��Ϣ
 * @author HP
 *
 */
public class Handler {

	/**
	 * controller ��
	 */
	private Class<?> controllerClass;
	
	/**
	 * action����
	 */
	private Method actionMethod;
	
	private Matcher requestPathMatcher;
	
	public Handler(Class<?> controllerClass, Method actionMethod){
		this.controllerClass = controllerClass;
		this.actionMethod = actionMethod;
	}

	public Class<?> getControllerClass() {
		return controllerClass;
	}

	public Method getActionMethod() {
		return actionMethod;
	}

	public Matcher getRequestPathMatcher() {
		return requestPathMatcher;
	}

	public void setRequestPathMatcher(Matcher requestPathMatcher) {
		this.requestPathMatcher = requestPathMatcher;
	}
	
}
