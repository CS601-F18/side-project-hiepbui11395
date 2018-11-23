package hpbui.gamerportal.entity;

import javax.persistence.*;

@Entity
@Table(name = "gamer_portal.account_game")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "updateNumberOfGamer",
                procedureName = "gamer_portal.updateNumberOfGamer")})
public class AccountGame {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(nullable = false)
    private long idAccount;

	@Column(nullable = false)
    private long idGame;

	@Column
	private int startTime;

	@Column
	private int endTime;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idGame", insertable = false, updatable = false)
	private Game game;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idAccount", insertable = false, updatable = false)
	private Account account;
	
	@Column(length = 1, nullable = false)
	private boolean active;

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

    public long getIdGame() {
		return idGame;
	}

    public void setIdGame(long idGame) {
		this.idGame = idGame;
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

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
