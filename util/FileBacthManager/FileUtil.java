package com.yabushan.test.util.FileBacthManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
/**
 * 文件批量重命名
 * 快速批量移动文件
 * 动态加载磁盘文件
 * 删除文件夹及其内容
 * 删除文件夹内容，保留文件夹
 * 
 * 合并多个txt文件
 * @author yabushan
 *
 */
public class FileUtil {
	//创建List集合，用于保存所有旧文件名
	private List<String> oldNameList = new ArrayList<String>();
	//创建List集合，用于保存所有新文件名
	private List<String> newNameList = new ArrayList<String>();
	public List<String> getOldNameList() {
		return oldNameList;
	}
	public List<String> getNewNameList() {
		return newNameList;
	}
	
	/**
	 * 文件批量重命名
	 * @param filePath 文件路径
	 * @param templet 文件命名模板
	 * @param extName 文件扩展名
	 */
	public void renameFile(String filePath,String templet ,String extName){
		   	File dir = new File(filePath); //根据文件路径创建File对象
		    int bi =1;//起始编号
		    int index = templet.indexOf("#");// 获取第一个“#”的索引
		    String code = templet.substring(index);// 获取模板中数字占位字符串
		    // 把模板中数字占位字符串替换为指定格式
		    templet = templet.replace(code, "%0" + code.length() + "d");
		    extName = extName.toLowerCase();
		    if (extName.indexOf(".") == -1)
		        extName = "." + extName;
		    // 获取文件夹中文件列表数组
		    File[] files = dir.listFiles(new ExtendNameFilter(extName));
		    for (File file : files) {// 变量文件数组
		        // 格式化每个文件名称
		        String name = templet.format(templet, bi++) + extName;
		        oldNameList.add(file.getName());//将旧文件名添加到List集合中
		        newNameList.add(name);	//将新文件名添加到List集合中     
		        File parentFile = file.getParentFile();// 获取文件所在文件夹对象
		        File newFile = new File(parentFile, name);
		        file.renameTo(newFile);// 文件重命名
		    }
	}
	@Test
	public  void test() {
		FileUtil fileUtil=new FileUtil();
		fileUtil.renameFile("D:/ZIP测试", "yabushan###", ".txt");
		
	}
	
	
	
	//创建List集合，用于保存文件移动操作记录
		private List<String> workLogList = new ArrayList<String>();
		public List<String> getWorkLogList() {
			return workLogList;
		}
		/**
		 * 快速批量移动文件
		 * @param sourcePath 文件源路径
		 * @param targetPath 文件目标路径
		 * @return 移动成功返回true,否则返回false
		 */
		public  boolean  moveFile(String sourcePath,String targetPath ){
		   try {
			   File sourceDir = new File(sourcePath);//根据源路径创建File对象
			   if(sourceDir.exists()){
				   for(File file :sourceDir.listFiles()){//遍历文件夹下的所有文件
					   File targetFile = new File(targetPath,file.getName());
					   file.renameTo(targetFile);//根据修改文件路径，实现文件移动
					   workLogList.add(file.getName()+" 移动到 "+targetPath+"--完成！");
				   }
			   }
			   return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}  
		}
		@Test
		public void test2(){
			System.out.println(new FileUtil().moveFile("D:/bacthTest", "D:/ZIP测试"));
		}
	
		
		/**
		 * 获取文件夹下所有文件
		 * @param path 文件夹路径
		 * @return
		 */
		public List<File> searchFile(String path) {
			List<File> fileList = new ArrayList<File>();
			File dir = new File(path);
			File[] files = dir.listFiles();
			for (File file:files) {//遍历用户选择的文件夹
				if (file.isFile()) {//判断是否是一个文件
					fileList.add(file);
				}
				try {
					Thread.sleep(100);//线程休眠0.1秒实现动态加载
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			return fileList;			
		}
		@Test
		public void test3(){
			FileUtil fileUti=new FileUtil();
			List<File> files=fileUti.searchFile("D:/ZIP测试");
			for (File file : files) {
				System.out.println(file.getName());
			}
		}
		
		
		
		
		/**
		 * 删除文件夹相关操作
		 * 
		 */
		private  List<File> delFiles = new ArrayList<File>();
		public List<File> getDelFiles() {
			return delFiles;
		}
		public void setDelFiles(List<File> delFiles) {
			this.delFiles = delFiles;
		}
		/**
		 * 删除文件夹及其中内容
		 * @param rootFile
		 */
		
		public  void deleteDictionary(File rootFile) {
			if (rootFile.isFile()) {
				delFiles.add(rootFile);
				rootFile.delete();//如果给定的File对象是文件就直接删除
			} else {//如果是一个文件夹就将其转换成File数组
				File[] files = rootFile.listFiles();
				for (File file : files) {
					deleteDictionary(file);//如果不是空文件夹则就迭代deleteDictionary()方法
				}
				rootFile.delete();//如果是空文件夹就直接删除
			}
		}
		/**
		 * 删除文件夹下所有内容但保留给定文件夹
		 * @param rootFile
		 */
		public  void deleteFiles(File rootFile) {
			if (rootFile.listFiles().length == 0) {//如果用户给定的是空文件夹就退出方法
				return;
			} else {
				File[] files = rootFile.listFiles();//将非空文件夹转换成File数组
				for (File file : files) {
					if (file.isFile()) {
						delFiles.add(file);
						file.delete();//删除指定文件夹下的所有文件
					} else {
						if (file.listFiles().length == 0) {
							file.delete();//删除指定文件夹下的所有空文件夹
						} else {
							deleteDictionary(file);//删除指定文件夹下的所有非空文件夹
						}
					}
				}
			}
		}
		
		
		
		/**
		 * 合并多个txt文件
		 * @param txtPath 用户选择的需要合并的所有文本文件的路径
		 * @param savePath 合并后的保存路径
		 */
		public void writeFiles(String[] txtPath, String savePath) {  
			try {	
				//根据文件保存地址创建FileOutputStream对象
		        FileOutputStream fo = new FileOutputStream(savePath, true); 
		        for (String path:txtPath) {		//循环遍历要数组         
		        	File file = new File(path);	//创建File对象
		        	FileInputStream fi1 = new FileInputStream(file); //创建FileInputStream对象
		            byte[] b1 = new byte[fi1.available()];    		//从流中获取字节数
		            fi1.read(b1);               				//读取数据
		            fo.write(b1);               				//向文件中写数据
		            fi1.close();
		        }
		        fo.close();
		    } catch (Exception e) { 
		        e.printStackTrace();
		    }        
		}
}
