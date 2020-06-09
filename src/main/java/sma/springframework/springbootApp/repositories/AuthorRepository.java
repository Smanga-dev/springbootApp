package sma.springframework.springbootApp.repositories;

import org.springframework.data.repository.CrudRepository;
import sma.springframework.springbootApp.domains.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
