package sda24.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by RENT on 2017-03-03.
 */

@Entity
@Table(name = "url")
public class URL {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "url")
    private String url;

    @OneToMany
    private List<Context> contextList = new ArrayList<Context>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Context> getContextList() {
        return contextList;
    }

    public void setContextList(List<Context> contextList) {
        this.contextList = contextList;
    }
}
