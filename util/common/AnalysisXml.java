package com.yabushan.test.util.common;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 
 * @author hongliang.dinghl Dom4j 生成XML文档与解析XML文档
 */
public class AnalysisXml {
	
	Logger logger =Logger.getLogger(AnalysisXml.class);
	//static final String relativelyPath = System.getProperty("user.dir");
	
	public static Map<String, String> parserXml(String fileName) {
		String realPathString=AnalysisXml.class.getClassLoader().getResource("/").getPath();
		
		Logger logger=Logger.getLogger(AnalysisXml.class);
		Map<String, String> params = null;
		String filePath = realPathString  + fileName;
		//System.out.println(filePath);
		logger.info("filePath"+filePath);
		File inputXml = new File(filePath);
		SAXReader saxReader = new SAXReader();
		try {
			params = new HashMap<String, String>();
			Document document = saxReader.read(inputXml);
			Element employees = document.getRootElement();
			for (Iterator i = employees.elementIterator(); i.hasNext();) {
				Element employee = (Element) i.next();
				for (Iterator j = employee.elementIterator(); j.hasNext();) {
					Element node = (Element) j.next();
					params.put(node.getName(), node.getText());
				}
			}
		} catch (DocumentException e) {
			logger.error(" 生成XML文档与解析XML文档错误"+e);
		}
		return params;
	}

}
