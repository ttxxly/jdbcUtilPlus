package com.ruanmou.vip.jdbc.util.enums;

import com.ruanmou.vip.jdbc.util.config.PropertiesPlaceHolder;
/**
 * 定义获取数据连接信息的枚举类
 * @author Administrator
 *
 */
public enum DriverInfoEnum {
	DRIVER_CLASS {
		@Override
		public String getInfo() {
			return new PropertiesPlaceHolder().getProperty("jdbc.driver_class");
		}
		
	},
	URL {

		@Override
		public String getInfo() {
			return new PropertiesPlaceHolder().getProperty("jdbc.url");
		}
		
	},
	USERNAME {

		@Override
		public String getInfo() {
			// TODO Auto-generated method stub
			return new PropertiesPlaceHolder().getProperty("jdbc.username");
		}
		
	},
	
	PASSWORD {

		@Override
		public String getInfo() {
			// TODO Auto-generated method stub
			return new PropertiesPlaceHolder().getProperty("jdbc.password");
		}
		
	};
	
	DriverInfoEnum() {
		
	}
	
	DriverInfoEnum(String driver) {
		
	}
	
	/**
	 * 定义抽象声明
	 * @return
	 */
	public abstract String getInfo();
}
