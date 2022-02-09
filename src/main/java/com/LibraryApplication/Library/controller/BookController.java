package com.LibraryApplication.Library.controller;

import com.LibraryApplication.Library.model.LibraryCatalogItems.Book;
import com.LibraryApplication.Library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NonUniqueResultException;
import java.util.Optional;

@Controller
@RequestMapping(path = "/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @PostMapping(path = "/addNewBook")
    public @ResponseBody
    String addNewBook(@RequestParam Integer libraryId, @RequestParam String title, @RequestParam String genre, @RequestParam String isbn, @RequestParam String author) {

        Book book = new Book(libraryId, isbn, author);
        book.setTitle(title);
        book.setGenre(genre);


        if (getBookByName(title).isEmpty()) {
            bookRepository.save(book);
            return "Saved Book to Library DB";

        }
        return "Didn't save book, as book with same name already exists. Please use update if you intend to update entity.";
        // https://www.baeldung.com/spring-new-requestmapping-shortcuts
    }

    @GetMapping(path = "/getBooks")
    public @ResponseBody
    Iterable<Book> getBooks() {
        return bookRepository.findAll();
    }

    @GetMapping(path = "/getBookById/{id}")
    public @ResponseBody
    Optional<Book>
    getBookById(@PathVariable Integer id) {
        return bookRepository.findById(id);
    }

    @GetMapping("/getBookByName/{name}")
    public @ResponseBody
    Optional<Book>
    getBookByName(@PathVariable String title) {
        Optional<Book> book;
        try {
            book = bookRepository.findByTitle(title);
        } catch (NonUniqueResultException nonUniqueResultException) {
            return Optional.empty();
        }
        return book;
    }

    @PostMapping(path = "/updateBook")
    public @ResponseBody
    String updateBook(@RequestParam String title, @RequestParam(required = false) String newTitle, @RequestParam String genre, @RequestParam String isbn, @RequestParam String author) {
        Optional<Book> bookFromDb = bookRepository.findByTitle(title);
        if (bookFromDb.isPresent()) {
            Book book = new Book(isbn, author);
            book.setGenre(genre);
            book.setTitle(newTitle);

            bookRepository.save(book);
            return "Updated Book";
        }

        return "Book not found; no update performed.";
    }

    @DeleteMapping("/deleteBookById/{id}")
    public @ResponseBody
    String
    deleteBookById(@PathVariable Integer id) {
        Optional<Book> book = bookRepository.findById(id);
        book.ifPresent(value -> bookRepository.delete(value));
        return "Deleted Library with name: " + book.get().getTitle();
    }

    @DeleteMapping("/deleteBookByName/{name}")
    public @ResponseBody
    String
    deleteBookByName(@PathVariable String name) {

        Optional<Book> book = bookRepository.findByTitle(name);
        book.ifPresent(value -> bookRepository.delete(value));
        return "Deleted Library with name: " + book.get().getTitle();
    }

}
