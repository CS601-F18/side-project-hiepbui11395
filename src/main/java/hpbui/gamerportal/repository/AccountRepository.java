package hpbui.gamerportal.repository;

import hpbui.gamerportal.entity.Account;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {
	Account findByEmail(String email);

    Account findAccountByUsername(String username);
}
