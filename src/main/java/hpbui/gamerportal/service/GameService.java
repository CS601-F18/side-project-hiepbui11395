package hpbui.gamerportal.service;

import hpbui.gamerportal.entity.Game;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;

public interface GameService {
	/**
	 * Get all Game
	 * @return
	 */
	Iterable<Game> findAll();

	/**
	 * Retrieve game by id
	 * @param id
	 * @return
	 */
    Game findById(Long id);

	/**
	 * Retrieve game by name
	 * @param name
	 * @return
	 */
	Game findByName(String name);

	/**
	 * Add Game with Genres
	 * @param game
	 * @param genres
	 */
	void addGame(Game game, ArrayList<String> genres);

	/**
	 * Get Games with pagination
	 * @param pageRequest
	 * @return
	 */
	Page<Game> getAllPagination(PageRequest pageRequest);

	/**
	 * Get number of games
	 * @return
	 */
    long getNumberOfGame();

	/**
	 * Get Games by name contain query
	 * @param query
	 * @param pageable
	 * @return
	 */
    Page<Game> findGameByQueryPagination(String query, Pageable pageable);
}
