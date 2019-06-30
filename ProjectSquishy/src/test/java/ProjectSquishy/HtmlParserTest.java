package ProjectSquishy;

import ProjectSquishy.utils.HtmlParser;
import org.jsoup.nodes.Document;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class HtmlParserTest {

    HtmlParser parser = new HtmlParser();
    String url = "http://google.com";

    @Test
    public void when_attempting_to_parse_a_document_is_returned() {
        parser.parse(url);
        assertTrue(parser.parse(url) instanceof Document);
    }
}
