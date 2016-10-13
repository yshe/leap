package com.yabushan.test.util.excel.jxl;


import java.io.File;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.Orientation;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
/**
 * 合并单元格
 * @author yabushan
 *
 */
public class ExcelOperationUtilMergeCell {



public boolean addInfoToExcel(String name,String sex,String age,String birthday){

	try {				

		WritableWorkbook book = Workbook.createWorkbook(new File("E:\\test\\用户信息.xls"));

		WritableSheet sheet = book.createSheet("用户信息", 0);

		//设置字体样式

		jxl.write.WritableFont font = new jxl.write.WritableFont(WritableFont.ARIAL, 15, WritableFont.BOLD, false,UnderlineStyle.SINGLE, jxl.format.Colour.GREEN);

		jxl.write.WritableCellFormat fontFormat = new jxl.write.WritableCellFormat(font);
		
		fontFormat.setAlignment(Alignment.CENTRE); //设置单元格内容水平居中
		fontFormat.setVerticalAlignment(VerticalAlignment.CENTRE);//设置单元格内容垂直居中显示
		Label label_title = new Label(0,0,"用户信息",fontFormat);//单元格字体样式

		sheet.mergeCells(0,0,3,0);//合并第一行的第1个到第3个单元格		
		sheet.setRowView(0, 400,false);//设置第一行的行高
		sheet.setColumnView(0, 20);//设置第1列宽度
		fontFormat.setWrap(true);//自动换行
		sheet.setColumnView(1, 20);//设置第2列宽度

		sheet.setColumnView(2, 20);//设置第3列宽度

		sheet.setColumnView(3, 20);//设置第4列宽度

		Label label_name = new Label(0,1,"姓名");

		Label label_sex = new Label(1,1,"性别");

		Label label_age = new Label(2,1,"年龄");

		Label label_birthday = new Label(3,1,"生日");		

		Label name_value = new Label(0,2,name);

		Label sex_value = new Label(1,2,sex);

		Label age_value = new Label(2,2,age);

		Label birthday_value = new Label(3,2,birthday);

		sheet.addCell(label_title);

		sheet.addCell(label_name);

		sheet.addCell(label_sex);

		sheet.addCell(label_age);

		sheet.addCell(label_birthday);

		sheet.addCell(name_value);

		sheet.addCell(sex_value);

		sheet.addCell(age_value);

		sheet.addCell(birthday_value);

		book.write();

		book.close();

		return true;

	} catch (Exception e) {

		System.out.println("异常信息："+e.getMessage());

		e.printStackTrace();

		return false;

	}

}
public boolean addInfoToExcel2(String name,String sex,String age,String dept){

	try {

		WritableWorkbook book = Workbook.createWorkbook(new File("E:\\test\\员工信息.xls"));

		WritableSheet sheet = book.createSheet("员工信息", 0);

		//设置字体样式

		jxl.write.WritableFont font = new jxl.write.WritableFont(WritableFont.ARIAL, 15, WritableFont.BOLD, false,UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.GREEN);

		jxl.write.WritableCellFormat cellFormat = new jxl.write.WritableCellFormat(font);	

		cellFormat.setAlignment(Alignment.CENTRE);

		cellFormat.setVerticalAlignment(VerticalAlignment.JUSTIFY);//设置单元格内容两端对齐

		cellFormat.setBackground(Colour.GRAY_25);//背景颜色

		cellFormat.setBorder(Border.ALL, BorderLineStyle.THICK,Colour.DARK_GREEN);//边框样式

		cellFormat.setShrinkToFit(true);//缩进

		cellFormat.setOrientation(Orientation.PLUS_45);//文字方向

		cellFormat.setIndentation(200);//凹进

		Label label_title = new Label(0,0,"员工信息表",cellFormat);

		sheet.mergeCells(0,0,3,0);//合并第一行的第1个到第4个单元格				

		sheet.setRowView(0, 600,false);//设置第一行的行高		

		Label label_name = new Label(0,1,"姓名");

		Label label_sex = new Label(1,1,"性别");

		Label label_age = new Label(2,1,"年龄");

		Label label_dept = new Label(3,1,"所在部门");		

		Label name_value = new Label(0,2,name);

		Label sex_value = new Label(1,2,sex);

		Label age_value = new Label(2,2,age);

		Label dept_value = new Label(3,2,dept);

		sheet.addCell(label_title);

		sheet.addCell(label_name);

		sheet.addCell(label_sex);

		sheet.addCell(label_age);

		sheet.addCell(label_dept);

		sheet.addCell(name_value);

		sheet.addCell(sex_value);

		sheet.addCell(age_value);

		sheet.addCell(dept_value);

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

