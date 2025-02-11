package org.example.filling.fromfile;

import org.example.entity.Book;
import org.example.utils.ReadFilesUtils;

import java.io.BufferedReader;
import java.util.List;

public class FillerFromFileBook extends FillerFromFile<Book> {
    public FillerFromFileBook(BufferedReader bufferedReader, List<Book> list) {
        super(bufferedReader, list);
        listFromFile = ReadFilesUtils.getBooksFromFile();
    }
}
