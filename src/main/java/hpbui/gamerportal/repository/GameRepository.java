package hpbui.gamerportal.repository;

import org.springframework.data.repository.CrudRepository;

import hpbui.gamerportal.entity.Game;

public interface GameRepository extends CrudRepository<Game, Integer> {
	Game findByName(String name);
}
