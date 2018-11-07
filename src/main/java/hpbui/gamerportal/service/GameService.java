package hpbui.gamerportal.service;

import java.util.ArrayList;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import hpbui.gamerportal.entity.Game;

public interface GameService {
	Iterable<Game> findAll();

	Game findById(int id);
	
	Game findByName(String name);

	void save(Game game);

	void delete(int id);
	
	void addGame(Game game, ArrayList<String> genres);
	
	Page<Game> getAllPagination(PageRequest pageRequest);
}
