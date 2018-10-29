package hpbui.gamerportal.service;

import hpbui.gamerportal.entity.Genre;

public interface GenreService {

	Iterable<Genre> findAll();
	
	void save(Genre genre);
}
