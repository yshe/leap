package com.yabushan.test.util.excel.jxl;

import java.io.File;

import java.io.FileInputStream;

import jxl.*;

import jxl.format.Alignment;

import jxl.format.UnderlineStyle;

import jxl.format.VerticalAlignment;

import jxl.write.Label;

import jxl.write.WritableFont;

import jxl.write.WritableImage;

import jxl.write.WritableSheet;

import jxl.write.WritableWorkbook;
/**
 * 向excel工作表中插入图片
 * @author yabushan
 *
 */
public class ExcelOperationUtilImage {

	public boolean addInfoToExcel(String name, String sex, String age,
			String dept, String imgPath) {

		try {

			File dir = new File("E:\\test");

			if (!dir.exists())
				;

			dir.mkdirs();

			File xlsFile = new File(dir.getPath(), "员工信息.xls");

			if (!xlsFile.exists())
				;

			xlsFile.createNewFile();

			WritableWorkbook book = Workbook.createWorkbook(xlsFile);

			WritableSheet sheet = book.createSheet("员工信息", 0);

			// 设置字体样式

			jxl.write.WritableFont font = new jxl.write.WritableFont(
					WritableFont.ARIAL, 15, WritableFont.BOLD, false,
					UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.GREEN);

			jxl.write.WritableCellFormat cellFormat = new jxl.write.WritableCellFormat(
					font);

			cellFormat.setAlignment(Alignment.CENTRE);

			cellFormat.setVerticalAlignment(VerticalAlignment.CENTRE);

			File file = new File(imgPath);// 根据图片路径创建File对象

			FileInputStream fs = new FileInputStream(file);// 创建字节输入流，用于读取图片字节数据

			byte[] bytes = new byte[fs.available()];// 根据图片的字节数，创建字节数组

			fs.read(bytes);// 读取图片字节数据保存到字节数组中

			WritableImage image = new WritableImage(0, 0, 1, 1, bytes);// 创建WritableImage对象，

			Label label_title = new Label(0, 0, "员工信息表", cellFormat);

			sheet.mergeCells(0, 0, 3, 0);// 合并第一行的第1个到第4个单元格

			sheet.setRowView(0, 600, false);// 设置第一行的行高

			Label label_name = new Label(0, 1, "姓名");

			Label label_sex = new Label(1, 1, "性别");

			Label label_age = new Label(2, 1, "年龄");

			Label label_dept = new Label(3, 1, "所在部门");

			Label name_value = new Label(0, 2, name);

			Label sex_value = new Label(1, 2, sex);

			Label age_value = new Label(2, 2, age);

			Label dept_value = new Label(3, 2, dept);

			sheet.addCell(label_title);

			sheet.addCell(label_name);

			sheet.addCell(label_sex);

			sheet.addCell(label_age);

			sheet.addCell(label_dept);

			sheet.addCell(name_value);

			sheet.addCell(sex_value);

			sheet.addCell(age_value);

			sheet.addCell(dept_value);

			sheet.addImage(image);

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
