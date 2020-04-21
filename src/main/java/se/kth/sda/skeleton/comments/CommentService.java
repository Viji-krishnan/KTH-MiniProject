package se.kth.sda.skeleton.comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import se.kth.sda.skeleton.posts.PostRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;


    @Autowired
    private PostRepository postRepository;


    public List<Comment> getAllCommentsByPostId(Long postId) {
        return commentRepository.findByPostId(postId);
    }

    public Optional<Comment> getById(Long id) {
        return commentRepository.findById(id);
    }

    public Comment createComment(Long postId, Comment newComment) throws Exception {

        return postRepository.findById(postId).map(post -> {
            newComment.setPost(post);
            return commentRepository.save(newComment);
        }).orElseThrow(() -> new Exception("PostId " + postId + " not found"));
    }


    public void deleteComment(Long postId,Long id) throws Exception {

        commentRepository.findByIdAndPostId(id, postId).map(comment -> {
            commentRepository.delete(comment);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new Exception("Comment not found with id " + id + " and postId " + postId));
    }


    public Comment updateComment( Long postId,Long id,Comment newComment) throws Exception {
        if(!postRepository.existsById(postId)) {
            throw new Exception("PostId " + postId + " not found");
        }

        return commentRepository.findById(id).map(comment -> {
            comment.setBody(newComment.getBody());
            return commentRepository.save(comment);
        }).orElseThrow(() -> new Exception("id " + id + "not found"));

    }



}
