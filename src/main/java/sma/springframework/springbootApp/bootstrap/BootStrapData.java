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

        Publisher pub = new Publisher();

        pub.setName("MacMillan Books");
        pub.setAddressLine1("142 Gilfillan Street");
        pub.setSuburb("Northgate");
        pub.setProvince("Gauteng");
        pub.setPostalCode("1966");


        publisherRepository.save(pub);


        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book ("Beginner Bootstrap", "865922134");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(pub);

        Author sma = new Author("Smangaliso","Mabota");
        Book sss = new Book("Bootstrap Journey - 2020","3578963");

        sma.getBooks().add(sss);
        sss.getAuthors().add(sma);

        sss.setPublisher(pub);
        pub.getBooks().add(sss);

        authorRepository.save(sma);
        bookRepository.save(sss);
        publisherRepository.save(pub);


        System.out.println("Started in Bootstrap");
        System.out.println("Publisher number of Books: "+ pub.getBooks().size());





        System.out.println("Publisher added in Bootstrap");
        System.out.println("Number of publisher: "+ publisherRepository.count());


    }
}
