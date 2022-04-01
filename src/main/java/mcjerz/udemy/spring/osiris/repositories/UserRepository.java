package mcjerz.udemy.spring.osiris.repositories;

import mcjerz.udemy.spring.osiris.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>
{

}
