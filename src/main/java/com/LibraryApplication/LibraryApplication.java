package com.LibraryApplication;

import com.LibraryApplication.Library.model.LibraryCatalogItems.Book;
import com.LibraryApplication.Library.model.LibraryCatalogItems.Movie;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class LibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
    }

//    private static Book createBook() {
//        Book book = new Book("9780393972832", "Herman Melville");
//        book.setTitle("Moby Dick");
//        book.setGenre("Adventure Fiction");
//        book.setCatalogId(1);
//        return book;
//    }
//
//    private static Movie createMovie() {
//        Movie movie = new Movie(132, "John McTiernan");
//        movie.setTitle("Die Hard");
//        movie.setGenre("Action");
//        movie.setCatalogId(2);
//        return movie;
//    }
}
