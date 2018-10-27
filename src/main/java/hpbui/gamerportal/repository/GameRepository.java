package hpbui.gamerportal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hpbui.gamerportal.entity.Game;

public interface GameRepository extends CrudRepository<Game, Integer>{
}
