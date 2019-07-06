package ProjectSquishy;


import ProjectSquishy.models.*;
import ProjectSquishy.utils.DataMapper;
import ProjectSquishy.utils.HtmlParser;
import org.jsoup.nodes.Document;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 */
public class App {

    private static String cameraUrl = "https://liquipedia.net/rocketleague/List_of_player_camera_settings";
    private static String controlUrl = "https://liquipedia.net/rocketleague/List_of_player_control_settings";
    private static String deadzoneUrl = "https://liquipedia.net/rocketleague/List_of_player_deadzone_settings";

    public static void main(String[] args) {
        System.out.println("Hello World!");

        HtmlParser parser = new HtmlParser();
        DataMapper mapper = new DataMapper();
        Map<String, Player> players = new HashMap<>();


        players = handlePlayerData(parser, mapper, players);


        System.out.println(players.keySet());

        printPlayerData(players);


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sqlDBconnect");
        GenericDao<Player> playerDao = new GenericDao<>(emf, Player.class);

        ControlSettings controlSettings = new ControlSettings("b", "x", "a", "s", "f", "a", "z");
        CameraSettings cameraSettings = new CameraSettings(true, 1,1,1,1,1.0,1.0, true);
        DeadzoneSettings deadzoneSettings = new DeadzoneSettings("cross", 2.0,2.0,2.0,2.0);


        Player player = new Player("Matt", controlSettings, cameraSettings, deadzoneSettings );

        playerDao.add(player);

        emf.close();

    }

    private static void printPlayerData(Map<String, Player> players) {
        for (Map.Entry<String, Player> player : players.entrySet()) {

            System.out.println(player.getKey());
            if (player.getValue().getDeadzoneSettings() != null) {
                System.out.println(player.getValue().getDeadzoneSettings().toString());
            } else {
                System.out.println("No deadzone data! ");
            }
            if (player.getValue().getCameraSettings() != null) {
                System.out.println(player.getValue().getCameraSettings().toString());
            } else {
                System.out.println("No camera setting data!");
            }

            if (player.getValue().getControlSettings() != null) {
                System.out.println(player.getValue().getControlSettings().toString());
            } else {
                System.out.println("No controls setting data!");
            }

            System.out.println("______________________________");
        }
    }

    private static Map<String, Player> handlePlayerData(HtmlParser parser, DataMapper mapper, Map<String, Player> players) {
        Document cameraDoc = parser.parse(cameraUrl);
        Document controlDoc = parser.parse(controlUrl);
        Document deadzoneDoc = parser.parse(deadzoneUrl);
        players = mapper.mapData(players, cameraDoc, controlDoc, deadzoneDoc);
        return players;
    }
}
