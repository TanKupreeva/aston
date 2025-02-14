package org.example.menu.selectaction;

import org.example.entity.Book;
import org.example.entity.comparators.book.ComparatorBook;
import org.example.entity.comparators.book.defaultt.DefaultComparatorBook;
import org.example.finder.FinderBook;
import org.example.menu.SelectSort;
import org.example.menu.fillcollection.FillCollectionBook;

import java.io.BufferedReader;
import java.util.List;

public class SelectActionBook extends SelectAction<Book> {
    public SelectActionBook(BufferedReader bufferedReader, List<Book> list) {
        super(bufferedReader,
                Book.class,
                list,
                new FillCollectionBook(bufferedReader, list),
                new FinderBook(bufferedReader, list, new DefaultComparatorBook().getComparator()),
                new SelectSort<>(bufferedReader, list, Book.class, new ComparatorBook(), (i) -> (i.getPages() % 2 == 0)));
    }
}
