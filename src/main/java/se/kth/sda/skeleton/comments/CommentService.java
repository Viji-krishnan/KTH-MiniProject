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

    public List<Comment> getAll() {
        return repository.findAll().stream()
                .collect(Collectors.toList());

    }

    public Optional<Comment> getById(Long id) {
        return repository.findById(id);
    }

    public Comment create(Comment newComment) {
        return repository.save(newComment);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Comment update(Comment updatedComment) {
        return repository.save(updatedComment);
    }

    public List<Comment> getAllByPostId(Long postId) {
        return repository.findAllByPostId(postId);
    }
}