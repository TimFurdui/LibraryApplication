package com.LibraryApplication.People.Model;

import com.LibraryApplication.Library.model.Library;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

//Each person has one library

@Entity
public class Person {

    @Id
    @Column(name = "person_primary_key")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer personPrimaryKey;

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
    @JoinColumn(name = "library_fk")
    private Library library;

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
