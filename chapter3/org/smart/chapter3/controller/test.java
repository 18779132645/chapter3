package org.smart.chapter3.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.page.util.ChartReturnData;
import org.page.util.Chart_PageUtil;
import org.page.util.Chart_Tools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart.chapter3.bean.Student;
import org.smart.chapter3.service.BookService;
import org.smart.chapter3.service.impl.StudentServiceImpl;
import org.smart.chapter3.util.ChartWeb;
import org.smart.framework.annotation.Action;
import org.smart.framework.annotation.Controller;
import org.smart.framework.annotation.Inject;
import org.smart.framework.bean.Data;
import org.smart.framework.bean.Param;
import org.smart.framework.bean.View;

@Controller
public class test {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(test.class);
	
	@Inject
	private StudentServiceImpl StudentServiceImpl;
	
	@Inject
	private BookService bookService;
	
	@Action(value = "get:/indexss")
	public View index(Param param){
		StudentServiceImpl.getVoid();
//		bookService.test();
//		StudentServiceImpl.getStudent();
		return new View("MyJsp.jsp");
	}
	@Action(value = "get:/indexs")
	public View indexs(Param param){
		StudentServiceImpl.getStudent();
		Map<String, String> mp = new HashMap<String, String>();
		mp.put("list", "成功表表表表表表");
		List<Student> list = new ArrayList<Student>();
		for(int i=0; i<3; i++){
			Student student = new Student();
			student.setId(33+i);
			student.setName("yangbo成功表表表表表表");
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
			student.setName("yangbo成功表表表表表表");
			student.setAge(89);
			student.setRemark("");
			list.add(student);
		}
		return new Data(list);
	}
	
	@Action(value = "get:/str")
	public Data getDataStr(Param param){
		return new Data("success");
	}
	
	@Action(value = "POST:/chart")
	public Data getChart(Param param){
		HttpServletRequest request = param.getRequest();
		HttpServletResponse response = param.getResponse();
		String temp = "";
		try {  
			String[][] configure = new String[12][2];
			configure[0][0] = "table_width";  configure[0][1] = "100%";
			configure[1][0] = "table_name";  configure[1][1] = "资源名称,等级,资源类型ID,资源分类ID,图片地址";
			configure[2][0] = "sql_name";  configure[2][1] = "ResourceName,Letters,ResourceTypeID,ResourceClassID,SavePath";
			configure[3][0] = "td_width";  configure[3][1] = "15%,20%,20%,20%,20%";
			configure[4][0] = "pageSizeList";  configure[4][1] = "5,10,20,50,all";
			configure[5][0] = "rowsDisplayed";  configure[5][1] = "10";
			configure[6][0] = "toolbarContent";  configure[6][1] = "add|delete|checkbox|modify|refresh|pagejump|pagesize|status";
			configure[7][0] = "main_table";  configure[7][1] = "resource,id";
			configure[8][0] = "action_modify";  configure[8][1] = "ChartServlet?chart_update.do";
			configure[9][0] = "action_delete";  configure[9][1] = "ChartServlet?chart_delete.do";
			configure[10][0] = "is_modify";  configure[10][1] = "0,0,0,0,0";
			configure[11][0] = "linking";  configure[11][1] = "1,1,1,1,1";

			if(ChartWeb.GetInitSide(request,response,configure)){
				temp = ChartWeb.GetPageDisplayText("<%chart_config%>", "<%chart_br%>").toString()+"<%chart_table%>"+Chart_Tools.GetStringForArray(configure,"<%chart_config%>","<%chart_br%>").toString();
				System.err.println(temp);
				return new Data(temp);
			}
			int[] page = Chart_PageUtil.chart_createPage(request, StudentServiceImpl.getCount());
			String[][] result = StudentServiceImpl.getResult(page);
			temp = ChartWeb.GetStringForPage(page)+"<%chart_data%>"+Chart_Tools.GetStringForArray2(result, "<%,%>", "<%br%>")+"<%chart_data%>"+"<%Array%>";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Data(temp);
	}
}
