package ProjectSquishy.utils.parser;

import ProjectSquishy.factories.DataMapperFactory;
import ProjectSquishy.factories.HtmlParserFactory;
import ProjectSquishy.models.Player;
import ProjectSquishy.utils.BannerPrinter;
import org.jsoup.nodes.Document;

import java.util.HashMap;
import java.util.Map;

public class HtmlParserController {

    private Map<String, Player> players = new HashMap<>();
    private HtmlParser parser;
    private DataMapper mapper;

    private static String cameraUrl = "https://liquipedia.net/rocketleague/List_of_player_camera_settings";
    private static String controlUrl = "https://liquipedia.net/rocketleague/List_of_player_control_settings";
    private static String deadzoneUrl = "https://liquipedia.net/rocketleague/List_of_player_deadzone_settings";

    public HtmlParserController(HtmlParserFactory htmlParserFactory, DataMapperFactory dataMapperFactory) {
        this.parser = htmlParserFactory.create();
        this.mapper = dataMapperFactory.create();
    }

    public Map<String, Player> parsePlayerData() {

        Document cameraDoc = parser.parse(cameraUrl);
        Document controlDoc = parser.parse(controlUrl);
        Document deadzoneDoc = parser.parse(deadzoneUrl);
        players = mapper.mapData(players, cameraDoc, controlDoc, deadzoneDoc);

        return players;
    }
}
