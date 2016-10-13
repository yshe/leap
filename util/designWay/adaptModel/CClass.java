package com.yabushan.test.util.designWay.adaptModel;
/**
 * 定义输出电压为 110V 的变压器类。
 * @author yabushan
 *
 */
public class CClass extends ChangeAdapter implements IAdapter{
	//實現類適配器
	public String Driver() {
		return this.web("輸出電壓110V");
	}
}
