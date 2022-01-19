package com.LibraryApplication.Library.model.LibraryCatalogItems;

import com.LibraryApplication.Library.model.Library;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

//Created class abstract so this class can't be implemented
@Entity
//Implemented Single Table strategy for Hibernate Inheritance Mapping and used Discriminator values to identify different records
@DiscriminatorColumn(name="library_catalog_item_type", discriminatorType = DiscriminatorType.STRING)
public abstract class LibraryCatalogItem {

    @Id
    @Column(name="catalog_item_primary_key")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer Id;

    //declared private for encapsulation
    @Getter
    @Setter
    protected String title, genre;

    @ManyToOne
    @JoinColumn(name = "library_id", nullable = false, referencedColumnName = "libraryId")
    private Library library;

    protected LibraryCatalogItem() {
    }

    @Override
    public String toString() {
        return "LibraryCatalogItem{" +
                "title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", catalogId=" + Id +
                '}';
    }
}
