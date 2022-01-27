package com.LibraryApplication.Library.model.LibraryCatalogItems;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Book")

public class Book extends LibraryCatalogItem {
    private String ISBN = "", author = "";

    public Book(String isbn, String author) {
        super();
        this.ISBN = isbn;
        this.author = author;
    }

    public Book() {

    }

    public Book(Integer libraryId, String isbn, String author) {
        super();
        this.libraryFk = libraryId;
        this.ISBN = isbn;
        this.author = author;
    }
//    @ManyToOne(targetEntity = Library.class)
//    @JoinColumn(name = "library_id", nullable = false)
//    protected Integer libraryId;

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