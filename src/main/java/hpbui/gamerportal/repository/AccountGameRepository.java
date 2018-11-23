package hpbui.gamerportal.repository;

import hpbui.gamerportal.entity.AccountGame;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface AccountGameRepository extends PagingAndSortingRepository<AccountGame, Long>, AccountGameRepositoryCustom {
    List<AccountGame> findAccountGamesByIdAccountAndIdGame(Long idAccount, Long idGame);

    @Query(value = "SELECT * FROM gamer_portal.account_game WHERE idGame = ?1 GROUP BY idGame, idAccount",
            countQuery = "SELECT COUNT(*) FROM gamer_portal.account_game WHERE idGame = ?1 GROUP BY idGame, idAccount",
            nativeQuery = true)
    Page<AccountGame> findDistinctIdAccountAndIdGameByIdGame(Long idGame, Pageable pageable);
}
