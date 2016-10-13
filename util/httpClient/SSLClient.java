package com.yabushan.test.util.httpClient;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
//用于进行http请求的httpclient
public class SSLClient extends DefaultHttpClient{
	public SSLClient() throws Exception{
		//super();
		SSLContext ctxContext=SSLContext.getInstance("TLS");
		X509TrustManager tm=new X509TrustManager() {
			
			@Override
			public X509Certificate[] getAcceptedIssuers() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void checkServerTrusted(X509Certificate[] chain, String authType)
					throws CertificateException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void checkClientTrusted(X509Certificate[] chain, String authType)
					throws CertificateException {
				// TODO Auto-generated method stub
				
			}
		};
		ctxContext.init(null,new TrustManager[]{tm} , null);
		SSLSocketFactory ssf=new SSLSocketFactory(ctxContext, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
		ClientConnectionManager ccm=this.getConnectionManager();
		SchemeRegistry sr=ccm.getSchemeRegistry();
		sr.register(new Scheme("https", 443, ssf));

	}

}
