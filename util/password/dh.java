package com.yabushan.test.util.password;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Objects;

import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;

import org.apache.commons.codec.binary.Base64;

public class dh {

	private static String src="wosdlfjslfjl ai ";
	public static void main(String[] args) {
		try {
			jdkDH();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void jdkDH() throws Exception{
		
		//1.初始化发送方密钥
		
		try {
			KeyPairGenerator sendkeyPairGenerator=KeyPairGenerator.getInstance("DH");
			sendkeyPairGenerator.initialize(512);
			KeyPair sendKeyPair=sendkeyPairGenerator.generateKeyPair();
			//发送方公钥，发送给接收方（网络，文件）
		 byte[]  senderpublickeyenc=	sendKeyPair.getPublic().getEncoded();
		 
			//2.初始化接收方秘钥
		 KeyFactory keyFactory=KeyFactory.getInstance("DH");
		 X509EncodedKeySpec x509EncodedKeySpec=new X509EncodedKeySpec(senderpublickeyenc);
		 PublicKey receiverPublicKey=keyFactory.generatePublic(x509EncodedKeySpec);
		 DHParameterSpec dhParameterSpec=((DHPublicKey)receiverPublicKey).getParams();
		 KeyPairGenerator receiverkyePairGenerator=KeyPairGenerator.getInstance("DH");
		 receiverkyePairGenerator.initialize(dhParameterSpec);
		KeyPair receiverKeyPair= receiverkyePairGenerator.generateKeyPair();
		PrivateKey receiverPrivateKey=receiverKeyPair.getPrivate();
		byte[] receiverPublicKeyEnc=receiverKeyPair.getPublic().getEncoded();
		//3.密钥构建
		KeyAgreement receiverkeyAgreement=KeyAgreement.getInstance("DH");
		receiverkeyAgreement.init(receiverPrivateKey);
		receiverkeyAgreement.doPhase(receiverPublicKey, true);
		SecretKey receiverSecretKey=receiverkeyAgreement.generateSecret("DES");
		
		
		@SuppressWarnings("static-access")
		KeyFactory senderKeyFactory=keyFactory.getInstance("DH");
		x509EncodedKeySpec=new X509EncodedKeySpec(receiverPublicKeyEnc);
		PublicKey senderPublicKey=senderKeyFactory.generatePublic(x509EncodedKeySpec);
		KeyAgreement sendKeyAgreement=KeyAgreement.getInstance("DH");
		sendKeyAgreement.init(sendKeyPair.getPrivate());
		sendKeyAgreement.doPhase(senderPublicKey, true);
		
		
		//生成发送方的本地密钥
		SecretKey senderdeSecretKey=sendKeyAgreement.generateSecret("DES");
		if(Objects.equals(receiverSecretKey, senderdeSecretKey)){
			System.out.println("双方密钥相同");
			System.out.println(senderdeSecretKey+">>>"+receiverSecretKey);
			
		}
		//4.加密
		Cipher cipher=Cipher.getInstance("DES");
		cipher.init(Cipher.ENCRYPT_MODE, senderdeSecretKey);
		byte[] result=cipher.doFinal(src.getBytes());
		System.out.println("jdk DH加密"+Base64.encodeBase64String(result));
		
		

		//4.解密
				
				cipher.init(Cipher.DECRYPT_MODE, receiverSecretKey);
				result=cipher.doFinal(result);
				System.out.println("jdk DH解密"+new String(result));
				
				
		
		 
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
