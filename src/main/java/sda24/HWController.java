package sda24;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import sda24.entity.Query;
import sda24.query.QueryService;

/**
 * Created by RENT on 2017-03-01.
 */

@RestController
public class HWController {

    @GetMapping
    public String showHW() {
        return "Hello World!";
    }


    }
