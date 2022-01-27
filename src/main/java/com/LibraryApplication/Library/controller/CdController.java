package com.LibraryApplication.Library.controller;

import com.LibraryApplication.Library.model.LibraryCatalogItems.CD;
import com.LibraryApplication.Library.model.LibraryCatalogItems.LibraryCatalogItem;
import com.LibraryApplication.Library.repository.CdRepository;
import com.LibraryApplication.Library.repository.LibraryCatalogItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NonUniqueResultException;
import java.util.Optional;

@Controller
@RequestMapping(path = "/cd")
public class CdController {

    @Autowired
    private LibraryCatalogItemsRepository libraryCatalogItemsRepository;

    @Autowired
    private com.LibraryApplication.Library.repository.CdRepository CdRepository;


    @PostMapping(path = "/addNewCd")
    public @ResponseBody
        //TODO map libraryId to a library in the library table
        //TODO different ways of doing this is by creating method that takes in name and queries DB for library row with name then sets the primaryKey to that row
        //TODO or I can just make the user supply the primaryKey
    String addNewCd(@RequestParam(required = false) Integer LibraryId, @RequestParam String title, @RequestParam String genre, @RequestParam Double duration, @RequestParam String artist) {

        CD cd = new CD(duration, artist);
        cd.setTitle(title);
        cd.setGenre(genre);

        if (getCdByName(title).isEmpty()) {
            libraryCatalogItemsRepository.save(cd);
            return "Saved CD to Library DB";

        }
        return "Didn't save CD, as CD with same name already exists. Please use update if you intend to update entity.";
    }

    //Todo returning all entities not just CD's
    @GetMapping("/getCds")
    public @ResponseBody
    Iterable<LibraryCatalogItem> getCds() {
        return CdRepository.getCds();
    }

    @GetMapping(path = "/getCdById/{id}")
    public @ResponseBody
    Optional<LibraryCatalogItem>
    getCdById(@PathVariable Integer id) {
        return libraryCatalogItemsRepository.findById(id);
    }

    @GetMapping("/getCdByName/{name}")
    public @ResponseBody
    Optional<LibraryCatalogItem>
    getCdByName(@PathVariable String title) {
        Optional<LibraryCatalogItem> cd;
        try {
            cd = libraryCatalogItemsRepository.findByTitle(title);
        } catch (NonUniqueResultException nonUniqueResultException) {
            return Optional.empty();
        }
        return cd;
    }

    @PostMapping(path = "/updateCd")
    public @ResponseBody
    String updateCd(@RequestParam String title, @RequestParam(required = false) String newTitle, @RequestParam String genre, @RequestParam double duration, @RequestParam String author) {
        Optional<LibraryCatalogItem> cdFromDb = libraryCatalogItemsRepository.findByTitle(title);
        if (cdFromDb.isPresent()) {
            CD cd = new CD(duration, author);
            cd.setGenre(genre);
            cd.setTitle(newTitle);

            libraryCatalogItemsRepository.save(cd);
            return "Updated CD";
        }

        return "CD not found; no update performed.";
    }

    @DeleteMapping("/deleteCdById/{id}")
    public @ResponseBody
    String
    deleteCdById(@PathVariable Integer id) {
        Optional<LibraryCatalogItem> cd = libraryCatalogItemsRepository.findById(id);
        cd.ifPresent(value -> libraryCatalogItemsRepository.delete(value));
        return "Deleted Library with name: " + cd.get().getTitle();
    }

    @DeleteMapping("/deleteCdByName/{name}")
    public @ResponseBody
    String
    deleteCdByName(@PathVariable String name) {

        Optional<LibraryCatalogItem> cd = libraryCatalogItemsRepository.findByTitle(name);
        cd.ifPresent(value -> libraryCatalogItemsRepository.delete(value));
        return "Deleted Library with name: " + cd.get().getTitle();
    }

}
