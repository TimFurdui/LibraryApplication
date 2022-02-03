package com.LibraryApplication.Library.repository;

import com.LibraryApplication.Library.model.LibraryCatalogItems.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
    public Optional<Book> findByTitle (String name);
}
