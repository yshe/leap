package com.yabushan.test.util.password;



import java.security.Key;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class DesKey {
	
	private static String src="我爱i";
	public static void main(String[] args) {
		jdkDES();
		bc();
	}
	
	public static void jdkDES(){
		
		try {
			//生成KEY
			KeyGenerator keyGenerator=KeyGenerator.getInstance("DES");
			keyGenerator.init(56);
			SecretKey secretKey=keyGenerator.generateKey();
			byte[] byteskey=secretKey.getEncoded();
			//KEY转换
			DESKeySpec desKeySpec=new DESKeySpec(byteskey);
			SecretKeyFactory factory=SecretKeyFactory.getInstance("DES");
			Key convertSecretKey=factory.generateSecret(desKeySpec);
			
			
		//加密
		Cipher cipher=Cipher.getInstance("DES/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, convertSecretKey);
		 byte[] result= cipher.doFinal(src.getBytes());
		 System.out.println("jdk des enctypt:"+result.toString());
			
		 
		
		 //解密
		 cipher.init(Cipher.DECRYPT_MODE, convertSecretKey);;
		 result=cipher.doFinal(result);
		 
		 System.out.println("jdk des decrypt:"+new String(result));
		 
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
public static void bc(){

	try {
		
		//生成KEY
		KeyGenerator keyGenerator=KeyGenerator.getInstance("DES","BC");
		keyGenerator.getProvider();
		keyGenerator.init(56);
		
		SecretKey secretKey=keyGenerator.generateKey();
		byte[] byteskey=secretKey.getEncoded();
		//KEY转换
		DESKeySpec desKeySpec=new DESKeySpec(byteskey);
		SecretKeyFactory factory=SecretKeyFactory.getInstance("DES");
		Key convertSecretKey=factory.generateSecret(desKeySpec);
		
		
	//加密
	Cipher cipher=Cipher.getInstance("DES/ECB/PKCS5Padding");
	cipher.init(Cipher.ENCRYPT_MODE, convertSecretKey);
	 byte[] result= cipher.doFinal(src.getBytes());
	 System.out.println("jdk des enctypt:"+result.toString());
		
	 
	
	 //解密
	 cipher.init(Cipher.DECRYPT_MODE, convertSecretKey);;
	 result=cipher.doFinal(result);
	 
	 System.out.println("jdk des decrypt:"+new String(result));
	 
	} catch (Exception e) {
		// TODO: handle exception
	}
		
}
	

}
