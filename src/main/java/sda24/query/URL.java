package sda24.query;

import sda24.query.Context;

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

    @JoinColumn(name = "context_id", referencedColumnName = "id")
    @ManyToOne
    private Context contextRef;



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

    public Context getContextRef() {
        return contextRef;
    }

    public void setContextRef(Context contextRef) {
        this.contextRef = contextRef;
    }
}
