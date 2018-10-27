package hpbui.gamerportal.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import hpbui.gamerportal.entity.Account;
import hpbui.gamerportal.entity.Role;
import hpbui.gamerportal.repository.AccountRepository;
import hpbui.gamerportal.repository.RoleRepository;

@Service
public class AccountService {
	private AccountRepository accountRepository;
	private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Autowired
    public AccountService(AccountRepository accountRepository,
                       RoleRepository roleRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.accountRepository = accountRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    public Account findAccountByEmail(String email) {
    	return accountRepository.findByEmail(email);
    }
    
    public void addAccount(Account account) {
    	account.setPassword(bCryptPasswordEncoder.encode(account.getPassword()));
    	account.setActive(true);
    	List<Role> userRole = roleRepository.findAll();
    	account.setRoles(new HashSet<Role>(userRole));
    	accountRepository.save(account);
    }
}
