package org.smart.framework;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.smart.framework.bean.Data;
import org.smart.framework.bean.Handler;
import org.smart.framework.bean.Param;
import org.smart.framework.bean.View;
import org.smart.framework.helper.BeanHelper;
import org.smart.framework.helper.ConfigHelper;
import org.smart.framework.helper.ControllerHelper;
import org.smart.framework.util.ArrayUtil;
import org.smart.framework.util.CodecUtil;
import org.smart.framework.util.JsonUtil;
import org.smart.framework.util.ReflectionUtil;
import org.smart.framework.util.StreamUtil;
import org.smart4j.framework.util.StringUtil;

/**
 * 请求转发器
 * @author HP
 *
 */
@WebServlet(urlPatterns = "/*", loadOnStartup = 0)
public class DispatcherServlet extends HttpServlet {

	public void init(ServletConfig servletConfig) throws ServletException{
		HelperLoader.init();
		ServletContext servletContext = servletConfig.getServletContext();
		ServletRegistration jspServlet = servletContext.getServletRegistration("jsp");
		jspServlet.addMapping(ConfigHelper.getAppJspPath() + "*");
		ServletRegistration defaultServlet = servletContext.getServletRegistration("default");
		defaultServlet.addMapping(ConfigHelper.getAppAssetPath() + "*");
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//获取请求方法与路径
		String requestMethod = request.getMethod().toLowerCase();
		String requestPath = request.getPathInfo();
		//获取ACTION处理器
		Handler handler = ControllerHelper.getHandler(requestMethod, requestPath);
		if(handler != null){
			//获取 Controller 类及其 Bean 应用 
			Class<?> controllerClass = handler.getControllerClass();
			Object controllerBean = BeanHelper.getBean(controllerClass);
			//创建请求参数对象
			Map<String, Object> paramMap = new HashMap<String, Object>();
			Enumeration<String> paramNames = request.getParameterNames();
			while (paramNames.hasMoreElements()) {
				String paramName = paramNames.nextElement();
				String paramValue = request.getParameter(paramName);
				paramMap.put(paramName, paramValue);
			}
			String boby = CodecUtil.decodeURL(StreamUtil.getString(request.getInputStream()));
			if(StringUtil.isNotEmpty(boby)){
				String[] params = StringUtil.splitString(boby, "&");
				if(ArrayUtil.isNotEmpty(params)){
					for(String param : params){
						String[] array = StringUtil.splitString(param, "=");
						if(ArrayUtil.isNotEmpty(array)){
							String paramName = array[0];
							String paramValue = array[1];
							paramMap.put(paramName, paramValue);
						}
					}
				}
			}
			Param param = new Param(paramMap);
			Method actionMethod = handler.getActionMethod();
			Object result = ReflectionUtil.invokeMethod(controllerBean, actionMethod, param);
			if(result instanceof View){
				View view = (View) result;
				String path = view.getPath();
				if(StringUtil.isNotEmpty(path)){
					if(path.startsWith("/")){
						response.sendRedirect(request.getContextPath() + path);
					}else{
						Map<String, Object> model = view.getModel();
						for(Map.Entry<String, Object>entry:model.entrySet()){
							request.setAttribute(entry.getKey(), entry.getValue());
						}
						request.getRequestDispatcher(ConfigHelper.getAppJspPath() + path).forward(request, response);
					}
				}else if(result instanceof Data){
					Data data = (Data) result;
					Object model = data.getModel();
					if(model != null){
						response.setContentType("applicatioin/json");
						response.setCharacterEncoding("UTF-8");
						PrintWriter writer = response.getWriter();
						String json = JsonUtil.toJson(model);
						writer.write(json);
						writer.flush();
						writer.close();
					}
				}
			}
		}
	}
}








