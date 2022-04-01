package mcjerz.udemy.spring.osiris.repositories;

import mcjerz.udemy.spring.osiris.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface BookRepository extends JpaRepository<Book, Long> {}
