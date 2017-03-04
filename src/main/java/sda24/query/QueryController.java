package sda24.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sda24.service.QueryService;

/**
 * Created by bolad on 3/3/17.
 */

@RestController
public class QueryController {

    @Autowired
    private QueryService queryService;

    @GetMapping("/query/{id}")
    public Integer get(@PathVariable Integer id) {
        System.out.println(id);
        return id;
    }

    @PostMapping("/query")
    public Query post(@RequestBody Query query)  {
       queryService.startSearching(query);
        return query;
    }
}
