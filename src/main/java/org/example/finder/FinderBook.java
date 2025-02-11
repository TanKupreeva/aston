package org.example.finder;

import org.example.entity.Book;
import org.example.utils.soututils.GetValueBook;

import java.io.BufferedReader;
import java.util.Comparator;
import java.util.List;

public class FinderBook extends Finder<Book> {
    public FinderBook(BufferedReader bufferedReader, List<Book> originalList, Comparator<Book> comparator) {
        super(bufferedReader,
                originalList,
                new GetValueBook(bufferedReader),
                comparator);
    }
}
