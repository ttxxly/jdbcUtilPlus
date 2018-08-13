package com.ruanmou.vip.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.ruanmou.vip.jdbc.util.enums.DriverInfoEnum;

/**
 * 封装DML操作思路： insert,update,delete 操作都是用executeUpdate方法，并且返回操作受影响下行数
 * 把DML操作的语句提取为一个方法来实现 public static int executeUpdate(String sql, Object...
 * parameters) { // 获取连接 // 定义执行DML语句 // 创建预编译对象 // 设置参数 // 需要通过编译对象执行SQL语句 //
 * 释放资源 }
 * 
 * @author Administrator 1、获取连接数据不确定? (MySql, Oracle,.....)->
 *         把数据连接想过信息配置一个properties文件中
 *
 */
public final class JDBCUtils {
	static { // 加载驱动操作
		try {
			Class.forName(DriverInfoEnum.DRIVER_CLASS.getInfo());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 定义一个获取数据库连接的方法
	 */
	private final static Connection getConnection() {
		Connection conn = null;
		try {
			// 通过DriverManager获取连接对象
			conn = DriverManager.getConnection(DriverInfoEnum.URL.getInfo(), 
					DriverInfoEnum.USERNAME.getInfo(),
					DriverInfoEnum.PASSWORD.getInfo());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	/**
	 * 定义根据占位符的SQL语句定义设置编译对象参数的方法
	 */
	private final static void setParameters(PreparedStatement pst, Object...parameters) {
		try {
			if (parameters.length > 0 ) {
				for (int i = 0; i< parameters.length; i++) {
					pst.setObject(i + 1, parameters[i]);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 执行简单SQL的DML(INSERT,UPDATE,DELETE)操作
	 * 
	 * @param sql
	 *            调用处传入的DML语句
	 * @param parameters
	 *            DML语句中占位符对应参数列表
	 * @return 返回操作受影响行数
	 */
	public final static int executeUpdate(String sql, Object... parameters) {
		// 定义操作数据受影响行数
		int row = 0;
		try (
				Connection conn = getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);
			) {
			// 设置参数
			setParameters(pst, parameters);
			// 通过编译对象执行SQL命令
			row = pst.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return row;
	}
}
