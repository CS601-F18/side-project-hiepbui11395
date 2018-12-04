package hpbui.gamerportal.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import hpbui.gamerportal.entity.Game;
import hpbui.gamerportal.entity.Genre;
import hpbui.gamerportal.service.AccountService;
import hpbui.gamerportal.service.GameService;
import hpbui.gamerportal.utils.JQueryDataTable;
import hpbui.gamerportal.viewmodel.GameViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GameRestController {
	@Autowired
	GameService gameService;
	@Autowired
	AccountService accountService;

	Gson gson = new Gson();

	/**
	 * API get list of games
	 * @return List of games
	 */
	@GetMapping(value="/api/games")
	public List<GameViewModel> getAll() {
		Iterable<Game> games = gameService.findAll();
		List<GameViewModel> result = new ArrayList<GameViewModel>();
		for(Game game : games){
			result.add(new GameViewModel(game.getId(),game.getName(),game.isActive()));
		}
		return result;
	}

	/**
	 * API get list of games
	 * @param dataTable
	 * @return List of games in DataTable
	 */
	@GetMapping(value="/api/games/getDataTable")
    public String gameDataTable(JQueryDataTable dataTable) {
		String sEcho = dataTable.getsEcho();
        String query = dataTable.getsSearch();
		long iTotalRecords; // total number of records (unfiltered)
		long iTotalDisplayRecords;//value will be set when code filters companies by keyword
        Page<Game> gameList;
        Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "numberOfGamer"));
        if (query.isEmpty()) {
            gameList = gameService.getAllPagination(PageRequest.of(
                    (dataTable.getiDisplayStart() / dataTable.getiDisplayLength()),
                    dataTable.getiDisplayLength(), sort));
        } else {
            gameList = gameService.findGameByQueryPagination(query,
                    PageRequest.of((dataTable.getiDisplayStart() / dataTable.getiDisplayLength()),
                            dataTable.getiDisplayLength(), sort));
        }
		iTotalRecords = gameList.getTotalElements();
		iTotalDisplayRecords = gameList.getTotalElements();
		JsonObject dataTableResponse = new JsonObject();
		dataTableResponse.addProperty("sEcho", sEcho);
		dataTableResponse.addProperty("iTotalRecords", iTotalRecords);
		dataTableResponse.addProperty("iTotalDisplayRecords", iTotalDisplayRecords);
		JsonArray data = new JsonArray();
		for(Game game : gameList){
	        JsonArray row = new JsonArray();
            row.add(new JsonPrimitive(game.getId()));
	        row.add(new JsonPrimitive(game.getName()));
	        StringBuilder genreStr = new StringBuilder();
	        for(Genre genre : game.getGenres()) {
                genreStr.append(genre.getName() + ", ");
	        }
            if (genreStr.length() > 0) {
                genreStr.delete(genreStr.length() - 1, genreStr.length());
            }
	        row.add(genreStr.toString());
	        row.add(new JsonPrimitive(game.getAccounts().size()));
	        data.add(row);
	    }
		dataTableResponse.add("aaData", data);
		return dataTableResponse.toString();
	}
}
