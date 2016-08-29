package org.smart.framework.helper;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart.framework.annotation.Action;
import org.smart.framework.bean.Handler;
import org.smart.framework.bean.Request;
import org.smart.framework.util.ArrayUtil;
import org.smart.framework.util.ClassUtil;
import org.smart.framework.util.CollectionUtil;

/**
 * 控制器助手类
 * @author HP
 *
 */
public final class ControllerHelper {

	private static final Logger LOGGER = LoggerFactory.getLogger(ControllerHelper.class);
	/**
	 * 用于存放请求与处理器的映射关系
	 */
	private static final Map<Request, Handler> ACTION_MAP = new HashMap<Request, Handler>();
	
	static {
		Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
		if(CollectionUtil.isNotEmpty(controllerClassSet)){
			for(Class<?> controllerClass : controllerClassSet){
				Method[] methods = controllerClass.getDeclaredMethods();
				if(ArrayUtil.isNotEmpty(methods)){
					for(Method method : methods){
						if(method.isAnnotationPresent(Action.class)){
							Action action = method.getAnnotation(Action.class);
							String mapping = action.value();
							if(mapping.matches("\\w+:/\\w*")){
								String[] array = mapping.split(":");
								if(ArrayUtil.isNotEmpty(array) && array.length == 2){
									String requestMethod = array[0];
									String requestPath = array[1];
									Request request = new Request(requestMethod, requestPath);
									Handler handler = new Handler(controllerClass, method);
									ACTION_MAP.put(request, handler);
									LOGGER.info("|request"+request+"      handler"+handler);
								}
							}
						}
					}
				}
			}
		}
	}
	
	/**
	 * 获取 Handler
	 * @param requestMethod
	 * @param requestPath
	 * @return
	 */
	public static Handler getHandler(String requestMethod, String requestPath){
		Request request = new Request(requestMethod, requestPath);
		return ACTION_MAP.get(request);
	}
}










