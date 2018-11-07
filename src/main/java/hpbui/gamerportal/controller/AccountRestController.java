package hpbui.gamerportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import hpbui.gamerportal.entity.Account;
import hpbui.gamerportal.service.AccountService;

@RestController
public class AccountRestController {
	@Autowired
	AccountService accountService;

	@PostMapping(path = "/account/games/add")
	public String addAccountGame() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.
        		getContext().getAuthentication().getPrincipal();
		Account entity = accountService.findAccountByEmail(userDetails.getUsername());
		return "";
	}
}
