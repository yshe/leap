package leap.demo.controller;

import java.util.List;

import leap.demo.form.UserForm;
import leap.demo.model.User;
import leap.web.action.ControllerBase;
import leap.web.annotation.http.GET;
import leap.web.annotation.http.POST;
import leap.web.view.ViewData;

public class UserController extends ControllerBase {
	public void index(ViewData vd){
		List<User> users = User.<User>query().list();
		vd.put("users", users);
	}
	@GET
	public void createUser(ViewData vd){
		//以GET请求访问路径/user/create_user会调用UserController.createUser
		//并返回视图/user/create_user
	}
	@POST
	public void createUser(ViewData vd, UserForm userForm){
		if(vd.validation().hasErrors() || vd.validation().validate(userForm).hasErrors()){
			return;
		}
		User user = new User();
		user.setName(userForm.name);
		user.setLoginId(userForm.loginId);
		user.setPassword(userForm.password);
		try {
			user.create();
			response().sendRedirect("/user/index");
		} catch (Exception e) {
			vd.validation().addError("保存失败", "用户登录账号已存在!");
		}
	}
	@GET
	public void editUser(ViewData vd, String loginId){
		User user = User.find(loginId);
		vd.put("user", user);
	}
	@POST
	public void editUser(ViewData vd, UserForm userForm){
		if(vd.validation().hasErrors() || vd.validation().validate(userForm).hasErrors()){
			return;
		}
		User user = User.find(userForm.loginId);
		user.setName(userForm.name);
		user.setPassword(userForm.password);
		try {
			user.update();
			response().sendRedirect("/user/index");
		} catch (Exception e) {
			vd.validation().addError("保存失败", e.getMessage());
		}
	}
	
	public void deleteUser(String loginId){
		User.delete(loginId);
		response().sendRedirect("/user/index");
	}
	
}
