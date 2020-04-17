package se.kth.sda.skeleton.posts;

import se.kth.sda.skeleton.user.User;

import javax.persistence.*;


@Entity
@Table(name="post")
public class Post {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name="body")
    private String body;

    @ManyToOne
    private User user;



//    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
//    private List<Comment> comments = new ArrayList<>();

    public Post() {
    }

    public Post(User user){
        this.user = user;
    }

    public Post(String body) {
        this.body = body;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

}
