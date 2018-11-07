package hpbui.gamerportal.service.impl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import hpbui.gamerportal.entity.Game;
import hpbui.gamerportal.entity.GameGenre;
import hpbui.gamerportal.entity.GameGenreId;
import hpbui.gamerportal.entity.Genre;
import hpbui.gamerportal.repository.GameGenreRepository;
import hpbui.gamerportal.repository.GameRepository;
import hpbui.gamerportal.repository.GenreRepository;
import hpbui.gamerportal.service.GameService;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	GameRepository gameRepository;
	@Autowired
	GenreRepository genreRepository;
	@Autowired
	GameGenreRepository gameGenreRepository;

	@Override
	public Iterable<Game> findAll() {
		// TODO Auto-generated method stub
		return gameRepository.findAll();
	}

	@Override
	public Game findById(int id) {
		Optional<Game> entity = gameRepository.findById(id);
		if(entity.isPresent()) {
			return entity.get();
		} else {
			return null;
		}
	}

	@Override
	public void save(Game game) {
		gameRepository.save(game);
	}

	@Override
	public void delete(int id) {
		Optional<Game> entity = gameRepository.findById(id);
		if(entity.isPresent()) {
			entity.get().setActive(false);
			gameRepository.save(entity.get());
		}
	}


	@Override
	public void addGame(Game game, ArrayList<String> genres) {
		if(gameRepository.findByName(game.getName())!=null){
			return;
		}
		game.setActive(true);
		Game entity = gameRepository.save(game);
		for(String genreName : genres) {
			Genre genre = genreRepository.findByGenre(genreName);
			GameGenre gameGenre = new GameGenre();
			GameGenreId id = new GameGenreId();
			id.setIdGame(entity.getId());
			id.setIdGenre(genre.getId());
			gameGenreRepository.save(gameGenre);
		}
	}

	
	@Override
	public Page<Game> getAllPagination(PageRequest pageRequest) {
		return gameRepository.findAll(pageRequest);
	}

	@Override
	public Game findByName(String name) {
		return gameRepository.findByName(name);
	}

	

	
}
