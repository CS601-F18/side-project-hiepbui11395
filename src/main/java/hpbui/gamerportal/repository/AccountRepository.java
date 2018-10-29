package hpbui.gamerportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hpbui.gamerportal.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{
	Account findByEmail(String email);
}
