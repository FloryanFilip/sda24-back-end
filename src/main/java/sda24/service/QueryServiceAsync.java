package sda24.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import sda24.parser.Parser;
import sda24.search.SearchEngine;

/**
 * Created by RENT on 2017-03-04.
 */
@Service
public class QueryServiceAsync {

    private static final int LINKS_NUMBERS = 20;
    private Parser parser;
    private SearchEngine searchEngine;

    @Autowired
    public QueryServiceAsync(Parser parser, SearchEngine searchEngine){
        this.parser=parser;
        this.searchEngine=searchEngine;
    }

    @Async()
    public void checkURLs(String query) {
        searchEngine.getLinks(query, LINKS_NUMBERS).forEach(e -> {
            parser.findContext(e, query);
        });
    }
}
