package com.yabushan.test.util.excel.poi;

import java.io.File;

import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;

import org.apache.poi.hssf.usermodel.HSSFRow;

import org.apache.poi.hssf.usermodel.HSSFSheet;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.hssf.util.Region;
/**
 * 合并单元格
 * @author yabushan
 *
 */
public class ExcelOperationUtilMergeCell {

	public boolean CreateExcelFile(String filePath, String fileName) {

		try {

			HSSFWorkbook workbook = new HSSFWorkbook();// 创建Excel工作簿对象

			HSSFSheet sheet = workbook.createSheet();// 在工作簿中创建工作表对象

			workbook.setSheetName(0, "测试");// 设置工作表的名称

			HSSFRow row1 = sheet.createRow(0);// 在工作表中创建行对象

			sheet.addMergedRegion(new Region(0, (short) 0, 0, (short) 5));// 合并第1行的第1个到第5个之间的单元格

			HSSFCell titleCell = row1.createCell(0);

			titleCell.setCellValue("员工信息表");

			titleCell.setCellStyle(alignStyle(workbook,
					HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER));

			HSSFRow row2 = sheet.createRow(1);

			HSSFCell nameCell = row2.createCell(0);// 在第1行中创建单元格对象

			nameCell.setCellValue("员工姓名");

			nameCell.setCellStyle(alignStyle(workbook,
					HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER));

			HSSFCell sexCell = row2.createCell(1);// 在行中创建单元格对象

			sexCell.setCellValue("员工性别");

			sexCell.setCellStyle(alignStyle(workbook,
					HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER));

			HSSFCell ageCell = row2.createCell(2);// 在行中创建单元格对象

			ageCell.setCellValue("员工年龄");

			ageCell.setCellStyle(alignStyle(workbook,
					HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER));

			HSSFCell deptCell = row2.createCell(3);// 在行中创建单元格对象

			deptCell.setCellValue("所在部门");

			deptCell.setCellStyle(alignStyle(workbook,
					HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER));

			HSSFCell dutyCell = row2.createCell(4);// 在行中创建单元格对象

			dutyCell.setCellValue("职务");

			dutyCell.setCellStyle(alignStyle(workbook,
					HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER));

			HSSFCell phoneCell = row2.createCell(5);// 在行中创建单元格对象

			phoneCell.setCellValue("联系电话");

			phoneCell.setCellStyle(alignStyle(workbook,
					HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER));

			HSSFRow row3 = sheet.createRow(2);// 在工作表中创建行对象

			HSSFCell nameValue = row3.createCell(0);// 在第2行中创建单元格对象

			nameValue.setCellValue("张三");

			nameValue.setCellStyle(alignStyle(workbook,
					HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER));

			HSSFCell sexValue = row3.createCell(1);// 在行中创建单元格对象

			sexValue.setCellValue("男");

			sexValue.setCellStyle(alignStyle(workbook,
					HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER));

			HSSFCell ageValue = row3.createCell(2);// 在行中创建单元格对象

			ageValue.setCellValue(25);

			ageValue.setCellStyle(alignStyle(workbook,
					HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER));

			HSSFCell deptValue = row3.createCell(3);// 在行中创建单元格对象

			deptValue.setCellValue("软件开发部");

			deptValue.setCellStyle(alignStyle(workbook,
					HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER));

			HSSFCell dutyValue = row3.createCell(4);// 在行中创建单元格对象

			dutyValue.setCellValue("程序员");

			dutyValue.setCellStyle(alignStyle(workbook,
					HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER));

			HSSFCell phoneValue = row3.createCell(5);// 在行中创建单元格对象

			phoneValue.setCellValue("13988888888");

			phoneValue.setCellStyle(alignStyle(workbook,
					HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER));

			File xlsFile = new File(filePath, fileName);

			FileOutputStream fos = new FileOutputStream(xlsFile);

			workbook.write(fos);// 将文档对象写入文件输出流

			fos.close();

			return true;

		} catch (Exception e) {

			e.printStackTrace();

			return false;

		}

	}

	private static HSSFCellStyle alignStyle(HSSFWorkbook wb, short align,
			short v_align)

	{

		HSSFCellStyle cellStyle = wb.createCellStyle();

		cellStyle.setAlignment(align);

		cellStyle.setVerticalAlignment(v_align);

		return cellStyle;

	}

}
