package hpbui.gamerportal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gamer_portal.account_account")
public class AccountAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(nullable = false)
	private int idAccount1;
	
	@Column(nullable = false)
	private int idAccount2;
	
	@Column(nullable = false)
	private boolean active;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdAccount1() {
		return idAccount1;
	}

	public void setIdAccount1(int idAccount1) {
		this.idAccount1 = idAccount1;
	}

	public int getIdAccount2() {
		return idAccount2;
	}

	public void setIdAccount2(int idAccount2) {
		this.idAccount2 = idAccount2;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
}
