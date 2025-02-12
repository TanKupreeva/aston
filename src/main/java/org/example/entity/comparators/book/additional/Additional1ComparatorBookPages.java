package org.example.entity.comparators.book.additional;

import org.example.entity.Book;

import java.util.Comparator;

import static org.example.entity.comparators.AllComparator.isBothOrSwitch;

public class Additional1ComparatorBookPages implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        boolean isEven1 = o1.getPages() % 2 == 0;
        boolean isEven2 = o2.getPages() % 2 == 0;
        int other = Integer.compare(o1.getPages(), o2.getPages());
        return isBothOrSwitch(isEven1, isEven2, other);
    }
}
