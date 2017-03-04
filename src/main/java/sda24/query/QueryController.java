package sda24.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sda24.entity.Query;

import javax.validation.Valid;

/**
 * Created by bolad on 3/3/17.
 */

@RestController
public class QueryController {
    private final QueryService queryService;

    @Autowired
    public QueryController(QueryService queryService){
        this.queryService = queryService;
    }

    @GetMapping("query/{id}")
    public Query get(@PathVariable Integer id) {
        return queryService.getQueryById(id);
    }

    @PostMapping(path = "query")
    public void post(@Valid Query query)  {
        queryService.saveQuery(query);
    }
}
