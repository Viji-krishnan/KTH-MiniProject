package se.kth.sda.skeleton.posts;

import se.kth.sda.skeleton.comments.Comment;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "post")
public class Post implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "body")
    private String body;
    @Column(name = "title")
    private String title;


//    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    private List<Comment> comments;


    public Post() {
    }

    public Post(String body, String title) {
        this.body = body;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public String getTitle() {
        return title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
