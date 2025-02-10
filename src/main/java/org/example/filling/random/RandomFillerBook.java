package org.example.filling.random;

import org.example.entity.Book;
import org.example.utils.ReadFilesUtils;

import java.io.BufferedReader;
import java.util.List;

public class RandomFillerBook extends RandomFiller<Book> {
    public RandomFillerBook(BufferedReader bufferedReader, List<Book> list) {
        super(bufferedReader, list);
        listRandom = ReadFilesUtils.getBooksFromFile();
    }
}
