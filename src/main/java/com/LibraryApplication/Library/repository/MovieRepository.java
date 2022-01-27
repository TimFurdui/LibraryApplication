package com.LibraryApplication.Library.repository;

import com.LibraryApplication.Library.model.LibraryCatalogItems.LibraryCatalogItem;
import com.LibraryApplication.Library.model.LibraryCatalogItems.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {
//    @Query("from Movies")
//    public List<LibraryCatalogItem> getMovies();
}
