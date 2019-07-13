package ProjectSquishy;


import ProjectSquishy.dao.DaoController;
import ProjectSquishy.dao.GenericDao;
import ProjectSquishy.factories.DataMapperFactory;
import ProjectSquishy.factories.HtmlParserFactory;
import ProjectSquishy.models.Player;
import ProjectSquishy.models.settings.CameraSettings;
import ProjectSquishy.models.settings.ControlSettings;
import ProjectSquishy.models.settings.DeadzoneSettings;
import ProjectSquishy.utils.BannerPrinter;
import ProjectSquishy.utils.IO.PlayerDataController;
import ProjectSquishy.utils.parser.ParserController;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class App {

    public static void main(String[] args) {

        BannerPrinter bannerPrinter = new BannerPrinter();
        HtmlParserFactory htmlParserFactory = new HtmlParserFactory();
        DataMapperFactory dataMapperFactory = new DataMapperFactory();
        PlayerDataController playerDataController = new PlayerDataController();
        ParserController parserController = new ParserController(htmlParserFactory, dataMapperFactory);
        DaoController daoController = new DaoController();
        Map<String, Player> players;


        // Create Entity Manager Factory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sqlDBconnect");

        // Create Daos
        GenericDao<Player> playerDao = new GenericDao<>(emf, Player.class);
        GenericDao<ControlSettings> controlDao = new GenericDao<>(emf, ControlSettings.class);
        GenericDao<CameraSettings> cameraDao = new GenericDao<>(emf, CameraSettings.class);
        GenericDao<DeadzoneSettings> deadzoneDao = new GenericDao<>(emf, DeadzoneSettings.class);


        bannerPrinter.print();

        Scanner s = new Scanner(System.in);
        System.out.println("\n Welcome to ProjectSquishy! \n");
        printOptions();
        String pick = s.nextLine();
        List<Player> searchedPlayers = new ArrayList<>();

        if (!(pick.equals("1") || pick.equals("2") || pick.equals("3"))) {
            System.out.println("Pick a valid number.");
            printOptions();
        } else if (pick.equals("1")) {
            searchedPlayers = playerDao.getAll();
//            System.out.println(searchedPlayers);
            for (Player player : searchedPlayers) {
                System.out.println(player.getPlayerName());
            }

        } else if (pick.equals("2")) {
            System.out.println("What player?");
            String playerChoice = s.nextLine();
            searchedPlayers = playerDao.getAllSearch(playerChoice);
            System.out.println(searchedPlayers);
        } else {
            players = parserController.parsePlayerData();
            playerDataController.print(players);
            daoController.addAllPlayers(players, playerDao, controlDao, cameraDao, deadzoneDao);
        }

        // Close Entity Manager Factory
        emf.close();
    }


    private static void printOptions() {
        System.out.println("(1) Show all players settings");
        System.out.println("(2) Choose a players settings");
        System.out.println("(3) Update player data");
    }


}
