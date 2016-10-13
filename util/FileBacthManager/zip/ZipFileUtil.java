package com.yabushan.test.util.FileBacthManager.zip;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
/**
 * 压缩所有文本文件
 * 文件类型在ExtendNameFilter.java中过滤
 * 
 * 解压缩指定文件到指定目录
 * @author yabushan
 *
 */
public class ZipFileUtil {
	
	public static void main(String[] args) throws IOException {
		//zipFile(new File("D:/ZIP测试"), new File("D:/ZIP.zip"));
		unZipFiles("D:/ZIP测试.zip", "D:/bacthTest",".txt");
		
	}
	/**
	 * 
	 * @param folder 要压缩的文件夹路径
	 * @param targetZipFile 压缩后的文件名
	 * @throws IOException
	 */
	public static void zipFile(File folder, File targetZipFile) throws IOException {
		File[] txtFiles = folder.listFiles(new ExtendNameFilter());
		//利用给定的targetZipFile对象创建文件输出流对象
		FileOutputStream fos = new FileOutputStream(targetZipFile);
		ZipOutputStream zos = new ZipOutputStream(fos);//利用文件输出流创建压缩输出流
		byte[] buffer = new byte[1024];//创建写入压缩文件的数组
		for (File file : txtFiles) {//遍历全部文件
			ZipEntry entry = new ZipEntry(file.getName());//利用每个文件的名字创建ZipEntry对象
			System.out.println(entry.getName());
			FileInputStream fis = new FileInputStream(file);//利用每个文件创建文件输入流对象
			zos.putNextEntry(entry);//在压缩文件中添加一个ZipEntry对象
			int read = 0;
			while ((read = fis.read(buffer)) != -1) {
				zos.write(buffer, 0, read);//将输入写入到压缩文件
			}
			zos.closeEntry();//关闭ZipEntry
			fis.close();//释放资源
		}
		zos.close();
		fos.close();
	}

	/**
	 * 
	 * @param zipFilePath 要解压的文件
	 * @param targetFolder 解压后的文件夹
	 * @param Type 要解压出来的文件类型
	 */
	public  static void unZipFiles(String zipFilePath,String targetFolder,String Type){
		ZipFile zf = null;
		try {
			zf = new ZipFile(zipFilePath);//利用用户选择的ZIP文件创建ZipFile对象
			Enumeration e = zf.entries();//创建枚举变量
			while (e.hasMoreElements()) {//遍历枚举变量
				ZipEntry entry = (ZipEntry) e.nextElement();//获得ZipEntry对象
				if (!entry.getName().endsWith(Type)) {//如果不是Type类型的文件就不进行解压缩
					continue;
				}
				//利用用户选择的文件夹和ZipEntry对象名称创建解压后的文件
				File currentFile = new File(targetFolder + File.separator + entry.getName());
				FileOutputStream out = new FileOutputStream(currentFile);
				InputStream in = zf.getInputStream(entry);//利用获得的ZipEntry对象的输入流
				int buffer = 0;
				while ((buffer = in.read()) != -1) {//将输入流写入到本地文件
					out.write(buffer);
				}
				in.close();//释放资源
				out.close();	
			}
			zf.close();
		} catch (Exception e) {//捕获异常
			e.printStackTrace();
		}
		
	}
}
