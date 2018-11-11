package hpbui.gamerportal.repository;

import hpbui.gamerportal.entity.AccountGame;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountGameRepository extends JpaRepository<AccountGame, Integer> {
    List<AccountGame> findAccountGameByIdAccountAndIdGame(int idAccount, int idGame);
}
