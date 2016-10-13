/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.yabushan.test.util.word;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 应用响应流导出到word
 * @author yabushan
 * 
 * 1.web中配置：
 * <!-- 表单数据输出到word -->
<filter>
        <filter-name>CharacterEncodingFilter</filter-name>
        <filter-class>com.yabushan.test.util.word.CharacterEncodingFilter</filter-class>
        <init-param>
            <param-name>encoding</param-name>
            <param-value>UTF-8</param-value>
        </init-param>
        </filter>
    <filter-mapping>
        <filter-name>CharacterEncodingFilter</filter-name>
        <url-pattern>/*</url-pattern>
        <dispatcher>REQUEST</dispatcher>
        <dispatcher>FORWARD</dispatcher>
    </filter-mapping>
     <servlet>
        <servlet-name>ReferServletWord</servlet-name>
        <servlet-class>com.yabushan.test.util.word.ReferServletWord</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>ReferServletWord</servlet-name>
        <url-pattern>/ReferServletWord</url-pattern>
    </servlet-mapping>
 *
 *2.表单页面配置：
 *<form name="form" method="post"
 * action="ReferServletWord">
 * </form>
 * 
 */
public class ReferServletWord extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = -8115150535773692526L;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        response.setContentType("application/msword");//设置为word格式
        PrintWriter out = response.getWriter();       //声明out打印实例
        out.println(request.getParameter("name"));	  //获取表单中的name
        out.println(request.getParameter("sex"));	  
        out.println(request.getParameter("age"));	  
        out.println(request.getParameter("born"));
        out.println(request.getParameter("profession"));
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        doGet(request, response);
    }
}

