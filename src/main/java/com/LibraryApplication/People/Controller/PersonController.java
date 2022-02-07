package com.LibraryApplication.People.Controller;

import com.LibraryApplication.Library.model.Library;
import com.LibraryApplication.Library.repository.LibraryRepository;
import com.LibraryApplication.People.Model.Person;
import com.LibraryApplication.People.Model.PersonRole;
import com.LibraryApplication.People.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NonUniqueResultException;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping(path = "/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private LibraryRepository libraryRepository;

    @PostMapping(path = "/addNewPerson")
    public @ResponseBody
    String addNewPerson(@RequestParam String firstName, @RequestParam(required = false) String middleName,
                        @RequestParam String lastName, @RequestParam String address,
                        @RequestParam String email, @RequestParam Integer age,
                        @RequestParam Integer phoneNumber, @RequestParam String role, @RequestParam String libraryName) {

        Person person = new Person(firstName, middleName, lastName,
                address, email, age, phoneNumber);

        if (PersonRole.get(role).isPresent())
            person.setRole(PersonRole.get(role).get());

        if(assignLibraryToPerson(libraryName).isPresent())
        person.setLibrary(assignLibraryToPerson(libraryName).get());

        if (getPersonByNumber(phoneNumber).isEmpty()) {
            personRepository.save(person);
            return "Saved Person to Library DB";
        }
        return "Didn't save person, as person with same number already exists. Please use update if you intend to update entity";
    }

    @GetMapping("/getPeopleByPhone/{phoneNumber}")
    public @ResponseBody
    Optional<Person>
    getPersonByNumber(@PathVariable Integer phoneNumber) {
        Optional<Person> person;
        try {
            person = personRepository.findByPhoneNumber(phoneNumber);
        } catch (NonUniqueResultException nonUniqueResultException) {
            return Optional.empty();
        }
        return person;
    }

    private Optional<Library> assignLibraryToPerson(String libraryName) {
        Optional<Library> library = Optional.empty();

        if (libraryName != null && !libraryName.isEmpty())
            try {
                library = libraryRepository.findByName(libraryName);
            } catch (NonUniqueResultException nonUniqueResultException) {
                return Optional.empty();
            }
        return library;
    }

}
