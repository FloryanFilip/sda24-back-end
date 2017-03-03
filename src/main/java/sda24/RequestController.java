package sda24;

import org.springframework.web.bind.annotation.*;

/**
 * Created by bolad on 3/3/17.
 */

@RestController
public class RequestController {

    @RequestMapping(path = "query/{id}", method = RequestMethod.GET)
    public Integer get(@PathVariable Integer id) {
        System.out.println(id);
        return id;
    }

}
