package pl.tamborski.npeapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.tamborski.npeapi.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
