package hpbui.gamerportal.entity;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "gamer_portal.games")
public class Game {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(length = 128, nullable = false)
	private String name;

	@Column(length = 1, nullable = false)
	private boolean active;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "gamer_portal.game_genre", 
	joinColumns = {@JoinColumn(name="idGame")},
	inverseJoinColumns = {@JoinColumn(name="idGenre")})
	private Set<Genre> genres;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "gamer_portal.account_game",
	joinColumns = {@JoinColumn(name="idGame")},
	inverseJoinColumns = {@JoinColumn(name="idAccount")})
	private Set<Account> accounts;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Set<Genre> getGenres() {
		return genres;
	}

	public void setGenres(Set<Genre> genres) {
		this.genres = genres;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

	
	
//	public Set<AccountGame> getAccountGames() {
//		return accountGames;
//	}
//
//	public void setAccountGames(Set<AccountGame> accountGames) {
//		this.accountGames = accountGames;
//	}

}
