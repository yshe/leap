package com.yabushan.test.util.password;

import org.kobjects.base64.Base64;

public class Bsse64Utils {
	
	//解密
	public static String deCodeString(String str){
		try {
			return new String(Base64.decode(str));
		} catch (Exception e) {
			return str;
		}
	}
	//加密
	public static String enCodeStr(String str){
		return Base64.encode(str.getBytes());
	}
	
}
