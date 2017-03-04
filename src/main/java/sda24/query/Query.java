package sda24.query;


import sda24.user.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Created by RENT on 2017-03-03.
 */

@Entity
@Table(name = "query")
public class Query {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "query")
    private String query;

    @OneToMany(mappedBy = "contextRef", fetch = FetchType.EAGER)
    private Set<Context> contexts = new HashSet<>();

    @OneToMany(mappedBy = "queryRef", fetch = FetchType.EAGER)
    private List<User> userList = new ArrayList<User>();


    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Set<Context> getContexts() {
        return contexts;
    }

    public void setContexts(Set<Context> contexts) {
        this.contexts = contexts;
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

}
