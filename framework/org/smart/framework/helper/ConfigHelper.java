package org.smart.framework.helper;

import java.util.Properties;

import org.smart.framework.ConfigConstant;
import org.smart.framework.util.PropsUtil;

import com.sun.corba.se.impl.orb.ORBConfiguratorImpl.ConfigParser;

/**
 * �����ļ�������
 * @author HP
 *
 */
public final class ConfigHelper {

	private static final Properties CONFIG_PROPS = PropsUtil.loadProps(ConfigConstant.CONFIG_FILE);
	
	/**
	 * ��ȡJDBC����
	 * @return
	 */
	public static String getJdbcDriver(){
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_DRIVER);
	}
	
	/**
	 * ��ȡJDBC URL
	 * @return
	 */
	public static String getJdbcUrl(){
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_URL);
	}
	
	/**
	 * ��ȡ JDBC USERNAME
	 * @return
	 */
	public static String getJdbcUsername(){
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_USERNAME);
	}
	
	/**
	 * ��ȡ��JDBC PASSWORD
	 * @return
	 */
	public static String getJdbcPassword(){
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_PASSWORD);
	}
	
	/**
	 * ��ȡӦ�û�������
	 * @return
	 */
	public static String getAppBasePackage(){
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_BASE_PACKAGE);
	}
	
	/**
	 * ��ȡӦ�� JSP ·��
	 * @return
	 */
	public static String getAppJspPath(){
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_JSP_PATH, "/WEB-INF/");
	}
	
	/**
	 * ��ȡӦ�þ�̬��Դ·��
	 * @return
	 */
	public static String getAppAssetPath(){
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_ASSET_PATH, "/WEB-INF/");
	}
	
	/**
	 * ��ȡӦ���ļ��ϴ�����
	 * @return
	 */
	public static int getAppUploadLimit(){
		return PropsUtil.getNumber(CONFIG_PROPS, ConfigConstant.APP_UPLOAD_LIMIT, 10);
	}
	
	/**
	 * ��ȡӦ����Ŀ��Ĭ���ļ�
	 * @return
	 */
	public static String getAppDefaultPage(){
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_DEFAULT_PAGE);
	}
	/**
	 * ��ȡ��Ŀ����
	 * @return
	 */
	public static String getAppCoding(){
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.App_Coding, "UTF-8");
	}
}







