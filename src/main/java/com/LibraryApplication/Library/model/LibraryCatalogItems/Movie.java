package com.LibraryApplication.Library.model.LibraryCatalogItems;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2")

public class Movie extends LibraryCatalogItem {
    private final double movieDuration;
    private final String director;

    public Movie(double movieDuration, String director) {
        this.movieDuration = movieDuration;
        this.director = director;
    }

    public double getMovieDuration() {
        return movieDuration;
    }

    public String getDirector() {
        return director;
    }

    @Override
    public String toString() {
        return super.toString() + "Movie{" +
                "movieDuration= " + movieDuration +
                "director= " + director +
                '}';
    }
}
