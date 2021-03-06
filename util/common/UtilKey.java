/**
 * This file created at 2014-4-16.
 *
 * Copyright (c) 2002-2014 Bingosoft, Inc. All rights reserved.
 */
package com.yabushan.test.util.common;

import java.security.Key;
import java.security.Security;

import javax.crypto.Cipher;

/**
 * 针对暴露路径进行加密处理
 *
 * @author xunjw
 */
public class UtilKey {

	/** 字符串默认键值     */
	private String strDefaultKey = "bingoDownloadKey";

	/** 加密工具     */
	private Cipher encryptCipher = null;

	/** 解密工具     */
	private Cipher decryptCipher = null;
	/** 静态对象 */
	static private UtilKey instance;

	/**
	 * 建构函数私有以防止其它对象创建本类实例
	 * @throws Exception 
	 */
	private UtilKey() throws Exception {
		init();
	}

	/**
	 * 创建唯一实例
	 * 
	 * @return
	 * @throws Exception 
	 */
	static public UtilKey getInstance() throws Exception {
		if (instance == null) {
			instance = new UtilKey();
		}
		return instance;
	}

	/**
	 * 初始化构造
	 * @throws Exception
	 */
	@SuppressWarnings("restriction")
	private void init() throws Exception {
		Security.addProvider(new com.sun.crypto.provider.SunJCE());
		Key key = getKey(strDefaultKey.getBytes());
		encryptCipher = Cipher.getInstance("DES");
		encryptCipher.init(Cipher.ENCRYPT_MODE, key);
		decryptCipher = Cipher.getInstance("DES");
		decryptCipher.init(Cipher.DECRYPT_MODE, key);
	}

	/**  
	* 从指定字符串生成密钥，密钥所需的字节数组长度为8位 不足8位时后面补0，超出8位只取前8位  
	*   
	* @param arrBTmp  
	*            构成该字符串的字节数组  
	* @return 生成的密钥  
	* @throws java.lang.Exception  
	*/
	private Key getKey(byte[] arrBTmp) throws Exception {
		// 创建一个空的8位字节数组（默认值为0）   
		byte[] arrB = new byte[8];
		// 将原始字节数组转换为8位   
		for (int i = 0; i < arrBTmp.length && i < arrB.length; i++) {
			arrB[i] = arrBTmp[i];
		}
		// 生成密钥   
		Key key = new javax.crypto.spec.SecretKeySpec(arrB, "DES");
		return key;
	}

	/**
	 * 加密
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public String encryption(String value) throws Exception {
		return byteArr2HexStr(encrypt(value.getBytes()));
	}

	/**
	 * 解密
	 * @param value
	 * @return
	 * @throws Exception 
	 */
	public String decryption(String value) throws Exception {
		return new String(decrypt(hexStr2ByteArr(value)));
	}

	/**  
	* 加密字节数组  
	*   
	* @param arrB  
	*            需加密的字节数组  
	* @return 加密后的字节数组  
	* @throws Exception  
	*/
	private byte[] encrypt(byte[] arrB) throws Exception {
		return encryptCipher.doFinal(arrB);
	}

	/**  
	   * 解密字节数组  
	   *   
	   * @param arrB  
	   *            需解密的字节数组  
	   * @return 解密后的字节数组  
	   * @throws Exception  
	   */
	private byte[] decrypt(byte[] arrB) throws Exception {
		return decryptCipher.doFinal(arrB);
	}

	/**  
	* 将byte数组转换为表示16进制值的字符串， 如：byte[]{8,18}转换为：0813， 和public static byte[]  
	* hexStr2ByteArr(String strIn) 互为可逆的转换过程  
	*   
	* @param arrB  
	*            需要转换的byte数组  
	* @return 转换后的字符串  
	* @throws Exception
	*/
	private String byteArr2HexStr(byte[] arrB) throws Exception {
		int iLen = arrB.length;
		StringBuffer sb = new StringBuffer(iLen * 2);
		for (int i = 0; i < iLen; i++) {
			int intTmp = arrB[i];
			while (intTmp < 0) {
				intTmp = intTmp + 256;
			}
			if (intTmp < 16) {
				sb.append("0");
			}
			sb.append(Integer.toString(intTmp, 16));
		}
		return sb.toString();
	}

	/**  
	* 将表示16进制值的字符串转换为byte数组， 和public static String byteArr2HexStr(byte[] arrB)  
	* 互为可逆的转换过程  
	*   
	* @param strIn  
	*            需要转换的字符串  
	* @return 转换后的byte数组  
	* @throws Exception  
	*             本方法不处理任何异常，所有异常全部抛出  
	* @author
	*/
	private byte[] hexStr2ByteArr(String strIn) throws Exception {
		byte[] arrB = strIn.getBytes();
		int iLen = arrB.length;

		// 两个字符表示一个字节，所以字节数组长度是字符串长度除以2   
		byte[] arrOut = new byte[iLen / 2];
		for (int i = 0; i < iLen; i = i + 2) {
			String strTmp = new String(arrB, i, 2);
			arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
		}
		return arrOut;
	}

	public static void main(String[] args)  {
		try {
			System.out.println(UtilKey.getInstance().encryption("E1://upload~!@#$%^&*()_+//我不知道_.txt"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println(UtilKey.getInstance().decryption("f090dadaf3ee189b940f8b76f7a3725b8f47df08e08ca429153b081d1db57eebba7a76068cd53c3e26ca1628ea313e86"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
