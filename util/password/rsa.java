package com.yabushan.test.util.password;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import org.apache.commons.codec.binary.Base64;

public class rsa {

	public static void main(String[] args) {
		try {
			jdkRSA();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static String src="sdfdsf谁干的";
	
	public static void jdkRSA() throws Exception{
		//1.初始化密钥
		try {
			KeyPairGenerator keyPairGenerator=KeyPairGenerator.getInstance("RSA");
			keyPairGenerator.initialize(512);
			KeyPair keyPair=keyPairGenerator.generateKeyPair();
			RSAPublicKey rsaPublicKey=(RSAPublicKey) keyPair.getPublic();
			RSAPrivateCrtKey rsaPrivatetKey=(RSAPrivateCrtKey) keyPair.getPrivate();
			System.out.println("public key"+Base64.encodeBase64String(rsaPublicKey.getEncoded()));
			System.out.println("private key"+Base64.encodeBase64String(rsaPrivatetKey.getEncoded()));
			
			//2.私钥加密， 公钥解   ——加密
			PKCS8EncodedKeySpec pkcs8EncodedKeySpec=new PKCS8EncodedKeySpec(rsaPrivatetKey.getEncoded());
			KeyFactory keyFactory=KeyFactory.getInstance("RSA");
			PrivateKey privateKey= keyFactory.generatePrivate(pkcs8EncodedKeySpec);
			Cipher cipher=Cipher.getInstance("RSA");
			cipher.init(Cipher.ENCRYPT_MODE, privateKey);
			byte[] result=cipher.doFinal(src.getBytes());
			System.out.println("加密："+Base64.encodeBase64String(result));
			
			
			//3.私钥加密公钥解密————解密
			X509EncodedKeySpec x509EncodedKeySpec=new X509EncodedKeySpec(rsaPublicKey.getEncoded());
			keyFactory=KeyFactory.getInstance("RSA");
			PublicKey publicKey=keyFactory.generatePublic(x509EncodedKeySpec);
			
			cipher=Cipher.getInstance("RSA");
			cipher.init(Cipher.DECRYPT_MODE, publicKey);
			result=cipher.doFinal(result);
			System.out.println(new String(result));
			
			
			
			
			
			//4.公钥加密，私钥解密————加密
				x509EncodedKeySpec=new X509EncodedKeySpec(rsaPublicKey.getEncoded());
				keyFactory=KeyFactory.getInstance("RSA");
				publicKey=keyFactory.generatePublic(x509EncodedKeySpec);
				cipher=Cipher.getInstance("RSA");
				cipher.init(Cipher.ENCRYPT_MODE, publicKey);
				result=cipher.doFinal(src.getBytes());
				System.out.println("公钥加密，私钥解密：+加密"+Base64.encodeBase64String(result));
				
			
			
			
			//5.公钥加密，私钥解密——解密
				pkcs8EncodedKeySpec=new PKCS8EncodedKeySpec(rsaPrivatetKey.getEncoded());
				 keyFactory=KeyFactory.getInstance("RSA");
				 privateKey= keyFactory.generatePrivate(pkcs8EncodedKeySpec);
				 cipher=Cipher.getInstance("RSA");
				cipher.init(Cipher.DECRYPT_MODE, privateKey);
				result= cipher.doFinal(result);
				System.out.println("公钥加密私钥解密——解密："+new String(result));
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
