package hpbui.gamerportal.service;

import hpbui.gamerportal.entity.Account;
import hpbui.gamerportal.entity.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Logic code for Account
 */
public interface AccountService {
    /**
     * Retrieve Account by email
     * @param email
     * @return
     */
    Account findAccountByEmail(String email);

    /**
     * Retrieve Account by username
     * @param username
     * @return
     */
    Account findAccountByUsername(String username);

    /**
     * Retrieve Account by id
     * @param id
     * @return
     */
    Account findAccountById(Long id);

    /**
     * Add an Account
     * @param account
     */
    void addAccount(Account account);

    /**
     * Retrieve Accounts by role
     * @param role
     * @param pageable
     * @return
     */
    Page<Account> findAccountsByRole(Role role, Long id, Pageable pageable);

    /**
     * Retrieve Accounts by role and username
     * @param query
     * @param role
     * @param pageable
     * @return
     */
    Page<Account> findAccountsByRoleAndUsernameContain(String query, Role role, Long id, Pageable pageable);

    /**
     * Retrieve Accounts by gameId
     * @param gameId
     * @param pageable
     * @return
     */
    Page<Account> findAccountsByGame(long gameId, Pageable pageable);
}
