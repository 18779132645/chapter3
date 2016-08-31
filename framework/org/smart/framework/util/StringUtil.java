package org.smart.framework.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;


/**
 * ×Ö·û´®²Ù×÷Àà
 * @author HP
 *
 */
public class StringUtil {

	public static boolean isEmpty(String str){
		if(str != null){
			str = str.trim();
		}
		return StringUtils.isEmpty(str);
	}
	
	public static boolean isNotEmpty(String str){
		return !isEmpty(str);
	}
	
	public static String defaultIfEmpty(String str, String defaultValue){
		return StringUtils.defaultIfEmpty(str, defaultValue);
	}
	
	public static String replaceAll(String str, String regex, String replacement){
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		StringBuffer sb = new StringBuffer();
		while(m.find()){
			m.appendReplacement(sb, replacement);
		}
		return sb.toString();
	}
	
	public static boolean isNumber(String str){
		return NumberUtils.isNumber(str);
	}
	
	public static boolean isDigits(String str){
		return NumberUtils.isDigits(str);
	}
	
	public static String[] splitString(String str, String separator)
	{
		return StringUtils.splitByWholeSeparator(str, separator);
	}
}
