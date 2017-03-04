package sda24.search;

import java.io.*;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class GoogleSearchByCustomSearch implements SearchEngine{
    private final String cx="003221646697086159726:w78o7o_jhi8";
    private final String key = "AIzaSyBNzA4AOCk4yw8NZx8a1jKmSHyQgk9S1wU";
    private final String key2 = "AIzaSyD7xDz_ZjQzgCvl1ikMkS1yvetwLOrbrGU";
    private final String cx2 = "003221646697086159726:pponda5yolo";
    //example link: GET https://www.googleapis.com/customsearch/v1?key=INSERT_YOUR_API_KEY&cx=INSERT_YUR_CX&q=lectures

    private final String charset = "UTF-8";
    private final String searchLink = "https://www.googleapis.com/customsearch/v1?key="+key2+"&cx="+cx2;
    private int startPage=1;

    private String readAll(Reader rd) throws IOException {
            StringBuilder sb = new StringBuilder();
            int cp;
            while ((cp = rd.read()) != -1) {
                sb.append((char) cp);
            }
            return sb.toString();
    }

        public JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
            InputStream is = new URL(url).openStream();
            try {
                BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
                String jsonText = readAll(rd);
                JSONObject json = new JSONObject(jsonText);
                return json;
            } finally {
                is.close();
            }
        }

    public List<String> getLinks(String topic, int linkNumbers) throws IOException {

        if(linkNumbers>100)linkNumbers=100;

        List<String> urlLinks = new ArrayList<String>();

        while(urlLinks.size()<linkNumbers) {

            JSONObject json = readJsonFromUrl(searchLink+ "&start="+startPage+"&q="+URLEncoder.encode(topic, charset));
            JSONArray items = json.getJSONArray("items");

            for (int i = 0; i < items.length(); i++) {
                urlLinks.add((String) items.getJSONObject(i).get("link"));
                if (urlLinks.size() == linkNumbers) break;
            }
            startPage+=10;

        }

        return urlLinks;
    }
}

