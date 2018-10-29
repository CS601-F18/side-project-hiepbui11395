package hpbui.gamerportal.controller;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import hpbui.gamerportal.entity.Game;
import hpbui.gamerportal.service.GameService;
import hpbui.gamerportal.utils.Utils;

@RestController
public class GameController {
	@Autowired
	private GameService gameService;

	@GetMapping(value="/admin/game/get/{offset}")
	public JSONObject getTest(@PathVariable int offset) {
		String urlString = "https://www.giantbomb.com/api/games/?api_key=24a0f044a74d7d88224268e7cbc11c39007727fc&"
				+ "format=json&"
				+ "field_list=id,name&"
				+ "offset=" + offset;
		String response = Utils.callGetApi(urlString);
        JSONObject jsonObject = new JSONObject(response);
        JSONArray jsonGameArray = jsonObject.getJSONArray("results");
        for(int i = 0;i<jsonGameArray.length();i++) {
        	JSONObject jsonGameObject = jsonGameArray.getJSONObject(i);
        	int idGame = jsonGameObject.getInt("id");
        	String nameGame = jsonGameObject.getString("name");
        	Game game = new Game();
        	game.setName(nameGame);
        	urlString = "https://www.giantbomb.com/api/game/" + idGame + "/?api_key=24a0f044a74d7d88224268e7cbc11c39007727fc&format=json&field_list=genres,name";
        	response = Utils.callGetApi(urlString);
        	JSONArray jsonGenreArray = new JSONObject(response).getJSONObject("results").getJSONArray("genres");
        	ArrayList<String> genres = new ArrayList<String>();
        	for(int j = 0;j<jsonGenreArray.length();j++) {
        		genres.add(jsonGenreArray.getJSONObject(j).getString("name"));
        	}
        	gameService.addGame(game, genres);
        }
        System.out.println(response.toString());

		return null;
	}
}
