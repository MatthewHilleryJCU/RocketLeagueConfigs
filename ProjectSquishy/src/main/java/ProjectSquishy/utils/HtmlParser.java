package ProjectSquishy.utils;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.print.Doc;
import java.io.IOException;

public class HtmlParser {

    private Logger logger = Logger.getLogger(HtmlParser.class);

    public Document parse (String url){

        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            logger.error("Error trying to parse:  " + url);
        }

        return doc;
    }
}

