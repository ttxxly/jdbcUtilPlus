package com.ruanmou.vip.jdbc.util.handler;
/**
 * 考虑到数据库不同可以操作不一致， 提供模板
 * @author Administrator
 *
 */
public abstract class HandlerTemplate {
	
	/**
	 * 定义事务提交方法
	 */
	
	/**
	 * 定义事务回滚方法
	 */
	
	/**
	 * 定义处理对象持久化的方法
	 */
	public abstract <T> void save(T entity);

}
