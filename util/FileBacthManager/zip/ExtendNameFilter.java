package com.yabushan.test.util.FileBacthManager.zip;

import java.io.File;
import java.io.FileFilter;

public class ExtendNameFilter implements FileFilter {
     public boolean accept(File pathname) {
         if (pathname.getName().toLowerCase().endsWith(".txt".toLowerCase())
        		 ||pathname.isDirectory())//判断文件的扩展名是否符合指定扩展名
             return true;
         return false;
     }
}
