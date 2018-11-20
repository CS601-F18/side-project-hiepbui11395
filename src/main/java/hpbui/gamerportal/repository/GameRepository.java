package hpbui.gamerportal.repository;

import hpbui.gamerportal.entity.Game;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GameRepository extends PagingAndSortingRepository<Game, Long> {
	Game findByName(String name);

    Page<Game> findGamesByNameContaining(String name, Pageable pageable);
}
