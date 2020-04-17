package se.kth.sda.skeleton.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.kth.sda.skeleton.user.User;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public List<Post> getAll(String sort) {
        return repository.findAll().stream()
                .sorted(Comparator.comparing(sort.equals("name") ? Post::getBody : Post::getBody))
                .collect(Collectors.toList());

    }

    public Optional<Post> getByID(Long id) {
        return repository.findById(id);
    }

    public Post save(Post post) {
        return repository.save(post);
    }

    public Post update(Post post) {
        return repository.save(post);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public List<Post> getAllPostByUserId(Long userId){ return repository.findAllByUserId(userId); }

}
