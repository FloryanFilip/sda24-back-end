package sda24.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Created by RENT on 2017-03-03.
 */
@Service
public class QueryService {
    private  final QueryDao queryDao;
    private final QueryServiceAsync queryServiceAsync;

    @Autowired
    public QueryService(QueryDao queryDao, QueryServiceAsync queryServiceAsync){
        this.queryDao = queryDao;
        this.queryServiceAsync = queryServiceAsync;
    }

    // Returns one query of given {queryId}
    public Query getQueryById(Integer queryId){
        return queryDao.findOne(queryId);
    }

    // Saves a single Query
    public void saveQuery(Query query){
        queryDao.save(query);
    }

    // returns all Queries
    List<Query> getAllQueries(){
        return queryDao.findAll();
    }

    // Returns a list of  all results for a Query of given {Id}
    public Context getResultsForQuery(Integer Id) {
        return queryDao.findOne(Id).getContext();
    }

    public void saveResultsForQuery(Query query, Context context){
        queryDao.save(query).setContext(context);
    }

    public void startSearching(String query) throws IOException {
        //save to DB
        queryServiceAsync.checkURLs(query);
    }

}
