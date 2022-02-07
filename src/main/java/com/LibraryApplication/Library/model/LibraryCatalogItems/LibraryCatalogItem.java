package com.LibraryApplication.Library.model.LibraryCatalogItems;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

//I had an issue with using SingleTable Inheritance Mapping when it came to using ForeignKey,
// so instead of persisting the whole class hierarchy (the parent class to the DB and inserting the subclass
// entities in the parent class table), I decided to use the MappedSuperClass so each child class will have an
// table while the superclass will not.
@MappedSuperclass
public abstract class LibraryCatalogItem {

    @Id
    @Column(name = "catalog_item_primary_key")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer Id;


    //declared private for encapsulation
    @Getter
    @Setter
    protected String title, genre;

    protected Integer libraryFk;
    
    @Getter
    @Setter
    protected Integer itemQuantity;


    protected LibraryCatalogItem() {
    }

    @Override
    public String toString() {
        return "LibraryCatalogItem{" +
                "title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", id=" + Id +
                '}';
    }

}
