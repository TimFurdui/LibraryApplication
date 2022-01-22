package com.LibraryApplication.Library.model;

import com.LibraryApplication.Library.model.LibraryCatalogItems.Book;
import com.LibraryApplication.Library.model.LibraryCatalogItems.LibraryCatalogItem;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
public class Library {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer primaryKey;

    @Getter
    @Setter
    private Integer phoneNumber;

    @Getter
    @Setter
    private String name, address, email;

    //TODO make libraryId foreign key relate to LibraryCatalogItem Table
//    @OneToMany(mappedBy = "libraryId", targetEntity = Book.class)
//    private List<LibraryCatalogItem> libraryCatalogItems;

    //TODO need to create junction table for library table and checkedOutLibraryCatalogItems
    //private Map<Person, LibraryCatalogItem> checkedOutLibraryCatalogItems;

    //TODO need to create junction table for library table and listOfCustomers
    //private List<Person> listOfCustomers;

}
