package hpbui.gamerportal.service.impl;

import hpbui.gamerportal.entity.Account;
import hpbui.gamerportal.entity.AccountGame;
import hpbui.gamerportal.entity.Game;
import hpbui.gamerportal.repository.AccountGameRepository;
import hpbui.gamerportal.service.AccountGameService;
import hpbui.gamerportal.viewmodel.GameAddViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    }
}
