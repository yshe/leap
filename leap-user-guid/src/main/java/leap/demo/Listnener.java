package leap.demo;

import leap.core.annotation.Bean;
import leap.web.App;
import leap.web.AppListener;
import leap.web.config.WebConfig;
import leap.web.config.WebConfigurator;
@Bean
public class Listnener implements AppListener {

	@Override
	public void preAppConfigure(App app, WebConfigurator c) throws Throwable {
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&+preAppConfigure");
		AppListener.super.preAppConfigure(app, c);
		
	}

	@Override
	public void postAppConfigure(App app, WebConfig c) throws Throwable {
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&+postAppConfigure");
		AppListener.super.postAppConfigure(app, c);
	}

	@Override
	public void preAppInit(App app) throws Throwable {
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&+preAppInit");
		AppListener.super.preAppInit(app);
	}

	@Override
	public void postAppInit(App app) throws Throwable {
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&+postAppInit");
		AppListener.super.postAppInit(app);
	}

	@Override
	public void preAppStart(App app) throws Throwable {
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&+preAppStart");
		AppListener.super.preAppStart(app);
	}

	@Override
	public void postAppStart(App app) throws Throwable {
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&+postAppStart");
		AppListener.super.postAppStart(app);
	}

	@Override
	public void preAppStop(App app) throws Throwable {
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&+preAppStop");
		AppListener.super.preAppStop(app);
	}

	@Override
	public void postAppStop(App app) throws Throwable {
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&+postAppStop");
		AppListener.super.postAppStop(app);
	}
	

}
