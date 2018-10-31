package hpbui.gamerportal.service;

import hpbui.gamerportal.entity.Account;

public interface AccountService {
    
    public Account findAccountByEmail(String email);
    
    public Account findAccountById(int id);
    
    public void addAccount(Account account);

}
