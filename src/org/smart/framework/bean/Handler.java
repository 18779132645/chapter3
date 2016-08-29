package org.smart.framework.bean;

import java.lang.reflect.Method;

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
	
}
