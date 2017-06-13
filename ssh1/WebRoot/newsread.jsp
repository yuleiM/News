<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="index_top.jsp" />
  <div id="container">
  <s:action name="indexsidebar" namespace="/" executeResult="true"/>
    <div class="main">
	    <div class="class_type"> <img src="Images/news_logo.png" alt="新闻中心" /></div> 
	    <div class="content">
	      <ul class="class_topic">
	      	<li id='class_tp'>    
	      	 <!-- 循环显示主题列表 -->  	
	      	 <s:iterator id="topic" value="#request.topicList">
	      	 	<a href="index?newsinfo.topic.id=${topic.id}"><b>${topic.name}</b></a>
	      	 </s:iterator>
	      </ul>
	      
	    <table width="80%" align="center">
	    <tr width="100%">
	    	<td colspan="2" align="center" style="font-size: 15px">${newsinfo.title}</td>
	    </tr>
	    <tr>
	    	<td colspan="2"><hr /></td>
	    </tr>
	    <tr>
	    <td align="center" style="font-size: 12px">
	    作者：${newsinfo.author}&nbsp;&nbsp;
	    类型：<a href="index?newsinfo.topic.id=${newsinfo.topic.id }&pager.curPage=1">${newsinfo.topic.name}</a>
	发布时间：${newsinfo.createDate}	    
	    </td>
	    </tr>
	    <tr>
	    	<td align="left" style="font-size: 12px"><strong>摘要：${newsinfo.summary}</strong></td>
	    </tr>
	    <tr>
	    	<td colspan="2" align="center"></td>
	    </tr>
	    <tr>
	    	<td colspan="2" style="font-size: 12px">${newsinfo.content}</td>
	    </tr>
	    </table>
	   
	    
		  </div>
    </div>
    </div>
    