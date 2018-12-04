package hpbui.gamerportal.service;

import hpbui.gamerportal.entity.Account;
import hpbui.gamerportal.entity.Game;
import hpbui.gamerportal.viewmodel.GameAddViewModel;
import hpbui.gamerportal.viewmodel.GameWithTimeViewModel;

/**
 * Logic code for AccountGame
 */
public interface AccountGameService {
	/**
	 * Add AccountGame to db
	 * @param model
	 * @param game
	 * @param account
	 */
	void addAccountGame(GameAddViewModel model, Game game, Account account);

	/**
	 * Retrieve AccountGame by game and account
	 * @param game
	 * @param account
	 * @return
	 */
	GameWithTimeViewModel findTimeByAccountAndGame(Game game, Account account);

	/**
	 * Delete AccountGame by id
	 * @param accountGameId
	 */
    void deleteAccountGame(long accountGameId);
}
