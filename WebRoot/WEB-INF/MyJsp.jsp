<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="asset/Ajax.js"></script>
<script type="text/javascript">
function test(){
	var str = CreateAndSendXMLHttp('data');
	alert(str)
}
</script>
  </head>
  
  <body>
    <a href="javascript:test()">This is my JSP  </a> pageMyJsp.jspMyJsp.jspMyJsp.jspMyJsp.jspMyJsp.jspMyJsp.jsp. <br>
    id:${ list[0].id }&nbsp;&nbsp;&nbsp;
    name:${ list[0].name }&nbsp;&nbsp;&nbsp;
    age:${ list[0].age }&nbsp;&nbsp;&nbsp;
    remark:${ list[0].remark }<br/>
    
    id:${ list[1].id }&nbsp;&nbsp;&nbsp;
    name:${ list[1].name }&nbsp;&nbsp;&nbsp;
    age:${ list[1].age }&nbsp;&nbsp;&nbsp;
    remark:${ list[1].remark }<br/>
  </body>
</html>
