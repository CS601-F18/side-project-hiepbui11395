package hpbui.gamerportal.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import hpbui.gamerportal.entity.Account;
import hpbui.gamerportal.entity.Game;
import hpbui.gamerportal.entity.Genre;
import hpbui.gamerportal.model.JQueryDataTable;
import hpbui.gamerportal.service.AccountService;
import hpbui.gamerportal.service.GameService;

@RestController
public class GameRestController {
	@Autowired
	GameService gameService;
	@Autowired
	AccountService accountService;

	Gson gson = new Gson();

	@GetMapping(value="/api/games")
	public Iterable<Game> getAll() {
		return gameService.findAll();
	}
	
	@GetMapping(value="/api/games/getDataTable")
	public String gameDataTable(JQueryDataTable dataTable) {  
		String sEcho = dataTable.getsEcho();
		long iTotalRecords; // total number of records (unfiltered)
		long iTotalDisplayRecords;//value will be set when code filters companies by keyword

		Page<Game> gameList = gameService.getAllPagination(PageRequest.of(
				(dataTable.getiDisplayStart() / dataTable.getiDisplayLength()),
				dataTable.getiDisplayLength()));
		iTotalRecords = gameList.getTotalElements();
		iTotalDisplayRecords = gameList.getTotalElements();
		JsonObject dataTableResponse = new JsonObject();
		dataTableResponse.addProperty("sEcho", sEcho);
		dataTableResponse.addProperty("iTotalRecords", iTotalRecords);
		dataTableResponse.addProperty("iTotalDisplayRecords", iTotalDisplayRecords);
//		List<Game> result = gameList.getContent();
		JsonArray data = new JsonArray();
		for(Game game : gameList){
	        JsonArray row = new JsonArray();
	        row.add(new JsonPrimitive(game.getName()));
	        StringBuilder genreStr = new StringBuilder();
	        for(Genre genre : game.getGenres()) {
	        	genreStr.append(genre.getGenre() + ", ");
	        }
	        genreStr.delete(genreStr.length()-1, genreStr.length());
	        row.add(genreStr.toString());
	        row.add(new JsonPrimitive(game.getAccounts().size()));
	        data.add(row);
	    }
		dataTableResponse.add("aaData", data);
		return dataTableResponse.toString();
	}

	@PostMapping(value = "/account/game")
	public String addGame(Model model) {
		return "";
	}
}
