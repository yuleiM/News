package com.yl.dao;

import java.util.List;

import com.yl.entity.Newsinfo;

public interface NewsinfoDao {
	//����ָ��ҳ���ȡ�����б�
	public List getAllNewsinfoByPage(int page,int pageSize);
	//��ȡ������������
	public Integer getCountOfAllNewsinfo();
	//�������⡢���ű����������ȡ������������
	public Integer getCountOfNewsinfo(Newsinfo newsinfo);
	//���������š����ű����������ָ��ҳ���ȡ�����б�
    public List getNewsinfoByConditionAndPage(Newsinfo newsinfo,int page,int pageSize);
    //�������ű�Ż�ȡ����
    public Newsinfo getNewsinfoById(int id);
    //�������
    public void addNews(Newsinfo newsinfo);
    //�޸�����
    public void updateNews(Newsinfo newsinfo);
    //ɾ������
    public void delectNews(Newsinfo newsinfo);
}
