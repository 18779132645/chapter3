package org.smart.chapter3.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.smart.chapter3.bean.Student;
import org.smart.framework.annotation.Action;
import org.smart.framework.annotation.Controller;
import org.smart.framework.bean.Data;
import org.smart.framework.bean.Param;
import org.smart.framework.bean.View;

@Controller
public class test {
	
	@Action(value = "get:/indexss")
	public View index(Param param){
		return new View("MyJsp.jsp");
	}
	@Action(value = "get:/indexs")
	public View indexs(Param param){
		System.err.println("indexs");
		Map<String, String> mp = new HashMap<String, String>();
		mp.put("list", "成功表表表表表表");
		List<Student> list = new ArrayList<Student>();
		for(int i=0; i<3; i++){
			Student student = new Student();
			student.setId(33+i);
			student.setName("yangbo");
			student.setAge(89);
			list.add(student);
		}
		return new View("MyJsp.jsp").data("list", list);
	}
	
	@Action(value = "get:/data")
	public Data getData(Param param){
		Map<String, String> mp = new HashMap<String, String>();
		mp.put("list", "成功表表表表表表");
		mp.put("list1", "成功表表表表表表");
		mp.put("list2", "成功表表表表表表");
		mp.put("list3", "成功表表表表表表");
		List<Student> list = new ArrayList<Student>();
		for(int i=0; i<3; i++){
			Student student = new Student();
			student.setId(33+i);
			student.setName("yangbo");
			student.setAge(89);
			student.setRemark("");
			list.add(student);
		}
		return new Data(list);
	}
}
