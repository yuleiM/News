package com.yl.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.yl.biz.TopicBiz;
import com.yl.entity.Topic;

public class TopicAction extends ActionSupport implements RequestAware,SessionAware {

	/**
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）
	 * @since 1.0.0
	 */
	
	private static final long serialVersionUID = 1L;
	
	TopicBiz topicBiz;
	public void setTopicBiz(TopicBiz topicBiz) {
		this.topicBiz = topicBiz;
	}
	private Topic topic;
	private int id;
	
	
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String addtopic(){
		topicBiz.addTopic(topic);
		return "admin";
	}
	
	public String topiclist(){
		List topicList = topicBiz.getAllTopics();
		request.put("topicList", topicList);
		return "topic_list";
	}
	
	public String toTopicModify(){
		Topic modifyTopic = topicBiz.getTopicById(id);
		request.put("modifyTopic", modifyTopic);
		return "topic_modify";
	}
	
	//更新主题
	public String doTopicModify(){
		topicBiz.updateTopic(topic);
		return "topicList";
	}
	
	public String deletetopic(){
		topicBiz.delectTopic(topic.getId());
		return "topicList";
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
