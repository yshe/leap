package com.yabushan.test.util.word;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 导出Word
 */
public class ExportWordServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//设置request的编码方式，防止中文乱码
		String fileName ="导出数据";//设置导出的文件名称
		StringBuffer sb=null;
		sb = new StringBuffer(request.getParameter("tableInfo"));//将表格信息放入内存
		String contentType = "application/mswrod";//设置导出文件的格式
		String recommendedName = new String(fileName.getBytes(),"utf-8");
		response.setContentType(contentType);
		response.setHeader("Content-Disposition", "attachment; filename=" + recommendedName + "\"");
		response.resetBuffer();
		//利用输出输入流导出文件
		ServletOutputStream sos = response.getOutputStream();
		sos.write(sb.toString().getBytes());
		sos.flush();
		sos.close();
	}	
}
