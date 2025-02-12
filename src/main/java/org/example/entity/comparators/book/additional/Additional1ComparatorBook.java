package org.example.entity.comparators.book.additional;

import org.example.entity.Book;

import java.util.Comparator;

public class Additional1ComparatorBook {


    private final Comparator<Book> comparator;

    public Additional1ComparatorBook() {
        comparator = new Additional1ComparatorBookPages();
    }

    public Comparator<Book> getComparator() {
        return comparator;
    }

}
