package com.LibraryApplication.Library.model.LibraryCatalogItems;

import javax.persistence.*;

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

    @JoinColumn(name = "library_fk"/*, nullable = false*/)
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