package com.yabushan.test.util.excel.jxl;

import java.io.File;

import jxl.*;

import jxl.write.Label;

import jxl.write.WritableSheet;

import jxl.write.WritableWorkbook;
/**
 * 向excel工作表中添加数值
 * 
 * @author yabushan
 *
 */
public class ExcelOperationUtilNumber {
	public static void main(String[] args) {
		addInfoToExcel("豆腐", "11", "2");
		
	}



public static boolean addInfoToExcel(String name,String count,String price){

	try {				

		WritableWorkbook book = Workbook.createWorkbook(new File("E:\\test\\商品.xls"));

		WritableSheet sheet = book.createSheet("商品", 0);

		Label label_name = new Label(0,0,"商品名称");

		Label label_count = new Label(1,0,"商品数量");

		Label label_price = new Label(2,0,"商品单价");

		
		Label name_value = new Label(0,1,name);

		//创建数值类型的单元格对象

		jxl.write.Number count_value = new jxl.write.Number(1,1,Double.parseDouble(count));

		//创建数值类型的单元格对象

		jxl.write.Number price_value = new jxl.write.Number(2,1,Double.parseDouble(price));

		sheet.addCell(label_name);

		sheet.addCell(label_count);

		sheet.addCell(label_price);

		sheet.addCell(name_value);

		sheet.addCell(price_value);

		sheet.addCell(count_value);

		book.write();

		book.close();

		return true;

	} catch (Exception e) {

		System.out.println("异常信息："+e.getMessage());

		e.printStackTrace();

		return false;

	}

}

}

