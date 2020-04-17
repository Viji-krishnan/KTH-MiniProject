package se.kth.sda.skeleton.comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;


@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("")
    public List<Comment> getAll(@RequestParam (required = false) String sort,
                                @RequestParam (required = false) Long postId){
        if (sort == null){ sort = "sort";}
        if (postId == null){ return commentService.getAll(sort);}
        else {
            return commentService.getAllByPostId(postId);
        }

    }

    @GetMapping("/{id}")
    public Comment getByID(@PathVariable Long id) {
        return commentService.getByID(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("")
    public Comment save(@RequestBody Comment comment) {
        return commentService.save(comment);
    }

    @PutMapping("")
    public Comment update(@RequestBody Comment comment) {
        return commentService.update(comment);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        commentService.deleteById(id);
    }
}