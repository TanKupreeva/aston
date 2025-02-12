package org.example.filling.manual;

import org.example.entity.Book;
import org.example.soututils.GetValueBook;

import java.io.BufferedReader;
import java.util.List;

public class FillerManualBook extends FillerManual<Book> {

    public FillerManualBook(BufferedReader bufferedReader, List<Book> originalList) {
        super(bufferedReader,
                originalList,
                new GetValueBook(bufferedReader));
    }

}
