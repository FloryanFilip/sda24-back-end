package sda24.search;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class SearchEngine {

    public List<String> getLinks(String query, int count) throws IOException {
        try {
            return new GoogleSearchByApi().getLinks(query, count);
        } catch (IOException e) {
            return new GoogleSearchByWeb().getLinks(query, count);
        }
    }

}
