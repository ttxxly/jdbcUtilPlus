package com.ruanmou.vip.jdbc.util.handler.mysql;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.ruanmou.vip.jdbc.util.JDBCUtils;
import com.ruanmou.vip.jdbc.util.constant.SqlConstant;
import com.ruanmou.vip.jdbc.util.handler.HandlerTemplate;

/**
 * mysql 数据操作实现类
 * @author Administrator
 *
 */
public class MySQLTemplateHandler extends HandlerTemplate {

	@Override
	public <T> void save(T entity) {
		// 构建一个与SQL语句占位符对应参数列表
		List<Object> parameterList = null;
		// 创建可变字符串对象
		StringBuffer sqlBuilder = new StringBuffer();
		// 获取操作对象的Class对象
		Class<?> clazz = entity.getClass();
		// 表名称默认为类名称
		String tableName = clazz.getSimpleName();
		// 拼接SQL语句
		sqlBuilder.append("INSERT INTO ").append(tableName).append("(");
		// 获取类中所有定义的字段
		Field[] fields = clazz.getDeclaredFields();
		
		if (fields != null && fields.length > 0) {
			// 实例化用于保存参数列表的集合
			parameterList = new ArrayList<Object>();
			for (int i = 0; i < fields.length; i++) {
				Field field = fields[i];
				// 获取所有的字段名称默认就是属性名称
				String fieldName = field.getName();
				
				// 判断是否为序列化名称
				if (SqlConstant.SERIALVERSION_UID.getValue().equals(fieldName)) {
					continue;
				}
				
				// 开启私有字段访问权限
				field.setAccessible(true);
				
				try {
					//通过反射 获取当前字段对应值
					Object value = field.get(entity);
					
					// 判断value是否为空
					if (null!=value) {
						// 追加SQL需要字段
						sqlBuilder.append(fieldName).append(",");
						// 添加当前字段对应值到集合
						parameterList.add(value);
					}
				} catch (Exception e) {
					e.printStackTrace();
				} 
				
			}
			// 出掉最后一个逗号
			sqlBuilder.deleteCharAt(sqlBuilder.length() - 1)
				.append(")").append(" VALUES").append(" (");
			
			// 拼接问号
			for (int i = 0; i< parameterList.size(); i++) {
				sqlBuilder.append("?").append(",");
			}
			
			sqlBuilder.deleteCharAt(sqlBuilder.length() - 1).append(")");
			
		}
		
		// 调用执行数据库数据持久化的工具方法
		JDBCUtils.executeUpdate(sqlBuilder.toString(), parameterList.toArray());

	}

}
