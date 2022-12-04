package pl.tamborski.npeapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.tamborski.npeapi.model.Comment;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    public abstract List<Comment> findAllByPostIdIn(List<Long> postIds);
}
