package aka.springframework.springwebapp.bootstrap;

import aka.springframework.springwebapp.model.Author;
import aka.springframework.springwebapp.model.Book;
import aka.springframework.springwebapp.model.Publisher;
import aka.springframework.springwebapp.repositories.AuthorRepository;
import aka.springframework.springwebapp.repositories.BookRepository;
import aka.springframework.springwebapp.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by AP
 */

//Good for local development to test with known data set
//Class Loads the data during spring initializing
@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        Publisher publisher = new Publisher("A", "Hamilton BLVD., PA");
        Publisher publisher1 = new Publisher("P", "Hamilton BLVD., PA");
        publisherRepository.save(publisher);
        publisherRepository.save(publisher1);

        //Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", publisher);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);


        //Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", publisher1 );
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }

}
