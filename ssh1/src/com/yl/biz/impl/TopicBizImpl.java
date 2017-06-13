package com.yl.biz.impl;

import java.util.List;

import com.yl.biz.TopicBiz;
import com.yl.dao.TopicDao;
import com.yl.entity.Topic;

public class TopicBizImpl implements TopicBiz {

	TopicDao topicdao;
	public void setTopicdao(TopicDao topicdao) {
		this.topicdao = topicdao;
	}
	@Override
	public List getAllTopics() {
		// TODO Auto-generated method stub
		return topicdao.getAllTopics();
	}
	@Override
	public void addTopic(Topic topic) {
		 topicdao.addTopic(topic);
	}
	@Override
	public Topic getTopicById(int id) {
		return topicdao.getTopicById(id);
	}
	@Override
	public void updateTopic(Topic topic) {
		topicdao.updateTopic(topic);
	}
	@Override
	public void delectTopic(int id) {
		Topic topic= topicdao.getTopicById(id);
		topicdao.delectTopic(topic);
	}

}
