package com.yabushan.test.util.FileBacthManager;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * 创建磁盘索引
 * 使用所有查找文件路径
 * @author yabushan
 *
 */
public class FileUtil3 {
	private List<String> list = new ArrayList<String>();	//用list保存索引
	private String pathStr;
	public String getPathStr() {
		return pathStr;
	}
	public void setPathStr(String pathStr) {
		this.pathStr = pathStr;
	}
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	/**
	 * 
	 * @param rootPath 
	 * @param indexFilePath
	 */
	public  void createIndexFile(String rootPath,String indexFilePath){	
		File rootFile = new File(rootPath);				//利用用户选择的磁盘创建File对象
		StringBuilder sb = new StringBuilder();			//利用StringBuilder对象保存写入的索引
		File indexFile = new File(indexFilePath);
		getFilePath(list, rootFile);					//获得磁盘上所有文件的路径
		for(String pathStr:list){						//遍历集合，将集合元素添加到StringBuffer中
			sb.append(pathStr+"\r\n");
		}
		pathStr = sb.toString();
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(indexFile);
			fileWriter.write(sb.toString());			//向用户选择的文本文件写入数据
			fileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public  List<String> getFilePath(List<String> list, File rootFile) {
		File[] files = rootFile.listFiles();
		if (files == null)
			return list;
		for (File file : files) {
			if (file.isDirectory()) {
				getFilePath(list, file);
			} else {
				list.add(file.getAbsolutePath().replace("\\", "/"));
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		FileUtil3 fileUtil3= new FileUtil3();
		fileUtil3.createIndexFile("D:/ZIP测试", "D:/ZIP测试/ML.txt");
	}
	
	
	/**
	 * 快速全盘查找文件
	 * @param keyword
	 * @param indexFilePath
	 * @return
	 */
	public String searchFile(String keyword,String indexFilePath){	
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try {
			fileReader = new FileReader(indexFilePath);//利用用户选择的文件创建FileReader对象
			bufferedReader = new BufferedReader(fileReader);
			StringBuilder builder = new StringBuilder();//利用StringBuilder对象保存索引
			String temp = null;
			while ((temp = bufferedReader.readLine()) != null) {//读入文本文件
				builder.append(temp);
				builder.append("\n");//在每一行的末尾添加一个分隔符
			}
			String[] rows = builder.toString().split("\n");//将索引按换行符分割
			StringBuffer sb = new StringBuffer();
			for(String row:rows) {//遍历读入的文本文件
				if(row.contains(keyword)) {//判断读入的文本文件是否包含指定的关键字
					sb.append(row+"\n");//返回结果
				}
			}
			return sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}
}
