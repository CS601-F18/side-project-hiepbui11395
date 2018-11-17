package hpbui.gamerportal.entity;

import javax.persistence.*;

@Entity
@Table(name="gamer_portal.game_genre")
public class GameGenre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(nullable = false)
    private long idGame;

	@Column(nullable = false)
    private long idGenre;

    public GameGenre(Long idGame, Long idGenre) {
        this.idGame = idGame;
        this.idGenre = idGenre;
    }

    public Long getId() {
		return id;
	}

    public void setId(Long id) {
		this.id = id;
	}

    public long getIdGame() {
		return idGame;
	}

    public void setIdGame(long idGame) {
		this.idGame = idGame;
	}

    public long getIdGenre() {
		return idGenre;
	}

    public void setIdGenre(long idGenre) {
		this.idGenre = idGenre;
	}

}
