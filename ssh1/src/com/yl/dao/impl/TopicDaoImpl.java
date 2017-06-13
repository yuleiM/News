package com.yl.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.yl.dao.TopicDao;

import com.yl.entity.Topic;

public class TopicDaoImpl implements TopicDao {

	SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public List getAllTopics() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(Topic.class);
		return c.list();
	}
	@Override
	public void addTopic(Topic topic) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(topic);
	}
	@Override
	public Topic getTopicById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Topic topic =(Topic) session.get(Topic.class, id);
		return topic;
	}
	@Override
	public void updateTopic(Topic topic) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(topic);
	}
	@Override
	public void delectTopic(Topic topic) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(topic);
	}

}
