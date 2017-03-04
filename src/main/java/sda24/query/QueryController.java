package sda24.query;

import org.springframework.web.bind.annotation.*;

/**
 * Created by bolad on 3/3/17.
 */

@RestController
public class QueryController {

    @GetMapping("query/{id}")
    public Integer get(@PathVariable Integer id) {
        System.out.println(id);
        return id;
    }

    @RequestMapping(path = "query", method = RequestMethod.POST)
    public Query post(@RequestBody Query query)  {
        return query;
    }
}
