package com.ruanmou.vip.jdbc.util.test;

import java.util.Arrays;

/**
 * 特点： 
 * 1.在使用前已经实例化
 * 2.只能放在最后
 * 
 * @author Administrator
 *
 */
public class TestFlexParameters {
	
	public static void main(String[] args) {
		doFlextParameters(11,"AAA","BB","CCC");
	}

	public static void doFlextParameters(int id,String...objects) {
		System.out.println(objects);
		System.out.println(Arrays.toString(objects));
	}
}
