package com.yl.biz;

import java.util.List;

import com.yl.entity.Topic;

public interface TopicBiz {
	public List getAllTopics();
	//�������
	public void addTopic(Topic topic);
	//ͨ����Ż�ȡ����
	public Topic getTopicById(int id);
	//��������
	public void updateTopic(Topic topic);
	//ɾ������
	public void delectTopic(int id);

}
