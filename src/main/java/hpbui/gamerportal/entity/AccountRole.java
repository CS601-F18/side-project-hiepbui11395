package hpbui.gamerportal.entity;

import javax.persistence.*;

@Entity
@Table(name = "gamer_portal.account_role")
public class AccountRole {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable=false)
	private int idAccount;

	@Column(nullable=false)
	private int idRole;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idAccount", insertable = false, updatable = false)
	private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(int idAccount) {
		this.idAccount = idAccount;
	}

	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}
	
}
