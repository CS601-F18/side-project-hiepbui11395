package hpbui.gamerportal.service;

import hpbui.gamerportal.entity.Game;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;

public interface GameService {
	Iterable<Game> findAll();

    Game findById(Long id);
	
	Game findByName(String name);

	void save(Game game);

    void delete(Long id);
	
	void addGame(Game game, ArrayList<String> genres);
	
	Page<Game> getAllPagination(PageRequest pageRequest);

    long getNumberOfGame();

    Page<Game> findGameByQueryPagination(String query, Pageable pageable);
}
