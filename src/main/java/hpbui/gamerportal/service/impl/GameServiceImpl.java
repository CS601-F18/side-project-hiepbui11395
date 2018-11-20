package hpbui.gamerportal.service.impl;

import hpbui.gamerportal.entity.Game;
import hpbui.gamerportal.entity.GameGenre;
import hpbui.gamerportal.entity.Genre;
import hpbui.gamerportal.repository.GameGenreRepository;
import hpbui.gamerportal.repository.GameRepository;
import hpbui.gamerportal.repository.GenreRepository;
import hpbui.gamerportal.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

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
		return gameRepository.findAll();
	}

	@Override
    public Game findById(Long id) {
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
    public void delete(Long id) {
		Optional<Game> entity = gameRepository.findById(id);
		if(entity.isPresent()) {
			entity.get().setActive(false);
			gameRepository.save(entity.get());
		}
	}


	@Override
	public void addGame(Game game, ArrayList<String> genres) {
        if (gameRepository.findByNameAndActiveTrue(game.getName()) != null) {
			return;
		}
		game.setActive(true);
		Game entity = gameRepository.save(game);
		for(String genreName : genres) {
            Genre genre = genreRepository.findGenreByNameAndActiveTrue(genreName);
            if (genre != null) {
                GameGenre gameGenre = new GameGenre(entity.getId(), genre.getId());
                gameGenreRepository.save(gameGenre);
            }
		}
	}

	
	@Override
	public Page<Game> getAllPagination(PageRequest pageRequest) {
		return gameRepository.findAll(pageRequest);
	}

    @Override
    public long getNumberOfGame() {
        return gameRepository.count();
    }

    @Override
    public Page<Game> findGameByQueryPagination(String query, Pageable pageable) {
        return gameRepository.findGamesByNameContainingAndActiveTrue(query, pageable);
    }

    @Override
	public Game findByName(String name) {
        return gameRepository.findByNameAndActiveTrue(name);
	}

	

	
}
