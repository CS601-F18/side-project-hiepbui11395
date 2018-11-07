package hpbui.gamerportal.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="gamer_portal.game_genre")
public class GameGenre {
	@EmbeddedId
	private GameGenreId id;
	
	public GameGenreId getId() {
		return id;
	}

	public void setId(GameGenreId id) {
		this.id = id;
	}

}
