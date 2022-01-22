package com.LibraryApplication.Library.model.LibraryCatalogItems;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CD")

public class CD extends LibraryCatalogItem {
    private double duration = -1;
    private String artist = "";

    public CD(double duration, String artist) {
        super();
        this.duration = duration;
        this.artist = artist;
    }

    public CD() {
    }

    @Override
    public String toString() {
        return super.toString() + " CD{" +
                "duration= " + duration +
                "artist= " + artist +
                '}';
    }
}
