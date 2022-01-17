package com.LibraryApplication.Library.model.LibraryCatalogItems;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("3")

public class CD extends LibraryCatalogItem {
    private final double duration;
    private final String artist;

    public CD(double duration, String artist) {
        super();
        this.duration = duration;
        this.artist = artist;
    }


    @Override
    public String toString() {
        return super.toString() + " CD{" +
                "duration=" + duration +
                '}';
    }
}
