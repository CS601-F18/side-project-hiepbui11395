package hpbui.gamerportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import hpbui.gamerportal.entity.Account;
import hpbui.gamerportal.service.AccountService;

@Controller
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	@GetMapping(path = "/account/detail")
	public String accountDetail(Model model) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.
        		getContext().getAuthentication().getPrincipal();
		Account entity = accountService.findAccountByEmail(userDetails.getUsername());
		model.addAttribute("account", entity);
		return "account/detail";
	}
}
