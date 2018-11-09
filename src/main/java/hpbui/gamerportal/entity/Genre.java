package hpbui.gamerportal.entity;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="gamer_portal.genres")
public class Genre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(length=45, nullable=false)
	private String genre;

	@Column(length=1, nullable=false)
	private boolean active;
	
	@ManyToMany(mappedBy="genres", fetch = FetchType.LAZY)
	private Set<Game> games;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
}
