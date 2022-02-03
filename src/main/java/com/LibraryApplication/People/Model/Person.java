package com.LibraryApplication.People.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Person {

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

}
