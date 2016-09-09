package org.smart.framework.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.smart.framework.util.CastUtil;
import org.smart.framework.util.CollectionUtil;
import org.smart.framework.util.StringUtil;

/**
 * �����������
 * @author HP
 *
 */
public class Param {

	private List<FormParam> formParamList;
	private List<FileParam> fileParamList;
	
	private Map<String, Object> paramMap;
	
	public Param(List<FormParam> formParamList){
		this.formParamList = formParamList;
	}
	
	public Param(List<FormParam> formParamList, List<FileParam> fileParamList){
		this.formParamList = formParamList;
		this.fileParamList = fileParamList;
	}
	
	/**
	 * ��ȡ�������ӳ��
	 * @return
	 */
	public Map<String, Object> getFieldMap(){
		Map<String, Object> fieldMap = new HashMap<String, Object>();
		if(CollectionUtil.isNotEmpty(formParamList)){
			for(FormParam formParam : formParamList){
				String fieldName = formParam.getFieldName();
				Object fieldValue = formParam.getFieldValue();
				if(fieldMap.containsKey(fieldName)){
					fieldValue = fieldMap.get(fieldName) + StringUtil.SEPARATOR + fieldValue;
				}
				fieldMap.put(fieldName, fieldValue);
			}
		}
		return fieldMap;
	}
	
	/**
	 * ��ȡ�ϴ��ļ�ӳ��
	 * @return
	 */
	public Map<String, List<FileParam>> getFileMap(){
		Map<String, List<FileParam>> fileMap = new HashMap<String, List<FileParam>>();
		if(CollectionUtil.isNotEmpty(fileParamList)){
			for(FileParam fileParam : fileParamList){
				String fieldName = fileParam.getFieldName();
				List<FileParam> fileParamList;
				if(fileMap.containsKey(fieldName)){
					fileParamList = fileMap.get(fieldName);
				} else {
					fileParamList = new ArrayList<FileParam>();
				}
				fileParamList.add(fileParam);
				fileMap.put(fieldName, fileParamList);
			}
		}
		return fileMap;
	}
	
	/**
	 * ��ȡ�����ϴ��ļ�
	 * @param fieldName
	 * @return
	 */
	public List<FileParam> getFileList(String fieldName){
		return getFileMap().get(fieldName);
	}
	
	/**
	 * ��ȡΨһ�ϴ��ļ�
	 * @param fieldName
	 * @return
	 */
	public FileParam getFile(String fieldName){
		List<FileParam> fileParamList = getFileList(fieldName);
		if(CollectionUtil.isNotEmpty(fileParamList) && fileParamList.size() == 1){
			return fileParamList.get(0);
		}
		return null;
	}
	
	/**
	 * ��֤�����Ƿ�Ϊ��
	 * @return
	 */
	public boolean isEmpty(){
		return CollectionUtil.isEmpty(formParamList) && CollectionUtil.isEmpty(fileParamList);
	}
	
	/**
	 * ���ݲ�������ȡ  String �Ͳ���ֵ
	 * @param name
	 * @return
	 */
	public String getString(String name){
		return CastUtil.castString(getFieldMap().get(name));
	}
	
	public Param(Map<String, Object> paramMap){
		this.paramMap = paramMap;
	}
	
	/**
	 * ���ݲ�������ȡ long �Ͳ���ֵ
	 * @param name
	 * @return
	 */
	public long getLong(String name){
		return CastUtil.castLong(getFieldMap().get(name));
	}
	
	/**
	 * ���ݲ�������ȡ Int �Ͳ���ֵ
	 * @param name
	 * @return
	 */
	public int getInt(String name){
		return CastUtil.castInt(getFieldMap().get(name));
	}
	
	/**
	 * ���ݲ�������ȡ Double �Ͳ���ֵ
	 * @param name
	 * @return
	 */
	public Double getDouble(String name){
		return CastUtil.castDouble(getFieldMap().get(name));
	}
	
	/**
	 * ���ݲ�������ȡ Boolean �Ͳ���ֵ
	 * @param name
	 * @return
	 */
	public boolean getBoolean(String name){
		return CastUtil.castBoolean(getFieldMap().get(name));
	}
	
	/**
	 * ���ݲ�������ȡ request
	 * @return
	 */
	public HttpServletRequest getRequest(){
		return (HttpServletRequest) getFieldMap().get("request");
	}
	
	/**
	 * ���ݲ�������ȡ response
	 * @return
	 */
	public HttpServletResponse getResponse(){
		return (HttpServletResponse) getFieldMap().get("response");
	}
	
	/**
	 * ��ȡ�����ֶ���Ϣ
	 * @return
	 */
	public Map<String, Object> getMap(){
		return getFieldMap();
	}
}
