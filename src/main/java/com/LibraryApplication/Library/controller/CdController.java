package com.LibraryApplication.Library.controller;

import com.LibraryApplication.Library.model.LibraryCatalogItems.CD;
import com.LibraryApplication.Library.repository.CdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NonUniqueResultException;
import java.util.Optional;

@Controller
@RequestMapping(path = "/cd")
public class CdController {

    @Autowired
    private CdRepository cdRepository;

    @PostMapping(path = "/addNewCd")
    public @ResponseBody
    String addNewCd(@RequestParam(required = false) Integer LibraryId, @RequestParam String title, @RequestParam String genre, @RequestParam Double duration, @RequestParam String artist) {

        CD cd = new CD(duration, artist);
        cd.setTitle(title);
        cd.setGenre(genre);

        if (getCdByName(title).isEmpty()) {
            cdRepository.save(cd);
            return "Saved CD to Library DB";

        }
        return "Didn't save CD, as CD with same name already exists. Please use update if you intend to update entity.";
    }

    @GetMapping("/getCds")
    public @ResponseBody
    Iterable<CD> getCds() {
        return cdRepository.findAll();
    }

    @GetMapping(path = "/getCdById/{id}")
    public @ResponseBody
    Optional<CD>
    getCdById(@PathVariable Integer id) {
        return cdRepository.findById(id);
    }

    @GetMapping("/getCdByName/{name}")
    public @ResponseBody
    Optional<CD>
    getCdByName(@PathVariable String title) {
        Optional<CD> cd;
        try {
            cd = cdRepository.findByTitle(title);
        } catch (NonUniqueResultException nonUniqueResultException) {
            return Optional.empty();
        }
        return cd;
    }

    @PostMapping(path = "/updateCd")
    public @ResponseBody
    String updateCd(@RequestParam String title, @RequestParam(required = false) String newTitle, @RequestParam String genre, @RequestParam double duration, @RequestParam String author) {
        Optional<CD> cdFromDb = cdRepository.findByTitle(title);
        if (cdFromDb.isPresent()) {
            CD cd = new CD(duration, author);
            cd.setGenre(genre);
            cd.setTitle(newTitle);

            cdRepository.save(cd);
            return "Updated CD";
        }

        return "CD not found; no update performed.";
    }

    @DeleteMapping("/deleteCdById/{id}")
    public @ResponseBody
    String
    deleteCdById(@PathVariable Integer id) {
        Optional<CD> cd = cdRepository.findById(id);
        cd.ifPresent(value -> cdRepository.delete(value));
        return "Deleted Library with name: " + cd.get().getTitle();
    }

    @DeleteMapping("/deleteCdByName/{name}")
    public @ResponseBody
    String
    deleteCdByName(@PathVariable String name) {

        Optional<CD> cd = cdRepository.findByTitle(name);
        cd.ifPresent(value -> cdRepository.delete(value));
        return "Deleted Library with name: " + cd.get().getTitle();
    }

}
