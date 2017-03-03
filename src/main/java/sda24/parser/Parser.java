package sda24.parser;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by RENT on 2017-03-03.
 */

public class Parser {
    private WebConnector webConnector;

    @Autowired
    public Parser(WebConnector webConnector) {
        this.webConnector = webConnector;
    }

    public List<String> findContext(String url, String query) {
        List<String> contextList = new ArrayList<>();
        String html = parseURL(url);
        Pattern p = Pattern.compile("[A-Z](?i)[^.?!]*?\\b" + "(" + query + ")" + "\\b[^.?!]*[.?!]");
        Matcher m = p.matcher(html);
        while (m.find()) {
            contextList.add(m.group());
        }
        return contextList;
    }
    private String parseURL(String urlToParse) {
        Document doc = Jsoup.parseBodyFragment(webConnector.getHTML(urlToParse));
        Element body = doc.body();
        return body.text();
    }
}

