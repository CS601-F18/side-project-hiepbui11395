package hpbui.gamerportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import hpbui.gamerportal.entity.Account;
import hpbui.gamerportal.service.AccountGameService;
import hpbui.gamerportal.service.AccountService;
import hpbui.gamerportal.service.GameService;
import hpbui.gamerportal.viewmodel.GameAddViewModel;

@RestController
public class AccountRestController {
	@Autowired
	AccountService accountService;
	@Autowired
	GameService gameService;
	@Autowired
	AccountGameService accountGameService;

	@PostMapping(path = "/account/games/add")
	public String addAccountGame(@RequestBody GameAddViewModel model) {
		//TODO:get current account email and check with the SecurityContextHolder
        UserDetails userDetails = (UserDetails) SecurityContextHolder.
        		getContext().getAuthentication().getPrincipal();
		Account entity = accountService.findAccountByEmail(userDetails.getUsername());
		return "";
	}
}
