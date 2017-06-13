package com.yl.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.yl.biz.AdminBiz;
import com.yl.entity.Admin;

public class AdminAction extends ActionSupport implements RequestAware,
		SessionAware {
	
	
	private AdminBiz adminBiz;
	private String LoginName;
	private String LoginPwd;
	private static final long serialVersionUID = 1L;
	private Map<String, Object> session;
	private Map<String, Object> request;

	public void setAdminBiz(AdminBiz adminBiz) {
		this.adminBiz = adminBiz;
	}

	public String getLoginName() {
		return LoginName;
	}

	public void setLoginName(String loginName) {
		LoginName = loginName;
	}

	public String getLoginPwd() {
		return LoginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		LoginPwd = loginPwd;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public String login() {
		Admin admin = new Admin();
		admin.setLoginName(LoginName);
		admin.setLoginPwd(LoginPwd);
		System.out.println(LoginPwd);
		List list = adminBiz.login(admin);
		if (list.size() > 0) {

			session.put("admin", list.get(0));
			return "admin";
		}
		return "login";
	}

}
