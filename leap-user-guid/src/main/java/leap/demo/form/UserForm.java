package leap.demo.form;

import leap.core.validation.annotations.Required;
import leap.web.form.FormBase;

public class UserForm extends FormBase {
	public @Required(message="请输入用户名")    String name;
	public @Required(message="请输入用户登录账号") String loginId;
	public @Required(message="请输入用户密码") String password;
}
