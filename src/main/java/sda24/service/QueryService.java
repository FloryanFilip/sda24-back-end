package sda24.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;

/**
 * Created by RENT on 2017-03-04.
 */
@Service
public class QueryService {

    private QueryServiceAsync queryServiceAsync;

    @Autowired
    public QueryService(QueryService queryServiceAsync) {
        this.queryServiceAsync = queryServiceAsync;
    }

    public void startSearching(String query) {
        //save to DB
        queryServiceAsync.checkURLs(query);
    }
}
