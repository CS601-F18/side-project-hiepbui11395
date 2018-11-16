package hpbui.gamerportal.controller;

import com.google.gson.Gson;
import hpbui.gamerportal.entity.Game;
import hpbui.gamerportal.service.GameService;
import hpbui.gamerportal.utils.Utils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

@Controller
public class GameController {
	Gson gson = new Gson();

	@Autowired
	private GameService gameService;

	@GetMapping(path = "/games")
	public String index() {
		return "game/index";
	}

	@GetMapping(path="/admin/game/get")
	public String getGame() {
		int offset = 200;
		int total = Integer.MAX_VALUE;
		while(offset<total) {
			String urlString = "https://www.giantbomb.com/api/games/?api_key=24a0f044a74d7d88224268e7cbc11c39007727fc&"
					+ "format=json&"
					+ "field_list=id,name&"
					+ "offset=" + offset;
			String response = Utils.callGetApi(urlString);
			JSONObject jsonObject = new JSONObject(response);
			total = jsonObject.getInt("number_of_total_results");
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
			System.out.println("get from: " + offset + " - to: " + offset+100);
			try {
				Thread.sleep(60000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			offset+=100;
		}
		return "admin/index";
	}

    @GetMapping(path = "/games/{id}")
    public String detail(Model model, @PathVariable int id) {
        Game game = gameService.findById(id);
        model.addAttribute("game", game);
        return "game/detail";
    }
}
