package hpbui.gamerportal.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import hpbui.gamerportal.entity.Account;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AccountRepository extends PagingAndSortingRepository<Account, Integer> {
	Account findByEmail(String email);
}
