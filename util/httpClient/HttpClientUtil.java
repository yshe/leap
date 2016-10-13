package com.yabushan.test.util.httpClient;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpClientUtil {
	public String doPost(String url,Map<String , String> map,String charset) throws Exception{
		
		HttpClient httpClient=null;
		HttpPost httpPost=null;
		String result=null;
	
			httpClient=new SSLClient();
			httpPost=new HttpPost(url);
			//设置参数
			List<NameValuePair> list=new ArrayList<NameValuePair>();
			Iterator iterator =map.entrySet().iterator();
			while(iterator.hasNext()){
				Entry<String , String > elem=(Entry<String, String>) iterator.next();
				list.add(new BasicNameValuePair(elem.getKey(), elem.getValue()));
				
			}
			if(list.size()>0){
				UrlEncodedFormEntity entity=new UrlEncodedFormEntity(list, charset);
				httpPost.setEntity(entity);
			}
			HttpResponse response=httpClient.execute(httpPost);
			if(response!=null){
				HttpEntity reseEntity=response.getEntity();
				if(reseEntity!=null){
					result=EntityUtils.toString(reseEntity);
				}
				
			}
			
		
		return result;
	}
}
