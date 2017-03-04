package sda24.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by RENT on 2017-03-03.
 */

@Entity
@Table(name = "query")
public class Query {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "query")
    private String query;

    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private User user;

    @OneToMany
    private List<Context> results = new ArrayList<Context>();

    public List<Context> getResults() {
        return results;
    }

    public void setResults(List<Context> results) {
        this.results = results;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
