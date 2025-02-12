package org.example.menu.selectaction;

import org.example.entity.Book;
import org.example.entity.comparators.book.BookComparator;
import org.example.finder.FinderBook;
import org.example.menu.fillcollection.FillCollectionBook;

import java.io.BufferedReader;
import java.util.List;

public class SelectActionBook extends SelectAction<Book> {
    public SelectActionBook(BufferedReader bufferedReader, List<Book> list) {
        super(bufferedReader,
                Book.class,
                list,
                new FillCollectionBook(bufferedReader, list),
                new FinderBook(bufferedReader, list, new BookComparator().getComparator()),
                new BookComparator());
    }
}
