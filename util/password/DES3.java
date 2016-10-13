package com.yabushan.test.util.password;

import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.DESedeKeySpec;

import org.apache.commons.codec.binary.Hex;

public class DES3 {
	/**
	 * 三重des
	 */
	private static String src="我爱idsfsdfasdgsg agsdsdfsdfsdfsdfsdfdsfsdfdsf ";
	public static void main(String[] args) {
		jdkdes3();
	}
	
	public static void jdkdes3(){
		try{
		//生成KEY
		KeyGenerator keyGenerator=KeyGenerator.getInstance("DESede");
		keyGenerator.getProvider();
		keyGenerator.init(new SecureRandom());
		
		SecretKey secretKey=keyGenerator.generateKey();
		byte[] byteskey=secretKey.getEncoded();
		//KEY转换
		DESedeKeySpec desKeySpec=new DESedeKeySpec(byteskey);
		SecretKeyFactory factory=SecretKeyFactory.getInstance("DESede");
		Key convertSecretKey=factory.generateSecret(desKeySpec);
		
		
	//加密
	Cipher cipher=Cipher.getInstance("DESede/ECB/PKCS5Padding");
	cipher.init(Cipher.ENCRYPT_MODE, convertSecretKey);
	 byte[] result= cipher.doFinal(src.getBytes());
	 System.out.println("jdk des enctypt:"+Hex.encodeHexString(result));
		
	 
	
	 //解密
	 cipher.init(Cipher.DECRYPT_MODE, convertSecretKey);;
	 result=cipher.doFinal(result);
	 
	 System.out.println("jdk des decrypt:"+new String(result));
	 
	} catch (Exception e) {
		// TODO: handle exception
	}
	}
}
