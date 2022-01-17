package com.LibraryApplication.Library.repository;

import com.LibraryApplication.Library.model.LibraryCatalogItems.LibraryCatalogItem;
import org.springframework.data.repository.CrudRepository;

public interface LibraryCatalogItemsRepository extends CrudRepository<LibraryCatalogItem, Integer> {
}
