package com.yabushan.test.util.common;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class UUIDGenerator { 
	public static String[] chars = new String[] { "a", "b", "c", "d", "e", "f",  
        "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",  
        "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",  
        "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",  
        "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",  
        "W", "X", "Y", "Z" };  
	
	/**
	 * 生成八位的uuid
	 * @return
	 */
	public static String generateShortUuid() {  
	    StringBuffer shortBuffer = new StringBuffer();  
	    String uuid = UUID.randomUUID().toString().replace("-", "");  
	    for (int i = 0; i < 8; i++) {  
	        String str = uuid.substring(i * 4, i * 4 + 4);  
	        int x = Integer.parseInt(str, 16);  
	        shortBuffer.append(chars[x % 0x3E]);  
	    }  
	    return shortBuffer.toString();  
	  
	}  
	
    public UUIDGenerator() { 
    } 
    public static String getUUID(){ 
        String s = UUID.randomUUID().toString(); 
     
        return s; 
    } 
    /** 
     * 获得一个UUID 
     * @return String UUID 
     */ 
   /* public static String getUUID(){ 
        String s = UUID.randomUUID().toString(); 
        //去掉“-”符号 
        return s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24); 
    } */
    /** 
     * 获得指定数目的UUID 
     * @param number int 需要获得的UUID数量 
     * @return String[] UUID数组 
     */ 
    public static String[] getUUID(int number){ 
        if(number < 1){ 
            return null; 
        } 
        String[] ss = new String[number]; 
        for(int i=0;i<number;i++){ 
            ss[i] = getUUID(); 
        } 
        return ss; 
    }
    public static String getUUIDReplaceStr(){
    	String s = UUID.randomUUID().toString(); 
    	return s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24); 
    }
    
    /**
     * 
    * @Description:  生成id
    * @param @return
    * @return String
    * @throws
     */
    public static String getID(){
    	StringBuffer buffer = new StringBuffer();
    	buffer.append(SystemConstants.SYSTEM_ID);
    	buffer.append(String.valueOf(System.currentTimeMillis()));
    	buffer.append(RandomUtil.getThreenumRandomCode(3,7));
    	return buffer.toString();
    }
    
    public static void main(String[] args){
    	
//        String[] ss = getUUID(10); 
//        for(int i=0;i<ss.length;i++){ 
//            System.out.println(ss[i]); 
//        } 
    	String uuid8 = "";
    	Set<String> set = new HashSet<String>();
    	
    	for (int i = 0; i < 1000000; i++) {
//    		uuid8 = generateShortUuid();
    		uuid8 = getID();
    		boolean isin = set.contains(uuid8); 
    		if (isin) {
				System.out.println("已经存在...."+uuid8);
			}else {
				set.add(uuid8);
			}
    		
		}
    	
    	System.out.println("set中总数为："+set.size());
    	System.out.println("全部执行完毕...");
    } 
}   
