package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;
import play.mvc.*;

import java.util.*;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        Map<String, String> playerHeroesMap = getPlayerHeroesMap();
        JsonNode content = Json.toJson(playerHeroesMap);
        return ok(content);
    }

    private Map<String, String> getPlayerHeroesMap() {
        Map<String, String> playerMap = new HashMap<>();

        List<String> players = new ArrayList<>();
        players.add("Luis");
        players.add("Alito");
        players.add("Mauricio");
        players.add("Huguito");
        players.add("Omar");
        players.add("Marco");

        List<String> heroes = new ArrayList<>();
        heroes.add("Verde");
        heroes.add("Morado");
        heroes.add("Rojo");
        heroes.add("Azul");
        heroes.add("Gris");
        heroes.add("Amarillo");
        for (String player : players) {
            heroes.remove(assignHeroes(player, heroes, playerMap));
        }
        return playerMap;
    }

    private String assignHeroes(String player, List<String> heroes, Map<String, String> playerMap) {
        Random random = new Random();
        String hero = heroes.get(random.nextInt(heroes.size()));
        playerMap.put(player, hero);
        return hero;
    }
}
