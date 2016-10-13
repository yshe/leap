package com.yabushan.test.util.FileBacthManager;


import java.io.File;
import java.io.FileFilter;

public class ExtendNameFilter1 implements FileFilter {
	 public boolean accept(File pathname) {
         if (pathname.getName().endsWith(".txt") || pathname.isDirectory())
             return true;
         return false;
     }
}
