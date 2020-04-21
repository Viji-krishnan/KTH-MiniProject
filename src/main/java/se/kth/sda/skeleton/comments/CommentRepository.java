package se.kth.sda.skeleton.comments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long>{

    List<Comment> findByPostId (Long postId);
    Optional<Comment> findByIdAndPostId(Long id, Long postId);
}


