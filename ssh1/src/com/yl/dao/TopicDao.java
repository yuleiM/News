package com.yl.dao;

import java.util.List;

import com.yl.entity.Topic;

public interface TopicDao {
	public List getAllTopics();
	
	//添加主题
	public void addTopic(Topic topic);
	//通过编号获取主题
	public Topic getTopicById(int id);
	//更新主题
	public void updateTopic(Topic topic);
	//删除主题
	public void delectTopic(Topic topic);

}
