package hpbui.gamerportal.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "gamer_portal.account_game")
public class AccountGame {
	@EmbeddedId
	private AccountGameId id;
	
	@Column(length = 1, nullable = false)
	private boolean active;

	@OneToMany(mappedBy="accountGame",
			cascade=CascadeType.ALL,
			orphanRemoval=true)
	private Set<GameTime> gameTimes;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "idAccount")
//	private Account account;
//	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "idGame")
//	private Game game;
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Set<GameTime> getGameTimes() {
		return gameTimes;
	}

	public void setGameTimes(Set<GameTime> gameTimes) {
		this.gameTimes = gameTimes;
	}
//
//	public Account getAccount() {
//		return account;
//	}
//
//	public void setAccount(Account account) {
//		this.account = account;
//	}
//
//	public Game getGame() {
//		return game;
//	}
//
//	public void setGame(Game game) {
//		this.game = game;
//	}
//
//	
	public AccountGameId getId() {
		return id;
	}

	public void setId(AccountGameId id) {
		this.id = id;
	}
	
}
