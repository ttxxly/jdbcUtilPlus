package com.ruanmou.vip.jdbc.util.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

import org.junit.Test;

public class TestReadProperties {
	
	@Test // 资源国际化
	public void test1() {
		
		ResourceBundle bundle = ResourceBundle.getBundle("dataSource");
		String url = bundle.getString("jdbc.url");
		System.out.println(url);
		
	}
	
	@Test // 通过咱们Properties文件处理
	public void test2() {
		String value = new MyProperties().getProperty("jdbc.driver_class");
		System.out.println(value);
	}
	
	
	private class MyProperties extends Properties {
		public MyProperties()  {
			try {
				InputStream in = this.getClass().getClassLoader().getResourceAsStream("dataSource.properties");
				this.load(in);
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		/*public String getValue(String key) {
			return this.getProperty(key);
		}*/
	}

}
