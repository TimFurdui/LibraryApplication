package com.LibraryApplication.Library.model.LibraryCatalogItems;


import javax.persistence.*;

@Entity
//@DiscriminatorValue("CD")

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
