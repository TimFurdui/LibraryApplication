package com.LibraryApplication.Library.repository;

import com.LibraryApplication.Library.model.Library;
import org.springframework.data.repository.CrudRepository;

public interface LibraryRepository extends CrudRepository<Library, Integer> {
}
