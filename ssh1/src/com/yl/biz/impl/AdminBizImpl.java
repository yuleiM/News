package com.yl.biz.impl;

import java.util.List;

import com.yl.biz.AdminBiz;
import com.yl.dao.AdminDao;
import com.yl.entity.Admin;

public class AdminBizImpl implements AdminBiz {

	AdminDao adminDao;
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
	@Override
	public List login(Admin admin) {
		return adminDao.login(admin);
	}

}
