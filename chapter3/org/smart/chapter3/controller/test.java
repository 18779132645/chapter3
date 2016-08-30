package org.smart.chapter3.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.smart.chapter3.bean.Student;
import org.smart.chapter3.service.BookService;
import org.smart.chapter3.service.impl.StudentServiceImpl;
import org.smart.framework.annotation.Action;
import org.smart.framework.annotation.Controller;
import org.smart.framework.annotation.Inject;
import org.smart.framework.bean.Data;
import org.smart.framework.bean.Param;
import org.smart.framework.bean.View;

@Controller
public class test {
	
	@Inject
	private StudentServiceImpl StudentServiceImpl;
	
	@Inject
	private BookService bookService;
	
	@Action(value = "get:/indexss")
	public View index(Param param){
		bookService.test();
		StudentServiceImpl.getStudent();
		return new View("MyJsp.jsp");
	}
	@Action(value = "get:/indexs")
	public View indexs(Param param){
		HttpServletRequest request = (HttpServletRequest) param.getMap().get("request");
		System.err.println(request);
//		System.err.println(StudentServiceImpl);
		Map<String, String> mp = new HashMap<String, String>();
		mp.put("list", "�ɹ��������");
		List<Student> list = new ArrayList<Student>();
		for(int i=0; i<3; i++){
			Student student = new Student();
			student.setId(33+i);
			student.setName("yangbo�ɹ��������");
			student.setAge(89);
			list.add(student);
		}
		return new View("MyJsp.jsp").data("list", list);
	}
	
	@Action(value = "get:/data")
	public Data getData(Param param){
		Map<String, String> mp = new HashMap<String, String>();
		mp.put("list", "�ɹ��������");
		mp.put("list1", "�ɹ��������");
		mp.put("list2", "�ɹ��������");
		mp.put("list3", "�ɹ��������");
		List<Student> list = new ArrayList<Student>();
		for(int i=0; i<3; i++){
			Student student = new Student();
			student.setId(33+i);
			student.setName("yangbo�ɹ��������");
			student.setAge(89);
			student.setRemark("");
			list.add(student);
		}
		return new Data(list);
	}
}
