package com.ruanmou.vip.jdbc.util.constant;

public enum SqlConstant {
	SERIALVERSION_UID("serialVersionUID");
	
	private String value;

	SqlConstant(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
