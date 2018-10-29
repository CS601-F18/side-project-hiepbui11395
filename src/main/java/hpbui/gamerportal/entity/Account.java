package hpbui.gamerportal.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "gamer_portal.accounts")
public class Account {
	public static final String ROLE_GAMER = "GAMER";
	public static final String ROLE_ADMIN = "ADMIN";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "username", length = 45, nullable = false)
    @NotEmpty(message = "*Please provide an username")
	private String username;

	@Column(name = "password",length = 128, nullable = false)
    @NotEmpty(message = "*Please provide password")
	private String password;

	@Column(name = "email", length = 128, nullable = false)
    @Email(message = "*Please provide a valid Email")
    @NotEmpty(message = "*Please provide an email")
	private String email;

	@Column(length = 1, nullable = false)
	private boolean active;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "gamer_portal.account_role", 
	joinColumns = {@JoinColumn(name="idAccount", referencedColumnName="id")}, 
	inverseJoinColumns = {@JoinColumn(name="idRole", referencedColumnName="id")})
	private Set<Role> roles;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "gamer_portal.account_account", 
	joinColumns = {@JoinColumn(name="idAccount1", referencedColumnName="id")}, 
	inverseJoinColumns = {@JoinColumn(name="idAccount2", referencedColumnName="id")})
	private Set<Account> accounts;

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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
