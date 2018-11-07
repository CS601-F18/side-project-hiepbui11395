package hpbui.gamerportal.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import hpbui.gamerportal.entity.Game;

public interface GameRepository extends PagingAndSortingRepository<Game, Integer> {
	Game findByName(String name);
}
