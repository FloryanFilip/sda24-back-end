package sda24.query;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.web.bind.WebDataBinder;
=======

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

>>>>>>> 29c56ae27320ed613f7719b92d678b1bb1fc6ce7
import org.springframework.web.bind.annotation.*;
import sda24.service.QueryService;


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

    @GetMapping
    public String helloWorld(){return "Hello World!";
    }

    @GetMapping("query/all")
    public List<Query> getAll(){ return queryService.getAllQueries();}

    @Autowired
    private QueryValidator queryValidator;

    @GetMapping("query/{id}")
    public Query get(@PathVariable Integer id) {
        return queryService.getQueryById(id);
    }

<<<<<<< HEAD
    @RequestMapping(path = "query", method = RequestMethod.POST)
    public Query post(@RequestBody @Valid Query query)  {
        return query;
=======
    @PostMapping(path = "query")
    public void post(@Valid Query query)  {
        queryService.saveQuery(query);
    }

    @PostMapping(path ="query/context")
    public void postContext(@Valid Query query, @Valid Context context){queryService.saveResultsForQuery(query, context);}

    @GetMapping(path = "query/{id}/context")
    public Context getContext(@PathVariable Integer id){
        return queryService.getResultsForQuery(id);
>>>>>>> 29c56ae27320ed613f7719b92d678b1bb1fc6ce7
    }

    @InitBinder("query")
    public void initBinder(WebDataBinder binder){
        binder.addValidators(queryValidator);
    }
}
