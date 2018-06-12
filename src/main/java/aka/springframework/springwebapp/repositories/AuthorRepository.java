package aka.springframework.springwebapp.repositories;

import aka.springframework.springwebapp.model.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by AP
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
