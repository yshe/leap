package com.yabushan.test.util.designWay.FactoryModel;

public class YellowLightFactory extends LightFactory{

	@Override
	public Light lightFactory() {
		return new YellowLight();
	}

}
