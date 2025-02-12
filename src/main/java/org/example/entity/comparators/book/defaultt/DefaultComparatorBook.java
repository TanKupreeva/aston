package org.example.entity.comparators.book.defaultt;

import org.example.entity.Book;

import java.util.Comparator;

public class DefaultComparatorBook {

    private final Comparator<Book> comparator;

    public DefaultComparatorBook() {
        comparator = new DefaultComparatorBookAuthor()
                .thenComparing(new DefaultComparatorBookTitle())
                .thenComparing(new DefaultComparatorBookPages());
    }

    public Comparator<Book> getComparator() {
        return comparator;
    }

}
