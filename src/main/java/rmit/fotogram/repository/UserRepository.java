package rmit.fotogram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import rmit.fotogram.model.User;

//@RepositoryRestResource(path="members")   // localhost:8080/api/members

public interface UserRepository extends JpaRepository<User, Long> {
}
