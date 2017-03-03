package sda24.entity;

import javax.persistence.*;

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

    @JoinColumn(name = "query_id", referencedColumnName = "id")
    @OneToOne
    private Query query;

    @JoinColumn(name = "url_id", referencedColumnName = "id")
    @ManyToOne
    private URL url;

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

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }
}
