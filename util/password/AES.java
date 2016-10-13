package com.yabushan.test.util.password;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class AES {

	private static String src="sdfdsf";
	public static void main(String[] args) {
		jdkAES();
	}
	
	
	public static void jdkAES(){
		try {
			//生成KEY
			KeyGenerator keyGenerator=KeyGenerator.getInstance("AES");
			keyGenerator.init(128);
			SecretKey secretKey=keyGenerator.generateKey();
			byte[] kEYBytes=secretKey.getEncoded();
			
			//KEY转换
			Key key=new SecretKeySpec(kEYBytes, "AES");
			//加密
			Cipher cipher=Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] result=cipher.doFinal(src.getBytes());
			System.out.println("jdk aes encrypt:"+org.apache.commons.codec.binary.Base64.encodeBase64String(result));
			
			
			//解密
			cipher.init(Cipher.DECRYPT_MODE, key);
			
			result=cipher.doFinal();
			System.out.println("jdk aes decrypt:"+new String(result));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
