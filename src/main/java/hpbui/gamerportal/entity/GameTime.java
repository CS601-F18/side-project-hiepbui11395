package hpbui.gamerportal.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="gamer_portal.game_time")
public class GameTime {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private int startTime;

	private int endTime;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "idAccount", referencedColumnName="idAccount", insertable=false, updatable=false),
		@JoinColumn(name = "idGame", referencedColumnName="idGame", insertable=false, updatable=false)
	})
	private AccountGame accountGame;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	public AccountGame getAccountGame() {
		return accountGame;
	}

	public void setAccountGame(AccountGame accountGame) {
		this.accountGame = accountGame;
	}

}
