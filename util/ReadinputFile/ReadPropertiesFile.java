/**
 * This file created at 2016年5月31日.
 *
 * Copyright (c) 2002-2016 Bingosoft, Inc. All rights reserved.
 */
package com.yabushan.test.util.ReadinputFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Properties;


/**
 * <code>{@link ReadPropertiesFile}</code>
 *
 * 读取properties文件
 *
 * @author yabushan
 */
public class ReadPropertiesFile {
	
	public final static String FILE_URL="jdbc.properties";
	public  String getUrl(){
		String Url="";
		InputStream inputStreams = this.getClass().getClassLoader().getResourceAsStream(FILE_URL);   
		  Properties p = new Properties();
		  try {
			p.load(inputStreams);
			 Url= p.getProperty("url");
		} catch (Exception e) {
		}
		 
		  return Url;
	}
	public static void main(String[] args) {
		System.out.println(new ReadPropertiesFile().getUrl());
	}
}
