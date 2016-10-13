package com.yabushan.test.util.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Export {
	/**
	 * 
	 * 导出excel，单页
	 * @param list
	 * @param type
	 * @param list 要导出的数据
	 * @param key 对应list中的数据：map中的key值（用,分隔）
	 * @param templatePath 文档的名字
	 * @param 页数
	 * @return 
	 * @throws IOException 
	 */
	public String createExcel(List<Map<String, Object>> list, String key, String templatePath, int page) throws IOException{
		String uri = "f:/www.xls";//GlobalConfig.getConfigValue("excelFile.path");模板路径
		File f = new File(uri);
		if (!f.exists()) {
			f.mkdirs();
		}
		String excelPath = ""; 
		String templateName = templatePath.substring(templatePath.lastIndexOf("/")+1);
		String [] keys =key.split(",");
		Row row = null;
		FileInputStream is = null;
		FileOutputStream out = null;
		try {
			is = new FileInputStream(new File(templatePath));
			Workbook workbook = WorkbookFactory.create(is); 
			Sheet sheet = workbook.getSheetAt(page);
			int rownum =2;
			for(Map<String, Object> map : list){
				row = sheet.createRow(rownum);
				for(int i=0;i<keys.length;i++){
					Cell cell = row.createCell(i);
					cell.setCellValue(map.get(keys[i].trim()) == null ? " " : map.get(keys[i].trim())+"");
				}
				rownum ++;
			}
			excelPath = uri+templateName;
			out = new FileOutputStream(excelPath);  
			workbook.write(out);
		} catch (Exception e) {
			e.printStackTrace();
			return excelPath;
		}finally{
			if(is!=null){
				is.close();
			}
			if(out!=null){
				out.close();
			}
		}
		return excelPath;		
	}
}
