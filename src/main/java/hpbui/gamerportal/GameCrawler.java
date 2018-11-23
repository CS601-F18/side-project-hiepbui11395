package hpbui.gamerportal;

import hpbui.gamerportal.entity.Game;
import hpbui.gamerportal.service.GameService;
import hpbui.gamerportal.utils.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class GameCrawler {
    private static final Logger logger = LogManager.getLogger();
    private long total = Long.MAX_VALUE;

    @Autowired
    private GameService gameService;

    @Scheduled(fixedDelay = 1800000)
    public void getGame() {

        long offset = gameService.getNumberOfGame();
            String urlString = "https://www.giantbomb.com/api/games/?api_key=24a0f044a74d7d88224268e7cbc11c39007727fc&"
                    + "format=json&"
                    + "field_list=id,name&"
                    + "offset=" + offset;
            String response = Utils.callGetApi(urlString);
            JSONObject jsonObject = new JSONObject(response);
            total = jsonObject.getInt("number_of_total_results");
            JSONArray jsonGameArray = jsonObject.getJSONArray("results");
            for (int i = 0; i < jsonGameArray.length(); i++) {
                JSONObject jsonGameObject = jsonGameArray.getJSONObject(i);
                int idGame = jsonGameObject.getInt("id");
                String nameGame = jsonGameObject.getString("name");
                Game game = new Game();
                game.setName(nameGame);
                urlString = "https://www.giantbomb.com/api/game/" + idGame + "/?api_key=24a0f044a74d7d88224268e7cbc11c39007727fc&format=json&field_list=genres,name";
                response = Utils.callGetApi(urlString);
                JSONObject jsonGenreObject = new JSONObject(response);
                JSONArray jsonGenreArray = new JSONArray();
                if (jsonGenreObject.has("genres")) {
                    jsonGenreArray = new JSONObject(response).getJSONObject("results").getJSONArray("genres");
                }
                ArrayList<String> genres = new ArrayList<String>();
                for (int j = 0; j < jsonGenreArray.length(); j++) {
                    genres.add(jsonGenreArray.getJSONObject(j).getString("name"));
                }
                gameService.addGame(game, genres);
            }
        long getTo = gameService.getNumberOfGame();
        logger.warn("\t Get from: " + offset + " - to: " + getTo);
        logger.warn("Sleep for 30 minutes");
    }
}
