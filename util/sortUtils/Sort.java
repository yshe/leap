/**
 * This file created at 2015年8月2日.
 *
 * Copyright (c) 2002-2015 Bingosoft, Inc. All rights reserved.
 */
package com.yabushan.test.util.sortUtils;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * <code>{@link Sort}</code>
 *
 * TODO : document me
 *
 * @author yabushan
 */

public class Sort {
	
	
	public  void test(){//
		int i=1;//整形
		char s='a';//字符类型
		String j="sdf";//字符类型
		int b=12;//true ,false
		
	}
	
	
	
	

	/**
	 * 冒泡排序
	 * 
	 * @param data
	 *            目标数组
	 */
	public static void bubbleSort(int[] data) {

		for (int i = 0; i < data.length - 1; i++) {// 控制趟数
			for (int j = 0; j < data.length - i - 1; j++) {

				if(data[j] > data[j + 1]){
					int tmp = data[j];
					data[j] = data[j + 1];
					data[j + 1] = tmp;
				}
			}
		}

	}

	/**
	 * 选择排序
	 * 
	 * @param data
	 *            目标数组
	 */
	public static void selectSort(int[] data) {
		if (data == null || data.length == 0) {
			return;
		}

		for (int i = 0; i < data.length - 1; i++) {
			int min = i;// 将当前下标定为最小值下标
			for (int j = i + 1; j < data.length; j++) {
				if (data[j] < data[min]) {
					min = j;
				}
			}

			if (i != min) {
				int tmp = data[i];
				data[i] = data[min];
				data[min] = tmp;
			}
		}
	}

	/**
	 * 选择排序 此算法效率不如上面的高
	 * 
	 * @param sort
	 */
	public static void selectSort2(int[] data) {

		for (int i = 0; i < data.length - 1; i++) {
			for (int j = i + 1; j < data.length; j++) {
				if (data[j] < data[i]) {
					int temp = data[j];
					data[j] = data[i];
					data[i] = temp;
				}
			}
		}
	}

	/**
	 * 快速排序算法
	 * 
	 * @param data
	 *            目标数组
	 * @param start
	 *            起始位
	 * @param end
	 *            结束位
	 */
	public static void quickSort(int[] data, int start, int end) {
		// 设置关键数据key为要排序数组的第一个元素，
		// 即第一趟排序后，key右边的数全部比key大，key左边的数全部比key小
		int key = data[start];
		// 设置数组左边的索引，往右移动比key大的数
		int i = start;
		// 设置数组右边的索引，往左移动比key小的数
		int j = end;
		// 如果左边索引比右边索引小，则还有数据没有排序
		while (i < j) {
			while (data[j] > key && j > i) {
				j--;
			}
			data[i] = data[j];

			while (data[i] < key && i < j) {
				i++;
			}
			data[j] = data[i];
		}
		// 此时 i==j
		data[i] = key;

		// 递归调用
		if (i - 1 > start) {
			// 递归调用，把key前面的完成排序
			quickSort(data, start, i - 1);
		}
		if (i + 1 < end) {
			// 递归调用，把key后面的完成排序
			quickSort(data, i + 1, end);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] p = { 34, 21, 54, 18, 23, 76, 38, 98, 45, 33, 27, 51, 11, 20, 79,
				30, 89, 41 };

		long start = System.currentTimeMillis();

//		Sort.bubbleSort(p);// 冒泡排序
//		Sort.selectSort(p);// 选择排序
//		Sort.selectSort2(p);// 选择排序2
		Sort.quickSort(p, 0, p.length - 1);// 快速排序

		System.out.println("所用时间：" + (System.currentTimeMillis() - start));
		for (int i = 0; i < p.length; i++) {
			System.out.print(p[i] + " ");
			String aString ="sdfdsf";
			System.out.println(aString.valueOf('a'));
		}
	}

}
