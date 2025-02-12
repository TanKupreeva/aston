package org.example.entity.comparators.book;

import org.example.entity.Book;
import org.example.entity.comparators.AllComparator;
import org.example.entity.comparators.book.additional.Additional1ComparatorBook;
import org.example.entity.comparators.book.defaultt.DefaultComparatorBook;

import java.util.Comparator;

public class ComparatorBook extends AllComparator<Book> {
    public ComparatorBook(Comparator<Book> comparatorDefault, Comparator<Book> comparatorAdditional) {
        super(new DefaultComparatorBook().getComparator(), new Additional1ComparatorBook().getComparator());
    }

}
