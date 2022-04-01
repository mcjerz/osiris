package mcjerz.udemy.spring.osiris.exceptions;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(Long id)
    {
        super("Could not find book ID:" + id);
    }
}
