package com.LibraryApplication.Library.model.LibraryCatalogItems;

import lombok.Getter;

import javax.persistence.*;

@Entity

public class Movie extends LibraryCatalogItem {
    @Getter
    private double duration = -1;
    @Getter
    private String director = "";

    public Movie() {
    }

    //libraryId is the foreign key which represents the library that contains this catalogItem
    public Movie(double duration, String director) {
        this.duration = duration;
        this.director = director;
    }

    public Movie(Integer libraryId, double duration, String director) {
        super();
        this.libraryFk = libraryId;
        this.duration = duration;
        this.director = director;
    }

//    @ManyToOne(targetEntity = Movie.class, cascade= CascadeType.ALL)

    @Override
    public String toString() {
        return super.toString() + "Movie{" +
                "duration= " + duration +
                "director= " + director +
                '}';
    }
}
