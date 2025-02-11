package org.example.filling.random;

import org.example.entity.Book;


import java.io.BufferedReader;
import java.util.List;

public class FillerRandomBook extends FillerRandom<Book> {
    public FillerRandomBook(BufferedReader bufferedReader, List<Book> list) {
        super(bufferedReader, list,  ReadFilesUtils.getBooksFromFile());
    }
}


