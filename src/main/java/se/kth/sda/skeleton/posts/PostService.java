package se.kth.sda.skeleton.posts;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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


    public Post update(Long id,Post postRequest) throws Exception {
        return repository.findById(id).map(post -> {
            post.setTitle(postRequest.getTitle());
            post.setBody(postRequest.getBody());
            return repository.save(post);
        }).orElseThrow(() -> new Exception("PostId " + id + " not found"));
    }

    public void deleteById(Long id) {
        // @TODO delete the post by id
        repository.deleteById(id);
    }
}
