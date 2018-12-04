package hpbui.gamerportal.service;

import hpbui.gamerportal.entity.Genre;

public interface GenreService {

	Iterable<Genre> findAll();

	/**
	 * Add Genre to DB
	 * @param genre
	 */
	void save(Genre genre);
}
