package org.example.filling.manual;

import org.example.entity.Book;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class FillerManualBook extends FillerManual<Book> {

    public FillerManualBook(BufferedReader bufferedReader, List<Book> list) {
        super(bufferedReader, list);
    }

    @Override
    protected Book getValue(int i) {
        String author = "";
        String title = "";
        int pages = 0;
        boolean is = true;
        while (is) {
            try {
                System.out.println("Enter author:");
                author = bufferedReader.readLine();
                System.out.println("Enter title:");
                title = bufferedReader.readLine();
                System.out.println("Enter pages:");
                pages = Integer.parseInt(bufferedReader.readLine());
                is = false;
            } catch (NumberFormatException ex) {
                System.out.print("This field only accepts numbers.\n\n" +
                        "Try filling object number " + i + " again.");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        Book book = Book.builder()
                .author(author)
                .title(title)
                .pages(pages)
                .build();
        return book;
    }

}
