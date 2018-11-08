package com.demo.util;

import java.util.UUID;

//获取随机字符串
public class UUIDUtil {
	public static  String getUUID() {
		return UUID.randomUUID().toString();  //随机获取一个字符串
	}
}
