<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri='/struts-tags' prefix='s' %>
<jsp:include page="index_top2.jsp" />
<div id="container">
  <jsp:include page="index_sidebar2.jsp" />
  <div class="main">
    
   <ul class="classlist"> 
   <h2>编辑主题</h2> 
    	<s:iterator id="topic" value="#request.topicList">
    		<li> &#160;&#160;&#160;&#160; ${topic.name}&#160;&#160;&#160;&#160; <a href='toTopicModify?topic.id=${topic.id}'>修改</a> &#160;&#160;&#160;&#160; <a href='deletetopic?topic.id=${topic.id}'  >删除</a> </li>
    	</s:iterator>
    	
    </ul>
  </div>
</div>

