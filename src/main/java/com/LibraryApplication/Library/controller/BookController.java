package com.LibraryApplication.Library.controller;

import com.LibraryApplication.Library.model.Library;
import com.LibraryApplication.Library.model.LibraryCatalogItems.Book;
import com.LibraryApplication.Library.model.LibraryCatalogItems.LibraryCatalogItem;
import com.LibraryApplication.Library.repository.LibraryCatalogItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NonUniqueResultException;
import java.util.Optional;

@Controller
@RequestMapping(path = "/book")
public class BookController {

    //TODO create try catch blocks to handle common erros such as; no value present, etc...
    //TODO find by title and find by ID to make sure book is unique,
    // need to also add quantity so Library can have multiple books

    @Autowired
    private LibraryCatalogItemsRepository libraryCatalogItemsRepository;

    @PostMapping(path = "/addNewBook")
    public @ResponseBody
    String addNewBook(@RequestParam(required = false) Integer libraryId, @RequestParam String title, @RequestParam String genre, @RequestParam String isbn, @RequestParam String author) {

//        Book book = new Book(libraryId, isbn, author);
        Book book = new Book(isbn, author);
        book.setTitle(title);
        book.setGenre(genre);


        if (getBookByName(title).isEmpty()) {
            libraryCatalogItemsRepository.save(book);
            return "Saved Book to Library DB";

        }
        return "Didn't save book, as book with same name already exists";
        // https://www.baeldung.com/spring-new-requestmapping-shortcuts
    }

    @GetMapping(path = "/getBooks")
    public @ResponseBody
    Iterable<LibraryCatalogItem> getBooks() {
        return libraryCatalogItemsRepository.findAll();
    }

    @GetMapping(path = "/getBookById/{id}")
    public @ResponseBody
    Optional<LibraryCatalogItem>
    getBookById(@PathVariable Integer id) {
        return libraryCatalogItemsRepository.findById(id);
    }

    //TODO find by title and find by ID to make sure book is unique,
    // need to also add quantity so Library can have multiple books
    @GetMapping("/getBookByName/{name}")
    public @ResponseBody
    Optional<LibraryCatalogItem>
    getBookByName(@PathVariable String title) {
        Optional<LibraryCatalogItem> book;
        try {
            book = libraryCatalogItemsRepository.findByTitle(title);
        } catch (NonUniqueResultException nonUniqueResultException) {
            return Optional.empty();
        }
        return book;
    }

    @PostMapping(path = "/updateBook")
    public @ResponseBody
    String updateBook(@RequestParam String title, @RequestParam(required = false) String newTitle, @RequestParam String genre, @RequestParam String isbn, @RequestParam String author) {
        Optional<LibraryCatalogItem> bookFromDb = libraryCatalogItemsRepository.findByTitle(title);
        if (bookFromDb.isPresent()) {
            //TODO need to change code to accept new name as parameter
            Book book = new Book(isbn, author);
            book.setGenre(genre);
            book.setTitle(newTitle);

            libraryCatalogItemsRepository.save(book);
            return "Updated Book";
        }

        return "Book not found; no update performed.";
    }

    @DeleteMapping("/deleteBookById/{id}")
    public @ResponseBody
    String
    deleteBookById(@PathVariable Integer id) {
        Optional<LibraryCatalogItem> book = libraryCatalogItemsRepository.findById(id);
        book.ifPresent(value -> libraryCatalogItemsRepository.delete(value));
        return "Deleted Library with name: " + book.get().getTitle();
    }

    @DeleteMapping("/deleteBookByName/{name}")
    public @ResponseBody
    String
    deleteBookByName(@PathVariable String name) {

        Optional<LibraryCatalogItem> book = libraryCatalogItemsRepository.findByTitle(name);
        book.ifPresent(value -> libraryCatalogItemsRepository.delete(value));
        return "Deleted Library with name: " + book.get().getTitle();
    }


}
