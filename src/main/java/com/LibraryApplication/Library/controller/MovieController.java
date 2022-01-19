package com.LibraryApplication.Library.controller;

import com.LibraryApplication.Library.model.LibraryCatalogItems.Movie;
import com.LibraryApplication.Library.repository.LibraryCatalogItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/movie")
public class MovieController {
    @Autowired
    private LibraryCatalogItemsRepository libraryCatalogItemsRepository;


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

}
