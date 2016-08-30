package org.smart.framework.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart.framework.bean.Handler;
import org.smart.framework.bean.Param;
import org.smart.framework.helper.BeanHelper;

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
	public static Object invokeMethod(Handler handler, Param param){
		Object result = null;
		try {
            result = handler.getActionMethod().invoke(BeanHelper.getBean(handler.getControllerClass()), param);
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











