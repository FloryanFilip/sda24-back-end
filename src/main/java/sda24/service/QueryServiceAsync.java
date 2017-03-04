package sda24.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import sda24.parser.Parser;

/**
 * Created by RENT on 2017-03-04.
 */
@Service
public class QueryServiceAsync {

    private Parser parser;
    // private SearchEngine

    // @Autowired SearchEngine
    @Autowired
    public QueryServiceAsync(Parser parser){
        this.parser=parser;
    }

    @Async()
    public void checkURLs(String query) {
//        searchEngine.getURrlList().forEach(e -> {
//            parser.findContext(e.getUrl, query);
//        });
    }
}
