package org.smart.framework.util;

import org.apache.commons.lang.ArrayUtils;


/**
 * ���鹤����
 * @author HP
 *
 */
public class ArrayUtil {

	/**
	 * �ж�����Ϊ�Ƿ�Ϊ�ǿ�
	 * @param array
	 * @return
	 */
	public static boolean isNotEmpty(Object[] array){
		return !ArrayUtils.isEmpty(array);
	}
	
	/**
	 * �ж�����Ϊ�Ƿ�Ϊ��
	 * @param array
	 * @return
	 */
	public static boolean isEmpty(Object[] array){
		return ArrayUtils.isEmpty(array);
	}
}
