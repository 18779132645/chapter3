package org.smart.framework.util;

import java.util.Collection;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;

/**
 * ���Ϲ�����
 * @author HP
 *
 */
public class CollectionUtil {

	/**
	 * �ж� Collection �Ƿ�Ϊ��
	 * @param collection
	 * @return
	 */
	public static boolean isEmpty(Collection<?> collection){
		return CollectionUtils.isEmpty(collection);
	}
	
	/**
	 * �ж� Collection �Ƿ�ǿ�
	 * @param collection
	 * @return
	 */
	public static boolean isNotEmpty(Collection<?> collection){
		return !isEmpty(collection);
	}
	
	/**
	 * �ж� Map �Ƿ�Ϊ��
	 * @param map
	 * @return
	 */
	public static boolean isEmpty(Map<?, ?> map){
		return MapUtils.isEmpty(map);
	}
	
	/**
	 * �ж� Map �Ƿ�ǿ�
	 * @param map
	 * @return
	 */
	public static boolean isNotEmpty(Map<?, ?> map){
		return !isEmpty(map);
	}
}
