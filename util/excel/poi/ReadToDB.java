package com.yabushan.test.util.excel.poi;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import com.yabushan.test.util.excel.jxl.Employee;
/**
 * 读取数据保存到数据库
 * @author yabushan
 *
 */
public class ReadToDB {

	public List<Employee> readExcelFileToDB(String filePath) {

		List<Employee> list = new ArrayList<Employee>();

		try {

			FileInputStream fis = new FileInputStream(filePath);

			POIFSFileSystem fs = new POIFSFileSystem(fis);

			HSSFWorkbook workbook = new HSSFWorkbook(fs);// 创建Excel工作簿对象

			HSSFSheet sheet = workbook.getSheetAt(0);// 获取第1个工作表

			HSSFPatriarch patriarch = sheet.getDrawingPatriarch();

			for (int i = 2; i <= sheet.getLastRowNum(); i++) {// 循环Excel文件的每一行

				Employee emp = new Employee();

				HSSFRow row = sheet.getRow(i);// 获取第i行

				HSSFCell cell1 = row.getCell(0);

				HSSFCell cell2 = row.getCell(1);

				HSSFCell cell3 = row.getCell(2);

				HSSFCell cell4 = row.getCell(3);

				HSSFCell cell5 = row.getCell(4);

				String name = cell1.getStringCellValue();// 获取第i行的第1个单元格的数据

				emp.setName(name);

				String sex = cell2.getStringCellValue();// 获取第i行的第2个单元格的数据

				emp.setSex(sex);

				String dept = cell3.getStringCellValue();// 获取第i行的第3个单元格的数据

				emp.setDept(dept);

				String duty = cell4.getStringCellValue();// 获取第i行的第4个单元格的数据

				emp.setDuty(duty);

				String phone = cell5.getStringCellValue();// 获取第i行的第5个单元格的数据

				emp.setTelephone(phone);

				list.add(emp);

			}

			fis.close();

			return list;

		} catch (Exception e) {

			e.printStackTrace();

			return null;

		}

	}

}
