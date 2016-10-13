package com.yabushan.test.util.designWay.FactoryModel;

public class Main {

	/**
	 * 缺点：工厂方法，工厂方法把抽象工厂内部逻辑判断移到了客户端代码来进行。
	 * 如果想要添加新的功能，本来是改工厂 类的，而现在是修改客户端。
	 * @param args
	 */
	public static void main(String[] args) {
		//分别创建红灯和绿灯工厂
		LightFactory redliLightFactory =new RedLightFactory();
		LightFactory yelLightFactory=new YellowLightFactory();
		 //利用红灯工厂对象创建红灯 
		Light redlLight=redliLightFactory.lightFactory();
		System.out.println(redlLight.MadeLight());
		System.out.println(redlLight.stopLight());
		
		//利用绿灯工厂对象创建绿灯
		Light yelloLight=yelLightFactory.lightFactory();
		System.out.println(yelloLight.MadeLight());
		System.out.println(yelloLight.stopLight());
	}
}
