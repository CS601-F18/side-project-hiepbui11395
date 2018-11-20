package hpbui.gamerportal.repository;

import hpbui.gamerportal.entity.Game;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GameRepository extends PagingAndSortingRepository<Game, Long> {
    Game findByNameAndActiveTrue(String name);

    Page<Game> findGamesByNameContainingAndActiveTrue(String name, Pageable pageable);
}
