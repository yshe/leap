package com.yabushan.test.util.common;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
/**
 * 从XML文件中读取数据
 * @author yabushan
 *
 */
public class ReadXMLData {
	
	public static void main(String[] args) {
		 System.out.println(Thread.currentThread().getContextClassLoader().getResource("").getPath().substring(1));;
		ReadXMLData readXMLData=new ReadXMLData(new File("E://gitProject/Project/yabushan/src/main/resources/jdbc.xml"));
		System.out.println(readXMLData.readXml("jdbc"));
		 //E:\gitProject\Project\yabushan\src\main\resources\spring-mvc.xml
	}
	
	private static Document document;    	//定义Document对象
	private File xmlFile;					//定义File对象
	public File getXmlFile() {
		return xmlFile;
	}
	public void setXmlFile(File xmlFile) {
		this.xmlFile = xmlFile;
	}
	public ReadXMLData(File xmlFile){		//带参数的构造方法
		this.xmlFile=xmlFile;
	}
	public   String readXml(String str) {
	//定义从XMl文档获取生成DOM对象的解析器
	    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    try {
	        DocumentBuilder builder = factory.newDocumentBuilder(); 
	        document = builder.parse(xmlFile); 		//根据XML获取DOM文档实例
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    String subNodeTag = document.getElementsByTagName(str).item(0)
	            .getFirstChild().getNodeValue();    //获取指定节点保存的值
	   return subNodeTag;          				  //返回读取的信息
	}

}
