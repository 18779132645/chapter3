package org.smart.chapter3.service.impl;

import java.util.List;

import org.smart.chapter3.bean.Filetype;
import org.smart.chapter3.bean.Student;
import org.smart.chapter3.dto.ResourceFile;
import org.smart.framework.annotation.Aspect;
import org.smart.framework.annotation.Service;
import org.smart.framework.annotation.Transaction;
import org.smart.framework.helper.DatabaseHelper;
import org.smart.framework.proxy.TransactionProxy;

@Service
@Aspect(Transaction.class)
public class StudentServiceImpl extends TransactionProxy{

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
		return (int) DatabaseHelper.queryCount(sql, null);
	}
	@Transaction
	public String[][] getResult(int[] page){
		String sql = "SELECT id,ResourceName,Letters,ResourceTypeID,ResourceClassID,SavePath FROM resource limit "+page[0]+","+(page[1]-page[0]);
		try {
			System.err.println(8/0);
		} catch (Exception e) {
			// TODO: handle exception
//			throw new RuntimeException(e);
		}
		return DatabaseHelper.queryEntityArrays(sql, 2, null);
	}
	
	@Transaction
	public Student getStudents() {
//		try {
//			String[] result = DatabaseHelper.queryEntityArray(" SELECT * FROM filetype limit 1", null);
//			String[][] results = DatabaseHelper.queryEntityArrays(" SELECT * FROM filetype limit 10",3, null);
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		
//		List<Filetype> list = null;
//		try {
//			list = DatabaseHelper.queryEntityList(Filetype.class, " SELECT * FROM filetype ", null);
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
		Student student = new Student();
		String sql = "INSERT INTO `filetype` (`typeName`) VALUESs ('ppssÎÄ¼þ')";
		DatabaseHelper.deleteEntity(Filetype.class,40);
		DatabaseHelper.executeUpdate(sql, null);
		student.setId(100);
		return new Student();
	}

}
