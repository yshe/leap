package com.yabushan.test.util.designWay.FactoryModel;

public class YellowLight extends Light{

	public YellowLight() {
		super();
	}
	@Override
	public String MadeLight() {
		return "工厂模式：生产绿灯";
	}

	@Override
	public String stopLight() {
		return "工厂模式：停止生产绿灯";
	}

}
