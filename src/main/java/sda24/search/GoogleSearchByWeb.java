package sda24.search;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;


public class GoogleSearchByWeb implements SearchProvider {

    private final String google = "http://www.google.com/search?num=";
    private final String charset = "UTF-8";
    private final String userAgent = "ExampleBot 1.0 (+http://example.com/bot)"; // Change this to your company's name and bot homepage! - wtf? kp

    public List<String> getLinks(String topic, int linkNumbers) throws IOException {


        List<String> urlList = new ArrayList<String>();

        Elements links = Jsoup.connect(google +linkNumbers+"&q="+ URLEncoder.encode(topic, charset)).userAgent(userAgent).get().select(".g>.r>a");

        for (Element link : links) {
            String url = link.absUrl("href"); // Google returns URLs in format "http://www.google.com/url?q=<url>&sa=U&ei=<someKey>".
            url = URLDecoder.decode(url.substring(url.indexOf('=') + 1, url.indexOf('&')), "UTF-8");

            if (!url.startsWith("http")) {
                continue; // Ads/news/etc.
            }
            urlList.add(url);
        }

        return urlList;
    }

}
