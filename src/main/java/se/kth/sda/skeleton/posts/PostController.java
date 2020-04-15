package se.kth.sda.skeleton.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/*
    @TODO AutoWire PostService and create the methods needed to implement the API.
    Don't forget to add necessary annotations.
 */

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public List<Post> getAll() {
        // @TODO get all posts and return them as List<Post>
        return null;
    }

    @GetMapping("/posts/{id}")
    public Optional<Post> getByID(Long id) {
        // @TODO get a post by ID if it exists
        return null;
    }

    @PutMapping("/post")
    public Post save(Post post) {
        // @TODO save the post to DB and return the saved post
        return null;
    }

    @PutMapping("/post")
    public Optional<Post> update(Post post) {
        // @TODO update the post if it exists in DB and return the updated post.
        return null;
    }

    @DeleteMapping("/task/{id}")
    public void deleteById(Long id) {
        // @TODO delete the post by id
        return;
    }
}
