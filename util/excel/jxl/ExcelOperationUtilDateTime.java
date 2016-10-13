package com.yabushan.test.util.excel.jxl;


import java.io.File;

import java.util.Calendar;

import jxl.*;

import jxl.write.Label;

import jxl.write.WritableSheet;

import jxl.write.WritableWorkbook;
/**
 * 向excel工作表中添加格式化日期时间
 * @author yabushan
 *
 */
public class ExcelOperationUtilDateTime{



public boolean addInfoToExcel(String name,String sex,String age,String birthday){

	try {				

		File dir = new File("E:\\test");

		if(!dir.exists());

			dir.mkdirs();

		File xlsFile = new File(dir.getPath(),"用户信息.xls")	;

		WritableWorkbook book = Workbook.createWorkbook(new File("E:\\test\\用户信息.xls"));

		WritableSheet sheet = book.createSheet("用户信息", 0);

		Label label_name = new Label(0,0,"姓名");

		Label label_sex = new Label(1,0,"性别");

		Label label_age = new Label(2,0,"年龄");

		Label label_birthday = new Label(3,0,"生日");

		Label name_value = new Label(0,1,name);

		Label sex_value = new Label(1,1,sex);

		Label age_value = new Label(2,1,age);

		String[] dateStr = birthday.split("-");//分割生日字符串

		Calendar c = Calendar.getInstance();//创建Calendar对象

		//将用户生日的年月日，设置为Calendar对象的年月日

		c.set(Integer.parseInt(dateStr[0]), (Integer.parseInt(dateStr[1])-1), Integer.parseInt(dateStr[2]));

		//创建日期时间类型的单元格对象，并将表示用户生日的Calendar对象添加到该对象中

		jxl.write.DateTime date_value = new jxl.write.DateTime(3,1,c.getTime());

		sheet.addCell(label_name);

		sheet.addCell(label_sex);

		sheet.addCell(label_age);

		sheet.addCell(label_birthday);

		sheet.addCell(name_value);

		sheet.addCell(sex_value);

		sheet.addCell(age_value);

		sheet.addCell(date_value);

		book.write();

		book.close();

		return true;

	} catch (Exception e) {

		System.out.println("异常信息："+e.getMessage());

		e.printStackTrace();

		return false;

	}

}

/**
 * 添加格式化日期时间
 * @param name
 * @param sex
 * @param age
 * @param birthday
 * @return
 */
public boolean addInfoToExcel2(String name,String sex,String age,String birthday){

	try {				

		WritableWorkbook book = Workbook.createWorkbook(new File("E:\\test\\用户信息.xls"));

		WritableSheet sheet = book.createSheet("用户信息", 0);

		Label label_name = new Label(0,0,"姓名");

		Label label_sex = new Label(1,0,"性别");

		Label label_age = new Label(2,0,"年龄");

		Label label_birthday = new Label(3,0,"生日");	

		Label name_value = new Label(0,1,name);

		Label sex_value = new Label(1,1,sex);

		Label age_value = new Label(2,1,age);

		String[] dateStr = birthday.split("-");//分割生日字符串

		Calendar c = Calendar.getInstance();//创建Calendar对象

		//将用户生日的年月日，设置为Calendar对象的年月日

		c.set(Integer.parseInt(dateStr[0]), (Integer.parseInt(dateStr[1])-1), Integer.parseInt(dateStr[2]));

		jxl.write.DateFormat format = new jxl.write.DateFormat("dd-mm-yyyy");

		jxl.write.WritableCellFormat cellFormat = new jxl.write.WritableCellFormat(format);

		//创建日期时间类型的单元格对象，并将表示用户生日的Calendar对象添加到该对象中

		jxl.write.DateTime date_value = new jxl.write.DateTime(3,1,c.getTime(),cellFormat);	

		sheet.addCell(label_name);

		sheet.addCell(label_sex);

		sheet.addCell(label_age);

		sheet.addCell(label_birthday);

		sheet.addCell(name_value);

		sheet.addCell(sex_value);

		sheet.addCell(age_value);

		sheet.addCell(date_value);

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

