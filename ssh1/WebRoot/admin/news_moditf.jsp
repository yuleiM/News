<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri='/struts-tags' prefix='s' %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<jsp:include page="index_top2.jsp" />
<div id="container">
  <jsp:include page="index_sidebar2.jsp" />
  <div class="main">
    <h1 id="opt_type"> 修改新闻： </h1>
    <form action="doNewsModify" method="post" onsubmit="return check()">
      <s:hidden name="newsinfo.id" value="%{#request.newsinfo.id}" />
      <p>        
        <s:select name="newsinfo.topic.id" label="主题" list="#request.topicList" listKey="id" listValue="name" value="%{#request.newsinfo.topic.id }" cssClass="opt_input" />
      </p>
      <p>
        <s:textfield label="标题" name="newsinfo.title" cssClass="opt_input" value="%{#request.newsinfo.title }"  />
      </p>      
      <p>
        <s:textarea label="摘要" name="newsinfo.summary" value="%{#request.newsinfo.summary }" cols="40" rows="3"  />
      </p>
      <p>
         <s:textarea label="内容" name="newsinfo.content" value="%{#request.newsinfo.content }" cols="70" rows="10" />        
      </p>   
      <br>
     <p>
         <s:submit value="提交" cssClass="opt_sub" align="center" />  
      </p> 
    </form>    
  </div>
</div>

