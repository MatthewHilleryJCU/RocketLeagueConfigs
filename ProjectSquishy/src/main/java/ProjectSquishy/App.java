package ProjectSquishy;


import ProjectSquishy.dao.GenericDao;
import ProjectSquishy.models.*;
import ProjectSquishy.models.settings.CameraSettings;
import ProjectSquishy.models.settings.ControlSettings;
import ProjectSquishy.models.settings.DeadzoneSettings;
import ProjectSquishy.utils.parser.DataMapper;
import ProjectSquishy.utils.parser.HtmlParser;
import ProjectSquishy.utils.BannerPrinter;
import org.jsoup.nodes.Document;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.*;


public class App {

    private static String cameraUrl = "https://liquipedia.net/rocketleague/List_of_player_camera_settings";
    private static String controlUrl = "https://liquipedia.net/rocketleague/List_of_player_control_settings";
    private static String deadzoneUrl = "https://liquipedia.net/rocketleague/List_of_player_deadzone_settings";



    public static void main(String[] args) {

        HtmlParser parser = new HtmlParser();
        DataMapper mapper = new DataMapper();
        BannerPrinter bannerPrinter = new BannerPrinter();
        Map<String, Player> players = new HashMap<>();


        // Create Entity Manager Factory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sqlDBconnect");

        // Create Daos
        GenericDao<Player> playerDao = new GenericDao<>(emf, Player.class);
        GenericDao<ControlSettings> controlDao = new GenericDao<>(emf, ControlSettings.class);
        GenericDao<CameraSettings> cameraDao = new GenericDao<>(emf, CameraSettings.class);
        GenericDao<DeadzoneSettings> deadzoneDao = new GenericDao<>(emf, DeadzoneSettings.class);



        Scanner s = new Scanner(System.in);

        System.out.println("\n Welcome to ProjectSquishy! \n");
        printOptions();


        String pick = s.nextLine();

        List<Player> searchedPlayers = new ArrayList<>();

        if (!(pick.equals("1") || pick.equals("2"))) {
            System.out.println("Pick a valid number.");
            printOptions();
        } else if ( pick.equals("1")){
            searchedPlayers = playerDao.getAll();
//            System.out.println(searchedPlayers);
            for (Player player : searchedPlayers) {
                System.out.println(player.getPlayerName());
            }


        } else {
            System.out.println("What player?");
            String playerChoice = s.nextLine();
            searchedPlayers = playerDao.getAllSearch(playerChoice);
            System.out.println(searchedPlayers);
        }




//
//        bannerPrinter.print();
//        players = handlePlayerData(parser, mapper, players);
//        printPlayerData(players);
//        addAllPlayers(players, playerDao, controlDao, cameraDao, deadzoneDao);

        // Close Entity Manager Factory
        emf.close();
    }

    private static void addAllPlayers(Map<String, Player> players, GenericDao<Player> playerDao, GenericDao<ControlSettings> controlDao, GenericDao<CameraSettings> cameraDao, GenericDao<DeadzoneSettings> deadzoneDao) {
        for (Map.Entry<String, Player> player : players.entrySet()) {
            if (player.getValue().getDeadzoneSettings() != null && player.getValue().getCameraSettings() != null && player.getValue().getControlSettings() != null) {
                cameraDao.add(player.getValue().getCameraSettings());
                controlDao.add(player.getValue().getControlSettings());
                deadzoneDao.add(player.getValue().getDeadzoneSettings());
                playerDao.add(player.getValue());
            }
        }
    }

    private static void printOptions() {
        System.out.println("(1) Show all players settings");
        System.out.println("(2) Choose a players settings");
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
                System.out.println("No camera settings data!");
            }

            if (player.getValue().getControlSettings() != null) {
                System.out.println(player.getValue().getControlSettings().toString());
            } else {
                System.out.println("No controls settings data!");
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
