package hpbui.gamerportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import hpbui.gamerportal.entity.Account;
import hpbui.gamerportal.service.AccountService;

@Controller
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	@GetMapping(value = "/account/{accountId}")
	public String accountDetail(Model model,@PathVariable int accountId) {
		Account entity = accountService.findAccountById(accountId);
		model.addAttribute("account", entity);
		return "account/detail";
	}
}
