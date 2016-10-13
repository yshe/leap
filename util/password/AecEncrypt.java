package com.yabushan.test.util.password;
/*package ease.shopping.util.Pwd;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;


public class AecEncrypt {
	
	
	//加解密秘钥
	public static final String SECRET="SanYueKeJiHereBy";
	*//** 
	 * 加密 
	 *  
	 * @param content 需要加密的内容 
	 * @param password  加密密码 
	 * @return 
	 *//*  
	
	public static byte[] encrypt(String content, String password) {  
	        try {             
	                KeyGenerator kgen = KeyGenerator.getInstance("AES");  
	                kgen.init(128, new SecureRandom(password.getBytes()));  
	                SecretKey secretKey = kgen.generateKey();  
	                byte[] enCodeFormat = secretKey.getEncoded();  
	                SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");  
	                Cipher cipher = Cipher.getInstance("AES");// 创建密码器   
	                byte[] byteContent = content.getBytes("utf-8");  
	                cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化   
	                byte[] result = cipher.doFinal(byteContent);  
	                return result; // 加密   
	        } catch (NoSuchAlgorithmException e) {  
	                e.printStackTrace();  
	        } catch (NoSuchPaddingException e) {  
	                e.printStackTrace();  
	        } catch (InvalidKeyException e) {  
	                e.printStackTrace();  
	        } catch (UnsupportedEncodingException e) {  
	                e.printStackTrace();  
	        } catch (IllegalBlockSizeException e) {  
	                e.printStackTrace();  
	        } catch (BadPaddingException e) {  
	                e.printStackTrace();  
	        }  
	        return null;  
	}  
	
	
	
	*//**解密 
	 * @param content  待解密内容 
	 * @param password 解密密钥 
	 * @return 
	 *//*  
	public static byte[] decrypt(byte[] content, String password) {  
	        try {  
	                 KeyGenerator kgen = KeyGenerator.getInstance("AES");  
	                 kgen.init(128, new SecureRandom(password.getBytes()));  
	                 SecretKey secretKey = kgen.generateKey();  
	                 byte[] enCodeFormat = secretKey.getEncoded();  
	                 SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");              
	                 Cipher cipher = Cipher.getInstance("AES");// 创建密码器   
	                
	                cipher.init(Cipher.DECRYPT_MODE, key);// 初始化   
	                byte[] result = cipher.doFinal(content);  
	                return result; // 加密   
	        } catch (NoSuchAlgorithmException e) {  
	                e.printStackTrace();  
	        } catch (NoSuchPaddingException e) {  
	                e.printStackTrace();  
	        } catch (InvalidKeyException e) {  
	                e.printStackTrace();  
	        } catch (IllegalBlockSizeException e) {  
	                e.printStackTrace();  
	        } catch (BadPaddingException e) {  
	                e.printStackTrace();  
	        }  
	        return null;  
	}  
	
	
	*//**将16进制转换为二进制 
	 * @param hexStr 
	 * @return 
	 *//*  
	public static byte[] parseHexStr2Byte(String hexStr) {  
	        if (hexStr.length() < 1)  
	                return null;  
	        byte[] result = new byte[hexStr.length()/2];  
	        for (int i = 0;i< hexStr.length()/2; i++) {  
	                int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16);  
	                int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16);  
	                result[i] = (byte) (high * 16 + low);  
	        }  
	        return result;  
	}  
	
	
	*//**将二进制转换成16进制 
	 * @param buf 
	 * @return 
	 *//*  
	public static String parseByte2HexStr(byte buf[]) {  
	        StringBuffer sb = new StringBuffer();  
	        for (int i = 0; i < buf.length; i++) {  
	                String hex = Integer.toHexString(buf[i] & 0xFF);  
	                if (hex.length() == 1) {  
	                        hex = '0' + hex;  
	                }  
	                sb.append(hex.toUpperCase());  
	        }  
	        return sb.toString();  
	}  
	
	
	public static void main(String[] args) {
		String content = "test";  
		String password = "12345678";  
		//加密   
		System.out.println("加密前：" + content);  
		byte[] encryptResult = encrypt(content, password);  
		String encryptResultStr = parseByte2HexStr(encryptResult);  
		System.out.println("加密后：" + encryptResultStr); 
		//解密   
		byte[] decryptFrom = parseHexStr2Byte(encryptResultStr);  
		byte[] decryptResult = decrypt(decryptFrom,password);  
		System.out.println("解密后：" + new String(decryptResult));
		String teString="sdfsdfsdfsdf 123124 sdgsdfdf";
		String test1=encryptStr(teString);
		System.out.println("加密后"+test1);
		String test2=decryptStr(test1);
		//String test2=decryptStr("A84F58E63440AB139FB4ED9F8DB82B28535B5E413743C3B93DED13B90A7238C37C10FE44FB308117D91D86D7162B892E");
		System.out.println("解密后："+test2);
	}
	
	//加密
	public static String encryptStr(String content){
		
		byte[] encryptResult = encrypt(content, SECRET);  
		//String encryptResultStr = parseByte2HexStr(encryptResult);  
		String encryptResultStr=Base64.encodeBase64String(encryptResult);
		return encryptResultStr;
	}
	
	
	//解密
	public static String decryptStr(String encryptResultStr){
		
		//byte[] decryptFrom = parseHexStr2Byte(encryptResultStr);  
		byte[] decryptFrom=Base64.decodeBase64(encryptResultStr);
		
		byte[] decryptResult = decrypt(decryptFrom,SECRET);  

		String target=new String(decryptResult);
		return target;
	}
}
*/