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
	    
	     <ul class="class_info"> 
        <!-- 循环显示当前页新闻列表 -->     
        <s:iterator id="news" value="#request.newsinfoList">
            <li><a href="newsread?id=${news.id}"> ${news.title} </a>
      	    <span> ${news.createDate}</span></li>
        </s:iterator>     
	
    <s:if test="pager.curPage>1">
            <p align="center">
			    <a href='index?pager.curPage=1&newsinfo.topic.id=${requestScope.newsinfo.topic.id}'>首页</a>
			    <a href='index?pager.curPage=${pager.curPage-1 }&newsinfo.topic.id=${requestScope.newsinfo.topic.id}'>上一页</a>
		    </p>
		</s:if>		
		
		<s:if test="pager.curPage < pager.pageCount">
		  <p align="center">
			<a href='index?pager.curPage=${pager.curPage+1}&newsinfo.topic.id=${requestScope.newsinfo.topic.id}'>下一页</a>
			<a href='index?pager.curPage=${pager.pageCount }&newsinfo.topic.id=${requestScope.newsinfo.topic.id}'>尾页</a>
		  </p>
		</s:if>
			</ul>
		  </div>
    </div>
    </div>
    
 

