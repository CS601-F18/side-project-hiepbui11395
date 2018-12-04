package hpbui.gamerportal.repository;

import hpbui.gamerportal.entity.Account;
import hpbui.gamerportal.entity.Game;
import hpbui.gamerportal.entity.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {
	Account findByEmail(String email);

    Account findAccountByUsernameAndActiveTrue(String username);

    Page<Account> findAccountsByRolesAndActiveTrueAndIdNot(Role role, Long id, Pageable pageable);

    Page<Account> findAccountsByRolesAndUsernameContainingAndActiveTrueAndIdNot(Role role, String username, Long id, Pageable pageable);

    Page<Account> findAccountsByGamesContainingAndActiveTrue(Game game, Pageable pageable);
}
