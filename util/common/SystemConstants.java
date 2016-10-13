package com.yabushan.test.util.common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import org.apache.log4j.Logger;
/**
 * 
 * <code>{@link SystemConstants}</code>
 *
 * TODO : document me
 *读取配置文件：properties类型
 * @author yabushan
 */
public class SystemConstants{

	protected static final Logger logger = Logger.getLogger(SystemConstants.class);
	private static boolean isInit = false;
	protected static Properties p = new Properties();

	protected static void init(String propertyFileName)
	{
		InputStream in = null;
		try
		{
			in = SystemConstants.class.getResourceAsStream(propertyFileName);

			p.clear();
//			logger.info("in:"+in);
			if (in != null)
				p.load(in);

			isInit = true;
			logger.info("init properties");

		} catch (IOException e)
		{
			logger.error("load " + propertyFileName + " into Contants error");
		} finally
		{
			if (in != null)
			{
				try
				{
					in.close();
				} catch (IOException e)
				{
					logger.error("载入系统配置文件时出错，文件路径：" + propertyFileName);
				}
			}
		}
	}
	public static String getProperty(String key)
	{
		return p.getProperty(key, "");
	}
	public static String getProperty(String key, String defaultValue)
	{
		return p.getProperty(key, defaultValue);
	}

	static
	{
		init("/systemConstants.properties");
	}
	
	public static void init(){
		if(!isInit) init("/systemConstants.properties");
	}
	
	
	public static void setProperty(String key ,String value){
		 p.setProperty(key, value);

		 URL url = SystemConstants.class.getClassLoader().getResource("/systemConstants.properties");
			File file = new File(url.getPath());
			FileOutputStream fo = null;
			try{
				 fo = new FileOutputStream(file);
				p.store(fo, "");
			}catch (Exception e) {
				logger.error("",e);
			}finally{
				if(fo != null){
					try
					{
						fo.close();
					} catch (IOException e)
					{
						
					}
				}
			}
	}
	
	public static final String url = getProperty("url");
	
	public static final String SALT = getProperty("salt_value");
	
	public static final String SYSTEM_ID = getProperty("system_id");
	
	public static void reLoad(){
		
	}

}
