package hpbui.gamerportal.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "gamer_portal.roles")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(length=45, nullable = false)
	private String roleName;
	
    @ManyToMany(mappedBy="roles")
    private Set<Account> accounts;

    public Long getId() {
		return id;
	}

    public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

}
