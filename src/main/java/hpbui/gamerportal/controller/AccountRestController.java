package hpbui.gamerportal.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import hpbui.gamerportal.entity.*;
import hpbui.gamerportal.model.JQueryDataTable;
import hpbui.gamerportal.service.*;
import hpbui.gamerportal.utils.Enums;
import hpbui.gamerportal.utils.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import hpbui.gamerportal.viewmodel.GameAddViewModel;

@RestController
public class AccountRestController {
	@Autowired
	AccountService accountService;
	@Autowired
	GameService gameService;
	@Autowired
	AccountGameService accountGameService;
	@Autowired
	RelationshipService relationshipService;
	@Autowired
    AccountRoleService accountRoleService;

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

	@PostMapping(path = "/api/accounts/addFriend/{}")
	public JsonResponse addFriend(Account model){
		UserDetails userDetails = (UserDetails) SecurityContextHolder.
			getContext().getAuthentication().getPrincipal();
		Account accountFrom = accountService.findAccountByEmail(userDetails.getUsername());
		Account accountTo = accountService.findAccountById(model.getId());
		relationshipService.addFriend(accountFrom, accountTo);
		JsonResponse response = new JsonResponse(JsonResponse.STATUS_SUCCESS, "Add success!");
		return response;
	}

	@GetMapping(value="/api/accounts/getDataTable")
	public String accountDataTable(JQueryDataTable dataTable) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.
				getContext().getAuthentication().getPrincipal();
		Account currentAccount = accountService.findAccountByEmail(userDetails.getUsername());
		String sEcho = dataTable.getsEcho();
		long iTotalRecords; // total number of records (unfiltered)
		long iTotalDisplayRecords;//value will be set when code filters companies by keyword
        Page<AccountRole> accountRoleList = accountRoleService.findAccountByRoleName("GAMER",PageRequest.of(
                (dataTable.getiDisplayStart() / dataTable.getiDisplayLength()),
                dataTable.getiDisplayLength()));
		iTotalRecords = accountRoleList.getTotalElements();
		iTotalDisplayRecords = accountRoleList.getTotalElements();
		JsonObject dataTableResponse = new JsonObject();
		dataTableResponse.addProperty("sEcho", sEcho);
		dataTableResponse.addProperty("iTotalRecords", iTotalRecords);
		dataTableResponse.addProperty("iTotalDisplayRecords", iTotalDisplayRecords);
		JsonArray data = new JsonArray();
		for(AccountRole accountRole : accountRoleList){
			JsonArray row = new JsonArray();
			row.add(new JsonPrimitive(accountRole.getAccount().getUsername()));
			StringBuilder genreStr = new StringBuilder();
			for(Game game : accountRole.getAccount().getGames()) {
				genreStr.append(game.getName() + "<br/>\n");
			}
			row.add(genreStr.toString());
			Relationship relationship = relationshipService.findRelationship(currentAccount.getId(), accountRole.getAccount().getId());
			if(relationship == null || relationship.getType() == Enums.Relationship.NOT_FRIEND.ordinal()){
				row.add(Enums.Relationship.NOT_FRIEND.ordinal());
			} else if(relationship.getType() == Enums.Relationship.PENDING.ordinal()){
				row.add(Enums.Relationship.PENDING.ordinal());
			} else{
				row.add(Enums.Relationship.FRIEND.ordinal());
			}
			data.add(row);
		}
		dataTableResponse.add("aaData", data);
		return dataTableResponse.toString();
	}
}
