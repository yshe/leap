package com.yabushan.test.util.password;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

import org.apache.commons.codec.binary.Base64;

public class PBE {

	private static String src="美女";
	
	private static byte[] salt={-29,100,93,104,-23,-25,33,34};
	
	private static String password="sanyuepwd";
	public static void main(String[] args) throws Exception {
		//bcPBE();
	for(int i=0; i<10;i++){
		String target=encrypt(src+i);
		
		decrypt(target);
	}
		
	}
	
	public static void bcPBE() throws Exception{
		
		//初始化盐
		//SecureRandom random=new SecureRandom();
	//	byte[] salt=random.generateSeed(8);
		byte[] salt={-29,100,93,104,-23,-25,33,34};
		for(int i=0;i<salt.length;i++){
			System.out.println(salt[i]+">>>");
		}
		System.out.println(Base64.encodeBase64String(salt));
		//口令与秘钥
	
		
		try {
			String password="mypass";
			PBEKeySpec pbeKeySpec=new PBEKeySpec(password.toCharArray());
			SecretKeyFactory factory=SecretKeyFactory.getInstance("PBEWITHMD5andDES");
			Key key=factory.generateSecret(pbeKeySpec);
			
			//加密
			
			PBEParameterSpec parameterSpec=new PBEParameterSpec(salt, 100);//100是指迭代次数
			Cipher cipher=Cipher.getInstance("PBEWITHMD5andDES");
			cipher.init(Cipher.ENCRYPT_MODE, key, parameterSpec);
			byte[] result=cipher.doFinal(src.getBytes());
			System.out.println("jdk pbe encrypt:"+Base64.encodeBase64String(result));
		
			
			//解密
			cipher.init(Cipher.DECRYPT_MODE, key,parameterSpec);
			result=cipher.doFinal(result);
			System.out.println("jdk pbe decrypt:"+new String(result));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//加密
	
	public static String encrypt(String src){
		try {
			PBEKeySpec pbeKeySpec=new PBEKeySpec(password.toCharArray());
			SecretKeyFactory factory=SecretKeyFactory.getInstance("PBEWITHMD5andDES");
			Key key=factory.generateSecret(pbeKeySpec);
			
			
			
			PBEParameterSpec parameterSpec=new PBEParameterSpec(salt, 100);//100是指迭代次数
			Cipher cipher=Cipher.getInstance("PBEWITHMD5andDES");
			cipher.init(Cipher.ENCRYPT_MODE, key, parameterSpec);
			byte[] result=cipher.doFinal(src.getBytes());
			System.out.println("jdk pbe encrypt:"+Base64.encodeBase64String(result));
			return Base64.encodeBase64String(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	//解密
	public static String decrypt(String target){
		try {
			PBEKeySpec pbeKeySpec=new PBEKeySpec(password.toCharArray());
			SecretKeyFactory factory=SecretKeyFactory.getInstance("PBEWITHMD5andDES");
			Key key=factory.generateSecret(pbeKeySpec);
			
			
			PBEParameterSpec parameterSpec=new PBEParameterSpec(salt, 100);//100是指迭代次数
			byte[] result=Base64.decodeBase64(target);
			Cipher cipher=Cipher.getInstance("PBEWITHMD5andDES");
			cipher.init(Cipher.ENCRYPT_MODE, key, parameterSpec);
			//解密
			cipher.init(Cipher.DECRYPT_MODE, key,parameterSpec);
			result=cipher.doFinal(result);
			System.out.println("jdk pbe decrypt:"+new String(result));
			return new String(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
}

