package hpbui.gamerportal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="gamer_portal.game_time")
public class GameTime {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(nullable=false)
	private int idAccountGame;
	
	@Column(nullable=false)
	private int idGame;
	
	private int startTime;
	
	private int endTime;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPost")
	private AccountGame accountGame;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdAccountGame() {
		return idAccountGame;
	}

	public void setIdAccountGame(int idAccountGame) {
		this.idAccountGame = idAccountGame;
	}

	public int getIdGame() {
		return idGame;
	}

	public void setIdGame(int idGame) {
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
	
}
