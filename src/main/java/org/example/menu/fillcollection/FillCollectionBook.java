package org.example.menu.fillcollection;

import org.example.entity.Book;
import org.example.filling.fromfile.FillerFromFileBook;
import org.example.filling.manual.FillerManualBook;
import org.example.filling.random.FillerRandomBook;

import java.io.BufferedReader;
import java.util.List;

public class FillCollectionBook extends FillCollection<Book> {
    public FillCollectionBook(BufferedReader bufferedReader, List<Book> list) {
        super(bufferedReader, Book.class,
                new FillerFromFileBook(bufferedReader, list),
                new FillerRandomBook(bufferedReader, list),
                new FillerManualBook(bufferedReader, list));
    }
}
