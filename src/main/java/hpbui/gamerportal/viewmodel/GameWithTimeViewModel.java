package hpbui.gamerportal.viewmodel;

import hpbui.gamerportal.entity.AccountGame;
import hpbui.gamerportal.entity.Game;
import hpbui.gamerportal.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class GameWithTimeViewModel {
    private Game game;
    private List<AccountGameViewModel> gameTimes;

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public GameWithTimeViewModel(Game game, List<AccountGame> gameTimes) {
        this.game = game;
        this.gameTimes = new ArrayList<>();
        for(AccountGame gameTime:gameTimes){
            String startTime = Utils.convertFromIntToTime(gameTime.getStartTime());
            String endTime = Utils.convertFromIntToTime(gameTime.getEndTime());
            this.gameTimes.add(new AccountGameViewModel(gameTime.getId(),
                    startTime + " - " + endTime));
        }
    }

    public List<AccountGameViewModel> getGameTimes() {
        return gameTimes;
    }

    public void setGameTimes(List<AccountGameViewModel> gameTimes) {
        this.gameTimes = gameTimes;
    }
}
