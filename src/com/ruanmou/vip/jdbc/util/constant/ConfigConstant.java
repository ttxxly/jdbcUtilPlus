package com.ruanmou.vip.jdbc.util.constant;

/**
 * 使用枚举定义常量
 */
public enum ConfigConstant {
	// 配置文件路径名称
	PROPERTIES_CONFIG_PATH("dataSource.properties");
	
	private String path;
	
	private ConfigConstant(String path) {
		this.path = path;
	}
	
	public String getPath() {
		return this.path;
	}
}
