package hpbui.gamerportal.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="gamer_portal.genres")
public class Genre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(length=45, nullable=false)
    private String name;

	@Column(length=1, nullable=false)
	private boolean active;
	
	@ManyToMany(mappedBy="genres", fetch = FetchType.LAZY)
	private Set<Game> games;

    public Long getId() {
		return id;
	}

    public void setId(Long id) {
		this.id = id;
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }

    public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
}
