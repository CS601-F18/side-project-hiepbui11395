package hpbui.gamerportal.service;

import hpbui.gamerportal.entity.Account;
import hpbui.gamerportal.entity.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AccountService {
    
    Account findAccountByEmail(String email);

    Account findAccountByUsername(String username);

    Account findAccountById(Long id);
    
    void addAccount(Account account);

    Page<Account> findAccountsByRole(Role role, Long id, Pageable pageable);

    Page<Account> findAccountsByRoleAndUsernameContain(String query, Role role, Long id, Pageable pageable);

    Page<Account> findAccountsByGame(long gameId, Pageable pageable);
}
