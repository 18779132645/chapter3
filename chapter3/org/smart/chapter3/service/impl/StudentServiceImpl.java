package org.smart.chapter3.service.impl;

import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;
import org.smart.chapter3.bean.Filetype;
import org.smart.chapter3.bean.Student;
import org.smart.chapter3.dto.ResourceFile;
import org.smart.framework.annotation.Service;
import org.smart.framework.annotation.Transaction;
import org.smart.framework.helper.DatabaseHelper;

@Service
public class StudentServiceImpl {

	public void getVoid(){
		List<ResourceFile> list1 = null;
		try {
			String sql = " SELECT resource.id,ResourceName,Letters,ResourceTypeID,ResourceClassID,filetype.typeName,SavePath "+ 
					" FROM resource,filetype "+
					" WHERE resource.FileType=filetype.id ";
			list1 = DatabaseHelper.queryEntityList(ResourceFile.class, sql, null);
			System.err.println("resource:"+list1.size());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public int getCount(){
		String sql = "SELECT count(*) FROM resource ";
		return DatabaseHelper.queryCount(sql, null);
	}
	public String[][] getResult(int[] page){
		String sql = "SELECT id,ResourceName,Letters,ResourceTypeID,ResourceClassID,SavePath FROM resource limit "+page[0]+","+(page[1]-page[0]);
		return DatabaseHelper.queryEntityArrays(sql, 2, null);
	}
	
	@Transaction
	public Student getStudent() {
		try {
			String[] result = DatabaseHelper.queryEntityArray(" SELECT * FROM filetype limit 1", null);
			for(int i=0; i<result.length; i++){
				System.err.print(result[i]+"   ");
			}
			System.err.println();
			System.err.println("------------------------");
			String[][] results = DatabaseHelper.queryEntityArrays(" SELECT * FROM filetype limit 10",3, null);
			for(int i=0; i<results.length; i++){
				for(int j=0; j<results[i].length; j++){
					System.err.print(results[i][j]+"   ");
				}
				System.err.println();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		List<Filetype> list = null;
		try {
			list = DatabaseHelper.queryEntityList(Filetype.class, " SELECT * FROM filetype ", null);
			System.err.println("filetype:"+list.size());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new Student();
	}

}
