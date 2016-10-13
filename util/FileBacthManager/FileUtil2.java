package com.yabushan.test.util.FileBacthManager;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
/**
 * 批量复制指定扩展名的文件
 * @author yabushan
 *
 */
public class FileUtil2 {
	private  List<String> allfilePath = new ArrayList<String>();   //定义文件地址的集合对象
	public List<String> getAllfilePath() {
		return allfilePath;
	}
	public void setAllfilePath(List<String> allfilePath) {
		this.allfilePath = allfilePath;
	}
	
	/**
	 * 递归方法，搜索某个路径下所有指定类型的文件
	 * @param path 文件夹路径 
	 * @param extendName 指定文件的扩展名
	 */
	public void getFiles(String path,String extendName) {
	    File dir = new File(path);      						//根据文件地址创建File对象
	    File files[] = dir.listFiles(new ExtendNameFilter(extendName));  //获取文件夹下的文件数组
	    for (File file:files ) {								//循环遍历数组
	        if (file.isDirectory())  							//判断文件是否是一个目录
	        	getFiles(file.getAbsolutePath(),extendName);    //如果为文件夹，继续执行本方法
	        else {
	        	allfilePath.add(file.getAbsolutePath());    	//将文件路径添加到集合中
	        }
	    }
	}
	/**
	 * 实现文件复制
	 * @param allOldPath 需要复制的所有文件组成的集合
	 * @param newPath 文件保存路径
	 */
	public void  copyFile(List<String> allOldPath, String newPath) {
		for(String oldPath:allOldPath){
		    try {
		        int bytesum = 0;
		        int byteread = 0;
		        File oldfile = new File(oldPath);
		        if (oldfile.exists()) { 										// 文件存在时
		            InputStream inStream = new FileInputStream(oldPath); 		// 读入原文件
		            File newFile = new File(newPath,oldfile.getName());
		            newFile.createNewFile();
		            FileOutputStream fs = new FileOutputStream(newFile);
		            byte[] buffer = new byte[1444];
		            while ((byteread = inStream.read(buffer)) != -1) {  		//循环读取文件
		                bytesum += byteread; 									// 获取文件大小
		                fs.write(buffer, 0, byteread);  						//将文件中写数据
		            }
		            fs.close();
		            inStream.close();
		        }
		     
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		}
	}    
}
