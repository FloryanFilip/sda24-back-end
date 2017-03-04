package sda24.search;

import java.io.IOException;
import java.util.List;

public interface SearchProvider {
    List<String> getLinks(String topic, int linkNumbers) throws IOException;
}
