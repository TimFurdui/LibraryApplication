package com.LibraryApplication.Library.controller;

import com.LibraryApplication.Library.model.Library;
import com.LibraryApplication.Library.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/library")
public class LibraryController {

    @Autowired
    private LibraryRepository libraryRepository;

    @PostMapping(path="/addLibrary")
    public @ResponseBody
    String addNewLibrary (@RequestParam String name, @RequestParam String address, @RequestParam String email, @RequestParam int phoneNumber) {
        Library library = new Library();
        library.setName(name);
        library.setAddress(address);
        library.setEmail(email);
        library.setPhoneNumber(phoneNumber);

        libraryRepository.save(library);

        return "Saved library to DB";
    }

    @GetMapping("/viewLibraries")
    public @ResponseBody Iterable<Library> viewLibraryCatalog(){
        return libraryRepository.findAll();
    }

    //TODO create update method

    //TODO create delete method
}
