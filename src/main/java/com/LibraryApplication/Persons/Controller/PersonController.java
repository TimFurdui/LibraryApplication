package com.LibraryApplication.People.Controller;

import com.LibraryApplication.Library.model.Library;
import com.LibraryApplication.Library.model.LibraryCatalogItems.Book;
import com.LibraryApplication.Library.model.LibraryCatalogItems.LibraryCatalogItem;
import com.LibraryApplication.Library.repository.*;
import com.LibraryApplication.People.Model.Person;
import com.LibraryApplication.People.Model.PersonRole;
import com.LibraryApplication.People.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NonUniqueResultException;
import java.util.Optional;


@Controller
@RequestMapping(path = "/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CdRepository cdRepository;
    @Autowired
    private MovieRepository movieRepository;
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

        if (assignLibraryToPerson(libraryName).isPresent())
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

//TODO checkout BOOK, MOVIE, CD
    @GetMapping("/getCatalogItem/{itemCatalogPk}")
    public @ResponseBody Optional<? extends LibraryCatalogItem> checkIfLibraryCatalogItemExist(@PathVariable Integer itemCatalogPk) {

        if (bookRepository.existsById(itemCatalogPk))
            return bookRepository.findById(itemCatalogPk);

        if (cdRepository.existsById(itemCatalogPk))
            return cdRepository.findById(itemCatalogPk);

        return movieRepository.findById(itemCatalogPk);
    }

    //to checkout item

    //Check if all items are checkedOut
    // Query for all of a specific item in library
    // Check if count is >= item quantity
        // don't allow checkout
    //checkout
    // (query total num of items and compare to item quantity that a library has available)
    //

    @PostMapping(path="/checkoutItem")
    public @ResponseBody String checkOutItem(@RequestParam Integer personPk, @RequestParam Integer itemCatalogPk){
        return ":";
    }


}
