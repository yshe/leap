package com.yabushan.test.util.excel.jxl;

import java.io.File;

import java.util.List;

import jxl.*;

import jxl.format.Alignment;

import jxl.format.Colour;

import jxl.format.UnderlineStyle;

import jxl.format.VerticalAlignment;

import jxl.write.Label;

import jxl.write.WritableFont;

import jxl.write.WritableSheet;

import jxl.write.WritableWorkbook;
/**
 * 导出数据库数据到excel
 * @author yabushan
 *
 */
public class ExportFromDB {

	public boolean readDataToExcelFile(List<Employee> list) {

		try {

			WritableWorkbook book = Workbook.createWorkbook(new File(
					"E:\\test\\员工信息.xls"));

			WritableSheet sheet = book.createSheet("员工信息", 0);

			// 设置字体样式

			jxl.write.WritableFont font = new jxl.write.WritableFont(
					WritableFont.ARIAL, 15, WritableFont.BOLD, false,
					UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.GREEN);

			jxl.write.WritableCellFormat cellFormat = new jxl.write.WritableCellFormat(
					font);

			cellFormat.setAlignment(Alignment.CENTRE);

			cellFormat.setVerticalAlignment(VerticalAlignment.CENTRE);// 设置单元格内容两端对齐

			cellFormat.setBackground(Colour.GRAY_25);// 背景颜色

			Label label_title = new Label(0, 0, "员工信息表", cellFormat);

			sheet.mergeCells(0, 0, 4, 0);// 合并第一行的第1个到第5个单元格

			sheet.setRowView(0, 600, false);// 设置第一行的行高

			Label label_name = new Label(0, 1, "员工姓名");

			Label label_sex = new Label(1, 1, "员工性别");

			Label label_dept = new Label(2, 1, "所在部门");

			Label label_duty = new Label(3, 1, "职务");

			Label label_telephone = new Label(4, 1, "联系电话");

			sheet.setColumnView(4, 15);// 设置列宽

			sheet.addCell(label_title);

			sheet.addCell(label_name);

			sheet.addCell(label_sex);

			sheet.addCell(label_dept);

			sheet.addCell(label_duty);

			sheet.addCell(label_telephone);

			for (int i = 0; i < list.size(); i++) {// 遍历保存员工信息对象的集合，将所有员工信息导出到Excel

				Employee emp = (Employee) list.get(i);

				Label name_value = new Label(0, i + 2, emp.getName());

				Label sex_value = new Label(1, i + 2, emp.getSex());

				Label dept_value = new Label(2, i + 2, emp.getDept());

				Label duty_value = new Label(3, i + 2, emp.getDuty());

				Label telephone_value = new Label(4, i + 2, emp.getTelephone());

				sheet.addCell(name_value);

				sheet.addCell(sex_value);

				sheet.addCell(dept_value);

				sheet.addCell(duty_value);

				sheet.addCell(telephone_value);

			}

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
