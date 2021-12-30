package com.LibraryApplication.Library.model.LibraryCatalogItems;

public class CD extends LibraryCatalogItem {
    private final double trackDuration;

    public CD(double trackDuration) {
        super();
        this.trackDuration = trackDuration;
    }


    @Override
    public String toString() {
        return super.toString() + " CD{" +
                "trackDuration=" + trackDuration +
                '}';
    }
}
