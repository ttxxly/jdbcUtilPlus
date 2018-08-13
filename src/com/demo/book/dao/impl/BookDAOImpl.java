package com.demo.book.dao.impl;

import com.demo.book.dao.BookDAO;
import com.demo.book.entity.BookInfo;
import com.ruanmou.vip.jdbc.util.handler.HandlerTemplate;
import com.ruanmou.vip.jdbc.util.handler.mysql.MySQLTemplateHandler;

/**
 * 图书信息的数据库访问类
 * @author Administrator
 *
 */
public class BookDAOImpl implements BookDAO {
	
	private HandlerTemplate tempalate = new MySQLTemplateHandler();
	
	public void save(BookInfo book) {
		tempalate.save(book);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
