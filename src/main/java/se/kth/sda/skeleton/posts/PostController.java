package se.kth.sda.skeleton.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se.kth.sda.skeleton.user.User;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("sort")
    public List<Post> getAll(@RequestParam String sort) {
        return postService.getAll(sort);
    }

    @GetMapping("/{id}")
    public Post getByID(@PathVariable Long id) {
        return postService.getByID(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{user_id}")
    public List<Post> getAllPostByUserId(@PathVariable Long userId){
        return postService.getAllPostByUserId(userId);
    }

    @PostMapping("")
    public Post save(@RequestBody Post post) {
        return postService.save(post);
    }

    @PutMapping("")
    public Post update(@RequestBody Post post) {
        return postService.update(post);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        postService.deleteById(id);
    }
}
