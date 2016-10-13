package com.yabushan.test.util.httpClient;

import java.util.HashMap;
import java.util.Map;

public class TestMain {

	 private String url = "https://192.168.1.101/login/register";  
	    private String charset = "utf-8";  
	    private HttpClientUtil httpClientUtil = null;  
	      
	    public TestMain(){  
	        httpClientUtil = new HttpClientUtil();  
	    }  
	    public void test(){  
	        String httpOrgCreateTest = url ;
	       
	        Map<String,String> createMap = new HashMap<String,String>();  
	        createMap.put("phone","123");  
	        createMap.put("flag","test");  
	        createMap.put("password","111");  
	        createMap.put("orgname","****");  
	      try {
	    	  String httpOrgCreateTestRtn = httpClientUtil.doPost(httpOrgCreateTest,createMap,charset);  
	    	  System.out.println("result:"+httpOrgCreateTestRtn); 
		} catch (Exception e) {
			System.out.println(">>>>>>>>>>"+e.getMessage());
		}
	       
	    }  
	      
	    public static void main(String[] args){  
	        TestMain main = new TestMain();  
	        main.test();  
	    }  
}
