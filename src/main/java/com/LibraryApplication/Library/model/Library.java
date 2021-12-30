package com.LibraryApplication.Library.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class
















































































































































































































































Library {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer phoneNumber;
    private String name, address, email;

        //TODO need to create junction table for library table and libraryCatalogItems
    //private List<LibraryCatalogItem> libraryCatalogItems;
    private String libraryCatalogItems;

        //TODO need to create junction table for library table and checkedOutLibraryCatalogItems
    //private Map<Person, LibraryCatalogItem> checkedOutLibraryCatalogItems;

        //TODO need to create junction table for library table and listOfCustomers
    //private List<Person> listOfCustomers;
    private String listOfCustomers;


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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
