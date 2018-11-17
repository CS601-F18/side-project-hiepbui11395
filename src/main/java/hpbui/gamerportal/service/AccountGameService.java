package hpbui.gamerportal.service;

import hpbui.gamerportal.entity.Account;
import hpbui.gamerportal.entity.Game;
import hpbui.gamerportal.viewmodel.GameAddViewModel;
import hpbui.gamerportal.viewmodel.GameWithTimeViewModel;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AccountGameService {
	void addAccountGame(GameAddViewModel model, Game game, Account account);
	GameWithTimeViewModel findTimeByAccountAndGame(Game game, Account account);

    List<Account> findAccountsByGame(Long idGame, Pageable pageable);
}
