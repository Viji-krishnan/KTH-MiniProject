package se.kth.sda.skeleton.comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentService {

    @Autowired
    private CommentRepository repository;

    public List<Comment> getAll(String sort) {
        return repository.findAll().stream()
                .sorted(Comparator.comparing(sort.equals("sort") ? Comment::getBody : Comment::getBody))
                .collect(Collectors.toList());
    }

    public Optional<Comment> getByID(Long id) {
        return repository.findById(id);
    }

    public Comment save(Comment comment) {
        return repository.save(comment);
    }

    public Comment update(Comment comment) {
        return repository.save(comment);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public List<Comment> getAllByPostId(Long postId){
        return repository.findAllByPostId(postId);
    }

    public List<Comment>  getAllCommentsByUserID(Long userId) {
        return repository.findAllCommentsByUserId(userId);
    }
}