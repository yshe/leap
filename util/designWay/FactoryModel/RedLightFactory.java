package com.yabushan.test.util.designWay.FactoryModel;

public class RedLightFactory extends LightFactory{
	@Override
	public Light lightFactory() {
		return new RedLight();
	}
}
