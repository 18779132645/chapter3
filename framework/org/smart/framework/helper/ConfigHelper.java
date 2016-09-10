package org.smart.framework.helper;

import java.util.Properties;

import org.smart.framework.ConfigConstant;
import org.smart.framework.util.PropsUtil;

import com.sun.corba.se.impl.orb.ORBConfiguratorImpl.ConfigParser;

/**
 * 属性文件助手类
 * @author HP
 *
 */
public final class ConfigHelper {

	private static final Properties CONFIG_PROPS = PropsUtil.loadProps(ConfigConstant.CONFIG_FILE);
	
	/**
	 * 获取JDBC驱动
	 * @return
	 */
	public static String getJdbcDriver(){
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_DRIVER);
	}
	
	/**
	 * 获取JDBC URL
	 * @return
	 */
	public static String getJdbcUrl(){
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_URL);
	}
	
	/**
	 * 获取 JDBC USERNAME
	 * @return
	 */
	public static String getJdbcUsername(){
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_USERNAME);
	}
	
	/**
	 * 获取　JDBC PASSWORD
	 * @return
	 */
	public static String getJdbcPassword(){
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_PASSWORD);
	}
	
	/**
	 * 获取应用基础包名
	 * @return
	 */
	public static String getAppBasePackage(){
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_BASE_PACKAGE);
	}
	
	/**
	 * 获取应用 JSP 路径
	 * @return
	 */
	public static String getAppJspPath(){
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_JSP_PATH, "/WEB-INF/");
	}
	
	/**
	 * 获取应用静态资源路径
	 * @return
	 */
	public static String getAppAssetPath(){
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_ASSET_PATH, "/WEB-INF/");
	}
	
	/**
	 * 获取应用文件上传限制
	 * @return
	 */
	public static int getAppUploadLimit(){
		return PropsUtil.getNumber(CONFIG_PROPS, ConfigConstant.APP_UPLOAD_LIMIT, 10);
	}
	
	/**
	 * 获取应用项目的默认文件
	 * @return
	 */
	public static String getAppDefaultPage(){
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_DEFAULT_PAGE);
	}
	/**
	 * 获取项目编码
	 * @return
	 */
	public static String getAppCoding(){
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.App_Coding, "UTF-8");
	}
}







