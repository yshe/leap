package leap.demo;

import leap.core.annotation.Inject;
import leap.web.App;
import leap.web.security.SecurityConfigurator;

public class Global extends App{

	/**
	 * 重写init函数，该函数在应用初始化完成之后启动
	 * 在这个类中,我们可以重写init()函数,这个函数将在应用初始化完成之后调用,
	 * 可以做一些定制化的初始化功能(比如用户登录校验等).
	 * 为了可以在这里配置应用的安全校验,我们需要在这里使用leap提供的安全配置器,
	 * 在Global中添加一个私有属性private SecurityConfigurator sc,代码如下:
	 */
	@Inject
	private SecurityConfigurator sc;
	@Inject
	private Listnener ls;
	
	@Override
	protected void init() throws Throwable {
		// TODO Auto-generated method stub
	System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
	}
}
