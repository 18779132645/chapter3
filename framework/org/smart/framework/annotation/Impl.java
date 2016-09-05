package org.smart.framework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * �ӿ���ע��
 * @author HP
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Impl {

	/**
	 * ע������,ʵ�ָ��������
	 * @return
	 */
	public abstract Class<?> value();
}
