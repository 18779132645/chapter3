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
 * 请求参数对象
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
	 * 获取请求参数映射
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
	 * 获取上传文件映射
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
	 * 获取所有上传文件
	 * @param fieldName
	 * @return
	 */
	public List<FileParam> getFileList(String fieldName){
		return getFileMap().get(fieldName);
	}
	
	/**
	 * 获取唯一上传文件
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
	 * 验证参数是否为空
	 * @return
	 */
	public boolean isEmpty(){
		return CollectionUtil.isEmpty(formParamList) && CollectionUtil.isEmpty(fileParamList);
	}
	
	/**
	 * 根据参数名获取  String 型参数值
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
	 * 根据参数名获取 long 型参数值
	 * @param name
	 * @return
	 */
	public long getLong(String name){
		return CastUtil.castLong(paramMap.get(name));
	}
	
	/**
	 * 根据参数名获取 Int 型参数值
	 * @param name
	 * @return
	 */
	public int getInt(String name){
		return CastUtil.castInt(paramMap.get(name));
	}
	
	/**
	 * 根据参数名获取 Double 型参数值
	 * @param name
	 * @return
	 */
	public Double getDouble(String name){
		return CastUtil.castDouble(paramMap.get(name));
	}
	
	/**
	 * 根据参数名获取 Boolean 型参数值
	 * @param name
	 * @return
	 */
	public boolean getBoolean(String name){
		return CastUtil.castBoolean(paramMap.get(name));
	}
	
	/**
	 * 根据参数名获取 request
	 * @return
	 */
	public HttpServletRequest getRequest(){
		return (HttpServletRequest) paramMap.get("request");
	}
	
	/**
	 * 根据参数名获取 response
	 * @return
	 */
	public HttpServletResponse getResponse(){
		return (HttpServletResponse) paramMap.get("response");
	}
	
	/**
	 * 获取所有字段信息
	 * @return
	 */
	public Map<String, Object> getMap(){
		return paramMap;
	}
}
