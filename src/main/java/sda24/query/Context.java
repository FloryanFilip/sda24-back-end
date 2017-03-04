package sda24.query;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @Column(name = "context",length = 10000)
    private String context;

    @JoinColumn(name = "query_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Query contextRef;

    @Column(name = "url")
    private String url;

    public Context(String context, String url, Query q) {
        this.context = context;
        this.url = url;
        this.contextRef = q;
    }

    public Context() {
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

    @JsonIgnore
    public Query getContextRef() {
        return contextRef;
    }

    public void setContextRef(Query contextRef) {
        this.contextRef = contextRef;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
