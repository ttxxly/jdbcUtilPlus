package com.ruanmou.vip.jdbc.util.test;

import com.demo.book.entity.LoginInfo;
import com.demo.book.login.LoginDAO;
import com.demo.book.login.impl.LoginDAOImpl;
import com.ruanmou.vip.jdbc.util.handler.HandlerTemplate;
import com.ruanmou.vip.jdbc.util.handler.mysql.MySQLTemplateHandler;
import com.ruanmou.vip.jdbc.util.handler.oracle.OracleTemplateHandler;
import com.ruanmou.vip.jdbc.util.handler.sqlserver.SqlServerHandlerTemplate;

public class TestJdbcUtil {
	public static void main(String[] args) {
		/*String sql = "insert into t_login(login_account, login_pass) values (?,?)";
		int row = JDBCUtils.executeUpdate(sql, "newAdmin1","1234");
		System.out.println(row > 0 ? "成功" : "失败");*/
		
		/*String sql = "insert into test1(id,name) values (?,?)";
		int row = JDBCUtils.executeUpdate(sql, 10001,"newAdmin1");
		System.out.println(row > 0 ? "成功" : "失败");*/
		
		/////////////////// 实现效果 //////////////////
		/*// 创建个图书对象
		BookInfo book = new BookInfo();
		book.setBookId(10002);
		book.setBookAuthor("王五");
		book.setBookPrice(35.7);
		
		// 调用BookDAOImpl类中方法操作对象
		BookDAO dao = new BookDAOImpl();
		dao.save(book); // 把设到book对象中的数据同步数据中【jdbc连接数据库】
*/		
		// 创建LoginInfo对象
		LoginInfo login = new LoginInfo();
		login.setLoginId(20001);
		login.setLoginName("admin");
		login.setLoginPass("admin123");
		
		LoginDAO ldao = new LoginDAOImpl();
		ldao.addLogin(login);
		
		// 提供一个通过SQL语句及参数列表来完成数据持久化到数据库的操作工具
		// 把方法中传入Book构建调用下面方法需要SQL及参数列表？？？？
		// JDBCUtils.executeUpdate(sql, parameters);
		/*HandlerTemplate template = new MySQLTemplateHandler();
		HandlerTemplate template1 = new OracleTemplateHandler();*/
		
		HandlerTemplate template = new MySQLTemplateHandler(); 
		template = new OracleTemplateHandler();
		template = new SqlServerHandlerTemplate();
		
		template.save(null);
		
	}
}
