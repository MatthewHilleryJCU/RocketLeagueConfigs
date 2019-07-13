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
        List<Player> searchedPlayers;


        // Create Entity Manager Factory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sqlDBconnect");

        // Create Daos
        GenericDao<Player> playerDao = new GenericDao<>(emf, Player.class);
        GenericDao<ControlSettings> controlDao = new GenericDao<>(emf, ControlSettings.class);
        GenericDao<CameraSettings> cameraDao = new GenericDao<>(emf, CameraSettings.class);
        GenericDao<DeadzoneSettings> deadzoneDao = new GenericDao<>(emf, DeadzoneSettings.class);

        searchedPlayers = playerDao.getAll();



        bannerPrinter.print();



        Scanner s = new Scanner(System.in);
        System.out.println("\n Welcome to ProjectSquishy! \n");

        int pick = 0;
        while (pick != 9) {
            pick = printMenu(s);
            switch (pick) {
                case 1:
                    for (Player player : searchedPlayers) {
                        System.out.println(player.getPlayerName());
                    }
                    break;
                case 2:
                    for (Player player : searchedPlayers) {
                        System.out.println(player.toString());
                    }
                    break;
                case 3:
                    System.out.println("What player?");
                    String playerChoice = s.nextLine().toLowerCase();
                    for (Player player : searchedPlayers) {
                        if (player.getPlayerName().toLowerCase().contains(playerChoice)){
                            System.out.println(player.toString());
                        }
                    }
                    break;
                case 4:
                    players = parserController.parsePlayerData();
                    playerDataController.print(players);
                    daoController.addAllPlayers(players, playerDao, controlDao, cameraDao, deadzoneDao);
                    break;
                case 9:
                    break;
                default:
                    System.out.println("Sorry, please enter valid Option");
            }
        }

        // Close Entity Manager Factory
        emf.close();
    }

    private static int printMenu(Scanner s) {
        System.out.println("(1) Show all player names");
        System.out.println("(2) Show all players settings");
        System.out.println("(3) Choose a players settings");
        System.out.println("(4) Update player data");
        System.out.println("(9) Quit");
        int choice = 0;
        try {
            choice = Integer.valueOf(s.nextLine());
        } catch (NumberFormatException e){
        }
        return choice;
    }
}
