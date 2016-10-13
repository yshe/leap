package com.yabushan.test.util.common;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
/**
 * 
 * <code>{@link OutJson}</code>
 *
 * TODO : document me
 *
 * @author yabushan
 * 
 */
public class OutJson {
    private static Logger logger = Logger.getLogger(OutJson.class);

    public static void out(HttpServletResponse response,String result){
		response.setContentType("application/json ; charset = utf-8");
//		response.setContentType("type = application/json ; charset = utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print(result);
			out.flush();
			out.close();
		} catch (IllegalStateException e){
            logger.warn("可能是调用了两次response",e);
        }catch (IOException e) {
            logger.warn("在OUTJSON中获时异常",e);
		}
		
	}
	
	//写出数据
	public static void outString(HttpServletResponse response,String jsonStr){
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().write(jsonStr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
