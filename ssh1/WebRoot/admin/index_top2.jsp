<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新浪新闻</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/admin.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript">
	 
	String datetime=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()); //获取系统时间  

	</script>
  </head>
  
  <body>
  <div class="head">
  	<div class="head_ul">
  	<ul>
  	
  	<li>欢迎你:<s:property value="#session.admin.LoginName"/></li>
  	<li><%=new SimpleDateFormat("yyyy-MM-dd  hh:mm").format(Calendar.getInstance().getTime()) %></li>
  	<li><a href="out">退出</a></li>
  	</ul>
  	</div>
  </div>
  <div id="header">
    <div id="nav">
    
	  <table>
	    <tr>
	    	<td><div id="logo"><a href="index2?pager.curPage=1&newsinfo.topic.id="><img src="Images/logo.jpg" alt="新闻" /> </a> </div></td>
	    	<td><img src="Images/logo1.png" alt="" style="height: 94px; width: 759px; "/></td>
	    </tr>
	  </table>
    <!--mainnav end-->
  </div>
  </div>
  </body>
</html>
