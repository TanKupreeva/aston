package org.example.menu.fillcollection;

import org.example.entity.Book;
import org.example.filling.fromfile.FromFileFiller;
import org.example.filling.fromfile.FromFileFillerBook;
import org.example.filling.manual.ManualFiller;
import org.example.filling.manual.ManualFillerBook;
import org.example.filling.random.RandomFiller;
import org.example.filling.random.RandomFillerBook;

import java.io.BufferedReader;
import java.util.List;

public class FillCollectionBook extends FillCollection<Book> {
    public FillCollectionBook(BufferedReader bufferedReader, List<Book> list) {
//        FromFileFiller<Book> fromFileFiller = new FromFileFillerBook(list);
//        RandomFiller<Book> randomFiller = new RandomFillerBook(list);
//        ManualFiller<Book> manualFiller = new ManualFillerBook(list);
//        super(bufferedReader, fromFileFiller, randomFiller, manualFiller);

        super(bufferedReader, new FromFileFillerBook(bufferedReader, list), new RandomFillerBook(bufferedReader, list), new ManualFillerBook(bufferedReader, list));
    }
}
