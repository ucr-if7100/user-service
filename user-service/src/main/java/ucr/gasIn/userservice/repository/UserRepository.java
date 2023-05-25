package ucr.gasIn.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucr.gasIn.userservice.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
