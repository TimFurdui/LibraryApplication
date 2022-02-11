package com.LibraryApplication.Library.repository;

import com.LibraryApplication.Library.model.CheckedOutLibraryCatalogItems.PersonCheckedOutBooks;
import org.springframework.data.repository.CrudRepository;

public interface PersonCheckedOutBooksRepository extends CrudRepository<PersonCheckedOutBooks, Integer> {
}
