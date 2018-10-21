package hpbui.gamerportal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Accounts")
public class Account {
	public static final String ROLE_GAMER = "GAMER";
	public static final String ROLE_ADMIN = "ADMIN";
	
	@Id
	@Column(name = "Id", nullable = false)
	private int id;
	
	@Column(name = "Username", length = 45, nullable = false)
	private String username;
	
	@Column(name = "Password", length = 128, nullable = false)
	private String password;
	
	@Column(name = "Email", length = 128, nullable = false)
	private String email;
	
	@Column(name = "Active", length = 1, nullable = false)
	private boolean active;
	
	@Column(name = "Role", length = 20, nullable = false)
	private String role;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
