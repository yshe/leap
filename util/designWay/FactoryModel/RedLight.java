package com.yabushan.test.util.designWay.FactoryModel;

public class RedLight extends Light{

	public RedLight() {
		super();
	}
	@Override
	public String MadeLight() {
	
		return "工厂模式：生产红灯";
	}

	@Override
	public String stopLight() {
		return "工厂模式：停止生产红灯";
	}
	

}
