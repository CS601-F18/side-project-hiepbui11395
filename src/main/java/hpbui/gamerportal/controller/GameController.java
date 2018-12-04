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
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class GameController {
	Gson gson = new Gson();

	@Autowired
	private GameService gameService;

	/**
	 * Get List Games page
	 * @return
	 */
	@GetMapping(path = "/games")
	public String index() {
		return "game/index";
	}

	/**
	 * Get Game Detail page
	 * @param model
	 * @param id
	 * @return
	 */
    @GetMapping(path = "/games/{id}")
    public String detail(Model model, @PathVariable Long id) {
        Game game = gameService.findById(id);
        model.addAttribute("game", game);
        return "game/detail";
    }
}
