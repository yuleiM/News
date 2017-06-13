package com.yl.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.yl.dao.NewsinfoDao;
import com.yl.entity.Newsinfo;

public class NewsinfoDaoImpl implements NewsinfoDao {
	
	SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//根据指定页码获取新闻列表
	@Override
	public List getAllNewsinfoByPage(int page, int pageSize) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(Newsinfo.class);
		c.setFirstResult(pageSize*(page-1));
		c.setMaxResults(pageSize);
		c.addOrder(Order.desc("createDate"));
		return c.list();
		
	}
	//获取所有新闻数量
	@Override
	public Integer getCountOfAllNewsinfo() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(Newsinfo.class);
		return c.list().size();
	}
	//根据主题、新闻标题等条件获取所属新闻数量
	@Override
	public Integer getCountOfNewsinfo(Newsinfo newsinfo) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(Newsinfo.class);
		if(newsinfo!=null){
			if((newsinfo.getTopic()!=null) && (newsinfo.getTopic().getId()!=null))
				c.add(Restrictions.eq("topic.id", newsinfo.getTopic().getId()));
			if((newsinfo.getTitle()!=null) && !("".equals(newsinfo.getTitle())))
				c.add(Restrictions.like("title", newsinfo.getTitle(),MatchMode.ANYWHERE));
		}
		return c.list().size();
	}
	//根据主题编号、新闻标题等条件和指定页码获取新闻列表
	@Override
	public List getNewsinfoByConditionAndPage(Newsinfo newsinfo, int page,
			int pageSize) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(Newsinfo.class);
		if(newsinfo!=null){
			if((newsinfo.getTopic()!=null) && (newsinfo.getTopic().getId()!=null))
				c.add(Restrictions.eq("topic.id", newsinfo.getTopic().getId()));
			if((newsinfo.getTitle()!=null) && !("".equals(newsinfo.getTitle())))
				c.add(Restrictions.like("title", newsinfo.getTitle(),MatchMode.ANYWHERE));
		}
		c.setFirstResult(pageSize*(page-1));
		c.setMaxResults(pageSize);
		c.addOrder(Order.desc("createDate"));
		return c.list();
	}
	@Override
	public Newsinfo getNewsinfoById(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Newsinfo newsinfo = (Newsinfo) session.get(Newsinfo.class, id);
		return newsinfo;
	}
	@Override
	public void addNews(Newsinfo newsinfo) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(newsinfo);
		
	}
	@Override
	public void updateNews(Newsinfo newsinfo) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(newsinfo);
	}
	@Override
	public void delectNews(Newsinfo newsinfo) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(newsinfo);
	}

}
