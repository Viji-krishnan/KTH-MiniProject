package se.kth.sda.skeleton.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/*
    @TODO Autowire the PostRepository and use it to implement all the service methods.
 */
@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public List<Post> getAll() {
        return repository.findAll();

    }

    public Optional<Post> getById(Long id) {
        // @TODO get a post by ID if it exists
        return repository.findById(id);
    }

    public Post create(Post newPost) {
        return repository.save(newPost);
    }


    public Post update(Post post) {
        // @TODO update the post if it exists in DB and return the updated post.
        return repository.save(post);
    }

    public void deleteById(Long id) {
        // @TODO delete the post by id
        repository.deleteById(id);
    }
}
