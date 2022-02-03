package com.LibraryApplication.Library.model.LibraryCatalogItems;


import lombok.Getter;

import javax.persistence.*;

@Entity
public class CD extends LibraryCatalogItem {
    @Getter
    private double duration = -1;
    @Getter
    private String artist = "";

    public CD(double duration, String artist) {
        super();
        this.duration = duration;
        this.artist = artist;
    }

    public CD() {
    }

    @JoinColumn(name = "library_fk"/*, nullable = false*/) //TODO uncomment nullable = false, once I figure out how to have foreign key
    @ManyToOne(targetEntity = CD.class, cascade= CascadeType.ALL)

    @Override
    public String toString() {
        return super.toString() + " CD{" +
                "duration= " + duration +
                "artist= " + artist +
                '}';
    }
}
