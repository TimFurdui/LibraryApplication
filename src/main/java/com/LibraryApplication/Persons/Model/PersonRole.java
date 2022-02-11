package com.LibraryApplication.Persons.Model;

import java.util.Arrays;
import java.util.Optional;

public enum PersonRole {
    LIBRARIAN("LIBRARIAN"),
    CUSTOMER("CUSTOMER"),
    ADMINISTRATOR("ADMIN");

    private final String role;

    PersonRole(String role){
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public static Optional<PersonRole> get(String thisRole){
        return Arrays.stream(PersonRole.values())
                .filter(personRole -> personRole.role.equals(thisRole))
                .findFirst();
    }
}
