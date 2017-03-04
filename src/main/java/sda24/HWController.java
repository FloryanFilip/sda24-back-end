package sda24;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sda24.query.Query;
import sda24.query.QueryDao;

/**
 * Created by RENT on 2017-03-01.
 */

@RestController
public class HWController {

//    private final QueryDao queryDao;
//    @Autowired
//    public HWController(QueryDao queryDao){
//        this.queryDao = queryDao;
//    }
//    private Query query;

    @GetMapping
    public String showHW() {

//        Query q1 = new Query();
//
//        q1.setQuery("hello");
//        queryDao.save(q1);
        return "Hello World!";
    }


    }
