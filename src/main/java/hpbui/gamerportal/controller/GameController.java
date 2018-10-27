package hpbui.gamerportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import hpbui.gamerportal.entity.Game;
import hpbui.gamerportal.repository.GameRepository;

@RestController 
@RequestMapping("/game")
public class GameController {
	@Autowired
	private GameRepository gameRepository;

	@RequestMapping
	public Iterable<Game> findAll(){
		return gameRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Game create(@RequestBody Game game) {
		return gameRepository.save(game);
	}

//	@PutMapping
//	public Game deleteGame(@PathVariable int id) {
//		Optional<Game> game = gameRepository.findById(id);
//		return null;
//	}
}
