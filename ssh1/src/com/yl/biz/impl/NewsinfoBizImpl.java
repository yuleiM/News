package com.yl.biz.impl;

import java.util.List;

import com.yl.biz.NewsinfoBiz;
import com.yl.dao.NewsinfoDao;
import com.yl.entity.Newsinfo;
import com.yl.entity.Pager;

public class NewsinfoBizImpl implements NewsinfoBiz {
	
	NewsinfoDao newsinfodao;
	public void setNewsinfodao(NewsinfoDao newsinfodao) {
		this.newsinfodao = newsinfodao;
	}
	@Override
	public List getAllNewsinfoByPage(int page, int pageSize) {
		// TODO Auto-generated method stub
		return newsinfodao.getAllNewsinfoByPage(page, pageSize);
	}

	@Override
	public Pager getPagerOfAllNewsinfo(int pageSize) {
		// TODO Auto-generated method stub
		int count= newsinfodao.getCountOfAllNewsinfo();
		//使用分页类Pager定义对象
		Pager pager=new Pager();
		//设置pager对象中的perPageRows属性，表示每页显示的记录数
		pager.setPerPageRows(pageSize);
		//设置pager对象中的rowCount属性，表示记录总数
		pager.setRowCount(count);
	    //返回pager对象
		return pager;
	}

	@Override
	public List getNewsinfoByConditionAndPage(Newsinfo newsinfo, int page,
			int pageSize) {
		// TODO Auto-generated method stub
		return newsinfodao.getNewsinfoByConditionAndPage(newsinfo, page, pageSize);
	}

	@Override
	public Pager getPagerOfNewsinfo(Newsinfo newsinfo, int pageSize) {
		// TODO Auto-generated method stub
		int count= newsinfodao.getCountOfNewsinfo(newsinfo);
		//使用分页类Pager定义对象
		Pager pager=new Pager();
		//设置pager对象中的perPageRows属性，表示每页显示的记录数
		pager.setPerPageRows(pageSize);
		//设置pager对象中的rowCount属性，表示记录总数
		pager.setRowCount(count);
	    //返回pager对象
		return pager;
	}
	@Override
	public Newsinfo getNewsinfoById(int id) {
		// TODO Auto-generated method stub
		return newsinfodao.getNewsinfoById(id);
	}
	@Override
	public void addNews(Newsinfo newsinfo) {
		newsinfodao.addNews(newsinfo);
	}
	@Override
	public void updateNews(Newsinfo newsinfo) {
		newsinfodao.updateNews(newsinfo);
	}
	@Override
	public void delectNews(Newsinfo newsinfo) {
		newsinfodao.delectNews(newsinfo);
	}

}
