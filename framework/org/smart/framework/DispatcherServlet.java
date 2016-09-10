package org.smart.framework;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart.chapter3.bean.Filetype;
import org.smart.framework.bean.Data;
import org.smart.framework.bean.Handler;
import org.smart.framework.bean.Param;
import org.smart.framework.bean.View;
import org.smart.framework.exception.AccessException;
import org.smart.framework.exception.PermissionException;
import org.smart.framework.helper.BeanHelper;
import org.smart.framework.helper.ConfigHelper;
import org.smart.framework.helper.ControllerHelper;
import org.smart.framework.helper.RequestHelper;
import org.smart.framework.helper.ServletHelper;
import org.smart.framework.helper.UploadHelper;
import org.smart.framework.util.ReflectionUtil;
import org.smart.framework.util.StringUtil;
import org.smart.framework.util.WebUtil;

/**
 * 请求转发器
 * @author HP
 *
 */
@WebServlet(urlPatterns = "/*", loadOnStartup = 0)
public class DispatcherServlet extends HttpServlet {

	private static final Logger LOGGER = LoggerFactory.getLogger(DispatcherServlet.class);
	  
	public void init(ServletConfig servletConfig) throws ServletException{
		HelperLoader.init();
		
		ServletContext servletContext = servletConfig.getServletContext();
		
		ServletRegistration jspServlet = servletContext.getServletRegistration("jsp");
		jspServlet.addMapping(ConfigHelper.getAppJspPath() + "*");
		
		ServletRegistration defaultServlet = servletContext.getServletRegistration("default");
		defaultServlet.addMapping(ConfigHelper.getAppAssetPath() + "*");
		
		UploadHelper.init(servletContext);
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ServletHelper.init(request, response);
		try {
			request.setCharacterEncoding(ConfigHelper.getAppCoding());
			//获取请求方法与路径
			String requestMethod = request.getMethod().toLowerCase();
			String requestPath = WebUtil.getRequestPath(request);
			LOGGER.debug("[Smart] {}:{}", requestMethod, requestPath);
			
			if(requestPath.equals("/favicon.ico")){
				return;
			}else if("/".equals(requestPath)){
				WebUtil.redirectRequest("/"+ConfigHelper.getAppDefaultPage(), request, response);
				return;
			}else if(requestPath.endsWith("/")){
				requestPath = requestPath.substring(0, requestPath.length() - 1);
			}
			//获取ACTION处理器
			Handler handler = ControllerHelper.getHandler(requestMethod, requestPath);
			if(handler != null){
				Class<?> controllerClass = handler.getControllerClass();
				Object controllerBean = BeanHelper.getBean(controllerClass);
				
				Param param;
				if(UploadHelper.isMultipart(request)){
					param = UploadHelper.createParam(request);
				}else{
					param = RequestHelper.createParam(request);
				}
				Method actionMethods = handler.getActionMethod();
				Class<?>[] CLASS_SET = actionMethods.getParameterTypes();
				Object[] obj = new Object[actionMethods.getParameterTypes().length];
				for(int i=0; i<CLASS_SET.length; i++){
					if(CLASS_SET[i].getName().endsWith("Param")){
						obj[i] = param;
					}else{
						obj[i] = new Filetype();
					}
				}
				for(int i=0; i<obj.length; i++){
					System.err.println(obj[i]);
				}
				
				Object result = ReflectionUtil.invokeMethod(controllerBean, handler.getActionMethod(), obj);
				handleActionMethodReturn(request, response, result);
			}else{
				WebUtil.sendError(404, "", response);
				return;
			}
		} catch (Exception e) {
			// TODO: handle exception
			handleActionException(request, response, e);
		} finally{
			ServletHelper.destroy();
		}
		return;
	}
	
	private void handleActionMethodReturn(HttpServletRequest request, HttpServletResponse response, Object result){
		if(result != null){
			if(result instanceof Data){
				Object model = ((Data) result).getModel();
				if(UploadHelper.isMultipart(request)){
					WebUtil.writeHTML(response, model);
				}else{
					WebUtil.writeJSON(response, model);
				}
			}else if(result instanceof View){
				View view = (View) result;
				String path = view.getPath();
				if(StringUtil.isNotEmpty(path)){
					if(path.startsWith("redirect:")){
						path = path.substring(9, path.length());
						if(path.startsWith("/")){
							WebUtil.redirectRequest(ConfigHelper.getAppJspPath() + path.substring(1,path.length()), request, response);
						}else{
							WebUtil.forwardRequest(path, request, response);
						}
					}else{
						Map<String, Object> model = view.getModel();
						for(Map.Entry<String, Object>entry : model.entrySet()){
							request.setAttribute(entry.getKey(), entry.getValue());
						}
						WebUtil.forwardRequest(ConfigHelper.getAppJspPath() + path, request, response);
					}
				}
			}
		}
	}
	
	private void handleActionException(HttpServletRequest request, HttpServletResponse response, Exception e){
		Throwable cause = e.getCause();
		if(cause instanceof AccessException){
			if(WebUtil.isAJAX(request)){
				WebUtil.sendError(403, "", response);
			}else{
				WebUtil.redirectRequest(ConfigHelper.getAppDefaultPage(), request, response);
			}
		}else if(cause instanceof PermissionException){
			WebUtil.sendError(403, "", response);
		}else{
			LOGGER.error("execute action failure");
			WebUtil.sendError(500, cause.getMessage(), response);
		}
	}
}








