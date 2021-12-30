package com.LibraryApplication.Library.model.LibraryCatalogItems;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Created class abstract so this class can't be implemented
@Entity
public abstract class LibraryCatalogItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long catalogId;

    //declared private for encapsulation
    protected String title, genre;

    protected LibraryCatalogItem() {
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public long getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    @Override
    public String toString() {
        return "LibraryCatalogItem{" +
                "title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", catalogId=" + catalogId +
                '}';
    }
}
