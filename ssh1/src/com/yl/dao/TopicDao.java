package com.yl.dao;

import java.util.List;

import com.yl.entity.Topic;

public interface TopicDao {
	public List getAllTopics();
	
	//�������
	public void addTopic(Topic topic);
	//ͨ����Ż�ȡ����
	public Topic getTopicById(int id);
	//��������
	public void updateTopic(Topic topic);
	//ɾ������
	public void delectTopic(Topic topic);

}
