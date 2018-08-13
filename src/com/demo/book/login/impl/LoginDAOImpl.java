package com.demo.book.login.impl;

import com.demo.book.entity.LoginInfo;
import com.demo.book.login.LoginDAO;
import com.ruanmou.vip.jdbc.util.handler.HandlerTemplate;

public class LoginDAOImpl implements LoginDAO {
	private HandlerTemplate tempalate;
	
	@Override
	public void addLogin(LoginInfo info) {
		tempalate.save(info);
	}
}
