package aka.springframework.springwebapp.repositories;

import aka.springframework.springwebapp.model.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by AP
 */
public interface BookRepository extends CrudRepository<Book, Long> {
}
