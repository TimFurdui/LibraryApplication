package com.LibraryApplication.Library.repository;

import com.LibraryApplication.Library.model.LibraryCatalogItems.CD;
import com.LibraryApplication.Library.model.LibraryCatalogItems.LibraryCatalogItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CdRepository extends CrudRepository<LibraryCatalogItem, Integer> {
//    @Query("from CD")
//    public List<LibraryCatalogItem> getCds();

    public Optional<CD> findByTitle (String name);


}
