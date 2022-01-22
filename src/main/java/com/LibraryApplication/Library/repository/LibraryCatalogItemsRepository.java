package com.LibraryApplication.Library.repository;

import com.LibraryApplication.Library.model.Library;
import com.LibraryApplication.Library.model.LibraryCatalogItems.LibraryCatalogItem;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LibraryCatalogItemsRepository extends CrudRepository<LibraryCatalogItem, Integer> {

    public Optional<LibraryCatalogItem> findByTitle (String name);

}
