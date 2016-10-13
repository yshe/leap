package com.yabushan.test.util.FileBacthManager.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import org.junit.Test;
/**
 * 压缩所有子文件夹
 * @author yabushan
 *
 */
public class ZipFileUtil1 {
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
	 * 深层文件夹压缩包的释放
	 * @param zipFile
	 * @param targetFile
	 * @param list
	 * @throws IOException
	 */
	public static List<String> unZipFile(File zipFile, File targetFile) throws IOException {
		List<String> list=new ArrayList<String>();//返回解压后的文件路径
		//利用用户选择的ZIP文件创建ZipInputStream对象
		ZipInputStream in = new ZipInputStream(new FileInputStream(zipFile));
		ZipEntry entry;
		while ((entry = in.getNextEntry()) != null) {//遍历所有ZipEntry对象
			if (entry.isDirectory()) {//如果ZipEntry对象是一个文件夹就进行迭代
				new File(targetFile+entry.getName()).mkdirs();
				
			} else {//如果是文件就将它写入到指定的文件夹中
				File file = new File(targetFile , entry.getName());
				File folder = new File(file.getParent());//根据文件父目录创建File对象
				if(!folder.exists())//如果目录不存在，则创建目录
					folder.mkdirs();
				if(!file.exists())//如果文件不存在，则创建文件
					file.createNewFile();
				list.add(file.getName());//将新生成的文件的路径添加到列表中
				FileOutputStream out = new FileOutputStream(file);
				int b;
				while ((b = in.read()) != -1) {//写入数据
					out.write(b);
				}
				out.close();//释放资源
			}
			entry.clone();
		}
		in.close();	
		return list;
	//	System.out.println(list.toString());
	}

	@Test
	public  void main() throws IOException {
		System.out.println("helo");
		ZipFileUtil1 util=new ZipFileUtil1();
		//util.zipFile("D:/ZIP测试", new File("D:/20160606.zip"), "D:/");
		List<String> list=unZipFile(new File("D:/20160606.zip"), new File("D:/ZIP测试2"));
		System.out.println(list.toString());
		
	}

}
