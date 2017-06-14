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
		//ʹ�÷�ҳ��Pager�������
		Pager pager=new Pager();
		//����pager�����е�perPageRows���ԣ���ʾÿҳ��ʾ�ļ�¼��
		pager.setPerPageRows(pageSize);
		//����pager�����е�rowCount���ԣ���ʾ��¼����
		pager.setRowCount(count);
	    //����pager����
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
		//ʹ�÷�ҳ��Pager�������
		Pager pager=new Pager();
		//����pager�����е�perPageRows���ԣ���ʾÿҳ��ʾ�ļ�¼��
		pager.setPerPageRows(pageSize);
		//����pager�����е�rowCount���ԣ���ʾ��¼����
		pager.setRowCount(count);
	    //����pager����
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
