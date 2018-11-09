package hpbui.gamerportal.repository;

import hpbui.gamerportal.entity.AccountGame;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountGameRepository extends JpaRepository<AccountGame, Integer> {
}
