package com.yabushan.test.util.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * <code>{@link BinaryUtils}</code>
 *
 * TODO : 二、八、十六进制之间的转换
 *
 * @author yabushan
 */
public class BinaryUtils {
	/**
	    * Convert byte[] to hex string.这里我们可以将byte转换成int，然后利用Integer.toHexString(int)来转换成16进制字符串。
	    * @param src byte[] data
	    * @return hex string
	    */   
	   public static String bytesToHexString(byte[] src){
	       StringBuilder stringBuilder = new StringBuilder("");
	       if (src == null || src.length <= 0) {
	           return null;
	       }
	       for (int i = 0; i < src.length; i++) {
	           int v = src[i] & 0xFF;
	           String hv = Integer.toHexString(v);
	           if (hv.length() < 2) {
	               stringBuilder.append(0);
	           }
	           stringBuilder.append(hv);
	       }
	       return stringBuilder.toString();
	   }
	   /**
	    * Convert hex string to byte[]
	    * @param hexString the hex string
	    * @return byte[]
	    */
	   public static byte[] hexStringToBytes(String hexString) {
	       if (hexString == null || hexString.equals("")) {
	           return null;
	       }
	       hexString = hexString.toUpperCase();
	       int length = hexString.length() / 2;
	       char[] hexChars = hexString.toCharArray();
	       byte[] d = new byte[length];
	       for (int i = 0; i < length; i++) {
	           int pos = i * 2;
	           d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
	       }
	       return d;
	   }
	   /**
	    * Convert char to byte
	    * @param c char
	    * @return byte
	    */
	    private static byte charToByte(char c) {
	       return (byte) "0123456789ABCDEF".indexOf(c);
	   }
	    
	    //十进制转换16进制
	    public static String convertIntToBinary ( Long value){

			  	return Long.toHexString(value);

			 }
	    
	    public static String addZero(String i){
			   while(i.length()<16){
				   i="0"+i;
			   }
			   return i;
		   }
	    
	    //传入了需要补的长度
	    public static String addZero(String i,int length){
	    	while(i.length()<length){
	    		i="0"+i;
	    	}
	    	return i;
	    }
	    
	   
	    

	public static void main(String args[]){
		System.out.println(BinaryUtils.hexStringToBytes("123"));
		System.out.println(BinaryUtils.bytesToHexString(new byte[]{0,1,2,3,10,15}));
		System.out.println(BinaryUtils.hexStringToBytes("1"));
	}
}
