package org.example.entity.comparators.book;

import org.example.entity.Book;
import org.example.entity.comparators.AllComparator;

public class BookComparator extends AllComparator<Book> {
    public BookComparator() {
        super(new BookAuthorComparator()
                .thenComparing(new BookTitleComparator())
                .thenComparing(new BookPagesComparator()));
    }
}
