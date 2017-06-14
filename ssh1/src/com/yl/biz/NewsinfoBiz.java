package com.yl.biz;

import java.util.List;

import com.yl.entity.Newsinfo;
import com.yl.entity.Pager;

public interface NewsinfoBiz {
	//����ָ��ҳ���ȡ�����б�
		public List getAllNewsinfoByPage(int page,int pageSize);
	//��ȡ������������,������ʼ����ҳ��Pager���󣬲�������perPageRows��rowCount����
	   public Pager getPagerOfAllNewsinfo(int pageSize);	
	 //���������š����ű����������ָ��ҳ���ȡ�����б�
	   public List getNewsinfoByConditionAndPage(Newsinfo newsinfo,int page,int pageSize);   
	    
	  //�������⡢���ű����������ȡ��������,������ʼ����ҳ��Pager���󣬲�������perPageRows��rowCount����
	   public Pager getPagerOfNewsinfo(Newsinfo newsinfo,int pageSize);
	   //�������ű�Ż�ȡ����
	   public Newsinfo getNewsinfoById(int id);
	   //�������
	   public void addNews(Newsinfo newsinfo);
	 //�޸�����
	   public void updateNews(Newsinfo newsinfo);
	   //ɾ������
	   public void delectNews(Newsinfo newsinfo);
}
