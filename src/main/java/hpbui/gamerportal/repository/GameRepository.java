package hpbui.gamerportal.repository;

import hpbui.gamerportal.entity.Game;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GameRepository extends PagingAndSortingRepository<Game, Long> {
	Game findByName(String name);
}
