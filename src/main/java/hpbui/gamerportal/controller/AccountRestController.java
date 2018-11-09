package hpbui.gamerportal.controller;

import hpbui.gamerportal.entity.AccountGame;
import hpbui.gamerportal.entity.Game;
import hpbui.gamerportal.service.AccountGameService;
import hpbui.gamerportal.utils.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import hpbui.gamerportal.entity.Account;
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
	public JsonResponse addAccountGame(GameAddViewModel model) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.
        		getContext().getAuthentication().getPrincipal();
		Account account = accountService.findAccountByEmail(userDetails.getUsername());
		Game game = gameService.findByName(model.getName());
		if(game == null){
			//TODO: handle if game not found
		}
		accountGameService.addAccountGame(model,game,account);
		JsonResponse response = new JsonResponse(JsonResponse.STATUS_SUCCESS, "Add success!");
		return response;
	}
}
