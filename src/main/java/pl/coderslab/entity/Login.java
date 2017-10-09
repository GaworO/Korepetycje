package pl.coderslab.entity;
import javax.persistence.*;
public class Login {


	private String password;
	private String login ;

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getLogin() {
		return login;
	}
}
