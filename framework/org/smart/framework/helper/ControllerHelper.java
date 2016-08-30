package org.smart.framework.helper;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart.framework.annotation.Action;
import org.smart.framework.bean.Handler;
import org.smart.framework.bean.Request;
import org.smart.framework.util.ArrayUtil;
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
									Handler oldHandler = getHandler(array[0], array[1]);
									if(oldHandler == null){
										ACTION_MAP.put(new Request(array[0], array[1]), new Handler(controllerClass, method));
									}else{
										LOGGER.error("'"+oldHandler.getControllerClass()+" & "+controllerClass+"-"+array[1]+"'  this Action repeat!");
									}
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
		Handler handler = null;
		Iterator<Map.Entry<Request, Handler>> it = ACTION_MAP.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry actionEntry = (Entry) it.next();
			
			Request request = (Request) actionEntry.getKey();
			String requestMethodcurr = request.getRequestMethod();
			String requestPathcurr = request.getRequestPath();
			
			Matcher requestPathMatcher = Pattern.compile(requestPathcurr).matcher(requestPath);
			
			if((requestMethodcurr.equalsIgnoreCase(requestMethodcurr)) && requestPathMatcher.matches()){
				handler = (Handler) actionEntry.getValue();
				if(handler == null){
					handler.setRequestPathMatcher(requestPathMatcher);
				}
			}
		}
		return handler;
//		Request request = new Request(requestMethod, requestPath);
//		return ACTION_MAP.get(request);
	}
}










