package com.yl.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import org.hibernate.criterion.Example;

import com.yl.dao.AdminDao;
import com.yl.entity.Admin;


public class AdminDaoImpl implements AdminDao {

	SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public List login(Admin admin) {
		
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(Admin.class);
		Example example = Example.create(admin);
		c.add(example);
		List list=c.list();
		return list;
	}

}
