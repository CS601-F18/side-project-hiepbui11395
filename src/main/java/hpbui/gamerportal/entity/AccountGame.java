package hpbui.gamerportal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Account_Game")
public class AccountGame {
	@Id
	@Column(name = "Id", nullable = false)
	private int id;
	
	@Column(name = "IdAccount", nullable = false)
	private int idAccount;
	
	@Column(name = "IdGame", nullable = false)
	private int idGame;
	
	@Column(name = "Active", length = 1, nullable = false)
	private boolean active;

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

	public int getIdGame() {
		return idGame;
	}

	public void setIdGame(int idGame) {
		this.idGame = idGame;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
}
