package hpbui.gamerportal.service;

import java.util.ArrayList;

import hpbui.gamerportal.entity.Game;

public interface GameService {
	Iterable<Game> findAll();

	Game findOne(int id);

	void save(Game game);

	void delete(int id);
	
	void addGame(Game game, ArrayList<String> genres);
}
