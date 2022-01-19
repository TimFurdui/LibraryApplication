package com.LibraryApplication.Library.repository;

import com.LibraryApplication.Library.model.Library;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LibraryRepository extends CrudRepository<Library, Integer> {

    public Optional<Library> findByName (String name);

}
