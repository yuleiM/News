<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
	<link href="css/main.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript">
	 
	String datetime=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()); //获取系统时间  

	</script>
  </head>
  
  <body>
  <div class="head">
  	<div class="head_ul">
  	<ul>
  	<li><a href="login.html">管理员登陆</a></li>
  	<li><%=new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss").format(Calendar.getInstance().getTime()) %></li>
  	</ul>
  	</div>
  </div>
  <div id="header">
    <div id="nav">
    
	  <table>
	    <tr>
	    	<td><div id="logo"><a href="index?pager.curPage=1&newsinfo.topic.id="><img src="Images/logo.jpg" alt="新闻" /> </a> </div></td>
	    	<td><img src="Images/logo1.png" alt="" style="height: 94px; width: 759px; "/></td>
	    </tr>
	  </table>
    <!--mainnav end-->
  </div>
  </div>
  </body>
</html>
