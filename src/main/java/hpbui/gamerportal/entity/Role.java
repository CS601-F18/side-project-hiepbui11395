package hpbui.gamerportal.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "gamer_portal.roles")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length=45, nullable = false)
	private String roleName;
	
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "gamer_portal.account_role", 
    joinColumns = {@JoinColumn(name="idRole", referencedColumnName="id")}, 
    inverseJoinColumns = {@JoinColumn(name="idAccount", referencedColumnName="id")})
    private Set<Account> accounts;
}
