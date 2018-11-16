package hpbui.gamerportal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gamer_portal.relationship")
public class Relationship {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private int idAccountFrom;
	
	@Column(nullable = false)
	private int idAccountTo;

	@Column(nullable = false)
	private int type;

    public Relationship() {
    }

    public Relationship(int idAccountFrom, int idAccountTo, int type) {
		this.idAccountFrom = idAccountFrom;
		this.idAccountTo = idAccountTo;
		this.type = type;
	}

	public int getIdAccountFrom() {
		return idAccountFrom;
	}

	public void setIdAccountFrom(int idAccountFrom) {
		this.idAccountFrom = idAccountFrom;
	}

	public int getIdAccountTo() {
		return idAccountTo;
	}

	public void setIdAccountTo(int idAccountTo) {
		this.idAccountTo = idAccountTo;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
