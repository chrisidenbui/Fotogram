package rmit.fotogram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import rmit.fotogram.model.Bind;

//@RepositoryRestResource(path="binds")
public interface BindRepository extends JpaRepository<Bind, Long> {
}
