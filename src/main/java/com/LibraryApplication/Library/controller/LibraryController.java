package com.LibraryApplication.Library.controller;

import com.LibraryApplication.Library.model.Library;
import com.LibraryApplication.Library.repository.LibraryCatalogItemsRepository;
import com.LibraryApplication.Library.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/library")
public class LibraryController {

    @Autowired
    private LibraryRepository libraryRepository;
    @Autowired
    private LibraryCatalogItemsRepository libraryCatalogItemsRepository;

    @PostMapping(path = "/addLibrary")
    public @ResponseBody
    String addNewLibrary(@RequestParam String name, @RequestParam String address, @RequestParam String email, @RequestParam int phoneNumber) {
        Library library = new Library();
        library.setName(name);
        library.setAddress(address);
        library.setEmail(email);
        library.setPhoneNumber(phoneNumber);

        libraryRepository.save(library);

        return "Saved library to DB";
    }

    @GetMapping("/viewLibraries")
    public @ResponseBody
    Iterable<Library> viewLibraryCatalog() {
        return libraryRepository.findAll();
    }

    @PostMapping(path = "/addNewLibraryCatalogItem/optional/")
    public @ResponseBody
    String addNewLibraryCatalogItem(@RequestParam String title, @RequestParam String genre, @RequestParam String director, @RequestParam double movieDuration, @RequestParam String ISBN, @RequestParam String Author, @RequestParam String trackDuration) {
        //TODO based on parameters passed in set fields accordingly
        // DO THIS NEXT
        // https://www.baeldung.com/spring-new-requestmapping-shortcuts
        return "Saved library to DB";
    }

    @GetMapping("/getLibraryById/{id}")
    public @ResponseBody Optional<Library>
    getLibraryById(@PathVariable Integer id){
        return libraryRepository.findById(id);
    }


    //TODO create update method

    //TODO create delete method
}
