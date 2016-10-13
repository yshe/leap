package com.yabushan.test.util.excel.jxl;

import java.io.File;

import java.util.Calendar;

import java.util.List;

import jxl.*;

import jxl.format.Alignment;

import jxl.format.Colour;

import jxl.format.PageOrientation;

import jxl.format.PaperSize;

import jxl.format.UnderlineStyle;

import jxl.format.VerticalAlignment;

import jxl.write.Label;

import jxl.write.WritableFont;

import jxl.write.WritableSheet;

import jxl.write.WritableWorkbook;
/**
 * 设置打印属性
 * @author yabushan
 *
 */
public class OtherInfo {
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

			Calendar c = Calendar.getInstance();

			String date = c.get(c.YEAR) + "/" + (c.get(c.MONTH) + 1) + "/"
					+ c.get(c.DAY_OF_MONTH);

			sheet.setHeader("", "", "普通文件");// 设置页眉

			sheet.setFooter("", "第一页", date);// 设置页脚

			sheet.setPageSetup(PageOrientation.PORTRAIT, PaperSize.A4, 0.2, 0.2);
			;// 设置打印纸的属性

			book.write();

			book.close();

			return true;

		} catch (Exception e) {

			System.out.println("异常信息：" + e.getMessage());

			e.printStackTrace();

			return false;

		}

	}
	
	
	
	//###########################设置详细打印属性
	
	public WritableSheet setSheetPrintStyle(WritableSheet sheet){

		SheetSettings settings = sheet.getSettings();

		settings.setHorizontalCentre(true);//设置打印内容水平居中

		settings.setVerticalCentre(true);//设置打印内容垂直居中

		HeaderFooter header = new HeaderFooter();//创建用于设置页眉页脚的对象

		header.getRight().append("普通文件");//设置页眉右侧的内容

		header.getRight().setFontSize(8);//设置页眉右侧内容的字号	

		settings.setHeader(header);//设置页眉

		settings.setFitHeight(5) ;//设置页高

		settings.setFitWidth(5);//设置页宽

		HeaderFooter footer = new HeaderFooter();//创建用于设置页眉页脚的对象

		footer.getRight().setFontSize(8);//设置页脚右侧字体的字号

		footer.getRight().appendDate();//设置在页脚右侧添加日期

		settings.setFooter(footer);//设置页脚

		settings.setFooterMargin(0.5);//设置页脚与页面底端的距离

		settings.setHeaderMargin(0.5);//设置页眉与页面顶端的距离

		settings.setOrientation(PageOrientation.PORTRAIT);//设置纵向打印

		settings.setPaperSize(PaperSize.A4) ;   //设置打印纸大小  

		settings.setPrintGridLines(true); //设置打印网格线

		settings.setPrintHeaders(true);//打印页眉

		settings.setScaleFactor(80)   ;//缩放比例

		return sheet;

	}

		



	public boolean readDataToExcelFile2(List<Employee> list){

		try {	

			WritableWorkbook book = Workbook.createWorkbook(new File("E:\\test\\员工信息.xls"));

			WritableSheet sheet = book.createSheet("员工信息", 0);

			sheet = this.setSheetPrintStyle(sheet);		

			//设置字体样式

			jxl.write.WritableFont font = new jxl.write.WritableFont(WritableFont.ARIAL, 15, WritableFont.BOLD, false,UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.GREEN);

			jxl.write.WritableCellFormat cellFormat = new jxl.write.WritableCellFormat(font);	

			cellFormat.setAlignment(Alignment.CENTRE);

			cellFormat.setVerticalAlignment(VerticalAlignment.CENTRE);//设置单元格内容两端对齐

			cellFormat.setBackground(Colour.GRAY_25);//背景颜色

			Label label_title = new Label(0,0,"员工信息表",cellFormat);

			sheet.mergeCells(0,0,4,0);//合并第一行的第1个到第5个单元格				

			sheet.setRowView(0, 600,false);//设置第一行的行高		

			Label label_name = new Label(0,1,"员工姓名");

			Label label_sex = new Label(1,1,"员工性别");

			Label label_dept = new Label(2,1,"所在部门");

			Label label_duty = new Label(3,1,"职务");	

			Label label_telephone = new Label(4,1,"联系电话");

			sheet.setColumnView(4, 15);//设置列宽

			sheet.addCell(label_title);

			sheet.addCell(label_name);

			sheet.addCell(label_sex);

			sheet.addCell(label_dept);

			sheet.addCell(label_duty);

			sheet.addCell(label_telephone);

			for(int i=0;i<list.size();i++){//遍历保存员工信息对象的集合，将所有员工信息导出到Excel

				Employee emp = (Employee)list.get(i);

				Label name_value = new Label(0,i+2,emp.getName());

				Label sex_value = new Label(1,i+2,emp.getSex());

				Label dept_value = new Label(2,i+2,emp.getDept());

				Label duty_value = new Label(3,i+2,emp.getDuty());

				Label telephone_value = new Label(4,i+2,emp.getTelephone());

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

			System.out.println("异常信息："+e.getMessage());

			e.printStackTrace();

			return false;

		}

	}


}
