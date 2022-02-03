package com.LibraryApplication.Library.repository;

import com.LibraryApplication.Library.model.LibraryCatalogItems.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {
    public Optional<Movie> findByTitle (String name);
}
