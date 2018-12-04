package hpbui.gamerportal.repository;

import hpbui.gamerportal.entity.AccountGame;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface AccountGameRepository extends PagingAndSortingRepository<AccountGame, Long>, AccountGameRepositoryCustom {
    List<AccountGame> findAccountGamesByIdAccountAndIdGame(Long idAccount, Long idGame);
}
