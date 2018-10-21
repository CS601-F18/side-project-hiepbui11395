package hpbui.gamerportal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Account_Account")
public class AccountAccount {
	@Id
	@Column(name = "Id", nullable = false)
	private int id;
	
	@Column(name = "IdAccount1", nullable = false)
	private int idAccount1;
	
	@Column(name = "IdAccount2", nullable = false)
	private int idAccount2;
	
	@Column(name = "Active", nullable = false)
	private boolean active;
}
