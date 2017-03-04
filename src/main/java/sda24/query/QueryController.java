package sda24.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

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

    @GetMapping
    public String helloWorld(){return "Hello World!";
    }

    @GetMapping("queries")
    public List<Query> getAll(){ return queryService.getAllQueries();}

    @Autowired
    private QueryValidator queryValidator;

    @GetMapping("queries/{id}")
    public Query get(@PathVariable Integer id) {
        return queryService.getQueryById(id);
    }

    @PostMapping(path = "queries")
    public void post(@Valid @RequestBody QueryDto query) throws IOException {
        queryService.startSearching(query.getQuery());
    }

    @PostMapping(path ="queies/context")
    public void postContext(@Valid Query query, @Valid Context context){queryService.saveResultsForQuery(query, context);}

    @GetMapping(path = "query/{id}/context")
    public Collection<Context> getContext(@PathVariable Integer id){
        return queryService.getResultsForQuery(id);
    }

    @InitBinder("query")
    public void initBinder(WebDataBinder binder){
        binder.addValidators(queryValidator);
    }
}
