package org.smart.framework.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ���乤���� 
 * @author HP
 *
 */
public final class ReflectionUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(ReflectionUtil.class);
	
	/**
	 * ����ʵ��
	 * @param cls
	 * @return
	 */
	public static Object newInstance(Class<?> cls){
		Object instance;
		try {
			instance = cls.newInstance();
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error("new instance failure", e);
			throw new RuntimeException(e);
		}
		return instance;
	}
	
	/**
	 * ���÷���
	 * @param obj
	 * @param method
	 * @param args
	 * @return
	 */
	public static Object invokeMethod(Object obj, Method method, Object...args){
		Object result;
		try {
			method.setAccessible(true);
			result = method.invoke(obj, args);
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error("invoke method failure", e);
			throw new RuntimeException(e);
		}
		return result;
	}
	
	/**
	 * ���ó�Ա������ֵ
	 * @param obj
	 * @param field
	 * @param value
	 */
	public static void setField(Object obj, Field field, Object value){
		try {
			field.setAccessible(true);
			field.set(obj, value);
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error("set field failure", e);
			throw new RuntimeException(e);
		}
	}
	
}












