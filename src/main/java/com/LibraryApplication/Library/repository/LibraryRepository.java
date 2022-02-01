package com.LibraryApplication.Library.repository;

import com.LibraryApplication.Library.model.Library;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LibraryRepository extends CrudRepository<Library, Integer> {

    public Optional<Library> findByName (String name);

}
