package com.yabushan.test.util.excel.poi;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * 向excel单元格添加不同类型的数据
 * 
 * @author yabushan
 *
 */
public class ExcelOperationUtilDiffType {

	public boolean CreateExcelFile(String filePath, String fileName) {

		try {

			HSSFWorkbook workbook = new HSSFWorkbook();// 创建Excel工作簿对象

			HSSFSheet sheet = workbook.createSheet();// 在工作簿中创建工作表对象

			workbook.setSheetName(0, "测试");// 设置工作表的名称

			HSSFRow row = sheet.createRow(0);// 在工作表中创建第1行对象

			HSSFCell label_num = row.createCell(0);// 第1行的第1个单元格

			label_num.setCellValue("数字类型");// 添加字符串

			HSSFCell label_date = row.createCell(1);// 第1行的第2个单元格

			label_date.setCellValue("日期时间类型");// 添加字符串

			HSSFCell label_bool = row.createCell(2);// 第1行的第3个单元格

			label_bool.setCellValue("布尔类型");// 添加字符串

			HSSFRow row2 = sheet.createRow(1);// 在工作表中创建第2行对象

			HSSFCell num_cell = row2.createCell(0);// 第2行的第1个单元格

			num_cell.setCellValue(3.1415926);// 添加数字

			HSSFCell date_cell = row2.createCell(1);// 第2行的第2个单元格

			date_cell.setCellValue(Calendar.getInstance());// 添加日期时间

			HSSFCell bool_cell = row2.createCell(2);// 第2行的第3个单元格

			bool_cell.setCellValue(false);// 添加布尔值

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

	/**
	 * 创建指定格式的单元格
	 * @param filePath
	 * @param fileName
	 * @return
	 */
	public boolean CreateExcelFile2(String filePath,String fileName){

		try{

			HSSFWorkbook workbook = new HSSFWorkbook();//创建Excel工作簿对象

		

			HSSFSheet sheet = workbook.createSheet();//在工作簿中创建工作表对象

			workbook.setSheetName(0, "测试");//设置工作表的名称

			HSSFRow row1 = sheet.createRow(0);//在工作表中创建行对象

			HSSFCell Label_cell = row1.createCell(0);//在行中创建单元格对象

			Label_cell.setCellValue("今天的日期是");

			HSSFRow row2 = sheet.createRow(1);//在工作表中创建行对象

			HSSFCell date_cell = row2.createCell(0);//在行中创建单元格对象

			HSSFCellStyle cellStyle = workbook.createCellStyle();		

			cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));	

			date_cell.setCellValue(Calendar.getInstance());

			date_cell.setCellStyle(cellStyle);	

			File xlsFile = new File(filePath,fileName);

			FileOutputStream fos = new FileOutputStream(xlsFile);

			workbook.write(fos);//将文档对象写入文件输出流

			fos.close();

			return true;

		} catch (Exception e) {

			e.printStackTrace();

			return false;

		} 

	}
	
	
	
	/**
	 * 设置单元格内容水平对齐方式
	 * @param filePath
	 * @param fileName
	 * @return
	 */
	public boolean CreateExcelFile3(String filePath,String fileName){

		try{

			HSSFWorkbook workbook = new HSSFWorkbook();//创建Excel工作簿对象	

			HSSFSheet sheet = workbook.createSheet();//在工作簿中创建工作表对象

			workbook.setSheetName(0, "测试");//设置工作表的名称

			HSSFRow row1 = sheet.createRow(0);//在工作表中创建行对象	

			HSSFCell nameCell = row1.createCell(0);//在第1行中创建单元格对象

			nameCell.setCellValue("员工姓名");

			nameCell.setCellStyle(createStyle(workbook,HSSFCellStyle.ALIGN_CENTER));

			HSSFCell sexCell = row1.createCell(1);//在行中创建单元格对象

			sexCell.setCellValue("员工性别");

			sexCell.setCellStyle(createStyle(workbook,HSSFCellStyle.ALIGN_CENTER));

			HSSFCell ageCell = row1.createCell(2);//在行中创建单元格对象

			ageCell.setCellValue("员工年龄");

			ageCell.setCellStyle(createStyle(workbook,HSSFCellStyle.ALIGN_CENTER));

			HSSFCell deptCell = row1.createCell(3);//在行中创建单元格对象

			deptCell.setCellValue("所在部门");

			deptCell.setCellStyle(createStyle(workbook,HSSFCellStyle.ALIGN_CENTER));

			HSSFCell dutyCell = row1.createCell(4);//在行中创建单元格对象

			dutyCell.setCellValue("职务");

			dutyCell.setCellStyle(createStyle(workbook,HSSFCellStyle.ALIGN_CENTER));

			HSSFCell phoneCell = row1.createCell(5);//在行中创建单元格对象

			phoneCell.setCellValue("联系电话");

			phoneCell.setCellStyle(createStyle(workbook,HSSFCellStyle.ALIGN_CENTER));

			HSSFRow row2 = sheet.createRow(1);//在工作表中创建行对象	

			HSSFCell nameValue = row2.createCell(0);//在第2行中创建单元格对象

			nameValue.setCellValue("张三");

			nameValue.setCellStyle(createStyle(workbook,HSSFCellStyle.ALIGN_CENTER));

			HSSFCell sexValue = row2.createCell(1);//在行中创建单元格对象

			sexValue.setCellValue("男");

			sexValue.setCellStyle(createStyle(workbook,HSSFCellStyle.ALIGN_CENTER));

			HSSFCell ageValue = row2.createCell(2);//在行中创建单元格对象

			ageValue.setCellValue(25);

			ageValue.setCellStyle(createStyle(workbook,HSSFCellStyle.ALIGN_CENTER));

			HSSFCell deptValue = row2.createCell(3);//在行中创建单元格对象

			deptValue.setCellValue("软件开发部");

			deptValue.setCellStyle(createStyle(workbook,HSSFCellStyle.ALIGN_CENTER));

			HSSFCell dutyValue = row2.createCell(4);//在行中创建单元格对象

			dutyValue.setCellValue("程序员");

			dutyValue.setCellStyle(createStyle(workbook,HSSFCellStyle.ALIGN_CENTER));

			HSSFCell phoneValue = row2.createCell(5);//在行中创建单元格对象

			phoneValue.setCellValue("13988888888");

			phoneValue.setCellStyle(createStyle(workbook,HSSFCellStyle.ALIGN_CENTER));

		

			File xlsFile = new File(filePath,fileName);

			FileOutputStream fos = new FileOutputStream(xlsFile);

			workbook.write(fos);//将文档对象写入文件输出流

			fos.close();

			return true;

		} catch (Exception e) {

			e.printStackTrace();

			return false;

		} 

	}



	private static HSSFCellStyle createStyle(HSSFWorkbook wb,short align)

	{

	    HSSFCellStyle cellStyle = wb.createCellStyle();

	    cellStyle.setAlignment(align);

	    return cellStyle;

	}

	
	//*******************************************
	/**
	 * 设置单元格内容的垂直对齐方式
	 * @param filePath
	 * @param fileName
	 * @return
	 */
	public boolean CreateExcelFile5(String filePath,String fileName){

		try{

			HSSFWorkbook workbook = new HSSFWorkbook();//创建Excel工作簿对象	

			HSSFSheet sheet = workbook.createSheet();//在工作簿中创建工作表对象

			workbook.setSheetName(0, "测试");//设置工作表的名称

			HSSFRow row1 = sheet.createRow(0);//在工作表中创建行对象	

			HSSFCell nameCell = row1.createCell(0);//在第1行中创建单元格对象

			nameCell.setCellValue("员工姓名");

			nameCell.setCellStyle(alignStyle(workbook,HSSFCellStyle.ALIGN_CENTER,HSSFCellStyle.VERTICAL_CENTER));

			HSSFCell sexCell = row1.createCell(1);//在行中创建单元格对象

			sexCell.setCellValue("员工性别");

			sexCell.setCellStyle(alignStyle(workbook,HSSFCellStyle.ALIGN_CENTER,HSSFCellStyle.VERTICAL_CENTER));

			HSSFCell ageCell = row1.createCell(2);//在行中创建单元格对象

			ageCell.setCellValue("员工年龄");

			ageCell.setCellStyle(alignStyle(workbook,HSSFCellStyle.ALIGN_CENTER,HSSFCellStyle.VERTICAL_CENTER));

			HSSFCell deptCell = row1.createCell(3);//在行中创建单元格对象

			deptCell.setCellValue("所在部门");

			deptCell.setCellStyle(alignStyle(workbook,HSSFCellStyle.ALIGN_CENTER,HSSFCellStyle.VERTICAL_CENTER));

			HSSFCell dutyCell = row1.createCell(4);//在行中创建单元格对象

			dutyCell.setCellValue("职务");

			dutyCell.setCellStyle(alignStyle(workbook,HSSFCellStyle.ALIGN_CENTER,HSSFCellStyle.VERTICAL_CENTER));

			HSSFCell phoneCell = row1.createCell(5);//在行中创建单元格对象

			phoneCell.setCellValue("联系电话");

			phoneCell.setCellStyle(alignStyle(workbook,HSSFCellStyle.ALIGN_CENTER,HSSFCellStyle.VERTICAL_CENTER));

			HSSFRow row2 = sheet.createRow(1);//在工作表中创建行对象	

			HSSFCell nameValue = row2.createCell(0);//在第2行中创建单元格对象

			nameValue.setCellValue("张三");

			nameValue.setCellStyle(alignStyle(workbook,HSSFCellStyle.ALIGN_CENTER,HSSFCellStyle.VERTICAL_CENTER));		

			HSSFCell sexValue = row2.createCell(1);//在行中创建单元格对象

			sexValue.setCellValue("男");

			sexValue.setCellStyle(alignStyle(workbook,HSSFCellStyle.ALIGN_CENTER,HSSFCellStyle.VERTICAL_CENTER));

			HSSFCell ageValue = row2.createCell(2);//在行中创建单元格对象

			ageValue.setCellValue(25);

			ageValue.setCellStyle(alignStyle(workbook,HSSFCellStyle.ALIGN_CENTER,HSSFCellStyle.VERTICAL_CENTER));

			HSSFCell deptValue = row2.createCell(3);//在行中创建单元格对象

			deptValue.setCellValue("软件开发部");

			deptValue.setCellStyle(alignStyle(workbook,HSSFCellStyle.ALIGN_CENTER,HSSFCellStyle.VERTICAL_CENTER));

			HSSFCell dutyValue = row2.createCell(4);//在行中创建单元格对象

			dutyValue.setCellValue("程序员");

			dutyValue.setCellStyle(alignStyle(workbook,HSSFCellStyle.ALIGN_CENTER,HSSFCellStyle.VERTICAL_CENTER));

			HSSFCell phoneValue = row2.createCell(5);//在行中创建单元格对象

			phoneValue.setCellValue("13988888888");

			phoneValue.setCellStyle(alignStyle(workbook,HSSFCellStyle.ALIGN_CENTER,HSSFCellStyle.VERTICAL_CENTER));

			File xlsFile = new File(filePath,fileName);

			FileOutputStream fos = new FileOutputStream(xlsFile);

			workbook.write(fos);//将文档对象写入文件输出流

			fos.close();

			return true;

		} catch (Exception e) {

			e.printStackTrace();

			return false;

		} 

	}



	private static HSSFCellStyle alignStyle(HSSFWorkbook wb,short align,short v_align)

	{

	    HSSFCellStyle cellStyle = wb.createCellStyle();

	    cellStyle.setAlignment(align);

	    cellStyle.setVerticalAlignment(v_align);

	    return cellStyle;

	}
}
