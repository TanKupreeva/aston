package org.example.entity.comparators.book.defaultt;

import org.example.entity.Book;

import java.util.Comparator;

public class DefaultComparatorBookTitle implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        return o1.getTitle().compareToIgnoreCase(o2.getTitle());
    }
}
