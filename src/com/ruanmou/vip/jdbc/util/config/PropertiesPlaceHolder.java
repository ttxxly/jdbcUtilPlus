package com.ruanmou.vip.jdbc.util.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.ruanmou.vip.jdbc.util.constant.ConfigConstant;

/**
 * 资源文件处理器
 * @author Administrator
 *
 */
public class PropertiesPlaceHolder extends Properties {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PropertiesPlaceHolder() {
		String path = ConfigConstant.PROPERTIES_CONFIG_PATH.getPath();
		
		try (
				// 里面的对象会自动关闭
				InputStream in = this.getClass().getClassLoader().getResourceAsStream(path);
			) {
			this.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 通过key获取值的方法
	 */
	public String getValueByKey(String key) {
		return getProperty(key);
	}
}
