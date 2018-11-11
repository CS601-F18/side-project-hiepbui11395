package hpbui.gamerportal.service;

import hpbui.gamerportal.entity.Account;
import hpbui.gamerportal.entity.AccountGame;
import hpbui.gamerportal.entity.Game;
import hpbui.gamerportal.viewmodel.GameAddViewModel;
import hpbui.gamerportal.viewmodel.GameWithTimeViewModel;

import org.springframework.stereotype.Component;

import java.util.List;

public interface AccountGameService {
	void addAccountGame(GameAddViewModel model, Game game, Account account);
	GameWithTimeViewModel findTimeByAccountAndGame(Game game, Account account);
}
