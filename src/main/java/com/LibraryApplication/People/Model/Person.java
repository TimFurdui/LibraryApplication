package com.LibraryApplication.People.Model;

import com.LibraryApplication.Library.model.Library;
import com.LibraryApplication.Library.model.LibraryCatalogItems.Book;
import com.LibraryApplication.Library.model.LibraryCatalogItems.CD;
import com.LibraryApplication.Library.model.LibraryCatalogItems.LibraryCatalogItem;
import com.LibraryApplication.Library.model.LibraryCatalogItems.Movie;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//Each person has one library

@Entity
public class Person {

    @Id
    @Column(name = "pk_person")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer pkPerson;

    @Getter
    @Setter
    private String firstName, middleName, lastName, address, email;

    @Getter
    @Setter
    private Integer age, phoneNumber;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    private PersonRole role;

    @Getter
    @Setter
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "library_fkd")
    private Library library;

    @ManyToMany(cascade = CascadeType.ALL)
    List<Book> checkedOutBooks;
    @ManyToMany(cascade = CascadeType.ALL)
    List<CD> checkedOutCds;
    @ManyToMany(cascade = CascadeType.ALL)
    List<Movie> checkedOutMovies;

    public Person() {
    }

    public Person(String firstName, String middleName, String lastName,
                  String address, String email,
                  Integer age, Integer phoneNumber) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public Person(String firstName, String middleName, String lastName,
                  String address, String email,
                  Integer age, Integer phoneNumber, PersonRole role) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }


}
