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
	        //���û��ָ����ѯ��������ȡָ��ҳ��������б�
			newsinfoList=newsinfobiz.getAllNewsinfoByPage(curPage,10);
			//�ٻ����������������������ʼ����ҳ��Pager����
			pager=newsinfobiz.getPagerOfAllNewsinfo(10);			
		}else{
			//���ָ���˲�ѯ����������������ȡָ��ҳ��������б�
			newsinfoList=newsinfobiz.getNewsinfoByConditionAndPage(newsinfo, curPage, 10);
			//�ٸ������������������������������ʼ����ҳ��Pager����
			pager=newsinfobiz.getPagerOfNewsinfo(newsinfo,10);			
		}
		//����Pager�����еĴ���ʾҳҳ��
		pager.setCurPage(curPage);
		//������ʾ�ĵ�ǰҳ�����б����request��Χ
		request.put("newsinfoList", newsinfoList);
		//��ȡ��������
		List topicList=topicbiz.getAllTopics();
		//�������б����request��Χ
		request.put("topicList", topicList);
		return "index";
	}
	
	public String indexsidebar()  throws Exception{
		//��ȡ5����������
				Newsinfo conditon =new Newsinfo();
				Topic topic =new Topic();
				topic.setId(1);
				conditon.setTopic(topic);		
				List domesticNewsList=newsinfobiz.getNewsinfoByConditionAndPage(conditon, 1,3);
				//��ȡ5����������
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
	        //���û��ָ����ѯ��������ȡָ��ҳ��������б�
			newsinfoList=newsinfobiz.getAllNewsinfoByPage(curPage,10);
			//�ٻ����������������������ʼ����ҳ��Pager����
			pager=newsinfobiz.getPagerOfAllNewsinfo(10);			
		}else{
			//���ָ���˲�ѯ����������������ȡָ��ҳ��������б�
			newsinfoList=newsinfobiz.getNewsinfoByConditionAndPage(newsinfo, curPage, 10);
			//�ٸ������������������������������ʼ����ҳ��Pager����
			pager=newsinfobiz.getPagerOfNewsinfo(newsinfo,10);			
		}
		//����Pager�����еĴ���ʾҳҳ��
		pager.setCurPage(curPage);
		//������ʾ�ĵ�ǰҳ�����б����request��Χ
		request.put("newsinfoList", newsinfoList);
		//��ȡ��������
		List topicList=topicbiz.getAllTopics();
		//�������б����request��Χ
		request.put("topicList", topicList);
		return "admin";
	}
	
	//��ȡ�����б���ת���������ҳ��
	public String newsadd(){
		List topicList = topicbiz.getAllTopics();
		request.put("topicList", topicList);
		return "news_add";
	}
	
	//ִ���������
	public String addNews(){
		Admin admin =(Admin) session.get("admin");
		newsinfo.setAuthor(admin.getLoginName());
		newsinfo.setCreateDate(new Date());
		newsinfobiz.addNews(newsinfo);
		return "admin";
	}
	
	//�������ű�Ż�ȡ���ţ�����ȡ�����б���ת�������޸�ҳ
	public String newsModitf(){
		Newsinfo newsinfo = newsinfobiz.getNewsinfoById(id);
		request.put("newsinfo", newsinfo);
		List topicList = topicbiz.getAllTopics();
		request.put("topicList", topicList);
		return "news_moditf";
	}
	
	//ִ���޸�����
	public String donewsModitf(){
		Admin admin =(Admin) session.get("admin");
		newsinfo.setAuthor(admin.getLoginName());
		newsinfo.setCreateDate(new Date());
		newsinfobiz.addNews(newsinfo);
		return "admin";
	}
	
	//ɾ������
	public String delectNews(){
		newsinfobiz.delectNews(newsinfo);
		return "admin";
	}
	
	//ע��
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
