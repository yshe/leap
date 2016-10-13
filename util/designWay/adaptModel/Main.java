package com.yabushan.test.util.designWay.adaptModel;

public class Main {
	public static void main(String[] args) {
		
		IAdapter adapter=new Adapter();
		System.out.println(adapter.Driver());
		adapter=new CClass();//調用第一個適配器
		System.out.println(adapter.Driver());
		adapter=new CObject();//調用第二個適配器
		System.out.println(adapter.Driver());
	}

}
