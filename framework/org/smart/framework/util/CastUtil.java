package org.smart.framework.util;

/**
 * 转型操作工具类
 * @author HP
 *
 */
public final class CastUtil {

	public static String castString(Object obj, String defaultValue){
		return obj != null ? String.valueOf(obj) : defaultValue;
	}
	
	public static String castString(Object obj){
		return castString(obj, "");
	}
	
	public static double castDouble(Object obj, double defaultValue){
		double doubleValue = defaultValue;
		if(obj != null){
			String strValue = castString(obj);
			if(StringUtil.isNotEmpty(strValue)){
				try {
					doubleValue = Double.parseDouble(strValue);
				} catch (NumberFormatException e) {
					// TODO: handle exception
					doubleValue = defaultValue;
				}
			}
		}
		return doubleValue;
	}
	
	public static double castDouble(Object obj){
		return CastUtil.castDouble(obj, 0);
	}
	
	
	
	public static long castLong(Object obj, long defaultValue){
		long longValue = defaultValue;
		if(obj != null){
			String strValue = castString(obj);
			if(StringUtil.isNotEmpty(strValue)){
				try {
					longValue = Long.parseLong(strValue);
				} catch (NumberFormatException e) {
					// TODO: handle exception
					longValue = defaultValue;
				}
			}
		}
		return longValue;
	}
	
	public static long castLong(Object obj){
		return CastUtil.castLong(obj, 0);
	}
	
	
	
	public static int castInt(Object obj, int defaultValue){
		int intValue = defaultValue;
		if(obj != null){
			String strValue = castString(obj);
			if(StringUtil.isNotEmpty(strValue)){
				try {
					intValue = Integer.parseInt(strValue);
				} catch (NumberFormatException e) {
					// TODO: handle exception
					intValue = defaultValue;
				}
			}
		}
		return intValue;
	}
	
	public static int castInt(Object obj){
		return CastUtil.castInt(obj, 0);
	}
	
	
	
	public static boolean castBoolean(Object obj, boolean defaultValue){
		boolean booleanValue = defaultValue;
		if(obj != null){
			booleanValue = Boolean.parseBoolean(castString(obj));
		}
		return booleanValue;
	}
	
	public static boolean castBoolean(Object obj){
		return CastUtil.castBoolean(obj, false);
	}
}

