package com.yabushan.test.util.excel.jxl;

import java.io.File;

import java.io.FileInputStream;

import java.util.ArrayList;

import java.util.List;

import jxl.*;

/**
 * 读取excel中的数据和图片并保存到数据库
 * @author yabushan
 *
 */
public class ReadFromExcel {

	public List<Employee> readExcelData(String filePath) {

		List<Employee> list = new ArrayList<Employee>();

		try {

			File xlsFile = new File(filePath);

			FileInputStream fs = new FileInputStream(xlsFile);

			Workbook book = Workbook.getWorkbook(fs);// 获取工作簿对象

			Sheet sheet = book.getSheet(0);// 获取工作表对象

			int rows = sheet.getRows();// 获取工作表中的数据行数

			for (int i = 2; i < rows; i++) {// 循环Excel工作表的行，并读取单元格数据

				Image img = sheet.getDrawing(0);// 获取工作表中的图片对象

				Employee emp = new Employee();

				String name = sheet.getCell(0, i).getContents();

				String sex = sheet.getCell(1, i).getContents();

				String dept = sheet.getCell(2, i).getContents();

				String duty = sheet.getCell(3, i).getContents();

				String telephone = sheet.getCell(4, i).getContents();

				emp.setName(name);

				emp.setSex(sex);

				emp.setDept(dept);

				emp.setDuty(duty);

				emp.setTelephone(telephone);

				emp.setImage(img);

				list.add(emp);

			}

			return list;

		} catch (Exception e) {

			System.out.println("异常信息：" + e.getMessage());

			e.printStackTrace();

			return null;

		}

	}

}
