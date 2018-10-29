package hpbui.gamerportal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hpbui.gamerportal.entity.Genre;
import hpbui.gamerportal.repository.GenreRepository;
import hpbui.gamerportal.service.GenreService;

@Service
public class GenreServiceImpl implements GenreService{
	@Autowired
	GenreRepository genreRepository;

	@Override
	public Iterable<Genre> findAll() {
		return genreRepository.findAll();
	}

	@Override
	public void save(Genre genre) {
		genreRepository.save(genre);
	}
	
}
