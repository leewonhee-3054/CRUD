package pratice.crud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pratice.crud.Entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
