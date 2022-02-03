package com.LibraryApplication.People.Repository;

import com.LibraryApplication.People.Model.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person, Integer> {
    public Optional<Person> findByPhoneNumber (Integer phoneNumber);
}
