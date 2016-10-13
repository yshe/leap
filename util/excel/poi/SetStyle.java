package com.yabushan.test.util.excel.poi;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFFooter;
import org.apache.poi.hssf.usermodel.HSSFHeader;
import org.apache.poi.hssf.usermodel.HSSFPrintSetup;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.hssf.util.Region;
import org.apache.poi.ss.usermodel.CellStyle;

import com.yabushan.test.util.excel.jxl.Employee;
/**
 * 设置打印属性
 * @author yabushan
 *
 */
public class SetStyle {

	public boolean readDataToExcelFile(List<Employee> list) {

		try {

			HSSFWorkbook workbook = new HSSFWorkbook();// 创建Excel工作簿对象

			HSSFSheet sheet = workbook.createSheet();// 在工作簿中创建工作表对象

			sheet = this.setPrint(sheet);

			sheet.setColumnWidth(3, 256 * 12);

			sheet.setColumnWidth(4, 256 * 14);

			workbook.setSheetName(0, "测试");// 设置工作表的名称

			HSSFRow row1 = sheet.createRow(0);// 在工作表中创建行对象

			sheet.addMergedRegion(new Region(0, (short) 0, 0, (short) 4));// 合并第1行的第1个到第5个之间的单元格

			HSSFFont font = workbook.createFont();// 创建字体对象

			font.setColor(HSSFColor.SKY_BLUE.index);// 设置字体颜色

			font.setFontHeightInPoints((short) 14);// 设置字号

			font.setFontName("楷体");// 设置字体样式

			HSSFCellStyle titleStyle = workbook.createCellStyle();

			titleStyle.setFont(font);

			titleStyle.setAlignment(CellStyle.ALIGN_CENTER);// 设置水平居中

			titleStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);// 设置垂直居中

			HSSFCellStyle cellStyle = workbook.createCellStyle();

			cellStyle.setAlignment(CellStyle.ALIGN_CENTER);// 设置水平居中

			cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);// 设置垂直居中

			HSSFCell titleCell = row1.createCell(0);

			titleCell.setCellValue("员工信息表");

			titleCell.setCellStyle(titleStyle);

			HSSFRow row2 = sheet.createRow(1);

			HSSFCell nameCell = row2.createCell(0);// 在第1行中创建单元格对象

			nameCell.setCellValue("员工姓名");

			HSSFCell sexCell = row2.createCell(1);// 在行中创建单元格对象

			sexCell.setCellValue("员工性别");

			sexCell.setCellStyle(cellStyle);

			HSSFCell deptCell = row2.createCell(2);// 在行中创建单元格对象

			deptCell.setCellValue("所在部门");

			deptCell.setCellStyle(cellStyle);

			HSSFCell dutyCell = row2.createCell(3);// 在行中创建单元格对象

			dutyCell.setCellValue("职务");

			dutyCell.setCellStyle(cellStyle);

			HSSFCell phoneCell = row2.createCell(4);// 在行中创建单元格对象

			phoneCell.setCellValue("联系电话");

			phoneCell.setCellStyle(cellStyle);

			for (int i = 0; i < list.size(); i++) {// 遍历保存数据对象的集合

				Employee emp = (Employee) list.get(i);// 获取封装数据的对象

				HSSFRow dataRow = sheet.createRow(i + 2);// 创建行

				HSSFCell name = dataRow.createCell(0);// 创建单元格

				name.setCellValue(emp.getName());// 将数据添加到单元格中

				name.setCellStyle(cellStyle);

				HSSFCell sex = dataRow.createCell(1);

				sex.setCellValue(emp.getSex());

				sex.setCellStyle(cellStyle);

				HSSFCell dept = dataRow.createCell(2);

				dept.setCellValue(emp.getDept());

				dept.setCellStyle(cellStyle);

				HSSFCell duty = dataRow.createCell(3);

				duty.setCellValue(emp.getDuty());

				duty.setCellStyle(cellStyle);

				HSSFCell phone = dataRow.createCell(4);

				phone.setCellValue(emp.getTelephone());

				phone.setCellStyle(cellStyle);

			}

			File xlsFile = new File("E:\\员工信息表.xls");

			FileOutputStream fos = new FileOutputStream(xlsFile);

			workbook.write(fos);// 将文档对象写入文件输出流

			fos.close();

			return true;

		} catch (Exception e) {

			e.printStackTrace();

			return false;

		}

	}

	public HSSFSheet setPrint(HSSFSheet sheet) {

		HSSFHeader header = sheet.getHeader();

		header.setRight("页眉");// 添加右侧页眉

		HSSFHeader.fontSize((short) 8);// 设置字号

		HSSFFooter footer = sheet.getFooter();

		HSSFFooter.fontSize((short) 8);// 设置字号

		footer.setRight("页脚");// 添加右侧页脚

		sheet.setPrintGridlines(true);// 打印网格线

		HSSFPrintSetup printSet = sheet.getPrintSetup();

		printSet.setFitWidth((short) 2);// 设置页宽

		printSet.setFitHeight((short) 2);// 设置页高

		printSet.setPaperSize(HSSFPrintSetup.A4_PAPERSIZE);// 设置打印纸大小

		printSet.setHeaderMargin(5.5);// 设置页眉边距

		printSet.setFooterMargin(5.5);// 设置页脚边距

		sheet.setVerticallyCenter(true);// 设置垂直居中

		sheet.setHorizontallyCenter(true);// 设置水平居中

		return sheet;

	}

}
