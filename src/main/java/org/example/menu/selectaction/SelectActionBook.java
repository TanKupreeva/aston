package org.example.menu.selectaction;

import org.example.entity.Book;
import org.example.entity.comparators.book.BookComparator;
import org.example.menu.findcollection.FindCollection;
import org.example.menu.fillcollection.FillCollectionBook;
import org.example.menu.fillcollection.FillCollection;
import org.example.menu.findcollection.FindCollectionBook;

import java.io.BufferedReader;
import java.util.List;

public class SelectActionBook extends SelectAction<Book>{
    public SelectActionBook(BufferedReader bufferedReader, List<Book> list) {
//        FillCollection<Book> filler = new FillCollectionBook(bufferedReader, list);
//        FindCollection<Book> finder = new FindCollectionBook(bufferedReader, list));
//        super(bufferedReader, filler, finder);

        super(bufferedReader, Book.class,
                new FillCollectionBook(bufferedReader, list),
                new FindCollectionBook(bufferedReader, list),
                new BookComparator());
        this.list = list;
    }
}
