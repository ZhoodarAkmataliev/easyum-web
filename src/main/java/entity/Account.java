package entity;

import java.util.Objects;

public class Account {
	private int id;
	private String login;
	private String password;
	private String role;

	public Account() {
	}

	public Account(int id, String login, String password, String role) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Account account = (Account) o;
		return id == account.id &&
				Objects.equals(login, account.login) &&
				Objects.equals(password, account.password) &&
				Objects.equals(role, account.role);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, login, password, role);
	}

	@Override
	public String toString() {
		return "Account{" +
				"id=" + id +
				", login='" + login + '\'' +
				", password='" + password + '\'' +
				", role='" + role + '\'' +
				'}';
	}
}
