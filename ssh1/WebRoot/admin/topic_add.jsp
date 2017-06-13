<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri='/struts-tags' prefix='s' %>
<jsp:include page="index_top2.jsp" />
<div id="container">
  <jsp:include page="index_sidebar2.jsp" />
  <div class="main">
    <h1 id="opt_type"> 添加主题： </h1>
    	<s:form action="addtopic" method="post">
    	<p><s:textfield label="主题名称" id="name" name="topic.name"></s:textfield></p>
    	<p><s:submit value="提交"></s:submit></p>
    	</s:form>
  </div>
</div>

