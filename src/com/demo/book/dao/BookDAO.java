package com.demo.book.dao;

import com.demo.book.entity.BookInfo;

public interface BookDAO {
	void save(BookInfo book);
	void delete(Integer id);
}
