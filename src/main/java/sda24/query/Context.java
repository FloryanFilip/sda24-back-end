package sda24.query;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by RENT on 2017-03-03.
 */

@Entity
@Table(name = "context")
public class Context {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "context")
    private String context;


    @OneToMany(mappedBy = "contextRef")
    private List<URL> Allurls = new ArrayList<URL>();

    public List<URL> getAllurls() {
        return Allurls;
    }

    public void setAllurls(List<URL> allurls) {
        Allurls = allurls;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }



}
