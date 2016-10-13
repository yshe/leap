package com.yabushan.test.util.excel.jxl;

import java.io.File;

import jxl.*;

import jxl.write.Label;

import jxl.write.WritableSheet;

import jxl.write.WritableWorkbook;
/**
 * 字符串形式导出
 * @author yabushan
 *
 */
public class ExcelOperationUtil1 {
	
	public static void main(String[] args) {
		Employee employee=new Employee();
		employee.setAge(11);
		employee.setName("yabushan");
		employee.setSex("男");
		employee.setTelephone("111111");
		addInfoToExcel(employee);
	}

	public static boolean addInfoToExcel(Employee emp) {

		try {

			File folder = new File("E:\\test\\");

			if (!folder.exists())

				folder.mkdirs();

			File xlsFile = new File(folder, "测试.xls");

			if (!xlsFile.exists())

				xlsFile.createNewFile();

			// 根据File文件对象来创建工作簿

			WritableWorkbook book = Workbook.createWorkbook(xlsFile);

			// 创建工作表，设置名称为"第一页"

			WritableSheet sheet = book.createSheet("第一页", 0);

			Label name = new Label(0, 0, "员工姓名");

			Label sex = new Label(1, 0, "员工性别");

			Label age = new Label(2, 0, "员工年龄");

			Label telephone = new Label(3, 0, "联系电话");

			Label name_value = new Label(0, 1, emp.getName());

			Label sex_value = new Label(1, 1, emp.getSex());

			Label age_value = new Label(2, 1, emp.getAge() + "");

			Label tele_value = new Label(3, 1, emp.getTelephone());

			sheet.addCell(name);

			sheet.addCell(sex);

			sheet.addCell(age);

			sheet.addCell(telephone);

			sheet.addCell(name_value);

			sheet.addCell(sex_value);

			sheet.addCell(age_value);

			sheet.addCell(tele_value);

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
