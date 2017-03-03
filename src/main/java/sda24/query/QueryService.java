package sda24.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by RENT on 2017-03-03.
 */
@Service
public class QueryService {
    private final QueryDao queryDao;

    @Autowired
    public QueryService(QueryDao queryDao){
        this.queryDao = queryDao;
    }

    public Query getQueryById(Integer queryId){
        return queryDao.findOne(queryId);
    }

    public void saveQuery(Query query){
        queryDao.save(query);
    }

    List<Query> getAllQueries(){
        return queryDao.findAll();
    }
    

    //zapisuje query(string) void//,
    //pobranie wszystkich query,
     pobranie wynikow dla danego query,
     zapisze wyniki dla query
}
