package hpbui.gamerportal.entity;

import javax.persistence.*;

@Entity
@Table(name = "gamer_portal.account_role")
public class AccountRole {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(nullable=false)
    private long idAccount;

	@Column(nullable=false)
    private long idRole;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idAccount", insertable = false, updatable = false)
	private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Long getId() {
		return id;
	}

    public void setId(Long id) {
		this.id = id;
	}

    public long getIdAccount() {
		return idAccount;
	}

    public void setIdAccount(long idAccount) {
		this.idAccount = idAccount;
	}

    public long getIdRole() {
		return idRole;
	}

    public void setIdRole(long idRole) {
		this.idRole = idRole;
	}
	
}
