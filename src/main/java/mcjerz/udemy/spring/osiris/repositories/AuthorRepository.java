package mcjerz.udemy.spring.osiris.repositories;

import mcjerz.udemy.spring.osiris.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthorRepository extends JpaRepository<Author, Long> {
}
