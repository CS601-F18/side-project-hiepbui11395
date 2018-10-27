package hpbui.gamerportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hpbui.gamerportal.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
	Account findByEmail(String email);
}
