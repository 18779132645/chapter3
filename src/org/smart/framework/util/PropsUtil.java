package org.smart.framework.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropsUtil {

	private static final Logger logger = LoggerFactory.getLogger(PropsUtil.class);

	  public static Properties loadProps(String propsPath)
	  {
	    Properties props = new Properties();
	    InputStream is = null;
	    try {
	      if (StringUtil.isEmpty(propsPath)) {
	        throw new IllegalArgumentException();
	      }
	      String suffix = ".properties";
	      if (propsPath.lastIndexOf(suffix) == -1) {
	        propsPath = propsPath + suffix;
	      }
	      is = ClassUtil.getClassLoader().getResourceAsStream(propsPath);
	      if (is != null)
	        props.load(is);
	    }
	    catch (Exception e) {
	      logger.error("���������ļ�������", e);
	      throw new RuntimeException(e);
	    } finally {
	      try {
	        if (is != null)
	          is.close();
	      }
	      catch (IOException e) {
	        logger.error("�ͷ���Դ������", e);
	      }
	    }
	    return props;
	  }

	  public static Map<String, String> loadPropsToMap(String propsPath)
	  {
	    Map map = new HashMap();
	    Properties props = loadProps(propsPath);
	    for (String key : props.stringPropertyNames()) {
	      map.put(key, props.getProperty(key));
	    }
	    return map;
	  }

	  public static String getString(Properties props, String key)
	  {
	    String value = "";
	    if (props.containsKey(key)) {
	      value = props.getProperty(key);
	    }
	    return value;
	  }

	  public static String getString(Properties props, String key, String defalutValue)
	  {
	    String value = defalutValue;
	    if (props.containsKey(key)) {
	      value = props.getProperty(key);
	    }
	    return value;
	  }

	  public static int getNumber(Properties props, String key)
	  {
	    int value = 0;
	    if (props.containsKey(key)) {
	      value = CastUtil.castInt(props.getProperty(key));
	    }
	    return value;
	  }

	  public static int getNumber(Properties props, String key, int defaultValue)
	  {
	    int value = defaultValue;
	    if (props.containsKey(key)) {
	      value = CastUtil.castInt(props.getProperty(key));
	    }
	    return value;
	  }

	  public static boolean getBoolean(Properties props, String key)
	  {
	    return getBoolean(props, key, false);
	  }

	  public static boolean getBoolean(Properties props, String key, boolean defalutValue)
	  {
	    boolean value = defalutValue;
	    if (props.containsKey(key)) {
	      value = CastUtil.castBoolean(props.getProperty(key));
	    }
	    return value;
	  }

//	  public static Map<String, Object> getMap(Properties props, String prefix)
//	  {
//	    Map kvMap = new LinkedHashMap();
//	    Set keySet = props.stringPropertyNames();
//	    if (CollectionUtil.isNotEmpty(keySet)) {
//	      for (String key : keySet) {
//	        if (key.startsWith(prefix)) {
//	          String value = props.getProperty(key);
//	          kvMap.put(key, value);
//	        }
//	      }
//	    }
//	    return kvMap;
//	  }
}