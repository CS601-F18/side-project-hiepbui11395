package hpbui.gamerportal.entity;

import javax.persistence.*;

@Entity
@Table(name = "gamer_portal.relationship")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "updateNumberOfFollower",
                procedureName = "gamer_portal.updateNumberOfFollower")})
public class Relationship {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable = false)
    private long idAccountFrom;
	
	@Column(nullable = false)
    private long idAccountTo;

	@Column(nullable = false)
	private int type;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAccountFrom", insertable = false, updatable = false)
    private Account accountFrom;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAccountTo", insertable = false, updatable = false)
    private Account accountTo;

    public Relationship() {
    }

    public Relationship(Long idAccountFrom, Long idAccountTo, int type) {
        this.idAccountFrom = idAccountFrom;
        this.idAccountTo = idAccountTo;
        this.type = type;
    }

    public Account getAccountFrom() {
        return accountFrom;
    }

    public void setAccountFrom(Account accountFrom) {
        this.accountFrom = accountFrom;
    }

    public Account getAccountTo() {
        return accountTo;
    }

    public void setAccountTo(Account accountTo) {
        this.accountTo = accountTo;
    }

    public long getIdAccountFrom() {
		return idAccountFrom;
	}

    public void setIdAccountFrom(long idAccountFrom) {
		this.idAccountFrom = idAccountFrom;
	}

    public long getIdAccountTo() {
		return idAccountTo;
	}

    public void setIdAccountTo(long idAccountTo) {
		this.idAccountTo = idAccountTo;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}


    public Long getId() {
		return id;
	}

    public void setId(Long id) {
		this.id = id;
	}

}
