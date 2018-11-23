package hpbui.gamerportal.viewmodel;

public class AccountGameViewModel {
    private Long id;
    private String gameTime;

    public AccountGameViewModel() {
    }

    public AccountGameViewModel(Long id, String gameTime) {
        this.id = id;
        this.gameTime = gameTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGameTime() {
        return gameTime;
    }

    public void setGameTime(String gameTime) {
        this.gameTime = gameTime;
    }
}
