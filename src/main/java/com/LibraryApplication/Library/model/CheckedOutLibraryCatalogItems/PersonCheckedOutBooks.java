package com.LibraryApplication.Library.model.CheckedOutLibraryCatalogItems;

import com.LibraryApplication.Library.model.LibraryCatalogItems.Book;
import com.LibraryApplication.People.Model.Person;

import javax.persistence.*;

@Entity
public class PersonCheckedOutBooks {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    Person persons;

    @ManyToOne
    @JoinColumn(name = "book_id")
    Book books;
}
