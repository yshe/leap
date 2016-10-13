package com.yabushan.test.util.excel.jxl;

import java.io.File;

import java.io.IOException;

import jxl.*;

import jxl.format.Alignment;

import jxl.write.Label;

import jxl.write.NumberFormat;

import jxl.write.WritableCell;

import jxl.write.WritableCellFormat;

import jxl.write.WritableSheet;

import jxl.write.WritableWorkbook;
/**
 * 想excel工作表中添加boolean值
 * @author yabushan
 *
 */
public class ExcelOperationUtilBoolean {

	public boolean addInfoToExcel(String name, String price, String isUp) {

		try {

			WritableWorkbook book = Workbook.createWorkbook(new File(
					"E:\\test\\蔬菜.xls"));

			WritableSheet sheet = book.createSheet("蔬菜", 0);

			Label label_name = new Label(0, 0, "蔬菜名称");

			Label label_price = new Label(1, 0, "市场平均售价");

			Label label_is = new Label(2, 0, "预测是否涨价");

			Label name_value = new Label(0, 1, name);

			jxl.write.Boolean b;

			if (isUp.equals("yes")) {

				b = new jxl.write.Boolean(2, 1, true);

			} else {

				b = new jxl.write.Boolean(2, 1, false);

			}

			NumberFormat format = new NumberFormat("#.##");// 数值格式化模板

			WritableCellFormat cellFormat = new WritableCellFormat(format);

			// 创建数值类型的单元格对象，并且应用指定格式

			jxl.write.Number price_value = new jxl.write.Number(1, 1,
					Double.parseDouble(price), cellFormat);

			sheet.addCell(label_name);

			sheet.addCell(label_price);

			sheet.addCell(name_value);

			sheet.addCell(price_value);

			sheet.addCell(label_is);

			sheet.addCell(b);

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
