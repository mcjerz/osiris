package mcjerz.udemy.spring.osiris.controller;

import mcjerz.udemy.spring.osiris.domain.Book;
import mcjerz.udemy.spring.osiris.repositories.BookRepository;

import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController

public class BookController {

    private final BookRepository bookRepository;


    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    Book addBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @GetMapping("/books")
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/books/{id}")
    public Book findById(@PathVariable Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new OpenApiResourceNotFoundException("Book ID not found."));
    }


    @PutMapping("/books/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book updateBook(
            @PathVariable("id") final Long id, @RequestBody final Book book) {
        return book;
    }

    @DeleteMapping("/books/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteBook(@PathVariable("id") final Long id) {
        bookRepository.deleteById(id);
    }


}