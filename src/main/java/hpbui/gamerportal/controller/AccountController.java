package hpbui.gamerportal.controller;

import hpbui.gamerportal.entity.Account;
import hpbui.gamerportal.entity.Game;
import hpbui.gamerportal.service.AccountGameService;
import hpbui.gamerportal.service.AccountService;
import hpbui.gamerportal.viewmodel.GameWithTimeViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AccountController {
	@Autowired
	private AccountService accountService;
	@Autowired
	private AccountGameService accountGameService;

	@GetMapping(path = "/account/detail")
	public String accountDetail(Model model) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.
        		getContext().getAuthentication().getPrincipal();
        Account currentAccount = accountService.findAccountByUsername(userDetails.getUsername());
		model.addAttribute("account", currentAccount);
		List<GameWithTimeViewModel> gameWithTimes = new ArrayList<>();
		for(Game game:currentAccount.getGames()){
			gameWithTimes.add(accountGameService.findTimeByAccountAndGame(game, currentAccount));
		}
		model.addAttribute("games",gameWithTimes);
		return "account/detail";
	}

    @GetMapping(path = "/accounts/{id}")
    public String info(Model model, @PathVariable long id) {
        Account account = accountService.findAccountById(id);
        model.addAttribute("account", account);
        List<GameWithTimeViewModel> gameWithTimes = new ArrayList<>();
        for (Game game : account.getGames()) {
            gameWithTimes.add(accountGameService.findTimeByAccountAndGame(game, account));
        }
        model.addAttribute("games", gameWithTimes);
        return "account/detail";
    }

	@GetMapping(path = "/accounts")
	public String index(){
		return "account/index";
	}
}
