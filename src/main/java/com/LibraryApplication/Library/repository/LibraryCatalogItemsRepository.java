package com.LibraryApplication.Library.repository;

import com.LibraryApplication.Library.model.Library;
import com.LibraryApplication.Library.model.LibraryCatalogItems.LibraryCatalogItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LibraryCatalogItemsRepository extends CrudRepository<LibraryCatalogItem, Integer> {
    public Optional<LibraryCatalogItem> findByTitle (String name);
}
