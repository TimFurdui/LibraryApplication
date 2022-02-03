package com.LibraryApplication.People.Model;

import java.util.Arrays;
import java.util.Optional;

public enum PersonRole {
    LIBRARIAN("Librarian"),
    CUSTOMER("Customer"),
    ADMINISTRATOR("Admin");

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
