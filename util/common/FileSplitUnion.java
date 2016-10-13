package com.yabushan.test.util.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 对大文件实现分割处理和合并
 * @author yabushan
 *
 */
public class FileSplitUnion {
	
	public static void main(String[] args) {
	//	splitFile(new File("E://视频教程/港囧.mp4"), new File("E://20160618"), 100);
		File file = new File("E:/20160618");
		File files[] = file.listFiles();
		for(int i=0;i<files.length;i++){
			System.out.println(files[i].getName());
		}
		heBing(files, file, "mp4");
	}
	/**
	 * 将大文件进行分割
	 * @param commFile 分割文件的地址
	 * @param untieFile 分割后文件的保存地址
	 * @param filesize 分割文件的大小
	 */
	public static boolean splitFile(File commFile, File untieFile, int fileSize) {
	    FileInputStream fis = null;
	    int size = 1024 * 1024; 					// 用来指定分割文件要以MB为单位
	    try {
	        if (!untieFile.isDirectory()) { 		// 如果要保存分割文件地址不是路径
	            untieFile.mkdirs(); 				// 创建该路径
	        }
	        size = size * fileSize;
	        int length = (int) commFile.length(); 	// 获取文件大小
	        int num = length / size; 				// 获取文件大小除以MB的得数
	        int yu = length % size; 					// 获取文件大小与MB相除的余数
	        String newfengeFile = commFile.getAbsolutePath(); 	// 获取保存文件的完成路径信息
	        int fileNew = newfengeFile.lastIndexOf(".");
	        String strNew = newfengeFile.substring(fileNew, newfengeFile
	                .length()); 						// 截取字符串
	        fis = new FileInputStream(commFile); 	// 创建FileInputStream类对象
	        File[] fl = new File[num + 1]; 			// 创建文件数组
	        int begin = 0;
	        for (int i = 0; i < num; i++) { 			// 循环遍历数组
	            fl[i] = new File(untieFile.getAbsolutePath() + "\\" + (i + 1)
	                    + strNew + ".tem"); 			// 指定分割后小文件的文件名
	            if (!fl[i].isFile()) {
	                fl[i].createNewFile(); 			// 创建该文件
	            }
	            FileOutputStream fos = new FileOutputStream(fl[i]);
	            byte[] bl = new byte[size];
	            fis.read(bl); 						// 读取分割后的小文件
	            fos.write(bl); 						// 写文件
	            begin = begin + size * 1024 * 1024;
	            fos.close(); 							// 关闭流
	        }
	        if (yu != 0) { 							// 文件大小与指定文件分割大小相除的余数不为0
	            fl[num] = new File(untieFile.getAbsolutePath() + "\\"
	                    + (num + 1) + strNew + ".tem"); 	// 指定文件分割后数组中最后一个文件名
	            if (!fl[num].isFile()) {
	                fl[num].createNewFile(); 				// 新建文件
	            }
	            FileOutputStream fyu = new FileOutputStream(fl[num]);
	            byte[] byt = new byte[yu];
	            fis.read(byt);
	            fyu.write(byt);
	            fyu.close();
	        }
	        return true;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	
	
	/**
	 * 文件合并
	 * @param file 	要合并的文件数组
	 * @param cunDir 文件保存路径
	 * @param hz 合并后文件的格式
	 * @return
	 */
	public static boolean heBing(File[] file, File cunDir, String hz) {
	    try { 
	    	// 指定分割后文件的文件名
	        File heBingFile = new File(cunDir.getAbsoluteFile() + "\\UNTIE." + hz); 
	        if (!heBingFile.isFile()) {
	            heBingFile.createNewFile();
	        }
	        // 创建FileOutputStream对象
	        FileOutputStream fos = new FileOutputStream(heBingFile); 
	        for (int i = 0; i < file.length; i++) { 	// 循环遍历要进行合并的文件数组对象
	            FileInputStream fis = new FileInputStream(file[i]);
	            int len = (int) file[i].length(); 	// 获取文件长度
	            byte[] bRead = new byte[len];
	            fis.read(bRead); 						// 读取文件
	            fos.write(bRead); 					// 写入文件
	            fis.close();							// 将流关闭
	        }
	        fos.close();    
	        return true;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}
}
