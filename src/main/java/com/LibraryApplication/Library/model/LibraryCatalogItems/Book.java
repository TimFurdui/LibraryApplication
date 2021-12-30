package com.LibraryApplication.Library.model.LibraryCatalogItems;

public class Book extends LibraryCatalogItem {
    private final String ISBN, Author;

    public Book(String isbn, String author) {
        super();
        this.ISBN = isbn;
        this.Author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getAuthor() {
        return Author;
    }

    @Override
    public String toString() {
        return super.toString() + " Book{" +
                "ISBN=" + ISBN +
                '}';
    }
}