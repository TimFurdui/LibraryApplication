package com.LibraryApplication.Library.controller;

import com.LibraryApplication.Library.model.LibraryCatalogItems.Book;
import com.LibraryApplication.Library.repository.LibraryCatalogItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/book")
public class BookController {

    @Autowired
    private LibraryCatalogItemsRepository libraryCatalogItemsRepository;

    @PostMapping(path = "/addNewBook")
    public @ResponseBody
        //TODO map libraryId to a library in the library table
        //TODO different ways of doing this is by creating method that takes in name and queries DB for library row with name then sets the primaryKey to that row
        //TODO or I can just make the user supply the primaryKey
    String addNewBook(@RequestParam int libraryId, @RequestParam String title, @RequestParam String genre, @RequestParam String isbn, @RequestParam String author) {

        Book book = new Book(isbn, author);
        book.setTitle(title);
        book.setGenre(genre);

        libraryCatalogItemsRepository.save(book);
        // https://www.baeldung.com/spring-new-requestmapping-shortcuts
        return "Saved Book to Library DB";
    }

    //TODO create getBook{id}, getBooks{libraryId}, repeat for CD/Movies
    @GetMapping(path = "/getBooks")
    public @ResponseBody
    //TODO map libraryId to a library in the library table
    //TODO different ways of doing this is by creating method that takes in name and queries DB for library row with name then sets the primaryKey to that row
    //TODO or I can just make the user supply the primaryKey
    String getLibraryCatalogItem(@RequestParam int libraryId, @RequestParam String title, @RequestParam String genre, @RequestParam String isbn, @RequestParam String author) {

        Book book = new Book(isbn, author);
        book.setTitle(title);
        book.setGenre(genre);

        libraryCatalogItemsRepository.save(book);
        // https://www.baeldung.com/spring-new-requestmapping-shortcuts
        return "Saved Book to Library DB";
    }


}
