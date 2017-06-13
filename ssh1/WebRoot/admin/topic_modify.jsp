<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri='/struts-tags' prefix='s' %>
<jsp:include page="index_top2.jsp" />
<div id="container">
  <jsp:include page="index_sidebar2.jsp" />
  <div class="main">
    <h1 id="opt_type">修改主题： </h1>
    <s:form action="doTopicModify" method="post" onsubmit="return check()">
      <s:hidden name="topic.id" value="%{#request.modifyTopic.id}" />
      <p>
        <s:textfield label="主题名称" id="name" name="topic.name" value="%{#request.modifyTopic.name }" cssClass="opt_input" />
      </p> 
       
      <p>
        <s:submit value="提交" cssClass="opt_sub" />
      </p>     
    </s:form>
  </div>
</div>

