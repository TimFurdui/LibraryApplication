package com.LibraryApplication.Library.model;

import com.LibraryApplication.Library.model.LibraryCatalogItems.Book;
import com.LibraryApplication.Library.model.LibraryCatalogItems.CD;
import com.LibraryApplication.Library.model.LibraryCatalogItems.Movie;
import com.LibraryApplication.Persons.Model.Person;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
public class Library {

    @Id
    @Column(name = "pkLibrary")
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer libraryPrimaryKey;

    @Getter
    @Setter
    private Integer phoneNumber;

    @Getter
    @Setter
    private String name, address, email;

    @OneToMany(mappedBy = "libraryFk", targetEntity = Book.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Book> booksList;

    @OneToMany(mappedBy = "libraryFk", targetEntity = CD.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Book> cdsList;

    @OneToMany(mappedBy = "libraryFk", targetEntity = Movie.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Book> moviesList;

    @OneToMany(mappedBy="library", targetEntity = Person.class, cascade = CascadeType.ALL)
    private List<Person> listOfPersons;

}
