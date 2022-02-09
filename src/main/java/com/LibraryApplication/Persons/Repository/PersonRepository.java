package com.LibraryApplication.People.Repository;

import com.LibraryApplication.People.Model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {
    public Optional<Person> findByPhoneNumber (Integer phoneNumber);
}
