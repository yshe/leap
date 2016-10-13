package com.yabushan.test.util.common;

import java.math.BigDecimal;
import java.text.DecimalFormat;
/**
 * 
 * @author yabushan
 * 保留小数位数
 *
 */
public class DoubleFormat {
	
	public static String format(Double d,int precision){
		    BigDecimal  bd = new BigDecimal(Double.toString(d));   
		    BigDecimal  bd2 = bd.setScale(precision, BigDecimal.ROUND_HALF_UP);   
	       return bd2.toString(); 
	}
	public static void test(){
		
	       // 1. 先乘后四舍五入, 再除;   
	        double d = 4.015;   
	 
	        double d2 = Math.round(d*100)/100.0;   
	        System.out.println("通过Math取整后做除法: " + d2);   
	  
	        // 2. 通过BigDecimal的setScale()实现四舍五入与小数点位数确定, 将转换为一个BigDecimal对象.   
	        BigDecimal bd = new BigDecimal(Double.toString(d));   
	        BigDecimal bd2 = bd.setScale(2, BigDecimal.ROUND_HALF_UP);   
	        System.out.println("通过BigDecimal.setScale获得: " + bd2);   
	        
	        d = 4.025;   
	         bd = new BigDecimal(Double.toString(d));   
	         bd2 = bd.setScale(2, BigDecimal.ROUND_HALF_UP);   
	        System.out.println("通过BigDecimal.setScale获得: " + bd2);   
	        
	        
	        d = 4.024;   
	         bd = new BigDecimal(Double.toString(d));   
	         bd2 = bd.setScale(2, BigDecimal.ROUND_HALF_UP);   
	        System.out.println("通过BigDecimal.setScale获得: " + bd2);  
	        
	        
	        // 3. 通过DecimalFormat.format返回String的   
	        DecimalFormat df = new DecimalFormat("#.##");   
	        System.out.println("通过DecimalFormat.format获得: " + df.format(d));   
	  
	        // 4. 通过String.format   
	        System.out.println("通过StringFormat: " + String.format("%.2f", d));   }
	public static void main(String[] args) {   
		System.out.println(format(4.014,2));
		System.out.println(format(4.015,2));
		System.out.println(format(4.025,2));
		System.out.println(format(4.055,2));  
		System.out.println(format(4.055,1)); 
		test();
	}   
}
