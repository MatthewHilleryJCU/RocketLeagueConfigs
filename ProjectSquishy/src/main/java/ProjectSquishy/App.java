//package ProjectSquishy;
//
//
//import ProjectSquishy.models.Player;
//import ProjectSquishy.utils.DataMapper;
//import ProjectSquishy.utils.HtmlParser;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * Hello world!
// */
//public class App {
//    public static void main(String[] args) {
//        System.out.println("Hello World!");
//
//        HtmlParser parser = new HtmlParser();
//        DataMapper mapper = new DataMapper();
//
//        String cameraUrl = "https://liquipedia.net/rocketleague/List_of_player_camera_settings";
//        String controlUrl = "https://liquipedia.net/rocketleague/List_of_player_control_settings";
//        String deadzoneUrl = "https://liquipedia.net/rocketleague/List_of_player_deadzone_settings";
//
//        Document cameraDoc = parser.parse(cameraUrl);
//        Document controlDoc = parser.parse(controlUrl);
//        Document deadzoneDoc = parser.parse(deadzoneUrl);
//
//        Map<String, Player> players = new HashMap<>();
//
//        players = mapper.mapData(players, cameraDoc, controlDoc, deadzoneDoc);
//
//        System.out.println(players.keySet());
//
//        for ( Map.Entry<String, Player> player : players.entrySet() ) {
//
//            System.out.println(player.getKey());
//            if (player.getValue().getDeadzoneSettings() != null) {
//                System.out.println(player.getValue().getDeadzoneSettings().toString());
//            } else {
//                System.out.println("No deadzone data! ");
//            }
//            if (player.getValue().getCameraSettings() != null) {
//                System.out.println(player.getValue().getCameraSettings().toString());
//            } else {
//                System.out.println("No camera setting data!");
//            }
//
//            if (player.getValue().getControlSettings() != null) {
//                System.out.println(player.getValue().getControlSettings().toString());
//            } else {
//                System.out.println("No controls setting data!");
//            }
//
//            System.out.println("______________________________");
//        }
//
//    }
//}
