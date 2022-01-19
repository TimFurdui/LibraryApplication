package com.LibraryApplication.Library.model;

import com.LibraryApplication.Library.model.LibraryCatalogItems.LibraryCatalogItem;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Integer libraryId;

    @Getter
    @Setter
    private Integer phoneNumber;

    @Getter
    @Setter
    private String name, address, email;
    //TODO make libraryId foreign key relate to LibraryCtalogItem Table
    @OneToMany(mappedBy = "library")
    private Set<LibraryCatalogItem> libraryCatalogItems;

    //TODO need to create junction table for library table and checkedOutLibraryCatalogItems
    //private Map<Person, LibraryCatalogItem> checkedOutLibraryCatalogItems;

    //TODO need to create junction table for library table and listOfCustomers
    //private List<Person> listOfCustomers;


//    public List<LibraryCatalogItem> getLibraryCatalogItems() {
//        return libraryCatalogItems;
//    }
//
//    public void setLibraryCatalogItems(List<LibraryCatalogItem> libraryCatalogItems) {
//        this.libraryCatalogItems = libraryCatalogItems;
//    }
//
//    public Map<Person, LibraryCatalogItem> getCheckedOutLibraryCatalogItems() {
//        return checkedOutLibraryCatalogItems;
//    }
//
//    public void setCheckedOutLibraryCatalogItems(Map<Person, LibraryCatalogItem> checkedOutLibraryCatalogItems) {
//        this.checkedOutLibraryCatalogItems = checkedOutLibraryCatalogItems;
//    }

//    public List<Person> getListOfCustomers() {
//        return listOfCustomers;
//    }
//
//    public void setListOfCustomers(List<Person> listOfCustomers) {
//        this.listOfCustomers = listOfCustomers;
//    }

}
