package com.yabushan.test.util.excel.jxl;

import java.io.File;

import java.io.IOException;

import java.text.SimpleDateFormat;

import java.util.Calendar;

import java.util.Date;

import jxl.*;

import jxl.format.Alignment;

import jxl.format.UnderlineStyle;

import jxl.write.Font;

import jxl.write.Label;

import jxl.write.NumberFormat;

import jxl.write.WritableCell;

import jxl.write.WritableCellFormat;

import jxl.write.WritableFont;

import jxl.write.WritableSheet;

import jxl.write.WritableWorkbook;
/**
 * 设置excel工作表字体样式
 * @author yabushan
 *
 */

public class ExcelOperationUtilStype {
	
	public static void main(String[] args) {
		addInfoToExcel("yabushan", "男", "22", "1992-10-12");
	}

	public static  boolean addInfoToExcel(String name, String sex, String age,
			String birthday) {

		try {

			WritableWorkbook book = Workbook.createWorkbook(new File(
					"E:\\test\\用户信息.xls"));

			WritableSheet sheet = book.createSheet("用户信息", 0);

			Label label_name = new Label(0, 0, "姓名");

			Label label_sex = new Label(1, 0, "性别");

			Label label_age = new Label(2, 0, "年龄");

			Label label_birthday = new Label(3, 0, "生日");

			// 设置字体样式
			/**
			 * xl.write.WritableFont(
					WritableFont.ARIAL, 15, WritableFont.BOLD, false,
					UnderlineStyle.SINGLE_ACCOUNTING, jxl.format.Colour.GREEN);
					
					WritableFont.ARIAL:字体样式名称;
					15:设置字体的大小；
					WritableFont.BOLD :设置字体是否加粗；
					false：设置字体是否倾斜
					UnderlineStyle.SINGLE_ACCOUNTING ： 设置字体是否带有下划线
					jxl.format.Colour.GREEN：设置字体颜色
					
					
			 */

			jxl.write.WritableFont font = new jxl.write.WritableFont(
					WritableFont.ARIAL, 15, WritableFont.BOLD, false,
					UnderlineStyle.SINGLE_ACCOUNTING, jxl.format.Colour.GREEN);
			jxl.write.WritableFont font2 = new jxl.write.WritableFont(
					WritableFont.COURIER, 10, WritableFont.BOLD, true,
					UnderlineStyle.SINGLE_ACCOUNTING, jxl.format.Colour.RED);

			jxl.write.WritableCellFormat fontFormat = new jxl.write.WritableCellFormat(
					font);
			jxl.write.WritableCellFormat fontFormat2 = new jxl.write.WritableCellFormat(
					font2);

			Label name_value = new Label(0, 1, name, fontFormat);

			Label sex_value = new Label(1, 1, sex);

			Label age_value = new Label(2, 1, age,fontFormat2);

			Label birthday_value = new Label(3, 1, birthday);

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

			System.out.println("异常信息：" + e.getMessage());

			e.printStackTrace();

			return false;

		}

	}

}
