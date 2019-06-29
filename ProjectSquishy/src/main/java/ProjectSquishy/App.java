package ProjectSquishy;

import ProjectSquishy.utils.JsonMapper;
import ProjectSquishy.utils.JsonReader;
import org.json.simple.JSONObject;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Player blakeOakfield = new Player();

        JsonReader reader = new JsonReader();
        JSONObject jsonObject = reader.readJson("src/main/resources/testJSON.json");
        JsonMapper mapper = new JsonMapper(jsonObject, blakeOakfield);

        System.out.println(blakeOakfield.toString());


    }
}
