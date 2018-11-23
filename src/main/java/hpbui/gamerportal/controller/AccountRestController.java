package hpbui.gamerportal.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import hpbui.gamerportal.entity.Account;
import hpbui.gamerportal.entity.Game;
import hpbui.gamerportal.entity.Relationship;
import hpbui.gamerportal.entity.Role;
import hpbui.gamerportal.service.*;
import hpbui.gamerportal.utils.Config;
import hpbui.gamerportal.utils.Enums;
import hpbui.gamerportal.utils.JQueryDataTable;
import hpbui.gamerportal.utils.JsonResponse;
import hpbui.gamerportal.viewmodel.FollowViewModel;
import hpbui.gamerportal.viewmodel.GameAddViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    @Autowired
    RoleService roleService;

    @PostMapping(path = "/api/account/games/add")
	public JsonResponse addAccountGame(GameAddViewModel model) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.
        		getContext().getAuthentication().getPrincipal();
        Account account = accountService.findAccountByUsername(userDetails.getUsername());
		Game game = gameService.findByName(model.getName());
		if(game == null){
			//TODO: handle if game not found
		}
		accountGameService.addAccountGame(model,game,account);
		JsonResponse response = new JsonResponse(JsonResponse.STATUS_SUCCESS, "Add success!");
		return response;
	}

    @PostMapping(path = "api/account/games/delete/{id}")
    public JsonResponse deleteAccoutnGame(@PathVariable long id) {
        accountGameService.deleteAccountGame(id);
        JsonResponse response = new JsonResponse(JsonResponse.STATUS_SUCCESS, "Delete success!");
        return response;
    }

	@PostMapping(path = "/api/accounts/follow")
	public JsonResponse changeRelationship(FollowViewModel model){
		UserDetails userDetails = (UserDetails) SecurityContextHolder.
			getContext().getAuthentication().getPrincipal();
        Account accountFrom = accountService.findAccountByUsername(userDetails.getUsername());
		Account accountTo = accountService.findAccountById(model.getId());
		relationshipService.changeRelationship(accountFrom, accountTo, model.getRelationshipType());
		JsonResponse response = new JsonResponse(JsonResponse.STATUS_SUCCESS, "Add success!");
		return response;
	}

	@GetMapping(value="/api/accounts/getDataTable")
    public String getGamerDataTable(JQueryDataTable dataTable) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.
				getContext().getAuthentication().getPrincipal();
        Account currentAccount = accountService.findAccountByUsername(userDetails.getUsername());
		String sEcho = dataTable.getsEcho();
        String query = dataTable.getsSearch();
        Page<Account> gamerList;
        Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "followers"));
        Pageable pageable = PageRequest.of((dataTable.getiDisplayStart() / dataTable.getiDisplayLength()),
                dataTable.getiDisplayLength(), sort);
        if (query.isEmpty()) {
            Role role = roleService.findRoleByRoleName(Config.getInstance().getProperty("gamer"));
            gamerList = accountService.findAccountsByRole(role, pageable);
        } else {
            Role role = roleService.findRoleByRoleName(Config.getInstance().getProperty("gamer"));
            gamerList = accountService.findAccountsByRoleAndUsernameContain(query, role, pageable);
        }
        long iTotalRecords = gamerList.getTotalElements();
        long iTotalDisplayRecords = gamerList.getTotalElements();
		JsonObject dataTableResponse = new JsonObject();
		dataTableResponse.addProperty("sEcho", sEcho);
		dataTableResponse.addProperty("iTotalRecords", iTotalRecords);
		dataTableResponse.addProperty("iTotalDisplayRecords", iTotalDisplayRecords);
		JsonArray data = new JsonArray();
        for (Account gamer : gamerList) {
            JsonArray row = new JsonArray();
            //Add Id
            row.add(new JsonPrimitive(gamer.getId()));
            //Add username
            row.add(new JsonPrimitive(gamer.getUsername()));
            StringBuilder genreStr = new StringBuilder();
            for (Game game : gamer.getGames()) {
                genreStr.append(game.getName() + "<br/>\n");
            }
            //Add game
            row.add(genreStr.toString());
            //Add relationship
            Relationship relationship = relationshipService.findRelationship(currentAccount.getId(), gamer.getId());
            if (relationship == null || relationship.getType() == Enums.Relationship.NO_RELATION.ordinal()) {
                row.add(Enums.Relationship.NO_RELATION.ordinal());
            } else {
                row.add(Enums.Relationship.FOLLOWING.ordinal());
            }
            data.add(row);
        }
		dataTableResponse.add("aaData", data);
		return dataTableResponse.toString();
	}

    @GetMapping(value = "/api/accounts/getFriendDataTable/{id}")
    public String getFriendDataTable(JQueryDataTable dataTable, @PathVariable long id) {
        Account currentAccount = accountService.findAccountById(id);
        String sEcho = dataTable.getsEcho();

        List<Account> listFriend = relationshipService.findFriend(currentAccount.getId(), PageRequest.of(
                (dataTable.getiDisplayStart() / dataTable.getiDisplayLength()),
                dataTable.getiDisplayLength()));
        long iTotalRecords = listFriend.size();
        long iTotalDisplayRecords = listFriend.size();
        JsonObject dataTableResponse = new JsonObject();
        dataTableResponse.addProperty("sEcho", sEcho);
        dataTableResponse.addProperty("iTotalRecords", iTotalRecords);
        dataTableResponse.addProperty("iTotalDisplayRecords", iTotalDisplayRecords);
        JsonArray data = new JsonArray();
        for (Account account : listFriend) {
            JsonArray row = new JsonArray();
            //Add id
            row.add(account.getId());
            //Add username
            row.add(account.getUsername());
            data.add(row);
        }
        dataTableResponse.add("aaData", data);
        return dataTableResponse.toString();
    }

    @GetMapping(value = "/api/accounts/getAccountByGame/{id}")
    public String getAccountByGameDataTable(JQueryDataTable dataTable, @PathVariable long id) {
        String sEcho = dataTable.getsEcho();
        Page<Account> listAccount = accountService.findAccountsByGame(id, PageRequest.of(
                (dataTable.getiDisplayStart() / dataTable.getiDisplayLength()),
                dataTable.getiDisplayLength()));
        long iTotalRecords = listAccount.getTotalElements();
        long iTotalDisplayRecords = listAccount.getTotalElements();
        JsonObject dataTableResponse = new JsonObject();
        dataTableResponse.addProperty("sEcho", sEcho);
        dataTableResponse.addProperty("iTotalRecords", iTotalRecords);
        dataTableResponse.addProperty("iTotalDisplayRecords", iTotalDisplayRecords);
        JsonArray data = new JsonArray();
        for (Account account : listAccount) {
            JsonArray row = new JsonArray();
            //Add id
            row.add(account.getId());
            //Add username
            row.add(account.getUsername());
            data.add(row);
        }
        dataTableResponse.add("aaData", data);
        return dataTableResponse.toString();
    }
}
