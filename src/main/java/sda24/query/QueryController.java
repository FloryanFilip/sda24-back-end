package sda24.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by bolad on 3/3/17.
 */

@RestController
public class QueryController {

    @Autowired
    private QueryValidator queryValidator;

    @GetMapping("query/{id}")
    public Integer get(@PathVariable Integer id) {
        System.out.println(id);
        return id;
    }

    @RequestMapping(path = "query", method = RequestMethod.POST)
    public Query post(@RequestBody @Valid Query query)  {
        return query;
    }

    @InitBinder("query")
    public void initBinder(WebDataBinder binder){
        binder.addValidators(queryValidator);
    }
}
