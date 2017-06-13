<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri='/struts-tags' prefix='s' %>
<jsp:include page="index_top2.jsp" />
<div id="container">
  <jsp:include page="index_sidebar2.jsp" />
  <div class="main">
    <h1 id="opt_type"> 添加新闻： </h1>
    <s:form action="doNewsAdd" method="post" onsubmit="return check()">
      <p>        
        <s:select name="newsinfo.topic.id" label="主题" list="#request.topicList" listKey="id" listValue="name" cssClass="opt_input" />
      </p>
      <p>
        <s:textfield label="标题" name="newsinfo.title" cssClass="opt_input"  />
      </p>      
      <p>
        <s:textarea label="摘要" name="newsinfo.summary" cols="40" rows="3" />
      </p>
      <p>
         <s:textarea label="内容" name="newsinfo.content" cols="70" rows="10" />        
      </p>   
      <br>
     <p>
         <s:submit value="提交" cssClass="opt_sub" align="center" />  
      </p> 
    </s:form>
  </div>
</div>

