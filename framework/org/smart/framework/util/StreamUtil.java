package org.smart.framework.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ������������
 * @author HP
 *
 */
public final class StreamUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(StreamUtil.class);
	
	/**
	 * ���������л�ȡ�ַ���
	 * @param is
	 * @return
	 */
	public static String getString(InputStream is){
		StringBuilder sb = new StringBuilder();
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			String line;
			while((line = reader.readLine()) != null){
				sb.append(line);
			}
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error("get string failure", e);
			throw new RuntimeException(e);
		}
		return sb.toString();
	}
}
