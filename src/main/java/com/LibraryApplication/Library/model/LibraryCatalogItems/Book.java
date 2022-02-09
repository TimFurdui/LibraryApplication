package com.LibraryApplication.Library.model.LibraryCatalogItems;

import com.LibraryApplication.People.Model.Person;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book extends LibraryCatalogItem {
    private String ISBN = "", author = "";

    public Book() {
    }

    public Book(String isbn, String author) {
        super();
        this.ISBN = isbn;
        this.author = author;
    }

    public Book(Integer libraryId, String isbn, String author) {
        super();
        this.libraryFk = libraryId;
        this.ISBN = isbn;
        this.author = author;
    }

    @ManyToOne(targetEntity = Book.class, cascade = CascadeType.ALL)

    public String getISBN() {
        return ISBN;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return super.toString() + " Book{" +
                "ISBN= " + ISBN +
                "Author= " + author +
                '}';
    }
}