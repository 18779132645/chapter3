package org.smart.chapter3.controller;

import org.smart.framework.annotation.Action;
import org.smart.framework.annotation.Controller;
import org.smart.framework.bean.View;

@Controller(value = "test")
public class test {
	
	@Action(value = "get:/index")
	public View index(){
		System.err.println("ddddddddddddddd");
		return new View("MyJsp.jsp");
	}
	@Action(value = "get:/indexs")
	public View indexs(){
		System.err.println("ddddddddddddddd");
		return new View("MyJsp.jsp");
	}
}
