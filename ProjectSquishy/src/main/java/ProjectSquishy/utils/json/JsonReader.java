package ProjectSquishy.utils.json;


import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class JsonReader {

    private final Logger logger = Logger.getLogger(JsonReader.class);

    public JSONObject readJson(String filename) {

        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;

        try (Reader reader = new FileReader(filename)) {

            jsonObject = (JSONObject) parser.parse(reader);
            logger.info("read and parsed file: " + filename);

        } catch (IOException e) {
            logger.error("failed to read file: " + filename);
        } catch (ParseException e) {
            logger.error("failed to parse file: " + filename);
        }
        return jsonObject;
    }
}
