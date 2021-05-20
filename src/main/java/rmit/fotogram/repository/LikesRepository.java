package rmit.fotogram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import rmit.fotogram.model.Likes;

@RepositoryRestResource(path="likes")
public interface LikesRepository extends JpaRepository<Likes, Long> {
}
