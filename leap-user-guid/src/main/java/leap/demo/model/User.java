package leap.demo.model;

import leap.orm.annotation.Column;
import leap.orm.annotation.Table;
import leap.orm.model.Model;
@Table("leap_user")
public class User extends Model {
	@Column(name="user_name")
	private String name;
	private String loginId;
	@Column(name="password")
	private String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
