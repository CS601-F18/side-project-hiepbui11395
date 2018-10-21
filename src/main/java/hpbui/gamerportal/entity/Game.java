package hpbui.gamerportal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Games")
public class Game {
	@Id
	@Column(name = "Id", nullable = false)
	private int id;
	
	@Column(name = "Name", length = 128, nullable = false)
	private String Name;
	
	@Column(name = "Active", length = 1, nullable = false)
	private boolean active;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
