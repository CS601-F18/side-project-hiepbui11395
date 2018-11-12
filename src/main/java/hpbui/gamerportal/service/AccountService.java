package hpbui.gamerportal.service;

import hpbui.gamerportal.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface AccountService {
    
    Account findAccountByEmail(String email);
    
    Account findAccountById(int id);
    
    void addAccount(Account account);

    Page<Account> getAllPagination(PageRequest pageRequest);
}
