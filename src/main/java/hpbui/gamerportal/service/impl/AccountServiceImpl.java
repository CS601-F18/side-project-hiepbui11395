package hpbui.gamerportal.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import hpbui.gamerportal.entity.Account;
import hpbui.gamerportal.entity.Role;
import hpbui.gamerportal.repository.AccountRepository;
import hpbui.gamerportal.repository.RoleRepository;
import hpbui.gamerportal.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService, UserDetailsService{
	private AccountRepository accountRepository;
	private RoleRepository roleRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public AccountServiceImpl(AccountRepository accountRepository,
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

	@Override
	public Account findAccountById(int id) {
		Account entity = accountRepository.findById(id)==null?null:accountRepository.findById(id).get();
		return entity;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO implement load user
		Account account = accountRepository.findByEmail(username);

		if (account == null) {
			throw new UsernameNotFoundException("User " //
					+ username + " was not found in the database");
		}

		Set<Role> roles = account.getRoles();

		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();

		for(Role role : roles) {
			GrantedAuthority authority = new SimpleGrantedAuthority(role.getRoleName());
			grantList.add(authority);
		}


		boolean enabled = account.isActive();
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;

		UserDetails userDetails = (UserDetails) new User(account.getEmail(), //
				account.getPassword(), enabled, accountNonExpired, //
				credentialsNonExpired, accountNonLocked, grantList);

		return userDetails;
	}

}
