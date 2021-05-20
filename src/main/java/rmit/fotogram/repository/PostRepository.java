package rmit.fotogram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import rmit.fotogram.model.Post;

//@RepositoryRestResource(path="posts")
public interface PostRepository extends JpaRepository<Post, Long> {
}
