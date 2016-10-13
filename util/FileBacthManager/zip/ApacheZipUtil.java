package com.yabushan.test.util.FileBacthManager.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.apache.tools.zip.ZipOutputStream;
/**
 * apache实现文件解压缩
 * @author yabushan
 *
 */
public class ApacheZipUtil {
	private List<String> filePaths = new ArrayList<String>();
	public List<String> getFilePaths() {
		return filePaths;
	}
	public void setFilePaths(List<String> filePaths) {
		this.filePaths = filePaths;
	}
	/**
	 * 压缩所有子文件夹
	 * @param path 所有要压缩的文件路径
	 * @param targetZipFile 压缩文件的保存位置
	 * @param base 压缩文件夹的基路径
	 * @throws IOException
	 */
	
	public  void zipFile(String sourceFolder, File targetZipFile, String base) throws IOException {
		getFiles(sourceFolder);
		//根据给定的targetZipFile创建文件输出流对象
		FileOutputStream fos = new FileOutputStream(targetZipFile);
		ZipOutputStream zos = new ZipOutputStream(fos);//利用文件输出流对象创建Zip输出流对象
		byte[] buffer = new byte[1024];
		for (String filePath : filePaths) {//遍历所有要压缩文件的路径
			File currentFile = new File(filePath);
			ZipEntry entry = new ZipEntry(filePath.substring(base.length()+1, filePath.length()));//利用要压缩文件的相对路径创建ZipEntry对象
			FileInputStream fis = new FileInputStream(currentFile);
			zos.putNextEntry(entry);
			int read = 0;
			while ((read = fis.read(buffer)) != -1) {//将数据写入到Zip输出流中
				zos.write(buffer, 0, read);
			}
			zos.closeEntry();//关闭ZipEntry对象
			fis.close();
		}
		zos.close();//释放资源
		fos.close();
	}
	
	public void getFiles(String path) {
	    File dir = new File(path);      						//根据文件地址创建File对象
	    File files[] = dir.listFiles();  					//获取文件夹下的文件数组
	    for (File file:files ) {							//循环遍历数组
	        if (file.isDirectory())  						//判断文件是否是一个目录
	        	getFiles(file.getAbsolutePath());    			//如果为文件夹，继续执行本方法
	        else {
	        	filePaths.add(file.getAbsolutePath());    	//将文件路径添加到集合中
	        }
	    }
	}

	
	/**
	 * 
	 * @param zipFile
	 * @param targetFile
	 * @param list
	 * @throws IOException
	 */
	public static void unZipFile(File zipFile, File targetFile, List<String> list) throws IOException {
		ZipFile zf = new ZipFile(zipFile);//创建ZipFile对象
		Enumeration e = zf.getEntries();
		while (e.hasMoreElements()) {//遍历所有ZipEntry对象
			ZipEntry entry = (ZipEntry) e.nextElement();
			if (entry.isDirectory()) {//如果ZipEntry对象是一个文件夹就创建这个文件夹
				new File(targetFile + entry.getName()).mkdir();
			} else {
				File file = new File(targetFile , entry.getName());//获得被压缩的文件
				File temp = new File(file.getParent());//获得被压缩文件的父文件夹
				if(!temp.exists())//如果父文件夹不存在，则创建
					temp.mkdirs();	
				if(!file.exists())//如果文件不存在，则创建
					file.createNewFile();
				list.add(file.getName());//将文件的路径保存到列表中
				FileOutputStream out = new FileOutputStream(file);
				InputStream in = zf.getInputStream(entry);
				int b;
				while ((b = in.read()) != -1) {//将数据写入到创建好的文件
					out.write(b);
				}
				out.close();//释放资源
			}
		}
		zf.close();//释放资源
	}

}
