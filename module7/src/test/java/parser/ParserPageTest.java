package parser;

import org.junit.Test;

import java.io.IOException;

public class ParserPageTest {

    @Test
    public void fetchUrlElementtest() throws IOException {
    ParserPage pp= new ParserPage();
    /*pp.fetchUrlElement("https://www.ss.lv/");
    *
    * */
    pp.fetchUrlElement("http://www.bjss.com/");

    }
}
