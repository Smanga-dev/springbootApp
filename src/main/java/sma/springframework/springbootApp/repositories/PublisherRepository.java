package sma.springframework.springbootApp.repositories;

import org.springframework.data.repository.CrudRepository;
import sma.springframework.springbootApp.domains.Publisher;

public interface PublisherRepository extends CrudRepository <Publisher, Long> {
}
