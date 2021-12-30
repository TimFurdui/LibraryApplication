package com.LibraryApplication.Library.view;

import com.LibraryApplication.Library.model.LibraryCatalogItems.LibraryCatalogItem;

public class LibraryView {

    public LibraryView() {
    }

    public void printLibraryCatalogItem(LibraryCatalogItem libraryCatalogItem) {
        System.out.println(libraryCatalogItem.toString());
    }
}
