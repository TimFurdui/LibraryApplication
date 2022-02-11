package com.LibraryApplication.Library.model.CheckedOutLibraryCatalogItems;

import com.LibraryApplication.Library.model.LibraryCatalogItems.Book;
import com.LibraryApplication.Persons.Model.Person;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class PersonCheckedOutBooks {

    public PersonCheckedOutBooks() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "person_id")
    Person persons;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "book_id")
    Book books;
}
