package hpbui.gamerportal.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class GameGenreId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1538764118738611527L;
	
	@Column(name="idGame")
	private long idGame;
	
	@Column(name="idGenre")
	private long idGenre;

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
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GameGenreId)) return false;
        GameGenreId that = (GameGenreId) o;
        return Objects.equals(getIdGame(), that.getIdGame()) &&
                Objects.equals(getIdGenre(), that.getIdGenre());
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(getIdGame(), getIdGenre());
    }
}
