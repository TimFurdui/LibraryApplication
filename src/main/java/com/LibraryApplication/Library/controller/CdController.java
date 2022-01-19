package com.LibraryApplication.Library.controller;

import com.LibraryApplication.Library.model.LibraryCatalogItems.CD;
import com.LibraryApplication.Library.repository.LibraryCatalogItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/cd")
public class CdController {
    @Autowired
    private LibraryCatalogItemsRepository libraryCatalogItemsRepository;

    @PostMapping(path = "/addNewCd")
    public @ResponseBody
        //TODO map libraryId to a library in the library table
        //TODO different ways of doing this is by creating method that takes in name and queries DB for library row with name then sets the primaryKey to that row
        //TODO or I can just make the user supply the primaryKey
    String addNewCd(@RequestParam(required = false) Integer LibraryId, @RequestParam String title, @RequestParam String genre, @RequestParam Double duration, @RequestParam String artist) {

        CD cd = new CD(duration, artist);
        cd.setTitle(title);
        cd.setGenre(genre);

        libraryCatalogItemsRepository.save(cd);
        // https://www.baeldung.com/spring-new-requestmapping-shortcuts
        return "Saved CD to Library DB";
    }
}
