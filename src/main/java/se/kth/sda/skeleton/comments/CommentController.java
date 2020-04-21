package se.kth.sda.skeleton.comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se.kth.sda.skeleton.posts.PostService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private PostService postService;


    @GetMapping("/posts/{postId}/comments")
    public List<Comment> getAllCommentsByPostId(@PathVariable(value = "postId") Long postId) {
        return commentService.getAllCommentsByPostId(postId);
    }

    @GetMapping("/posts/{postId}/comments/{id}")
    public Comment getById(@PathVariable Long id) {
        return commentService.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


    @PostMapping("/posts/{postId}/comments")
    public Comment createComment(@PathVariable (value = "postId") Long postId,
                                 @Valid @RequestBody Comment newComment) throws Exception {
        return commentService.createComment(postId,newComment);
    }

    @PutMapping("/posts/{postId}/comments/{id}")
    public Comment updateComment(@PathVariable (value = "postId") Long postId,
                                 @PathVariable (value = "id") Long id,
                                 @Valid @RequestBody Comment updatedComment) throws Exception {
        return commentService.updateComment(postId,id,updatedComment);
    }

    @DeleteMapping("/posts/{postId}/comments/{id}")
    public void deleteComment(@PathVariable (value = "postId") Long postId,
                              @PathVariable (value = "id") Long id) throws Exception {
        commentService.deleteComment(postId,id);
    }

}
