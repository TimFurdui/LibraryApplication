package com.LibraryApplication.Library.model.LibraryCatalogItems;

import com.LibraryApplication.Library.model.CheckedOutLibraryCatalogItems.PersonCheckedOutBooks;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book extends LibraryCatalogItem {
    @Getter
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

    @OneToMany(mappedBy = "books")
    List<PersonCheckedOutBooks> books;

    @Override
    public String toString() {
        return super.toString() + " Book{" +
                "ISBN= " + ISBN +
                "Author= " + author +
                '}';
    }
}