package com.yl.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.yl.biz.NewsinfoBiz;
import com.yl.biz.TopicBiz;
import com.yl.entity.Admin;
import com.yl.entity.Newsinfo;
import com.yl.entity.Pager;
import com.yl.entity.Topic;

public class NewsinfoAction extends ActionSupport implements RequestAware,SessionAware{

	Newsinfo newsinfo;
	
	
	public Newsinfo getNewsinfo() {
		return newsinfo;
	}

	public void setNewsinfo(Newsinfo newsinfo) {
		this.newsinfo = newsinfo;
	}
	
	TopicBiz topicbiz;
	public void setTopicbiz(TopicBiz topicbiz) {
		this.topicbiz = topicbiz;
	}
	
	NewsinfoBiz newsinfobiz;
	public void setNewsinfobiz(NewsinfoBiz newsinfobiz) {
		this.newsinfobiz = newsinfobiz;
	}
	
	private Pager pager;
	

	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}
private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String index()  throws Exception{
		int curPage=1;
		if(pager!=null)
			curPage=pager.getCurPage();
		List newsinfoList=null;
		if(newsinfo==null){
	        //如何没有指定查询条件，获取指定页码的新闻列表
			newsinfoList=newsinfobiz.getAllNewsinfoByPage(curPage,10);
			//再获得所有新闻总数，用来初始化分页类Pager对象
			pager=newsinfobiz.getPagerOfAllNewsinfo(10);			
		}else{
			//如果指定了查询条件，根据条件获取指定页码的新闻列表
			newsinfoList=newsinfobiz.getNewsinfoByConditionAndPage(newsinfo, curPage, 10);
			//再根据条件获得所属新闻总数，用来初始化分页类Pager对象
			pager=newsinfobiz.getPagerOfNewsinfo(newsinfo,10);			
		}
		//设置Pager对象中的待显示页页码
		pager.setCurPage(curPage);
		//将待显示的当前页新闻列表存入request范围
		request.put("newsinfoList", newsinfoList);
		//获取所有主题
		List topicList=topicbiz.getAllTopics();
		//将主题列表存入request范围
		request.put("topicList", topicList);
		return "index";
	}
	
	public String indexsidebar()  throws Exception{
		//获取5条国内新闻
				Newsinfo conditon =new Newsinfo();
				Topic topic =new Topic();
				topic.setId(1);
				conditon.setTopic(topic);		
				List domesticNewsList=newsinfobiz.getNewsinfoByConditionAndPage(conditon, 1,3);
				//获取5条国际新闻
				topic.setId(2);
				conditon.setTopic(topic);
				List internationalNewsList=newsinfobiz.getNewsinfoByConditionAndPage(conditon, 1,3);
				request.put("domesticNewsList", domesticNewsList);
				request.put("internationalNewsList", internationalNewsList);
				return "index_sidebar";
	}
	public String newsread() throws Exception{
		Newsinfo newsinfo = newsinfobiz.getNewsinfoById(id);
		request.put("newsinfo", newsinfo);
		Newsinfo conditon =new Newsinfo();
		Topic topic =new Topic();
		topic.setId(1);
		conditon.setTopic(topic);		
		List domesticNewsList=newsinfobiz.getNewsinfoByConditionAndPage(conditon, 1,3);
		//
		topic.setId(2);
		conditon.setTopic(topic);
		List internationalNewsList=newsinfobiz.getNewsinfoByConditionAndPage(conditon, 1,3);
		request.put("domesticNewsList", domesticNewsList);
		request.put("internationalNewsList", internationalNewsList);
		List topicList=topicbiz.getAllTopics();
		//
		request.put("topicList", topicList);
		return "news_read";
	}
	public String admin(){
		int curPage=1;
		if(pager!=null)
			curPage=pager.getCurPage();
		List newsinfoList=null;
		if(newsinfo==null){
	        //如何没有指定查询条件，获取指定页码的新闻列表
			newsinfoList=newsinfobiz.getAllNewsinfoByPage(curPage,10);
			//再获得所有新闻总数，用来初始化分页类Pager对象
			pager=newsinfobiz.getPagerOfAllNewsinfo(10);			
		}else{
			//如果指定了查询条件，根据条件获取指定页码的新闻列表
			newsinfoList=newsinfobiz.getNewsinfoByConditionAndPage(newsinfo, curPage, 10);
			//再根据条件获得所属新闻总数，用来初始化分页类Pager对象
			pager=newsinfobiz.getPagerOfNewsinfo(newsinfo,10);			
		}
		//设置Pager对象中的待显示页页码
		pager.setCurPage(curPage);
		//将待显示的当前页新闻列表存入request范围
		request.put("newsinfoList", newsinfoList);
		//获取所有主题
		List topicList=topicbiz.getAllTopics();
		//将主题列表存入request范围
		request.put("topicList", topicList);
		return "admin";
	}
	
	//获取主题列表，再转到新闻添加页面
	public String newsadd(){
		List topicList = topicbiz.getAllTopics();
		request.put("topicList", topicList);
		return "news_add";
	}
	
	//执行添加新闻
	public String addNews(){
		Admin admin =(Admin) session.get("admin");
		newsinfo.setAuthor(admin.getLoginName());
		newsinfo.setCreateDate(new Date());
		newsinfobiz.addNews(newsinfo);
		return "admin";
	}
	
	//根据新闻编号获取新闻，并获取主题列表，再转到新闻修改页
	public String newsModitf(){
		Newsinfo newsinfo = newsinfobiz.getNewsinfoById(id);
		request.put("newsinfo", newsinfo);
		List topicList = topicbiz.getAllTopics();
		request.put("topicList", topicList);
		return "news_moditf";
	}
	
	//执行修改新闻
	public String donewsModitf(){
		Admin admin =(Admin) session.get("admin");
		newsinfo.setAuthor(admin.getLoginName());
		newsinfo.setCreateDate(new Date());
		newsinfobiz.addNews(newsinfo);
		return "admin";
	}
	
	//删除新闻
	public String delectNews(){
		newsinfobiz.delectNews(newsinfo);
		return "admin";
	}
	
	//注销
	public String out(){
		session.clear();
		return "out";
	}
	Map<String, Object> session;
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session=session;
	}

	Map<String, Object> request;
	@Override
	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.request=request;
	}

}
