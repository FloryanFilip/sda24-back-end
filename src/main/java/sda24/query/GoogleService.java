package sda24.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by RENT on 2017-03-03.
 */
@Service
public class GoogleService {
    private final GoogleDao googleDao;

    @Autowired
    public GoogleService(GoogleDao googleDao){
        this.googleDao =googleDao;
    }
    
}
