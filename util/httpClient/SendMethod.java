/**
 * This file created at 2016年5月31日.
 *
 * Copyright (c) 2002-2016 Bingosoft, Inc. All rights reserved.
 */
package com.yabushan.test.util.httpClient;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

/**
 * <code>{@link SendMethod}</code>
 *
 * TODO : 发送http请求
 *
 * @author yabushan
 */
public class SendMethod {
	
    /**
     * post请求
     * @param url         url地址
     * @param jsonParam     参数
     * @param noNeedResponse    不需要返回结果
     * @return
     * @throws IOException 
     * @throws ClientProtocolException 
     */
    public static String httpPost(String url,String jsonParam,Map<String, String> headers) throws ClientProtocolException, IOException{
        //post请求返回结果
        DefaultHttpClient httpClient = new DefaultHttpClient();
        //设置超时时间
        
        HttpPost method = new HttpPost(url);
        //设置请求头
        for (String key : headers.keySet()) {
        	method.setHeader(key,headers.get(key));
		}
        if (null != jsonParam) {
            //解决中文乱码问题
            StringEntity entity = new StringEntity(jsonParam,"utf-8");
            entity.setContentEncoding("UTF-8");
            entity.setContentType("application/json");
            method.setEntity(entity);
        }
        HttpResponse result = httpClient.execute(method);
        url = URLDecoder.decode(url, "UTF-8");
        String str="";
      // str = EntityUtils.toString(result.getEntity());
      // str+="响应状态码："+result.getStatusLine().getStatusCode();
      // jsonResult =JSONObject.fromObject(str).getString("resp_code");
        /**请求发送成功，并得到响应**/
        if (result.getStatusLine().getStatusCode() == 200) {
                //**读取服务器返回过来的json字符串数据**//*
                str = EntityUtils.toString(result.getEntity());
                //**把json字符串转换成json对象**//*
            
                //jsonResult =JSONObject.fromObject(str).getString("resp_code");
           
        }
        return str;
    }
    

   
}
