package com.yabushan.test.util.designWay.adaptModel;
/**
 * 實現對象適配器
 * 定义输出电压为 220V 的变压器类。
 * @author yabushan
 *
 */
public class CObject implements IAdapter {
	private ChangeAdapter changeAdapter;
	public CObject() {
		changeAdapter=new ChangeAdapter();
	}
	
	public String Driver() {
		return changeAdapter.web("輸出220V電壓");
	}

}
