package rmit.fotogram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import rmit.fotogram.model.Tag;

//@RepositoryRestResource(path="tags")
public interface TagRepository extends JpaRepository<Tag, Long> {
}
