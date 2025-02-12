package org.example.entity.comparators.book;

import org.example.entity.Book;
import org.example.entity.comparators.AllComparator;
import org.example.entity.comparators.book.additional.Additional1ComparatorBook;
import org.example.entity.comparators.book.defaultt.DefaultComparatorBook;

public class ComparatorBook extends AllComparator<Book> {
    public ComparatorBook() {
        super(new DefaultComparatorBook().getComparator(),
                new Additional1ComparatorBook().getComparator());
    }

}
