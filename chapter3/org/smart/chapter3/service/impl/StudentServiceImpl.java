package org.smart.chapter3.service.impl;

import org.smart.chapter3.bean.Student;
import org.smart.framework.annotation.Service;

@Service
public class StudentServiceImpl {

	public Student getStudent() {
		System.err.println("getStudent");
		return new Student();
	}

}
