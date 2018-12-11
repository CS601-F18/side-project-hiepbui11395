package hpbui.gamerportal.service.impl;

import hpbui.gamerportal.entity.Account;
import hpbui.gamerportal.entity.AccountGame;
import hpbui.gamerportal.entity.Game;
import hpbui.gamerportal.repository.AccountGameRepository;
import hpbui.gamerportal.service.AccountGameService;
import hpbui.gamerportal.viewmodel.GameAddViewModel;
import hpbui.gamerportal.viewmodel.GameWithTimeViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountGameServiceImpl implements AccountGameService {
    @Autowired
    AccountGameRepository accountGameRepository;

    @Override
    public void addAccountGame(GameAddViewModel model, Game game, Account account) {
        AccountGame entity = new AccountGame();
        entity.setActive(true);
        entity.setStartTime(model.getStartTime());
        entity.setEndTime(model.getEndTime());
        entity.setIdAccount(account.getId());
        entity.setIdGame(game.getId());
        accountGameRepository.save(entity);
        accountGameRepository.updateNumberOfGamer(game.getId());
    }

    @Override
    public GameWithTimeViewModel findTimeByAccountAndGame(Game game, Account account) {
        List<AccountGame> result = accountGameRepository.
                findAccountGamesByIdAccountAndIdGame(account.getId(), game.getId());
        GameWithTimeViewModel gameWithTime = new GameWithTimeViewModel(game,result);
        return gameWithTime;
    }

    @Override
    public void deleteAccountGame(long accountGameId) {
        AccountGame accountGame = accountGameRepository.findById(accountGameId).get();
        accountGameRepository.deleteById(accountGameId);
        accountGameRepository.updateNumberOfGamer(accountGame.getIdGame());
    }
}
