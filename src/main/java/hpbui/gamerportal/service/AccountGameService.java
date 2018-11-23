package hpbui.gamerportal.service;

import hpbui.gamerportal.entity.Account;
import hpbui.gamerportal.entity.Game;
import hpbui.gamerportal.viewmodel.GameAddViewModel;
import hpbui.gamerportal.viewmodel.GameWithTimeViewModel;

public interface AccountGameService {
	void addAccountGame(GameAddViewModel model, Game game, Account account);
	GameWithTimeViewModel findTimeByAccountAndGame(Game game, Account account);

    void deleteAccountGame(long accountGameId);
}
