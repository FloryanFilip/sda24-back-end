package sda24.search;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by RENT on 2017-03-04.
 */
public interface SearchEngine {

    List<String> getLinks(String topic, int linkNumbers) throws IOException;
}
