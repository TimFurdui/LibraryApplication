package com.LibraryApplication.Library.controller;

import com.LibraryApplication.Library.model.LibraryCatalogItems.Movie;
import com.LibraryApplication.Library.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NonUniqueResultException;
import java.util.Optional;

@Controller
@RequestMapping(path = "/movie")
public class MovieController {

    @Autowired
    MovieRepository movieRepository;

    @PostMapping(path = "/addNewMovie")
    public @ResponseBody
    String addNewMovie(@RequestParam Integer libraryId, @RequestParam String title, @RequestParam String genre, @RequestParam Double duration, @RequestParam String director) {

        Movie movie = new Movie(libraryId, duration, director);
        movie.setTitle(title);
        movie.setGenre(genre);

        if(getMovieByName(title).isEmpty()) {
            movieRepository.save(movie);
            return "Saved Movie to Library DB";
        }

        return "Didn't save Movie, as movie with same name already exists. Please use update if you intend to update entity.";

        // https://www.baeldung.com/spring-new-requestmapping-shortcuts
    }


    @GetMapping(path = "/getMovies")
    public @ResponseBody
    Iterable<Movie> getMovie() {
        return movieRepository.findAll();
    }

    @GetMapping(path = "/getMovieById/{id}")
    public @ResponseBody
    Optional<Movie>
    getMovieById(@PathVariable Integer id) {
        return movieRepository.findById(id);
    }

    @GetMapping("/getMovieByName/{name}")
    public @ResponseBody
    Optional<Movie>
    getMovieByName(@PathVariable String title) {
        Optional<Movie> movie;
        try {
            movie = movieRepository.findByTitle(title);
        } catch (NonUniqueResultException nonUniqueResultException) {
            return Optional.empty();
        }
        return movie;
    }

    @PostMapping(path = "/updateMovie")
    public @ResponseBody
    String updateMovie(@RequestParam String title, @RequestParam(required = false) String newTitle, @RequestParam String genre, @RequestParam Double duration, @RequestParam String director) {
        Optional<Movie> movieFromDb = movieRepository.findByTitle(title);
        if (movieFromDb.isPresent()) {
            Movie movie = new Movie(duration, director);
            movie.setGenre(genre);
            movie.setTitle(newTitle);

            movieRepository.save(movie);
            return "Updated Movie";
        }

        return "Movie not found; no update performed.";
    }

    @DeleteMapping("/deleteMovieById/{id}")
    public @ResponseBody
    String
    deleteMovieById(@PathVariable Integer id) {
        Optional<Movie> movie = movieRepository.findById(id);
        movie.ifPresent(value -> movieRepository.delete(value));
        return "Deleted movie with name: " + movie.get().getTitle();
    }

    @DeleteMapping("/deleteMovieByName/{name}")
    public @ResponseBody
    String
    deleteMovieByName(@PathVariable String name) {

        Optional<Movie> movie = movieRepository.findByTitle(name);
        movie.ifPresent(value -> movieRepository.delete(value));
        return "Deleted movie with name: " + movie.get().getTitle();
    }

    //deleteallbooks
}
