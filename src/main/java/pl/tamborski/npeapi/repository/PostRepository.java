package pl.tamborski.npeapi.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.tamborski.npeapi.model.Post;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query(value = "Select p From Post p",
            nativeQuery = false)
    public abstract List<Post> findAllPosts(Pageable page);
}
