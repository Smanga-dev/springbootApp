package sma.springframework.springbootApp.repositories;

import org.springframework.data.repository.CrudRepository;
import sma.springframework.springbootApp.domains.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
