package org.smart.framework.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

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
	
	/**
	 * ������
	 * @param inputStream
	 * @param outputStream
	 */
	 public static void copyStream(InputStream inputStream, OutputStream outputStream)
	 {
		 try{
			 byte[] buffer = new byte[4 * 1024];
			 int length;
			 while ((length = inputStream.read(buffer, 0, buffer.length)) != -1) {
				 outputStream.write(buffer, 0, length);
			 }
			 outputStream.flush();
		 } catch (Exception e) {
			 LOGGER.error("copy stream failure", e);
			 throw new RuntimeException(e);
		 } finally {
			 try {
				 inputStream.close();
				 outputStream.close();
			 } catch (Exception e) {
				 LOGGER.error("close stream failure", e);
			 }
		 }
	 }
}
