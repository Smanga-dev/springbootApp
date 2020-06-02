package sma.springframework.springbootApp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sma.springframework.springbootApp.domains.Author;
import sma.springframework.springbootApp.domains.Book;
import sma.springframework.springbootApp.domains.Publisher;
import sma.springframework.springbootApp.repositories.AuthorRepository;
import sma.springframework.springbootApp.repositories.BookRepository;
import sma.springframework.springbootApp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {


    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book ("Beginner Bootstrap", "865922134");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author sma = new Author("Smangaliso","Mabota");
        Book sss = new Book("Bootstrap Journey - 2020","3578963");

        authorRepository.save(sma);
        bookRepository.save(sss);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: "+ bookRepository.count());

        Publisher pub = new Publisher("MacMillan Books", "142 Gilfillan Street", "Northgate", "Gauteng", "1966");
        publisherRepository.save(pub);

        Publisher ppp = new Publisher("CUM Books", "89 Mtere Street", "Fourways", "Gauteng", "2162" );
        publisherRepository.save(ppp);

        System.out.println("Publisher added in Bootstrap");
        System.out.println("Number of publisher: "+ publisherRepository.count());


    }
}
