<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="index_top2.jsp" />
<script language="javascript">
	function clickdel(){
		return confirm("删除请点击确认");
	}	
</script>
<script language="javascript">
	function clickdel(){
		return confirm("删除请点击确认");
	}	
</script>
  <div id="container">
  <jsp:include page="index_sidebar2.jsp" />
    <div class="main">
	    
	    <div class="content">
	      <s:form ation="admin" method="post" theme="simple">
                      主题：<s:select name="newsinfo.topic.id" list="#request.topicList" listKey="id" listValue="name" cssClass="opt_input" />
         &nbsp;&nbsp; &nbsp;新闻标题：<s:textfield name="newsinfo.title" />
          <s:submit value="查询" />
        </s:form>
	    
	     <ul class="class_info"> 
        <!-- 循环显示当前页新闻列表 -->     
        <s:iterator id="news" value="#request.newsinfoList">
            <li> ${news.title} 
      	    <span>作者： ${news.author}&#160;&#160;&#160;<a href="NewsModitf?id=${news.id }">修改</a>&#160;&#160;&#160;<a href="delectNews?id=${news.id }" onclick="return clickdel()">删除</a></span></li>
        </s:iterator>     
	
    <s:if test="pager.curPage>1">
            <p align="center">
			    <a href='index2?pager.curPage=1&newsinfo.topic.id=${requestScope.newsinfo.topic.id}'>首页</a>
			    <a href='index2?pager.curPage=${pager.curPage-1 }&newsinfo.topic.id=${requestScope.newsinfo.topic.id}'>上一页</a>
		    </p>
		</s:if>		
		
		<s:if test="pager.curPage < pager.pageCount">
		  <p align="center">
			<a href='index2?pager.curPage=${pager.curPage+1}&newsinfo.topic.id=${requestScope.newsinfo.topic.id}'>下一页</a>
			<a href='index2?pager.curPage=${pager.pageCount }&newsinfo.topic.id=${requestScope.newsinfo.topic.id}'>尾页</a>
		  </p>
		</s:if>
			</ul>
		  </div>
    </div>
    </div>
    
 

