package sda24.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import sda24.parser.Parser;
import sda24.search.SearchEngine;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by RENT on 2017-03-04.
 */
@Service
public class QueryServiceAsync {

    private static final int LINKS_NUMBERS = 20;
    @Autowired
    private ContextDao contextDao;

    private Parser parser;
    private SearchEngine searchEngine;

    @Autowired
    public QueryServiceAsync(Parser parser, SearchEngine searchEngine) {
        this.parser = parser;
        this.searchEngine = searchEngine;
    }

    @Async
    public void checkURLs(Query query) throws IOException {
        searchEngine.getLinks(query.getQuery(), LINKS_NUMBERS).forEach(e -> {
            try {
                parser.findContext(e, query.getQuery()).forEach(s -> contextDao.save(new Context(s, null, query)));
            }catch (Exception ex){
                ex.printStackTrace();
            }
        });
    }
}
