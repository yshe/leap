package com.yabushan.test.util.designWay.FacadeModel;
/**
 * 计算机外观
 * 定义计算机类 Computer，并实现打开电脑和关闭电脑的方法
 * @author yabushan
 *
 */
public class Computer {
	private MainBoard mainBoard;
	private Power power;
	
	public Computer(MainBoard mainBoard,Power power) {
		this.mainBoard=mainBoard;
		this.power=power;
	}
	public void startUp(){
		//启动计算机
		this.mainBoard.on();
		this.power.connect();
	}
	public void stopUp(){
		this.mainBoard.off();
		this.power.disconnect();
	}
}
