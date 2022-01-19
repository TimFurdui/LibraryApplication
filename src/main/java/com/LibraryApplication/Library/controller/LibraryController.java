package com.LibraryApplication.Library.controller;

import com.LibraryApplication.Library.model.Library;
import com.LibraryApplication.Library.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NonUniqueResultException;
import javax.swing.text.html.Option;
import java.util.Optional;

@Controller
@RequestMapping(path = "/library")
public class LibraryController {

    @Autowired
    private LibraryRepository libraryRepository;

    //Didn't want to combine add and update functionality, as it would allow customer to accidentally overwrite already existing entry. Also, separation of concerns.
    @PostMapping(path = "/addLibrary")
    public @ResponseBody
    String addLibrary(@RequestParam String name, @RequestParam String address, @RequestParam String email, @RequestParam int phoneNumber) {
        Library library = new Library();
        library.setName(name);
        library.setAddress(address);
        library.setEmail(email);
        library.setPhoneNumber(phoneNumber);

        if (getLibraryByName(name).isEmpty()) {
            libraryRepository.save(library);
            return "Saved library to DB";
        }
        return "Didn't save library, as library with same name already exists";
    }

    @GetMapping("/viewLibraries")
    public @ResponseBody
    Iterable<Library> viewLibraryCatalog() {
        return libraryRepository.findAll();
    }

    @GetMapping("/getLibraryById/{id}")
    public @ResponseBody
    Optional<Library>
    getLibraryById(@PathVariable Integer id) {
        return libraryRepository.findById(id);
    }

    @GetMapping("/getLibraryByName/{name}")
    public @ResponseBody
    Optional<Library>
    getLibraryByName(@PathVariable String name) {
        Optional<Library> library;
        try {
            library = libraryRepository.findByName(name);
        } catch (NonUniqueResultException nonUniqueResultException) {
            return Optional.empty();
        }
        return library;
    }

    @PostMapping(path = "/updateLibrary")
    public @ResponseBody
    String updateLibrary(@RequestParam String name, @RequestParam String address, @RequestParam String email, @RequestParam int phoneNumber) {
        Optional<Library> libraryFromDb = libraryRepository.findByName(name);
        if (libraryFromDb.isPresent()) {
            //TODO need to change code to find entry to edit
            Library library = libraryFromDb.get();
            library.setName(name);
            library.setAddress(address);
            library.setEmail(email);
            library.setPhoneNumber(phoneNumber);

            libraryRepository.save(library);
            return "Updated Library";
        }

        return "Library not present; no update performed.";
    }


    @DeleteMapping("/deleteLibraryById/{id}")
    public @ResponseBody
    String
    deleteLibraryById(@PathVariable Integer id) {

        Optional<Library> library = libraryRepository.findById(id);
        library.ifPresent(value -> libraryRepository.delete(value));
        return "Deleted Library with name: " + library.get().getName();
    }

    @DeleteMapping("/deleteLibraryByName/{name}")
    public @ResponseBody
    String
    deleteLibraryByName(@PathVariable String name) {

        Optional<Library> library = libraryRepository.findByName(name);
        library.ifPresent(value -> libraryRepository.delete(value));
        return "Deleted Library with name: " + library.get().getName();
    }


}
