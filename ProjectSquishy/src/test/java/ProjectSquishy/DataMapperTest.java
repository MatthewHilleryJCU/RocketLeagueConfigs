package ProjectSquishy;

import ProjectSquishy.models.Player;
import ProjectSquishy.utils.parser.DataMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;

public class DataMapperTest {

    private final DataMapper dataMapper = new DataMapper();
    private File controlDocFile = new File("src/test/resources/controlDocStub.html");
    private File cameraDocFile = new File("src/test/resources/cameraDocStub.html");
    private File deadzoneDocFile = new File("src/test/resources/deadzoneDocStub.html");
    private Map<String, Player> players = new HashMap<>();
    private Document cameraDoc;
    private Document controlDoc;
    private Document deadzoneaDoc;

    {
        try {
            cameraDoc = Jsoup.parse(cameraDocFile, "UTF-8");
            controlDoc = Jsoup.parse(controlDocFile, "UTF-8");
            deadzoneaDoc = Jsoup.parse(deadzoneDocFile, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void when_map_data_is_ran_play_hashmap_is_returned_not_null() {
        dataMapper.mapData(players, cameraDoc, controlDoc, deadzoneaDoc);
        assertNotNull(players);
    }
}



