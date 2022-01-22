package com.LibraryApplication.Library.model.LibraryCatalogItems;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Movie")

public class Movie extends LibraryCatalogItem {
    private double duration = -1;
    private String director = "";

    public Movie(double duration, String director) {
        this.duration = duration;
        this.director = director;
    }

    public Movie() {
    }

    public double getDuration() {
        return duration;
    }

    public String getDirector() {
        return director;
    }

    @Override
    public String toString() {
        return super.toString() + "Movie{" +
                "duration= " + duration +
                "director= " + director +
                '}';
    }
}
