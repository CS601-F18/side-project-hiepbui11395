package hpbui.gamerportal.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AccountGameId implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3151877294404643986L;
	@Column(name = "idAccount")
	private long idAccount;
	@Column(name = "idGame")
	private long idGame;
	
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

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccountGameId)) return false;
        AccountGameId that = (AccountGameId) o;
        return Objects.equals(getIdAccount(), that.getIdAccount()) &&
                Objects.equals(getIdGame(), that.getIdGame());
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(getIdAccount(), getIdGame());
    }
}