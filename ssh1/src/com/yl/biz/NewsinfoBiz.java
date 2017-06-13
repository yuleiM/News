package com.yl.biz;

import java.util.List;

import com.yl.entity.Newsinfo;
import com.yl.entity.Pager;

public interface NewsinfoBiz {
	//根据指定页码获取新闻列表
		public List getAllNewsinfoByPage(int page,int pageSize);
	//获取所有新闻数量,用来初始化分页类Pager对象，并设置其perPageRows和rowCount属性
	   public Pager getPagerOfAllNewsinfo(int pageSize);	
	 //根据主题编号、新闻标题等条件和指定页码获取新闻列表
	   public List getNewsinfoByConditionAndPage(Newsinfo newsinfo,int page,int pageSize);   
	    
	  //根据主题、新闻标题等条件获取新闻数量,用来初始化分页类Pager对象，并设置其perPageRows和rowCount属性
	   public Pager getPagerOfNewsinfo(Newsinfo newsinfo,int pageSize);
	   //根据新闻编号获取新闻
	   public Newsinfo getNewsinfoById(int id);
	   //添加新闻
	   public void addNews(Newsinfo newsinfo);
	 //修改新闻
	   public void updateNews(Newsinfo newsinfo);
	   //删除新闻
	   public void delectNews(Newsinfo newsinfo);
}
