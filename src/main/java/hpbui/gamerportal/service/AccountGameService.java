package hpbui.gamerportal.service;

import hpbui.gamerportal.entity.Account;
import hpbui.gamerportal.entity.AccountGame;
import hpbui.gamerportal.entity.Game;
import hpbui.gamerportal.viewmodel.GameAddViewModel;
import org.springframework.stereotype.Component;

public interface AccountGameService {
	void addAccountGame(GameAddViewModel model, Game game, Account account);
}
