package org.example.entity.comparators.book.defaultt;

import org.example.entity.Book;

import java.util.Comparator;

public class DefaultComparatorBookPages implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        return Integer.compare(o1.getPages(), o2.getPages());
    }
}
