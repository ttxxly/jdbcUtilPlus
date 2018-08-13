package com.ruanmou.vip.jdbc.util.test;

import com.ruanmou.vip.jdbc.util.enums.DriverInfoEnum;

/**
 * 测试枚举
 * Effect java(推荐使用枚举来定义常量)
 * @author Administrator
 *
 */
public class TestEnum {
	public static void main(String[] args) {
		// DRIVER_CLASS = 0
		System.out.println(DriverInfoEnum.PASSWORD.ordinal());
		System.out.println(DriverInfoEnum.valueOf("DRIVER_CLASS").ordinal());
	}
}
