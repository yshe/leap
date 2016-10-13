package com.yabushan.test.util.designWay.FacadeModel;

public class Main {
	public static void main(String[] args) {
		Power power = new Power();         
		//创建电源对象      
		MainBoard mainBoard = new MainBoard();       //创建主板对象       
		System.out.println("打开电脑");
		Computer computer=new Computer(mainBoard, power);
		computer.startUp();
		System.out.println("关闭电脑");
		computer.stopUp();
	}

}
