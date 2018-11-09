package hpbui.gamerportal.service;

import hpbui.gamerportal.entity.Account;

public interface AccountService {
    
    Account findAccountByEmail(String email);
    
    Account findAccountById(int id);
    
    void addAccount(Account account);

}
