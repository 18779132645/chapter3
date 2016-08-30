package org.smart.framework.util;

import java.util.Collection;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;

/**
 * 集合工具类
 * @author HP
 *
 */
public class CollectionUtil {

	/**
	 * 判断 Collection 是否为空
	 * @param collection
	 * @return
	 */
	public static boolean isEmpty(Collection<?> collection){
		return CollectionUtils.isEmpty(collection);
	}
	
	/**
	 * 判断 Collection 是否非空
	 * @param collection
	 * @return
	 */
	public static boolean isNotEmpty(Collection<?> collection){
		return !isEmpty(collection);
	}
	
	/**
	 * 判断 Map 是否为空
	 * @param map
	 * @return
	 */
	public static boolean isEmpty(Map<?, ?> map){
		return MapUtils.isEmpty(map);
	}
	
	/**
	 * 判断 Map 是否非空
	 * @param map
	 * @return
	 */
	public static boolean isNotEmpty(Map<?, ?> map){
		return !isEmpty(map);
	}
}
