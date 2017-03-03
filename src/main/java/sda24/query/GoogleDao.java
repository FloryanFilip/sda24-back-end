package sda24.query;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by RENT on 2017-03-03.
 */
@Component
public class GoogleDao {
    private List<String> queries = new ArrayList<String>();

    public List<String> getQueries() {
        return queries;
    }

    public void setQueries(List<String> queries) {
        this.queries = queries;
    }

}
