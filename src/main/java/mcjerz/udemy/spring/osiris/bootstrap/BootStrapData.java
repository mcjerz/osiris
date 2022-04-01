package mcjerz.udemy.spring.osiris.bootstrap;

import mcjerz.udemy.spring.osiris.domain.Author;
import mcjerz.udemy.spring.osiris.domain.Book;
import mcjerz.udemy.spring.osiris.domain.Product;
import mcjerz.udemy.spring.osiris.domain.Publisher;
import mcjerz.udemy.spring.osiris.repositories.AuthorRepository;
import mcjerz.udemy.spring.osiris.repositories.BookRepository;
import mcjerz.udemy.spring.osiris.repositories.ProductRepository;
import mcjerz.udemy.spring.osiris.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BootStrapData implements CommandLineRunner
{
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final ProductRepository productRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, ProductRepository productRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.productRepository = productRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started in Bootstrap");

        Product product = new Product();
        product.setName("bookmark");
        product.setDescription("save your spot");
        product.setPrice(BigDecimal.valueOf(4.99));

        productRepository.save(product);

        Publisher publisher = new Publisher();
        publisher.setName("Tor");
        publisher.setCity("Salt Lake City");
        publisher.setState("UT");

        publisherRepository.save(publisher);

        Author author = new Author();
        author.setFirstName("Brandon");
        author.setLastName("Sanderson");

        authorRepository.save(author);

        Book book = new Book();
        book.setTitle("Mistborn");
        book.setIsbn("9780765350381");

        bookRepository.save(book);



        System.out.println("Publisher Count: " + publisherRepository.count());

        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Number of Books: " + publisher.getBooks().size());

    }
}
