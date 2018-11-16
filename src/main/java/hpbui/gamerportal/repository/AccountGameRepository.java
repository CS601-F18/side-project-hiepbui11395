package hpbui.gamerportal.repository;

import hpbui.gamerportal.entity.AccountGame;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface AccountGameRepository extends PagingAndSortingRepository<AccountGame, Integer> {
    List<AccountGame> findAccountGamesByIdAccountAndIdGame(int idAccount, int idGame);

    @Query(value = "SELECT * FROM gamer_portal.account_game WHERE idGame = ?1 GROUP BY idGame, idAccount",
            countQuery = "SELECT COUNT(*) FROM gamer_portal.account_game WHERE idGame = ?1 GROUP BY idGame, idAccount",
            nativeQuery = true)
    Page<AccountGame> findDistinctIdAccountAndIdGameByIdGame(int idGame, Pageable pageable);
}
