package org.smart.framework.util;

import java.net.URLDecoder;
import java.net.URLEncoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ������������������
 * @author HP
 *
 */
public final class CodecUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(CodecUtil.class);
	
	/**
	 * �� URL ����
	 * @param source
	 * @return
	 */
	public static String encodeURL(String source){
		String target;
		try {
			target = URLEncoder.encode(source, "UTF-8");
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error("encode url failure", e);
			throw new RuntimeException(e);
		}
		return target;
	}
	
	/**
	 * �� URL ����
	 * @param source
	 * @return
	 */
	public static String decodeURL(String source){
		String target;
		try {
			target = URLDecoder.decode(source, "UTF-8");
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error("decode url failure", e);
			throw new RuntimeException(e);
		}
		return target;
	}
}
