package com.LibraryApplication.Library.repository;

import com.LibraryApplication.Library.model.LibraryCatalogItems.LibraryCatalogItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryCatalogItemsRepository extends JpaRepository<LibraryCatalogItem, Integer> {
}
