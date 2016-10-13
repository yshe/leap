package com.yabushan.test.util.designWay.FactoryModel;

public abstract class LightFactory {
	//）定义抽象工厂类 Factory，并声明抽象方法。
	//Factory 类起到抽象工厂角色，是工厂方法模式的核心， 任何在模式中创建的对象的工厂类必须实现这个接口
	public abstract Light lightFactory();
	

}
