package sda24.query;

import sda24.user.User;

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

    @JoinColumn(name = "context_id", referencedColumnName = "id")
    @OneToOne
    private Context context;

    @OneToMany(mappedBy = "queryRef")
    private List<User> userList = new ArrayList<User>();

//    @OneToMany
//    private List<Context> results = new ArrayList<Context>();


    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
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
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
}
