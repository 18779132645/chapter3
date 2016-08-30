package org.smart.framework.helper;

import java.lang.reflect.Field;
import java.util.Map;

import org.smart.framework.annotation.Impl;
import org.smart.framework.annotation.Inject;
import org.smart.framework.util.ArrayUtil;
import org.smart.framework.util.CollectionUtil;
import org.smart.framework.util.ReflectionUtil;

/**
 * “¿¿µ◊¢»Î÷˙ ÷¿‡
 * @author HP
 *
 */
public final class IocHelper {

	static {
		Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
		if(CollectionUtil.isNotEmpty(beanMap)){
			for(Map.Entry<Class<?>, Object> beanEntry : beanMap.entrySet()){
				Class<?> beanClass = beanEntry.getKey();
				Object beanInstance = beanEntry.getValue();
				Field[] beanFields = beanClass.getDeclaredFields();
				if(ArrayUtil.isNotEmpty(beanFields)){
					for(Field beanField : beanFields){
						if(beanField.isAnnotationPresent(Inject.class)){
							Class<?> beanFieldClass = beanField.getType();
							if(beanFieldClass.isAnnotationPresent(Impl.class)){
								beanFieldClass = beanFieldClass.getAnnotation(Impl.class).value();
							}
							Object beanFieldInstance = beanMap.get(beanFieldClass);
							if(beanFieldInstance != null){
								ReflectionUtil.setField(beanInstance, beanField, beanFieldInstance);
							}
						}
					}
				}
			}
		}
	}
}
