package com.yabushan.test.util.excel.jxl;

import java.io.File;

import jxl.*;

import jxl.write.Label;

import jxl.write.NumberFormat;

import jxl.write.WritableCellFormat;

import jxl.write.WritableSheet;

import jxl.write.WritableWorkbook;
/**
 * 向excel工作表中添加格式化数值
 * @author yabushan
 *
 */
public class ExcelOperationUtilFormateNumber {

	public boolean addInfoToExcel(String name, String price) {

		try {

			WritableWorkbook book = Workbook.createWorkbook(new File(
					"E:\\test\\蔬菜.xls"));

			WritableSheet sheet = book.createSheet("蔬菜", 0);

			Label label_name = new Label(0, 0, "蔬菜名称");

			Label label_price = new Label(1, 0, "全国平均售价");

			Label name_value = new Label(0, 1, name);

			NumberFormat format = new NumberFormat("#.##");// 数值格式化模板

			WritableCellFormat cellFormat = new WritableCellFormat(format);

			// 创建数值类型的单元格对象，并且应用指定格式

			jxl.write.Number price_value = new jxl.write.Number(1, 1,
					Double.parseDouble(price), cellFormat);

			sheet.addCell(label_name);

			sheet.addCell(label_price);

			sheet.addCell(name_value);

			sheet.addCell(price_value);

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
