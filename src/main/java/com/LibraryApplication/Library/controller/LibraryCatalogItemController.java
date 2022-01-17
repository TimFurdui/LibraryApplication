package com.LibraryApplication.Library.controller;

import com.LibraryApplication.Library.model.LibraryCatalogItems.Book;
import com.LibraryApplication.Library.model.LibraryCatalogItems.CD;
import com.LibraryApplication.Library.model.LibraryCatalogItems.LibraryCatalogItem;
import com.LibraryApplication.Library.model.LibraryCatalogItems.Movie;
import com.LibraryApplication.Library.repository.LibraryCatalogItemsRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping(path = "/catalog")
public class LibraryCatalogItemController {

    @Autowired
    private LibraryCatalogItemsRepository libraryCatalogItemsRepository;

    //TODO finish addCD, addMovie methods

    @PostMapping(path = "/addNewBook")
    public @ResponseBody
        //TODO map libraryId to a library in the library table
        //TODO different ways of doing this is by creating method that takes in name and queries DB for library row with name then sets the primaryKey to that row
        //TODO or I can just make the user supply the primaryKey
    String addNewBook(@RequestParam(required = false) Integer LibraryId, @RequestParam String title, @RequestParam String genre, @RequestParam String isbn, @RequestParam String author) {

        Book book = new Book(isbn, author);
        book.setTitle(title);
        book.setGenre(genre);

        libraryCatalogItemsRepository.save(book);
        // https://www.baeldung.com/spring-new-requestmapping-shortcuts
        return "Saved Book to Library DB";
    }

    @PostMapping(path = "/addNewCd")
    public @ResponseBody
        //TODO map libraryId to a library in the library table
        //TODO different ways of doing this is by creating method that takes in name and queries DB for library row with name then sets the primaryKey to that row
        //TODO or I can just make the user supply the primaryKey
    String addNewCd(@RequestParam(required = false) Integer LibraryId, @RequestParam String title, @RequestParam String genre, @RequestParam Double duration, @RequestParam String artist) {

        CD cd = new CD(duration, artist);
        cd.setTitle(title);
        cd.setGenre(genre);

        libraryCatalogItemsRepository.save(cd);
        // https://www.baeldung.com/spring-new-requestmapping-shortcuts
        return "Saved CD to Library DB";
    }

    @PostMapping(path = "/addNewMovie")
    public @ResponseBody
        //TODO map libraryId to a library in the library table
        //TODO different ways of doing this is by creating method that takes in name and queries DB for library row with name then sets the primaryKey to that row
        //TODO or I can just make the user supply the primaryKey
    String addNewMovie(@RequestParam(required = false) Integer LibraryId, @RequestParam String title, @RequestParam String genre, @RequestParam String author, @RequestParam Double duration, @RequestParam String director) {

        Movie movie = new Movie(duration, director);
        movie.setTitle(title);
        movie.setGenre(genre);

        libraryCatalogItemsRepository.save(movie);
        // https://www.baeldung.com/spring-new-requestmapping-shortcuts
        return "Saved Movie to Library DB";
    }

    //TODO create getBook{id}, getBooks{libraryId}, repeat for CD/Movies
    @GetMapping(path = "/getBooks")
    public @ResponseBody
    //TODO map libraryId to a library in the library table
    //TODO different ways of doing this is by creating method that takes in name and queries DB for library row with name then sets the primaryKey to that row
    //TODO or I can just make the user supply the primaryKey
    String getLibraryCatalogItem(@RequestParam Integer LibraryId, @RequestParam String title, @RequestParam String genre, @RequestParam String isbn, @RequestParam String author) {

        Book book = new Book(isbn, author);
        book.setTitle(title);
        book.setGenre(genre);

        libraryCatalogItemsRepository.save(book);
        // https://www.baeldung.com/spring-new-requestmapping-shortcuts
        return "Saved Book to Library DB";
    }


}
